package control2;

public class Control_Auxiliaire_Refrig {
	
	private Mode mode;
	private Plant plant;
	private int n=0;
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
		n++;
		if (mode==Mode.STOP){
			plant.aux2.setACP1(false);
			plant.aux2.setACP1(false);
			plant.aux2.setACCV1(0);
			plant.aux2.setACCV2(0);
		}
		else{
			pid.compute();
			if (n==3){
				plant.aux2.setACP1(!(plant.aux2.getACP1()));
				plant.aux2.setACP1(!(plant.aux2.getACP2()));
				n=0;
			}
		}
	}	
}
