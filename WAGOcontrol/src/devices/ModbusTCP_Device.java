package devices;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.mint.io.modbus.ModbusTCP_Connection;

import control2.Mode_Function;

public abstract class ModbusTCP_Device {

	public ModbusTCP_Connection connection;
	public Mode_Function modefunction;
	
	public ModbusTCP_Device(String address, int port) throws UnknownHostException, IOException {
		super();
		connection = new ModbusTCP_Connection(InetAddress.getByName(address), port);
	}
	
	public abstract void read();
	public abstract void write();
	
	static double ITV (int entier){
		return (entier*100-32768);
	}
	
	static int VTI (double value){
		return (int)((value+32768)*0.01-327.68);
	}
}
