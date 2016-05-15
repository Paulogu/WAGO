package control;

import com.mint.io.modbus.ModbusTCP_Connection;
import com.mint.io.modbus.functions.ModbusTCP_ReadInputRegisters;
import com.mint.io.modbus.functions.ModbusTCP_WriteSingleRegister;

public class Auxiliaire extends Module{
	
	public ModbusTCP_ReadInputRegisters functionRIR;
	public ModbusTCP_WriteSingleRegister functionWSR;
	short PreviousInput=0;
	short PreviousOutputs=0;
	
	
	public Auxiliaire(TableInputBoolean tableBi, TableInputRegister tableRi, TableOutputBoolean tableBo, TableOutputRegister tableRo){
		
		this.input.InputRegister=new short[1];
		this.input.Address=new int[1];
		this.output.HoldingRegister=new short[1];
		this.output.Address=new int[1];
				
		int i=-1;
		while(!tableRi.Tableau[i].name.equals("ACLT1") || i!=tableRi.taille){i++;};
		this.input.Address[0]=tableRi.Tableau[i].address;
		i=-1;
		while(!tableRo.Tableau[i].name.equals("ACCV2") || i!=tableRo.taille){i++;};
		this.output.Address[0]=tableRo.Tableau[i].address;
		
		this.functionRIR=new ModbusTCP_ReadInputRegisters(this.input.Address[0],1);
		this.functionWSR.setAddress(this.output.Address[1]);
	}
	
	
	void checkState(TableInputBoolean tableB, TableInputRegister tableD, ModbusTCP_Connection connection){
		
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
				this.output.HoldingRegister[0]= ConvertValuetoInt(K*(consigne-ConvertIntToValue(this.input.InputRegister[0]))+ConvertIntToValue(this.PreviousOutputs)+K*deltaT/(2*Ti)*(ConvertIntToValue(this.input.InputRegister[0])+ConvertIntToValue(this.PreviousInput)));
				this.output.HoldingRegister[1]=this.output.HoldingRegister[0];
				this.PreviousOutputs=this.output.HoldingRegister[0];
				this.PreviousInput=this.input.InputRegister[0];
			}
		}

		this.functionWSR.setInteger(this.output.HoldingRegister[0]);
		connection.execute(this.functionWSR);
	}
}
