package control2;

public class Control_pumpGlycol {

	private Plant plant;
	private PID pid = new PID() {
		
		@Override
		public void setValue(double value) {
			plant.pumpGlycol1.setRotationSpeed(value);
			this.inp=getInput();		
		}
		
		@Override
		public double getInput() {
			return plant.pumpGlycol1.gettemperature();
		}

		@Override
		public double getOutput() {
			return plant.pumpGlycol1.getRotationSpeed();
		}

		@Override
		public double Consigne() {
			return plant.pumpGlycol1.getregulation_setpoint();
		}

	};
	
	public void control(){		
			pid.compute();
	}	
}
