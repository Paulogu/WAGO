package devices;

import java.io.IOException;
import java.net.UnknownHostException;

import com.mint.io.modbus.functions.ModbusTCP_ReadInputRegisters;
import com.mint.io.modbus.functions.ModbusTCP_WriteCoil;

public class Motor extends ModbusTCP_Device{
	
	private int addressInput;
	private int addressOutput[]=new int[2];
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
	
	private boolean ActuateurR,
					ValveR;
	
	private boolean ActuateurW,
					ValveW;
	
	public Motor(String address, int port, int addIn, int addOut1, int addOut2) throws UnknownHostException, IOException {
		super(address, port);
		this.addressInput=addIn;
		this.addressOutput[0]=addOut1;
		this.addressOutput[1]=addOut1;
		this.f02= new ModbusTCP_ReadInputRegisters(addressInput, 8);
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
		this.f01.setAddress(this.addressOutput[0]);
		this.f01.setValue(this.ActuateurW);
		connection.execute(f01);
		
		this.f01.setAddress(this.addressOutput[1]);
		this.f01.setValue(this.ValveW);
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
	
	public boolean getActuatorR(){
		return this.ActuateurR;
	}
	
	public boolean getValveR(){
		return this.ValveR;
	}
	
	public void setActateurW(boolean value){
		this.ActuateurW=value;
	}
	
	public void setValveW(boolean value){
		this.ValveW=value;
	}
}
