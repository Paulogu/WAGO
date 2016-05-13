package control;

import com.mint.io.modbus.ModbusTCP_Connection;
import com.mint.io.modbus.functions.ModbusTCP_ReadInputRegisters;
import com.mint.io.modbus.functions.ModbusTCP_WriteSingleRegister;

public class Auxiliaire extends Module{
	
	public ModbusTCP_ReadInputRegisters functionRIR;
	public ModbusTCP_WriteSingleRegister functionWSR;
	short PreviousInput=0;
	short PreviousOutputs[]={0,0};
	
	
	public Auxiliaire(){
		this.state=State.STOP;
		this.input.InputRegister=new short[1];
		this.output.HoldingRegister=new short[1];
	}
	
	
	void checkState(TableInputBoolean tableB, TableInputRegister tableD, ModbusTCP_Connection connection){
		int i=-1;
		while(!tableD.Tableau[i].name.equals("ACLT1") || i<tableD.taille){i++;}
		this.input.Address=tableD.Tableau[i].address;
		this.functionRIR=new ModbusTCP_ReadInputRegisters(this.input.Address,1);
		connection.execute(this.functionRIR);
		this.input.InputRegister[0]=(short)this.functionRIR.getRegisters(0);
	}
	
	
	public double ConvertIntToValue(short entier){
		return (entier+32768)*0.01-327.68;
	}
	
	
	public short ConvertValuetoInt(double reel){
		return (short)(reel*100-32768);
	}
	
	
	void HandleState(TableOutputBoolean tableB, TableOutputRegister tableD, Mode mode, ModbusTCP_Connection connection){
		if (mode==Mode.EmergencyShutdown || mode==Mode.Shutdown || mode==Mode.TurbineStopped){
			this.output.HoldingRegister[0]=0;
		}
		else{
			double K=0.1,Ti=30,deltaT=0.1;
			double consigne=200;
			if(mode==Mode.StartingUp || mode==Mode.Started || mode==Mode.TurbineStopped || mode==Mode.TurbineStopping || mode==Mode.WaterloopSecurity){
				this.output.HoldingRegister[0]= ConvertValuetoInt(K*(consigne-ConvertIntToValue(this.input.InputRegister[0]))+ConvertIntToValue(this.PreviousOutputs[0])+K*deltaT/(2*Ti)*(ConvertIntToValue(this.input.InputRegister[0])+ConvertIntToValue(this.PreviousInput)));
				this.output.HoldingRegister[1]=this.output.HoldingRegister[0];
				this.PreviousOutputs[0]=this.output.HoldingRegister[0];
				this.PreviousOutputs[1]=this.output.HoldingRegister[1];
				this.PreviousInput=this.input.InputRegister[0];
			}
		}
		int i=-1;
		while(!tableD.Tableau[i].name.equals("J320W_V1.isBypassLimitswitch") || i!=tableD.taille){i++;};
		this.output.Address=tableD.Tableau[i].address;
		this.functionWSR.setInteger(this.output.HoldingRegister[0]);
		this.functionWSR.setAddress(this.output.Address);
		connection.execute(this.functionWSR);
	}
}
