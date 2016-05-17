package control2;

public class Control02 {
	private Plant plant;
	private PID pid01 = new PID() {
		
		@Override
		public void setValue(double value) {
			plant.pump.setRotationSpeed(value);
			this.inp=getInput();		
		}
		
		@Override
		public double getInput() {
			return plant.pump.gettemperature();
		}

		@Override
		public double getOutput() {
			return plant.pump.getRotationSpeed();
		}

		@Override
		public double Consigne() {
			return plant.pump.getregulation_setpoint();
		}

	};
	
	public void control(){		
			pid01.compute();
	}	
}
