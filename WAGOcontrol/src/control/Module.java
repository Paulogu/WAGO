package control;

import com.mint.io.modbus.ModbusTCP_Connection;

abstract class Module {
	public State state;
	public Input input;
	public Output output;
	
	abstract void checkState(TableInputBoolean tableB, TableInputRegister tableD, ModbusTCP_Connection connection); // Vérifie l'état du système et actualise la ou les tables d'inputs 
	abstract void HandleState(TableOutputBoolean tableB, TableOutputRegister tableD, Mode mode, ModbusTCP_Connection connection); // Suivant le mode de fonctionnement, le système adapte sa stratégie de commande et les valeurs en sorties(Régulation PID, arrêt du système...) et actualise les tables d'outputs
}
