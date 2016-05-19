package devices;

import java.io.IOException;
import java.net.UnknownHostException;

import com.mint.io.modbus.functions.ModbusTCP_ReadInputRegisters;
import com.mint.io.modbus.functions.ModbusTCP_WriteMultipleRegisters;
import com.mint.io.modbus.utilities.ByteUtilities;

public class Container_Cooling extends ModbusTCP_Device {
	
	private ModbusTCP_WriteMultipleRegisters f01 = new ModbusTCP_WriteMultipleRegisters(0x00, 1);
	private ModbusTCP_ReadInputRegisters f02 = new ModbusTCP_ReadInputRegisters(0,1);
	
	public Container_Cooling(String address, int port) throws UnknownHostException, IOException {
		super(address, port);
	}

	private int T_CONT,
				ContainerCooling;
	
	@Override
	public void read() {
		connection.execute(f02);
		this.T_CONT = this.f02.getRegisters(0);
	}

	@Override
	public void write() {
		byte[] bytes = f01.getData();
		ByteUtilities.writeInteger16(bytes, 2, this.ContainerCooling);
		connection.execute(f01);
	}
	
	public void setContainerCooling(double value){
		this.ContainerCooling=VTI(value);
	}
	
	public double getContainerCooling(){
		return ITV(this.ContainerCooling);
	}
	
	public double getT_CONT(){
		return ITV(this.T_CONT);
	}
}
