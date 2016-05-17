package control2;

public class Control01 {

	private Plant plant;
	private PID pid01 = new PID() {
		
		@Override
		public void setValue(double value) {
			plant.pump.setRotationSpeed(value);
		}
		
		@Override
		public double getInput() {
			return plant.pump.gettemperature();
		}

		@Override
		public double getInputP() {
			return plant.pump.gettemperatureP();
		}

		@Override
		public double getOutputP() {
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
