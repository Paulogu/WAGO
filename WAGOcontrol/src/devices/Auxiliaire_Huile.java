package devices;

import java.io.IOException;
import java.net.UnknownHostException;

import com.mint.io.modbus.functions.ModbusTCP_ReadInputRegisters;
import com.mint.io.modbus.functions.ModbusTCP_WriteCoil;


public class Auxiliaire_Huile extends ModbusTCP_Device{
	
	private ModbusTCP_ReadInputRegisters f01 = new ModbusTCP_ReadInputRegisters(0,1);
	private ModbusTCP_WriteCoil f02 = new ModbusTCP_WriteCoil();
	
	public Auxiliaire_Huile(String address, int port) throws UnknownHostException, IOException {
		super(address, port);
		this.f02.setAddress(0);
	}

	private int ALT1;
	private boolean ALAC1;
	
	@Override
	public void read() {
		connection.execute(f01);
		this.ALT1 = this.f01.getRegisters(0);
	}

	@Override
	public void write() {
		f02.setValue(this.ALAC1);
		connection.execute(f02);
	}
	
	public boolean getALAC1(){
		return this.ALAC1;
	}
	
	public void setALAC1(boolean value){
		this.ALAC1=value;
	}
	
	public double getALT1(){
		return ITV(this.ALT1);
	}
}
