package devices;

import java.io.IOException;
import java.net.UnknownHostException;

import com.mint.io.modbus.functions.ModbusTCP_ReadInputRegisters;
import com.mint.io.modbus.functions.ModbusTCP_WriteCoil;

public class Motor extends ModbusTCP_Device{
	
	private ModbusTCP_WriteCoil f01 = new ModbusTCP_WriteCoil();
	private ModbusTCP_ReadInputRegisters f02 = new ModbusTCP_ReadInputRegisters(0x00, 10);
	
	private int TESI, 
				TCRA,
				TCRR,
				TFA,
				TFR,
				temperatureOut,
				temperatureIn,
				volumeFlow,
				thermalPower,
				totalEnergy;
	
	private boolean ActuatorToORC,
					ActuatorToBypass,
					ValveToORC,
					ValveToBypass;
	
	public Motor(String address, int port) throws UnknownHostException, IOException {
		super(address, port);
	}

	@Override
	public void read() {
		
		connection.execute(f02);
		this.TESI=this.f02.getRegisters(0);
		this.TCRA=this.f02.getRegisters(1);
		this.TCRR=this.f02.getRegisters(2);
		this.TFA=this.f02.getRegisters(3);
		this.TFR=this.f02.getRegisters(4);
		this.temperatureOut=this.f02.getRegisters(5);
		this.temperatureIn=this.f02.getRegisters(6);
		this.volumeFlow=this.f02.getRegisters(7);
		this.thermalPower=this.f02.getRegisters(8);
		this.totalEnergy=this.f02.getRegisters(9);
	}

	@Override
	public void write() {
		this.f01.setAddress(0);
		this.f01.setValue(this.ActuatorToORC);
		connection.execute(f01);
		
		this.f01.setAddress(1);
		this.f01.setValue(this.ActuatorToBypass);
		connection.execute(f01);
		
		this.f01.setAddress(2);
		this.f01.setValue(this.ValveToORC);
		connection.execute(f01);
		
		this.f01.setAddress(3);
		this.f01.setValue(this.ValveToBypass);
		connection.execute(f01);
	}
	
	public double getTESI(){
		return ITV(this.TESI);
	}
	
	public double getTCRA(){
		return ITV(this.TCRA);
	}
	
	public double getTCRR(){
		return ITV(this.TCRR);
	}
	
	public double getTFA(){
		return ITV(this.TFA);
	}
	
	public double getTFR(){
		return ITV(this.TFR);
	}
	
	public double gettemperatureOut(){
		return ITV(this.temperatureOut);
	}
	
	public double gettemperatureIn(){
		return ITV(this.temperatureIn);
	}
	
	public double getvolumeFlow(){
		return ITV(this.volumeFlow);
	}
	
	public double getthermalPower(){
		return ITV(this.thermalPower);
	}
	
	public double gettotalEnergy(){
		return ITV(this.totalEnergy);
	}
	
	public void setActuatorToORC(boolean value){
		this.ActuatorToORC=value;
	}
	
	public void setActuatorToBypass(boolean value){
		this.ActuatorToBypass=value;
	}
	
	public void setValveToORC(boolean value){
		this.ValveToORC=value;
	}
	
	public void setValveToBypass(boolean value){
		this.ValveToBypass=value;
	}
}
