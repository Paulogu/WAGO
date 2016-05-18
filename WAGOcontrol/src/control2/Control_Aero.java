package control2;

public class Control_Aero {
	
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
	
	public void control(){		
			pid.compute();
	}
}
