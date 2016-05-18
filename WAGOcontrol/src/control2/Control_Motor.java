package control2;

public class Control_Motor {
	private Plant plant;
	
	public void control(Mode mode){
		if (mode==Mode.EmergencyShutdown || mode==Mode.Shutdown || mode==Mode.ShuttingDown){
			plant.JGC320.setValveToORC(false);		plant.JGC416.setValveToORC(false);
			plant.JGC320.setValveToBypass(true);	plant.JGC416.setValveToBypass(true);
			plant.JGC320.setActuatorToORC(false);	plant.JGC416.setActuatorToORC(false);
			plant.JGC320.setActuatorToBypass(true);	plant.JGC416.setActuatorToBypass(true);
		}
		if (mode==Mode.Started){
			plant.JGC320.setValveToORC(true);		plant.JGC416.setValveToORC(true);
			plant.JGC320.setValveToBypass(false);	plant.JGC416.setValveToBypass(false);
			plant.JGC320.setActuatorToORC(true);	plant.JGC416.setActuatorToORC(true);
			plant.JGC320.setActuatorToBypass(false);plant.JGC416.setActuatorToBypass(false);
		}
		if (mode==Mode.WaterloopSecurity){
			plant.JGC320.setValveToORC(true);		plant.JGC416.setValveToORC(true);
			plant.JGC320.setValveToBypass(false);	plant.JGC416.setValveToBypass(false);
			plant.JGC320.setActuatorToORC(false);	plant.JGC416.setActuatorToORC(false);
			plant.JGC320.setActuatorToBypass(true);	plant.JGC416.setActuatorToBypass(true);
		}
	}
}