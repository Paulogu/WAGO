package control;

import com.mint.io.modbus.ModbusTCP_Connection;
import com.mint.io.modbus.functions.ModbusTCP_ReadInputRegisters;
import com.mint.io.modbus.functions.ModbusTCP_WriteSingleRegister;

public class Pompe extends Module{
	
	short PreviousInput=0;
	short PreviousOutputs=0;
	public ModbusTCP_ReadInputRegisters functionRIR;
	public ModbusTCP_WriteSingleRegister functionWSR;
	
	public Pompe(TableInputBoolean tableBi, TableInputRegister tableRi, TableOutputBoolean tableBo, TableOutputRegister tableRo){
		this.input.InputRegister=new short[1];
		this.input.Address=new int[1];
		this.output.HoldingRegister=new short[1];
		this.output.Address=new int[1];
		
		int i=0;
		while(!tableRi.Tableau[i].name.equals("T_CONT") || i!=tableRi.taille){i++;};
		this.input.Address[0]=tableRi.Tableau[i].address;

		i=0;
		while(!tableRo.Tableau[i].name.equals("ContainerSetpointTemp") || i!=tableRo.taille){i++;};
		this.output.Address[0]=tableRo.Tableau[i].address;
		
		this.functionRIR=new ModbusTCP_ReadInputRegisters(this.input.Address[0],1);
		this.functionWSR.setAddress(this.output.Address[0]);
	}
	
	void checkState(TableInputBoolean tableB, TableInputRegister tableD, ModbusTCP_Connection connection){
		
	}
	
	void HandleState(TableOutputBoolean tableB, TableOutputRegister tableD, Mode mode, ModbusTCP_Connection connection){
		
	}
	
	void SecurityCheck(TableInputBoolean tableB, TableInputRegister tableD){
		
	}
}
