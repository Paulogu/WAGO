package devices;

import java.io.IOException;
import java.net.UnknownHostException;

import com.mint.io.modbus.functions.ModbusTCP_ReadInputRegisters;

public class Echangeur extends ModbusTCP_Device{
	
	private ModbusTCP_ReadInputRegisters f01= new ModbusTCP_ReadInputRegisters(0,6);
	
	public Echangeur(String address, int port) throws UnknownHostException, IOException {
		super(address, port);
	}

	private int TES,
				TRS,
				TRSP,
				T_amb,
				PRS;
	
	@Override
	public void read() {
		connection.execute(f01);
		this.TES = this.f01.getRegisters(0);
		this.TRS = this.f01.getRegisters(1);
		this.TRSP = this.f01.getRegisters(2);
		this.T_amb = this.f01.getRegisters(3);
		this.PRS = this.f01.getRegisters(4);
	}

	@Override
	public void write() {
	}
	
	public double getTES(){
		return ITV(this.TES);
	}
	
	public double getTRS(){
		return ITV(this.TRS);
	}
	
	public double getTRSP(){
		return ITV(this.TRSP);
	}
	
	public double getT_amb(){
		return ITV(this.T_amb);
	}
	
	public double getPRS(){
		return ITV(this.PRS);
	}
	
	
}
