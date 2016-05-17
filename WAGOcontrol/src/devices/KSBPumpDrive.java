package devices;

import java.io.IOException;
import java.net.UnknownHostException;

import com.mint.io.modbus.functions.ModbusTCP_ReadInputRegisters;
import com.mint.io.modbus.functions.ModbusTCP_WriteMultipleRegisters;
import com.mint.io.modbus.utilities.ByteUtilities;

public class KSBPumpDrive extends ModbusTCP_Device {
		
	private ModbusTCP_WriteMultipleRegisters f01 = new ModbusTCP_WriteMultipleRegisters(0x00, 1);
	private ModbusTCP_ReadInputRegisters f02 = new ModbusTCP_ReadInputRegisters(0x00, 8);
	
	private int inPressure;
	private int outPressure;
	private int regulation_setpoint;
	private int temperature;
	private int temperatureP;
	private int elec_consumption;
	private int flow;
	private int rotation_speed;
	private int time_to_maintenance;
	private int status;
	
	public KSBPumpDrive(String address, int port) throws UnknownHostException, IOException {
		super(address, port);
	}
	
	@Override
	public void read(){

		connection.execute(f02);
		this.inPressure=this.f02.getRegisters(0);
		this.outPressure=this.f02.getRegisters(1);
		this.regulation_setpoint=this.f02.getRegisters(2);
		this.temperature=this.f02.getRegisters(3);
		this.elec_consumption=this.f02.getRegisters(4);
		this.flow=this.f02.getRegisters(5);
		this.time_to_maintenance=this.f02.getRegisters(6);
		this.status=this.f02.getRegisters(7);
	}
	
	@Override
	public void write(){		
		byte[] bytes = f01.getData();
		ByteUtilities.writeInteger16(bytes, 0, this.rotation_speed);
	}
			
	public double getinPressure(){
		return (this.inPressure+32768)*0.01-327.68;
	}
	
	public double getoutPressure(){
		return (this.outPressure+32768)*0.01-327.68;
	}
	
	public double getregulation_setpoint(){
		return (this.regulation_setpoint+32768)*0.01-327.68;
	}
	
	public double gettemperature(){
		return (this.temperature+32768)*0.01-327.68;
	}
	
	public double gettemperatureP(){
		return (this.temperatureP+32768)*0.01-327.68;
	}
	
	public double getelec_consumption(){
		return (this.elec_consumption+32768)*0.01-327.68;
	}
	
	public double getflow(){
		return (this.flow+32768)*0.01-327.68;
	}
	
	public void setRotationSpeed(double value){
		this.rotation_speed=(int)(value*100-32768);
		this.temperatureP=this.temperature;
	}
	
	public double getRotationSpeed(){
		return (this.rotation_speed+32768)*0.01-327.68;
	}
	
	public double gettime_to_maintenance(){
		return (this.time_to_maintenance+32768)*0.01-327.68;
	}
	
	public double getstatus(){
		return (this.status+32768)*0.01-327.68;
	}
}	

