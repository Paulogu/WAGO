package control2;

public class Control_pumpGlycol_320 {

	private Plant plant;
	private PID pid = new PID() {
		
		@Override
		public void setValue(double value) {
			plant.pumpGlycol_320.setRotationSpeed(value);
			this.inp=getInput();		
		}
		
		@Override
		public double getInput() {
			return plant.JGC320.getTCRR();
		}

		@Override
		public double getOutput() {
			return plant.pumpGlycol_320.getRotationSpeed();
		}

		@Override
		public double Consigne() {
			return 69;
		}

	};
	
	public void control(){		
		pid.compute();
	}	
}
