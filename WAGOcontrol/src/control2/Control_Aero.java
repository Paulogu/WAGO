package control2;

public class Control_Aero{
	
	private Plant plant;
	private double subcooling = 7; // en [K]
	private PID pid = new PID() {
		
		@Override
		public void setValue(double value) {
			plant.aero.setCOND1_2(value);
			this.inp=getInput();		
		}
		
		@Override
		public double getInput() {
			return plant.aero.getTRSA();
		}

		@Override
		public double getOutput() {
			return plant.aero.getCOND1_2();
		}

		@Override
		public double Consigne() {
			return TsatFromP(plant.pumpWater.getinPressure())-subcooling;
		}

	};
	
	public void control(Mode mode){
		
		if (mode==Mode.EmergencyShutdown || mode==Mode.Shutdown || mode==Mode.ShuttingDown){
			plant.aero.setCOND1_2(0);
			plant.aero.setCOND3_4(0);
		}
		if (mode==Mode.Started || mode==Mode.StartingUp || mode==Mode.TurbineStopping || mode==Mode.WaterloopSecurity){
			pid.compute();
		}
	}
}
