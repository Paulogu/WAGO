package control2;

public class Security_Check {
	
	private Plant plant;
	private boolean NidecAlarme,
					NidecDefaut,
					NidecBR,
					NidecTooHot,
					NidecADSerror,
					NidecADSWatchdogError,
					Wpump1_NoLiquid,
					Wpump1a_alarm,
					Wpump1b_alarm,
					Wpump1_WriteModbusError,
					Wpump2_NoLiquid,
					Wpump2a_alarm,
					Wpump2b_alarm,
					Wpump2_WriteModbusError,
					Rpump_NoLiquid,
					Rpump_alarm,
					Rpump_WriteModbusError,
					PRS_tooHigh,
					PRIT_tooHigh,
					PRST_tooHigh,
					RPUMP_pIn_tooHigh,
					RPUMP_pOut_tooHigh,
					WPUMP1_pIn_tooHigh,
					WPUMP1_pOut_tooHigh,
					WPUMP2_pIn_tooHigh,
					WPUMP2_pOut_tooHigh,
					ALT1_oilTooLow,
					Actuateur_J320_BLOCKED,
					Actuateur_J416_BLOCKED;
	
	public void ResetErrors(){
		this.NidecAlarme = false;
		this.NidecDefaut = false;
		this.NidecBR = false;
		this.NidecTooHot = false;
		this.NidecADSerror = false;
		this.NidecADSWatchdogError = false;
		this.Wpump1_NoLiquid = false;
		this.Wpump1a_alarm = false;
		this.Wpump1b_alarm = false;
		this.Wpump1_WriteModbusError = false;
		this.Wpump2_NoLiquid = false;
		this.Wpump2a_alarm = false;
		this.Wpump2b_alarm = false;
		this.Wpump2_WriteModbusError = false;
		this.Rpump_NoLiquid = false;
		this.Rpump_alarm = false;
		this.Rpump_WriteModbusError = false;
		this.PRS_tooHigh = false;
		this.PRIT_tooHigh = false;
		this.PRST_tooHigh = false;
		this.RPUMP_pIn_tooHigh = false;
		this.RPUMP_pOut_tooHigh = false;
		this.WPUMP1_pIn_tooHigh = false;
		this.WPUMP1_pOut_tooHigh = false;
		this.WPUMP2_pIn_tooHigh = false;
		this.WPUMP2_pOut_tooHigh = false;
		this.ALT1_oilTooLow = false;
		this.Actuateur_J320_BLOCKED = false;
		this.Actuateur_J416_BLOCKED = false;
	}
	
	public void AuxiliariesCheck (){
		if (plant.aux1.getALT1()>75){
			plant.aux1.setALAC1(true);
			plant.turbo.setsetpoint_rotSpeed(500);
		}
		
		if (plant.aux1.getALT1()<35){
			this.ALT1_oilTooLow = true;
		}
	}
	
	public void GeneratorCheck (Mode mode){
		if (plant.turbo.getCONV_OBI_Marche() && mode == Mode.Started){
				mode = Mode.ShuttingDown;
		}
		if ( plant.turbo.gettempKTY1S1() > 80
				|| plant.turbo.gettempKTY1S2() > 80
				|| plant.turbo.gettempKTY1S3() > 80
				|| plant.turbo.gettempKTY1S4() > 80
				|| plant.turbo.gettempKTY2S1() > 80
				|| plant.turbo.gettempKTY2S2() > 80
				|| plant.turbo.gettempKTY2S3() > 80
				|| plant.turbo.gettempKTY2S4() > 80){
			this.NidecTooHot = true;
			plant.aux2.setACCV1(plant.aux2.getACCV1()*2);
		}
	}
	
	public void HeatRecoverySecurityCheck (){
		if (plant.JGC320.getTCRR()>70){
			plant.JGC320.setValveToBypass(true);
		}
		if (plant.JGC416.getTCRR()>75){
			plant.JGC416.setValveToBypass(true);
		}
	}
	
	public void RefrigerantOverpressureCheck(Mode mode){
		if (plant.echang.getPRS() > 10){
			this.PRS_tooHigh = true;
			mode = Mode.ShuttingDown;
		}
		if (plant.turbo.getPRST() > 10){
			this.PRST_tooHigh = true;
			mode = Mode.ShuttingDown;
		}

		if (plant.pumpWater.getinPressure() > 10){
			this.RPUMP_pIn_tooHigh = true;
			mode = Mode.ShuttingDown;
		}

		if (plant.pumpWater.getoutPressure() > 10){
			this.RPUMP_pOut_tooHigh = true;
			mode = Mode.ShuttingDown;
		}
	}
	
	public void WaterloopOverpressureCheck (Mode mode){
		if (plant.pumpGlycol1.getinPressure() > 10){
			this.WPUMP1_pIn_tooHigh = true;
			mode = Mode.WaterloopSecurity;
		}
		
		if (plant.pumpGlycol1.getoutPressure() > 10){
			this.WPUMP1_pOut_tooHigh = true;
			mode = Mode.WaterloopSecurity;
		}

		if (plant.pumpGlycol2.getoutPressure() > 10){
			this.WPUMP2_pOut_tooHigh = true;
			mode = Mode.WaterloopSecurity;
		}

		if (plant.pumpGlycol2.getoutPressure() > 10){
			this.WPUMP2_pOut_tooHigh = true;
			mode = Mode.WaterloopSecurity;
		}
	}
}
