package control;

import com.mint.io.modbus.ModbusTCP_Connection;

abstract class Module {
	public Input input;
	public Output output;
	
	abstract void checkState(TableInputBoolean tableB, TableInputRegister tableD, ModbusTCP_Connection connection); // V�rifie l'�tat du syst�me et actualise la ou les tables d'inputs 
	abstract void HandleState(TableOutputBoolean tableB, TableOutputRegister tableD, Mode mode, ModbusTCP_Connection connection); // Suivant le mode de fonctionnement, le syst�me adapte sa strat�gie de commande et les valeurs en sorties(R�gulation PID, arr�t du syst�me...) et actualise les tables d'outputs
	abstract void SecurityCheck(TableInputBoolean tableB, TableInputRegister tableD);
}
