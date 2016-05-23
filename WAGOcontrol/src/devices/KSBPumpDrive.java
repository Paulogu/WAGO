package devices;

import java.io.IOException;
import java.net.UnknownHostException;

import com.mint.io.modbus.functions.ModbusTCP_ReadInputRegisters;
import com.mint.io.modbus.functions.ModbusTCP_WriteMultipleRegisters;
import com.mint.io.modbus.utilities.ByteUtilities;

public class KSBPumpDrive extends ModbusTCP_Device {
		
	private ModbusTCP_WriteMultipleRegisters f01;
	private ModbusTCP_ReadInputRegisters f02;
	
	private int inPressure,
				outPressure,
				regulation_setpoint,
				temperature,
				elec_consumption,
				flow,
				rotation_speed,
				time_to_maintenance,
				status,
				rotation_consigne;
	
	public KSBPumpDrive(String address, int port,int addr1, int addr2) throws UnknownHostException, IOException {
		super(address, port);
		this.f01 = new ModbusTCP_WriteMultipleRegisters(addr2,1);
		this.f02 = new ModbusTCP_ReadInputRegisters(addr1,9);
	}
	
	@Override
	public void read(){

		connection.execute(f02);
		this.inPressure = this.f02.getRegisters(0);
		this.outPressure = this.f02.getRegisters(1);
		this.regulation_setpoint = this.f02.getRegisters(2);
		this.temperature = this.f02.getRegisters(3);
		this.elec_consumption = this.f02.getRegisters(4);
		this.flow = this.f02.getRegisters(5);
		this.rotation_speed=this.f02.getRegisters(6);
		this.time_to_maintenance = this.f02.getRegisters(7);
		this.status = this.f02.getRegisters(8);
	}
	
	@Override
	public void write(){		
		byte[] bytes = f01.getData();
		ByteUtilities.writeInteger16(bytes, 0, this.rotation_consigne);
		connection.execute(f01);
	}
			
	public double getinPressure(){
		return ITV(this.inPressure);
	}
	
	public double getoutPressure(){
		return ITV(this.outPressure);
	}
	
	public double getregulation_setpoint(){
		return ITV(this.regulation_setpoint);
	}
	
	public double gettemperature(){
		return ITV(this.temperature);
	}
	
	public double getelec_consumption(){
		return ITV(this.elec_consumption);
	}
	
	public double getflow(){
		return ITV(this.flow);
	}
	
	public void setRotationSpeed(double value){
		this.rotation_consigne=VTI(value);
	}
	
	public double getRotationSpeed(){
		return ITV(this.rotation_speed);
	}
	
	public double gettime_to_maintenance(){
		return ITV(this.time_to_maintenance);
	}
	
	public double getstatus(){
		return ITV(this.status);
	}
}	

