package control2;

public class Control_pumpGlycol_416 {

		private Mode mode;
		private Plant plant;
		private PID pid = new PID() {
			
			@Override
			public void setValue(double value) {
				plant.pumpGlycol_416.setRotationSpeed(value);
				this.inp=getInput();		
			}
			
			@Override
			public double getInput() {
				return plant.JGC416.getTCRR();
			}

			@Override
			public double getOutput() {
				return plant.pumpGlycol_416.getRotationSpeed();
			}

			@Override
			public double Consigne() {
				return 69;
			}

		};
		
		public void control(){		
			if (mode==Mode.RUN){
				pid.compute();
			}
			else{
				plant.pumpGlycol_320.setRotationSpeed(0);
			}
		}	
}

