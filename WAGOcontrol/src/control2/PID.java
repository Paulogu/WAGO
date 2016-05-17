package control2;

public abstract class PID {
	
	public double K,Ti,deltaT;
	
	public abstract void setValue(double value);
	
	public abstract double getInput();
	
	public abstract double getInputP();
	
	public abstract double getOutputP();
	
	public abstract double Consigne();


	public void compute(){	
		double in = getInput();
		double out = 0;
		double consigne = Consigne();;
		double inp = getInputP();
		double outp = getOutputP();
		out = K*(consigne-in)+outp+K*deltaT/(2*Ti)*(in+inp);
		setValue(out);
	}
}
