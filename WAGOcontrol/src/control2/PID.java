package control2;

public abstract class PID {
	
	public double K,Ti,deltaT;
	public double max,min;
	public double inp;
	
	public abstract void setValue(double value);
	
	public abstract double getInput();
	
	public abstract double getOutput();
	
	public abstract double Consigne();


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
