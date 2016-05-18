package devices;

import java.io.IOException;
import java.net.UnknownHostException;

import com.mint.io.modbus.functions.ModbusTCP_ReadInputRegisters;
import com.mint.io.modbus.functions.ModbusTCP_WriteMultipleCoils;
import com.mint.io.modbus.functions.ModbusTCP_WriteMultipleRegisters;
import com.mint.io.modbus.utilities.ByteUtilities;

public class Auxiliaire_Refrigerant extends ModbusTCP_Device{
	
	private int addressOutput, addressInput;
	private ModbusTCP_ReadInputRegisters f01;
	private ModbusTCP_WriteMultipleRegisters f02;
	private ModbusTCP_WriteMultipleCoils f03 = new ModbusTCP_WriteMultipleCoils();
	
	public Auxiliaire_Refrigerant(String address, int port, int addIn, int addOut) throws UnknownHostException, IOException {
		super(address, port);
		this.addressInput = addIn;
		this.addressOutput = addOut;
		this.f01 = new ModbusTCP_ReadInputRegisters(addressInput, 2);
		this.f02 = new ModbusTCP_WriteMultipleRegisters(addressOutput, 1);
		this.f03.setAddress(0);
	}

	private int ACLT1,
				ACCV2,
				aclt1_setpoint;
	
	private boolean	ACP1,
					ACP2;
	
	@Override
	public void read() {
		
		connection.execute(f01);
		this.ACLT1 = this.f01.getRegisters(0);
		this.aclt1_setpoint = this.f01.getRegisters(1);
	}

	@Override
	public void write() {
		
		byte[] bytes = f02.getData();
		ByteUtilities.writeInteger16(bytes, 0, this.ACCV2);
		connection.execute(f02);
		
		boolean ACP[]=new boolean [2];
		ACP[0]=this.ACP1;ACP[1]=this.ACP2;
		this.f03.setValues(ACP);
		connection.execute(f03);
	}
	
	public double getACLT1(){
		return ITV(this.ACLT1);
	}
	
	public double getaclt1_setpoint(){
		return ITV(this.aclt1_setpoint);
	}

	public void setACCV2(double value){
		this.ACCV2=VTI(value);
	}
	
	public double getACCV2(){
		return ITV(this.ACCV2);
	}
	
	public void setACP1(boolean value){
		this.ACP1=value;
	}
	
	public void setACP2(boolean value){
		this.ACP2=value;
	}
}
