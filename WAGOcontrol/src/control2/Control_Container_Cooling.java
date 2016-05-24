package control2;

public class Control_Container_Cooling {
	
	private Mode mode;
	private Plant plant;
	private PID pid = new PID() {
		
		@Override
		public void setValue(double value) {
			plant.cool.setContainerCooling(value);
			this.inp=getInput();		
		}
		
		@Override
		public double getInput() {
			return plant.cool.getT_CONT();
		}

		@Override
		public double getOutput() {
			return plant.cool.getContainerCooling();
		}

		@Override
		public double Consigne() {
			return 35;
		}

	};
	
	public void control(){
		this.pid.max=327.67;
		this.pid.min=this.pid.max*0.1;
		if (mode==Mode.STOP){
			plant.cool.setContainerCooling(0);
		}
		else{
			pid.compute();
		}
	}
}
