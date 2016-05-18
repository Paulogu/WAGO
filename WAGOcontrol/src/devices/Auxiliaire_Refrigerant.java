package devices;

import java.io.IOException;
import java.net.UnknownHostException;

import com.mint.io.modbus.functions.ModbusTCP_ReadInputRegisters;
import com.mint.io.modbus.functions.ModbusTCP_WriteMultipleRegisters;
import com.mint.io.modbus.utilities.ByteUtilities;

public class Auxiliaire_Refrigerant extends ModbusTCP_Device{
	
	private int addressOutput, addressInput;
	private ModbusTCP_ReadInputRegisters f01;
	private ModbusTCP_WriteMultipleRegisters f02;
	
	public Auxiliaire_Refrigerant(String address, int port, int addIn, int addOut) throws UnknownHostException, IOException {
		super(address, port);
		this.addressInput = addIn;
		this.addressOutput = addOut;
		this.f01 = new ModbusTCP_ReadInputRegisters(addressInput, 4);
		this.f02 = new ModbusTCP_WriteMultipleRegisters(addressOutput, 1);
	}

	private int ACLT1,
				ALT1,
				ACCV2,
				ALAC1,
				setpoint_rotSpeed;
	
	@Override
	public void read() {
		
		connection.execute(f01);
		this.ACLT1 = this.f01.getRegisters(0);
		this.ALT1 = this.f01.getRegisters(1);
		this.ALAC1 = this.f01.getRegisters(2);
		this.setpoint_rotSpeed = this.f01.getRegisters(3);
	}

	@Override
	public void write() {
		
		byte[] bytes = f02.getData();
		ByteUtilities.writeInteger16(bytes, 0, this.ACCV2);
		connection.execute(f02);
	}
	
	public double getACLT1(){
		return ITV(this.ACLT1);
	}
	
	public double getALT1(){
		return ITV(this.ALT1);
	}
	
	public double getALAC1(){
		return ITV(this.ALAC1);
	}
	
	public double getsetpoint_rotSpeed(){
		return ITV(this.setpoint_rotSpeed);
	}

	public void setACCV2(double value){
		this.ACCV2=VTI(value);
	}
	
	public double getACCV2(){
		return ITV(this.ACCV2);
	}
}
