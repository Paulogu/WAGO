package control2;

public class Control_Motor_416 {
	
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
			return plant.JGC416.getTCRA();
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
			return plant.JGC416.getTCRA();
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
		if (mode==Mode.STOP){
			plant.JGC416.setValveToORC(false);
			plant.JGC416.setValveToBypass(true);
			plant.JGC416.setActuatorToORC(false);
			plant.JGC416.setActuatorToBypass(true);
		}

		n++;
		if (n==15){
			pid_actuateur.compute();
			pid_valve.compute();
			n=0;
		}
			
		if (mode==Mode.RUN){	
			if (position_actu-(int)pid_actuateur.getOutput()>0){
				n1++;
				plant.JGC416.setActuatorToORC(true);
				if (position_actu-(int)pid_actuateur.getOutput()>=n1){
					n1=0;
					plant.JGC416.setActuatorToORC(false);
					position_actu=(int)pid_actuateur.getOutput();
				}
			}
			else{
				n1++;
				plant.JGC416.setActuatorToBypass(true);
				if (position_actu-(int)pid_actuateur.getOutput()>=n1){
					n1=0;
					plant.JGC416.setActuatorToBypass(false);
					position_actu=(int)pid_actuateur.getOutput();
				}
			}
			
			
			if (position_valve-(int)pid_valve.getOutput()>0){
				n2++;
				plant.JGC416.setValveToORC(true);
				if (position_valve-(int)pid_valve.getOutput()>=n2){
					n2=0;
					plant.JGC416.setValveToORC(false);
					position_valve=(int)pid_actuateur.getOutput();
				}
			}
			else{
				n2++;
				plant.JGC416.setValveToBypass(true);
				if (position_valve-(int)pid_valve.getOutput()>=n2){
					n2=0;
					plant.JGC416.setValveToBypass(false);
					position_valve=(int)pid_actuateur.getOutput();
				}
			}
			
		}
		if (mode==Mode.RunToStop){

		}
		if (mode==Mode.StopToRun){
			if(plant.JGC416.gettotalEnergy()>0.03){
				if (position_actu-(int)pid_actuateur.getOutput()>0){
					n1++;
					plant.JGC416.setActuatorToORC(true);
					if (position_actu-(int)pid_actuateur.getOutput()>=n1){
						n1=0;
						plant.JGC416.setActuatorToORC(false);
						position_actu=(int)pid_actuateur.getOutput();
					}
				}
				else{
					n1++;
					plant.JGC416.setActuatorToBypass(true);
					if (position_actu-(int)pid_actuateur.getOutput()>=n1){
						n1=0;
						plant.JGC416.setActuatorToBypass(false);
						position_actu=(int)pid_actuateur.getOutput();
					}
				}
				this.mode=Mode.RUN;
			}
		}
	}
}
