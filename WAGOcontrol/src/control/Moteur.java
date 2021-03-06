package control;

import com.mint.io.modbus.ModbusTCP_Connection;
import com.mint.io.modbus.functions.ModbusTCP_ReadDiscreteInputs;
import com.mint.io.modbus.functions.ModbusTCP_ReadInputRegisters;
import com.mint.io.modbus.functions.ModbusTCP_WriteMultipleCoils;

public class Moteur extends Module{
	
	public ModbusTCP_ReadDiscreteInputs functionRDI;
	public ModbusTCP_ReadInputRegisters functionRIR;
	public ModbusTCP_WriteMultipleCoils functionWMC;
	
	public Moteur(TableInputBoolean tableA, TableInputRegister tableB, TableOutputBoolean tableC, TableOutputRegister tableD){

		this.input.InputRegister=new short[10];
		// {TESI_J320, TESI_J416, TCRA_J320, TCRA_J416, TCRR_J320, TCRR_J416, TFA_J320, TFA_J416, TFR_J320, TFR_J416}
		this.input.DiscreteInput=new boolean[8];
		this.output.Coils=new boolean[8];
		/*{Actuateur_J416_SET_TO_ORC , Actuateur_J416_SET_TO_BYPASS, Actuateur_J320_SET_TO_ORC, Actuateur_J320_SET_TO_BYPASS,
		   J416W_V1_SET_TO_ORC , J416W_V1_SET_TO_BYPASS, J320W_V1_SET_TO_ORC , J320W_V1_SET_TO_BYPASS}
		*/
		this.output.Address=new int[2];
		this.input.Address=new int[2];
		int i=0;
		while(!tableA.Tableau[i].name.equals("J320W_V1.isBypassLimitswitch") || i!=tableA.taille){i++;};
		this.input.Address[0]=tableA.Tableau[i].address;
		i=0;
		while(!tableB.Tableau[i].name.equals("TESI_J320") || i!=tableB.taille){i++;};
		this.input.Address[1]=tableB.Tableau[i].address;
		i=0;
		while(!tableD.Tableau[i].name.equals("TCRR_J320") || i!=tableD.taille){i++;};
		this.output.Address[0]=tableD.Tableau[i].address;
		i=0;
		while(!tableC.Tableau[i].name.equals("J320W_V1.isBypassLimitswitch") || i!=tableC.taille){i++;};
		this.output.Address[1]=tableC.Tableau[i].address;
		functionWMC.setAddress(this.output.Address[1]);
	}
	
	
	public double ConvertIntToValue(short entier){
		return (entier+32768)*0.01-327.68;
	}
	
	
	void checkState(TableInputBoolean tableB, TableInputRegister tableD, ModbusTCP_Connection connection){
		
		this.functionRDI=new ModbusTCP_ReadDiscreteInputs(this.input.Address[0],8);
		connection.execute(this.functionRDI);
		for (int j=0;j<8;j++){
			this.input.DiscreteInput[j]=this.functionRDI.getInputs(j);
		}
		
		this.functionRIR=new ModbusTCP_ReadInputRegisters(this.input.Address[1],8);
		connection.execute(this.functionRIR);
		for (int j=0;j<8;j++){
			this.input.InputRegister[j]=(short)this.functionRIR.getRegisters(j);
		}
	}
	
	
	void HandleState(TableOutputBoolean tableB, TableOutputRegister tableD, Mode mode, ModbusTCP_Connection connection){
		
		if (mode==Mode.EmergencyShutdown || mode==Mode.ShuttingDown || mode==Mode.Shutdown){
			
			this.output.Coils[0]=false;
			this.output.Coils[2]=false;	
			this.output.Coils[4]=false;	
			this.output.Coils[6]=false;	
		}
		
		if (mode==Mode.Started || mode==Mode.StartingUp || mode==Mode.TurbineStopping || mode==Mode.TurbineStopped){			
			
			if(ConvertIntToValue(this.input.InputRegister[4])<70){
				this.output.Coils[4]=true;
			}
			else{
				this.output.Coils[4]=false;
			}
			
			
			if(ConvertIntToValue(this.input.InputRegister[5])<75){
				this.output.Coils[6]=true;
			}
			else{
				this.output.Coils[6]=false;
			}
			
			
			if(ConvertIntToValue(this.input.InputRegister[7])<10){
				this.output.Coils[0]=true;
			}
			else{
				this.output.Coils[0]=false;
			}
			
			
			if(ConvertIntToValue(this.input.InputRegister[8])<10){
				this.output.Coils[2]=true;
			}
			else{
				this.output.Coils[2]=false;
			}
		
			
		if (mode==Mode.WaterloopSecurity){
			
			if(ConvertIntToValue(this.input.InputRegister[4])<70){
				this.output.Coils[4]=true;
			}
			else{
				this.output.Coils[4]=false;
			}
			
			
			if(ConvertIntToValue(this.input.InputRegister[5])<75){
				this.output.Coils[6]=true;
			}
			else{
				this.output.Coils[6]=false;
			}
			
			
			this.output.Coils[0]=false;
			this.output.Coils[2]=false;	
		}
				
		this.output.Coils[1]=!this.output.Coils[0];
		this.output.Coils[3]=!this.output.Coils[2];
		this.output.Coils[5]=!this.output.Coils[4];
		this.output.Coils[7]=!this.output.Coils[6];
			
		}
		
		functionWMC.setValues(this.output.Coils);	
		connection.execute(functionWMC);
	}
	
	void SecurityCheck(TableInputBoolean tableB, TableInputRegister tableD){
		
	}
}
