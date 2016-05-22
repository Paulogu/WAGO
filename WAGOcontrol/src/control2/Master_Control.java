package control2;

import java.util.concurrent.TimeUnit;

public class Master_Control {

	public static void main(String[] args) throws InterruptedException{
		
		Mode mode;
		mode=Mode.STOP;
		Control_Aero aero = new Control_Aero();
		Control_Auxiliaire_Huile aux1 = new Control_Auxiliaire_Huile();
		Control_Auxiliaire_Refrig aux2 = new Control_Auxiliaire_Refrig();
		Control_Container_Cooling cool = new Control_Container_Cooling();
		Control_Motor_320 M1 = new Control_Motor_320();
		Control_Motor_416 M2 = new Control_Motor_416();
		Control_pumpGlycol_320 pumpG1 = new Control_pumpGlycol_320();
		Control_pumpGlycol_416 pumpG2 = new Control_pumpGlycol_416();
		Control_pumpWater pumpW = new Control_pumpWater();
		Control_Turbo turbo = new Control_Turbo();
		
		while(true){
			TimeUnit.SECONDS.sleep(1);
			aero.control(mode);
			aux1.control(mode);
			aux2.control(mode);
			cool.control(mode);
			M1.control(mode);
			M2.control(mode);
			pumpG1.control();
			pumpG2.control();
			pumpW.control();
			turbo.control(mode);
		}
	}
}
