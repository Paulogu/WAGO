package devices;

import java.io.IOException;
import java.net.UnknownHostException;

import com.mint.io.modbus.functions.ModbusTCP_ReadInputRegisters;
import com.mint.io.modbus.functions.ModbusTCP_WriteMultipleRegisters;

public class Turbogenerator extends ModbusTCP_Device{
	
	private ModbusTCP_WriteMultipleRegisters f01 = new ModbusTCP_WriteMultipleRegisters(0x00, 1);
	private ModbusTCP_ReadInputRegisters f02 = new ModbusTCP_ReadInputRegisters(0x00, 39);
	
	private int currentSpeed,
				AFE_OLI_PremierDef,
				setpoint_rotSpeed,
				currentPower,	
				
				tempKTY1S1,
				tempKTY1S2,
				tempKTY1S3,
				tempKTY1S4,
				tempKTY2S1,
				tempKTY2S2,
				tempKTY2S3,
				tempKTY2S4,	
				
				AFE_ORI_Vdc,
				AFE_ORI_Iac,
				AFE_ORI_Freq,
				AFE_ORI_Vac,
				AFE_OLI_StatusW1,
				
				OND1_ORI_Iac,
				OND1_ORI_Vac,
				OND1_ORI_Iq,
				OND1_ORI_Id,
				OND1_OLI_StatusW1,
				
				OND2_ORI_Iac,
				OND2_ORI_Vac,
				OND2_ORI_Iq,
				OND2_ORI_Id,
				OND2_OLI_StatusW1,
				
				OND3_ORI_Iac,
				OND3_ORI_Vac,
				OND3_ORI_Iq,
				OND3_ORI_Id,
				OND3_OLI_StatusW1,
				
				OND4_ORI_Iac,
				OND4_ORI_Vac,
				OND4_ORI_Iq,
				OND4_ORI_Id,
				OND4_OLI_StatusW1,
				
				OND1_OLI_PremierDef,
				OND2_OLI_PremierDef;
	
	public Turbogenerator(String address, int port) throws UnknownHostException, IOException {
		super(address, port);
	}
	
	@Override
	public void read(){

		connection.execute(f02);
		this.currentSpeed=this.f02.getRegisters(0);
		this.AFE_OLI_PremierDef=this.f02.getRegisters(1);
		this.setpoint_rotSpeed=this.f02.getRegisters(2);
		this.currentPower=this.f02.getRegisters(3);
		this.tempKTY1S1=this.f02.getRegisters(4);
		this.tempKTY1S2=this.f02.getRegisters(5);
		this.tempKTY1S3=this.f02.getRegisters(6);
		this.tempKTY1S4=this.f02.getRegisters(7);
		this.tempKTY2S1=this.f02.getRegisters(8);
		this.tempKTY2S2=this.f02.getRegisters(9);
		this.tempKTY2S3=this.f02.getRegisters(10);
		this.tempKTY2S4=this.f02.getRegisters(11);
		this.AFE_ORI_Vdc=this.f02.getRegisters(12);
		this.AFE_ORI_Iac=this.f02.getRegisters(13);
		this.AFE_ORI_Freq=this.f02.getRegisters(14);
		this.AFE_ORI_Vac=this.f02.getRegisters(15);
		this.AFE_OLI_StatusW1=this.f02.getRegisters(16);
		this.OND1_ORI_Iac=this.f02.getRegisters(17);
		this.OND1_ORI_Vac=this.f02.getRegisters(18);
		this.OND1_ORI_Iq=this.f02.getRegisters(19);
		this.OND1_ORI_Id=this.f02.getRegisters(20);
		this.OND1_OLI_StatusW1=this.f02.getRegisters(21);
		this.OND2_ORI_Iac=this.f02.getRegisters(22);
		this.OND2_ORI_Vac=this.f02.getRegisters(23);
		this.OND2_ORI_Iq=this.f02.getRegisters(24);
		this.OND2_ORI_Id=this.f02.getRegisters(25);
		this.OND2_OLI_StatusW1=this.f02.getRegisters(26);
		this.OND3_ORI_Iac=this.f02.getRegisters(27);
		this.OND3_ORI_Vac=this.f02.getRegisters(28);
		this.OND3_ORI_Iq=this.f02.getRegisters(29);
		this.OND3_ORI_Id=this.f02.getRegisters(30);
		this.OND3_OLI_StatusW1=this.f02.getRegisters(31);
		this.OND4_ORI_Iac=this.f02.getRegisters(32);
		this.OND4_ORI_Vac=this.f02.getRegisters(33);
		this.OND4_ORI_Iq=this.f02.getRegisters(34);
		this.OND4_ORI_Id=this.f02.getRegisters(35);
		this.OND4_OLI_StatusW1=this.f02.getRegisters(36);
		this.OND1_OLI_PremierDef=this.f02.getRegisters(37);
		this.OND2_OLI_PremierDef=this.f02.getRegisters(38);
	}
	
	@Override
	public void write(){		

	}
}
