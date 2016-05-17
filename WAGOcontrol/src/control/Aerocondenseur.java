package control;

import com.mint.io.modbus.ModbusTCP_Connection;
import com.mint.io.modbus.functions.ModbusTCP_ReadInputRegisters;
import com.mint.io.modbus.functions.ModbusTCP_WriteMultipleRegisters;
import com.mint.io.modbus.utilities.ByteUtilities;

public class Aerocondenseur extends Module{
	
	public ModbusTCP_ReadInputRegisters functionRIR;
	public ModbusTCP_WriteMultipleRegisters functionWMR;
	short PreviousInput=0;
	short PreviousOutputs=0;
	byte[] bytes;
	int a,b,c;
	
	public Aerocondenseur(TableInputBoolean tableBi, TableInputRegister tableRi, TableOutputBoolean tableBo, TableOutputRegister tableRo){
		
		this.input.InputRegister=new short[2];
		this.input.Address=new int[2];
		this.output.HoldingRegister=new short[1];		
		this.output.Address=new int[1];

		int i=0;
		while(!tableRi.Tableau[i].name.equals("RPUMP.pump_A.pIn") || i!=tableRi.taille){i++;};
		this.input.Address[0]=tableRi.Tableau[i].address;
		a=i;
		
		i=0;
		while(!tableRi.Tableau[i].name.equals("TRSA") || i!=tableRi.taille){i++;};
		this.input.Address[1]=tableRi.Tableau[i].address;
		b=i;
		
		i=0;
		while(!tableRo.Tableau[i].name.equals("COND1_2") || i!=tableRo.taille){i++;};
		this.output.Address[0]=tableRo.Tableau[i].address;
		c=i;
		
		this.functionWMR= new ModbusTCP_WriteMultipleRegisters(this.output.Address[0], 2);
		this.bytes= this.functionWMR.getData();
	}
	
	
	void checkState(TableInputBoolean tableB, TableInputRegister tableD, ModbusTCP_Connection connection){
		
		this.functionRIR=new ModbusTCP_ReadInputRegisters(this.input.Address[0],1);
		connection.execute(this.functionRIR);
		this.input.InputRegister[0]=(short)this.functionRIR.getRegisters(0);
		tableD.Tableau[a].value=this.input.InputRegister[0];
		
		this.functionRIR=new ModbusTCP_ReadInputRegisters(this.input.Address[1],1);
		connection.execute(this.functionRIR);
		this.input.InputRegister[1]=(short)this.functionRIR.getRegisters(1);
		tableD.Tableau[b].value=this.input.InputRegister[1];
	
	}
	
	public double ConvertIntToValue(short entier){
		return (entier+32768)*0.01-327.68;
	}
	
	public short ConvertValuetoInt(double reel){
		return (short)(reel*100-32768);
	}
	
	double TsatFromP(double value){
		return Math.pow(Math.log(value),4) * 0.7101 + Math.pow(Math.log(value),3) * 3.4647 + Math.pow(Math.log(value),2) * 13.655 + Math.log(value) * 57.095 + 14.819;
	}
	
	
	void HandleState(TableOutputBoolean tableB, TableOutputRegister tableD, Mode mode, ModbusTCP_Connection connection){	
		
		double consigne=TsatFromP(ConvertIntToValue(this.input.InputRegister[1]))-7;
		double K=0.1,Ti=30,deltaT=0.1;
		
		if(mode==Mode.StartingUp || mode==Mode.Started || mode==Mode.TurbineStopped || mode==Mode.TurbineStopping || mode==Mode.WaterloopSecurity){
			this.output.HoldingRegister[0]= ConvertValuetoInt(K*(consigne-ConvertIntToValue(this.input.InputRegister[0]))+ConvertIntToValue(this.PreviousOutputs)+K*deltaT/(2*Ti)*(ConvertIntToValue(this.input.InputRegister[0])+ConvertIntToValue(this.PreviousInput)));
			this.PreviousOutputs=this.output.HoldingRegister[0];
			this.PreviousInput=this.input.InputRegister[0];
		}
		else{
			this.output.HoldingRegister[0]=0;
		}
		
		for (int i=0;i<2;i++){
			ByteUtilities.writeInteger16(bytes, i*2, this.output.HoldingRegister[i]);
		}
		connection.execute(this.functionWMR);
	}
	
	void SecurityCheck(TableInputBoolean tableB, TableInputRegister tableD){
		
	}
}
