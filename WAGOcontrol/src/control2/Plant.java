package control2;

import java.io.IOException;
import java.net.UnknownHostException;

import com.mint.io.modbus.ModbusTCP_Connection;

import devices.Aerocondenser;
import devices.Auxiliaire_Huile;
import devices.Auxiliaire_Refrigerant;
import devices.Container_Cooling;
import devices.Echangeur;
import devices.KSBPumpDrive;
import devices.Motor;
import devices.Turbogenerator;

public class Plant {
	
	public KSBPumpDrive pumpGlycol_320;
	public KSBPumpDrive pumpGlycol_416;
	public KSBPumpDrive pumpWater;
	public Aerocondenser aero;
	public Auxiliaire_Huile aux1;
	public Auxiliaire_Refrigerant aux2;
	public Echangeur echang;
	public Turbogenerator turbo;
	public Motor JGC320;
	public Motor JGC416;
	public Container_Cooling cool;
	
	private int addin1[]={1,21};
	private int addin2[]={11,31};
	private int addout2[]={10,0};
	private int addout1[]={14,2};

	public Plant() throws UnknownHostException, IOException {
		this.pumpGlycol_320 = new KSBPumpDrive("192.168.1.21", ModbusTCP_Connection.DEFAULT_PORT,16,87);
		this.pumpGlycol_416 = new KSBPumpDrive("192.168.1.21", ModbusTCP_Connection.DEFAULT_PORT,20,105);
		this.pumpWater = new KSBPumpDrive("192.168.1.21", ModbusTCP_Connection.DEFAULT_PORT,24,137);
		this.aero = new Aerocondenser("192.168.1.21", ModbusTCP_Connection.DEFAULT_PORT);
		this.aux1 = new Auxiliaire_Huile("192.168.1.21", ModbusTCP_Connection.DEFAULT_PORT);
		this.aux2 = new Auxiliaire_Refrigerant("192.168.1.21", ModbusTCP_Connection.DEFAULT_PORT);
		this.echang = new Echangeur("192.168.1.21", ModbusTCP_Connection.DEFAULT_PORT);
		this.turbo = new Turbogenerator("192.168.1.21", ModbusTCP_Connection.DEFAULT_PORT);
		this.JGC320 = new Motor("192.168.1.21", ModbusTCP_Connection.DEFAULT_PORT,addin1,addout1);
		this.JGC416 = new Motor("192.168.1.21", ModbusTCP_Connection.DEFAULT_PORT,addin2,addout2);
		this.cool = new Container_Cooling("192.168.1.21", ModbusTCP_Connection.DEFAULT_PORT);
	}
}
