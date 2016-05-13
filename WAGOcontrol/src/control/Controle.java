package control;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.mint.io.modbus.ModbusTCP_Connection;

public class Controle {
	
	public static void main(String[] args) throws IOException{
		
		InetAddress address = null;
		try {
		address = InetAddress.getByName("192.168.0.21"); //Addresse à redéfinir
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		ModbusTCP_Connection connection= new ModbusTCP_Connection(address);
		connection.setUnitId(1);
		TableInputRegister tableInputRegister=new TableInputRegister();
		TableInputBoolean tableInputBoolean=new TableInputBoolean();
		TableOutputRegister tableOutputRegister=new TableOutputRegister();
		TableOutputBoolean tableOutputBoolean=new TableOutputBoolean();
		Security security=new Security();
		Moteur moteur=new Moteur();
		Pompe pompe=new Pompe();
		Evaporateur evaporateur=new Evaporateur();
		Aerocondenseur aerocondenseur=new Aerocondenseur();
		Turbogenerateur turbogenerateur=new Turbogenerateur();
		Auxiliaire auxiliaire=new Auxiliaire();
		
		while(true){
			
			security.checkSafetyModule();
			security.checkEmergencyShutdownButton();
			
			moteur.checkState(tableInputBoolean,tableInputRegister,connection);
			moteur.HandleState(tableOutputBoolean,tableOutputRegister,security.mode,connection);
			
			pompe.checkState(tableInputBoolean,tableInputRegister,connection);
			pompe.HandleState(tableOutputBoolean,tableOutputRegister,security.mode,connection);
			
			evaporateur.checkState(tableInputBoolean,tableInputRegister,connection);
			evaporateur.HandleState(tableOutputBoolean,tableOutputRegister,security.mode,connection);
			
			aerocondenseur.checkState(tableInputBoolean,tableInputRegister,connection);
			aerocondenseur.HandleState(tableOutputBoolean,tableOutputRegister,security.mode,connection);
			
			turbogenerateur.checkState(tableInputBoolean,tableInputRegister,connection);
			turbogenerateur.HandleState(tableOutputBoolean,tableOutputRegister,security.mode,connection);
			
			auxiliaire.checkState(tableInputBoolean,tableInputRegister,connection);
			auxiliaire.HandleState(tableOutputBoolean,tableOutputRegister,security.mode,connection);			
		}
	}
}
