package control2;

public class Control_Motor_320 {
	
	private Mode mode;
	private Plant plant;
	private PID pid_actuateur = new PID() {
		
		double out;
		@Override
		public void setValue(double value) {	
			this.out=value;
		}
		
		@Override
		public double getInput() {
			return plant.JGC320.getTCRA();
		}

		@Override
		public double getOutput() {
			return out;
		}

		@Override
		public double Consigne() {
			return 105;
		}

	};
	
	private PID pid_valve = new PID() {
		
		double out;
		@Override
		public void setValue(double value) {
			this.out=value;
		}
		
		@Override
		public double getInput() {
			return plant.JGC320.getTCRA();
		}

		@Override
		public double getOutput() {
			return out;
		}

		@Override
		public double Consigne() {
			return 80;
		}

	};
	
	int n=0,n1=0,n2=0;
	int position_actu=0,position_valve=0;
	public void control(){
		this.pid_valve.min=0;
		this.pid_actuateur.min=0;
		this.pid_valve.max=15;
		this.pid_actuateur.max=15;
		if (this.mode==Mode.STOP){
			plant.JGC320.setValveToORC(false);
			plant.JGC320.setValveToBypass(true);
			plant.JGC320.setActuatorToORC(false);
			plant.JGC320.setActuatorToBypass(true);
		}
		if (this.mode==Mode.RUN){
			n++;
			if (n==15){
				pid_actuateur.compute();
				pid_valve.compute();
				n=0;
			}
			
			
			if (position_actu-(int)pid_actuateur.getOutput()>0){
				n1++;
				plant.JGC320.setActuatorToORC(true);
				if (position_actu-(int)pid_actuateur.getOutput()==n1){
					n1=0;
					plant.JGC320.setActuatorToORC(false);
					position_actu=(int)pid_actuateur.getOutput();
				}
			}
			else{
				n1++;
				plant.JGC320.setActuatorToBypass(true);
				if (position_actu-(int)pid_actuateur.getOutput()==n1){
					n1=0;
					plant.JGC320.setActuatorToBypass(false);
					position_actu=(int)pid_actuateur.getOutput();
				}
			}
			
			
			if (position_valve-(int)pid_valve.getOutput()>0){
				n2++;
				plant.JGC320.setValveToORC(true);
				if (position_valve-(int)pid_valve.getOutput()==n2){
					n2=0;
					plant.JGC320.setValveToORC(false);
					position_valve=(int)pid_actuateur.getOutput();
				}
			}
			else{
				n2++;
				plant.JGC320.setValveToBypass(true);
				if (position_valve-(int)pid_valve.getOutput()==n2){
					n2=0;
					plant.JGC320.setValveToBypass(false);
					position_valve=(int)pid_actuateur.getOutput();
				}
			}
			
		}
		if (this.mode==Mode.RunToStop){
			//if()
		}
		if (this.mode==Mode.StopToRun){
			
		}
	}
}
