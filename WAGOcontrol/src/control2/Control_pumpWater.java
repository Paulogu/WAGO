package control2;

public class Control_pumpWater {
	
	private Plant plant;
	private PID pid = new PID() {
		
		@Override
		public void setValue(double value) {
			plant.pumpWater.setRotationSpeed(value);
			this.inp=getInput();		
		}
		
		@Override
		public double getInput() {
			return plant.echang.getTES();
		}

		@Override
		public double getOutput() {
			return plant.pumpWater.getRotationSpeed();
		}

		@Override
		public double Consigne() {
			return 63;
		}
	};
	
	public void control(){		
		pid.compute();
	}	
}
