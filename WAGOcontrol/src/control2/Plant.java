package control2;

import java.io.IOException;
import java.net.UnknownHostException;

import com.mint.io.modbus.ModbusTCP_Connection;

import devices.KSBPumpDrive;

public class Plant {
	
	public KSBPumpDrive pump;

	public Plant() throws UnknownHostException, IOException {
		this.pump = new KSBPumpDrive("192.168.1.21", ModbusTCP_Connection.DEFAULT_PORT);
	}

}
