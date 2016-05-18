package control2;

public class Control_Auxiliaire_Refrig {
	
	private Plant plant;
	private PID pid = new PID() {
		
		@Override
		public void setValue(double value) {
			plant.aux2.setACCV2(value);
			this.inp=getInput();		
		}
		
		@Override
		public double getInput() {
			return plant.aux2.getACLT1();
		}

		@Override
		public double getOutput() {
			return plant.aux2.getACCV2();
		}

		@Override
		public double Consigne() {
			return plant.aux2.getaclt1_setpoint();
		}

	};
	
	public void control(){		
			pid.compute();
	}	
}
