package control2;

public class Control_Auxiliaire_Huile {
	
	private Plant plant;
	private double margin;
	private double hysteresis;
	
	static double TsatFromP(double value){
		return Math.pow(Math.log(value),4) * 0.7101 + Math.pow(Math.log(value),3) * 3.4647 + Math.pow(Math.log(value),2) * 13.655 + Math.log(value) * 57.095 + 14.819;
	}
	
	public void control(Mode mode){
		if (mode==Mode.EmergencyShutdown || mode==Mode.Shutdown){
			plant.aux1.setALAC1(false);
		}
		if (plant.aux1.getALAC1()==false && plant.aux1.getALT1() < TsatFromP(plant.pumpWater.getinPressure())+ margin + hysteresis){
			plant.aux1.setALAC1(false);
		}
		else if (plant.aux1.getALAC1()==true && plant.aux1.getALT1() > TsatFromP(plant.pumpWater.getinPressure())+ margin){
			plant.aux1.setALAC1(true);
		}
		else if (plant.aux1.getALAC1()==true && plant.aux1.getALT1() < TsatFromP(plant.pumpWater.getinPressure())+ margin){
			plant.aux1.setALAC1(false);
		}
		else{
			plant.aux1.setALAC1(true);
		}
	}
}
