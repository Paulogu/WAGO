package control;

import com.mint.io.modbus.ModbusTCP_Connection;

public class Evaporateur extends Module{
	short PreviousInput=0;
	short PreviousOutputs[]={0,0};
	public Evaporateur(){
		this.state=State.STOP;
		this.input.InputRegister=new short[1];
		this.output.HoldingRegister=new short[1];
	}
	void checkState(TableInputBoolean tableB, TableInputRegister tableD, ModbusTCP_Connection connection){
		int i=-1;
		while(!tableB.Tableau[i].name.equals("T_CONT") || i!=tableB.taille){
				i++;
				if (tableB.Tableau[i].name.equals("T_CONT")){
					this.input.Address=tableB.Tableau[i].address;
				}
		}
	}
	void HandleState(TableOutputBoolean tableB, TableOutputRegister tableD, Mode mode, ModbusTCP_Connection connection){
		double consigne=35;
		double K=0.1,Ti=30,deltaT=0.1;
		if(mode==Mode.Started){
			this.output.HoldingRegister[0]=(short) (K*(consigne-(double)this.input.InputRegister[0])+(double)this.PreviousOutputs[0]+K*deltaT/(2*Ti)*((double)this.input.InputRegister[0]+(double)this.PreviousInput));
			this.output.HoldingRegister[1]=this.output.HoldingRegister[0];
			this.PreviousOutputs[0]=this.output.HoldingRegister[0];
			this.PreviousOutputs[1]=this.output.HoldingRegister[1];
			this.PreviousInput=this.input.InputRegister[0];
		}
		else{
			this.output.HoldingRegister[0]=0;
			this.output.HoldingRegister[1]=0;
		}
	}
}
