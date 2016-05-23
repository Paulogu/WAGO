package devices;

import java.io.IOException;
import java.net.UnknownHostException;

import com.mint.io.modbus.functions.ModbusTCP_ReadInputRegisters;
import com.mint.io.modbus.functions.ModbusTCP_WriteMultipleRegisters;
import com.mint.io.modbus.utilities.ByteUtilities;

public class Aerocondenser extends ModbusTCP_Device{

	private ModbusTCP_WriteMultipleRegisters f01 = new ModbusTCP_WriteMultipleRegisters(4,2);
	private ModbusTCP_ReadInputRegisters f02 = new ModbusTCP_ReadInputRegisters(47,1);
	
	public Aerocondenser(String address, int port) throws UnknownHostException, IOException {
		super(address, port);
	}

	private int TRSA,
				COND1_2,
				COND3_4;
	
	@Override
	public void read() {
		connection.execute(f02);	
		this.TRSA=f02.getRegisters(0);
	}

	@Override
	public void write() {
		byte[] bytes = f01.getData();
		ByteUtilities.writeInteger16(bytes, 0, this.COND1_2);
		ByteUtilities.writeInteger16(bytes, 2, this.COND3_4);
		connection.execute(f01);
	}
	
	public double getTRSA(){
		return ITV(this.TRSA);
	}
	
	public void setCOND1_2(double value){
		this.COND1_2=VTI(value);
	}
	
	public double getCOND1_2(){
		return ITV(this.COND1_2);
	}
	
	public void setCOND3_4(double value){
		this.COND3_4=VTI(value);
	}
}
