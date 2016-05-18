package control2;

import java.io.IOException;
import java.net.UnknownHostException;

import com.mint.io.modbus.ModbusTCP_Connection;

import devices.Aerocondenser;
import devices.Auxiliaire_ACCV2;
import devices.KSBPumpDrive;

public class Plant {
	
	public KSBPumpDrive pumpGlycol;
	public KSBPumpDrive pumpWater;
	public Aerocondenser aero;
	public Auxiliaire_ACCV2 aux2;

	public Plant() throws UnknownHostException, IOException {
		this.pumpGlycol = new KSBPumpDrive("192.168.1.21", ModbusTCP_Connection.DEFAULT_PORT,0,0);
		this.pumpWater = new KSBPumpDrive("192.168.1.21", ModbusTCP_Connection.DEFAULT_PORT,0,0);
		this.aero = new Aerocondenser("192.168.1.21", ModbusTCP_Connection.DEFAULT_PORT);
		this.aux2 = new Auxiliaire_ACCV2("192.168.1.21", ModbusTCP_Connection.DEFAULT_PORT,0,0);
	}
}
