package control2;

public class Control_Turbo {
	
	private Plant plant;
	private double superheating = 3; // en [K]
	private PID pid = new PID() {
		@Override
		public void setValue(double value) {
			plant.turbo.setsetpoint_rotSpeed(value);
			this.inp=getInput();		
		}
		
		@Override
		public double getInput() {
			return plant.echang.getTRS();
		}

		@Override
		public double getOutput() {
			return plant.turbo.getsetpoint_rotSpeed();
		}

		@Override
		public double Consigne() {
			return TsatFromP(plant.echang.getPRS())+superheating;
		}
	};
	
	public void control(Mode mode){
		this.pid.max=3200;
		this.pid.min=600;
		if (mode==Mode.EmergencyShutdown || mode==Mode.ShuttingDown){
			plant.turbo.setBypassTurbineToBypass(true);
			plant.turbo.setBypassTurbineToORC(false);
		}
		if (mode==Mode.Shutdown){
			plant.turbo.setBypassTurbineToBypass(true);
			plant.turbo.setBypassTurbineToORC(false);
			plant.turbo.setsetpoint_rotSpeed(0);
		}
		if (mode==Mode.Started){
			plant.turbo.setBypassTurbineToBypass(false);
			plant.turbo.setBypassTurbineToORC(true);
		}
		if (mode==Mode.StartingUp){
			if (plant.turbo.modefunction==Mode_Function.AUTO){
				pid.compute();
			}
			else{
				
			}
		}
		if (mode==Mode.TurbineStopping){
			plant.turbo.setBypassTurbineToBypass(true);
			plant.turbo.setBypassTurbineToORC(false);
		}
		if(mode==Mode.WaterloopSecurity){
			plant.turbo.setBypassTurbineToBypass(false);
			plant.turbo.setBypassTurbineToORC(true);
		}
	}	
}
