package control2;

public abstract class PID {
	
	public double K=0.1,Ti=30,deltaT=1;
	public double max,min;
	public double inp;
	
	public abstract void setValue(double value);
	
	public abstract double getInput();
	
	public abstract double getOutput();
	
	public abstract double Consigne();
	
	static double TsatFromP(double value){
		return Math.pow(Math.log(value),4) * 0.7101 + Math.pow(Math.log(value),3) * 3.4647 + Math.pow(Math.log(value),2) * 13.655 + Math.log(value) * 57.095 + 14.819;
	}

	public void compute(){	
		double in = getInput();
		double out = 0;
		double consigne = Consigne();;
		double outp = getOutput();
		out = K*(consigne-in)+outp+K*deltaT/(2*Ti)*(in+inp);
		
		if (out>max){
			out = max;
		}
		
		if (out<min){
			out = min;
		}
		setValue(out);
	}
}
