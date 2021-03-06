package control;

public class TableInputBoolean{

	class CaseT extends CaseTable{
		public boolean value;
	}
	public CaseT[] Tableau;
	public int taille;
	
	public TableInputBoolean(){
		this.taille=101;
		this.Tableau=new CaseT[this.taille];
		for (int i=0;i<this.taille;i++){
			this.Tableau[i].address=i;
		}
		
		this.Tableau[0].name="OPERATING_MODE_StartingUp_Possible";
		this.Tableau[1].name="OPERATING_MODE_TurbineStopping_Possible";
		this.Tableau[2].name="OPERATING_MODE_Started_Possible";
		this.Tableau[3].name="OPERATING_MODE_ShuttingDown_Possible";
		this.Tableau[4].name="EMERGENCY_BUTTON_1_NOTPRESSED";
		this.Tableau[5].name="EMERGENCY_BUTTON_2_NOTPRESSED";
		this.Tableau[6].name="ALLS1";
		this.Tableau[7].name="ACLS1";
		this.Tableau[8].name="ALFCI1";
		this.Tableau[9].name="ACP1";
		this.Tableau[10].name= "ACP2";
		this.Tableau[11].name= "ALAC1";
		this.Tableau[12].name= "BYPASS_TURBINE.isBypassLimitswitch";
		this.Tableau[13].name= "BYPASS_TURBINE.isToOrcLimitswitch";
		this.Tableau[14].name= "BYPASS_TURBINE.setpointPosition = TO_ORC";
		this.Tableau[15].name= "J320W_V1.isBypassLimitswitch";
		this.Tableau[16].name= "J320W_V1.isToOrcLimitswitch";
		this.Tableau[17].name= "J320W_V1.setpointPosition = TO_ORC";
		this.Tableau[18].name= "J416W_V1.isBypassLimitswitch";
		this.Tableau[19].name= "J416W_V1.isToOrcLimitswitch";
		this.Tableau[20].name= "J416W_V1.setpointPosition = TO_ORC";
		this.Tableau[21].name= "Actuateur_J320.isBypassLimitswitch";
		this.Tableau[22].name= "Actuateur_J320.isToOrcLimitswitch";
		this.Tableau[23].name= "Actuateur_J320.setpointPosition = TO_ORC";
		this.Tableau[24].name= "Actuateur_J416.isBypassLimitswitch";
		this.Tableau[25].name= "Actuateur_J416.isToOrcLimitswitch";
		this.Tableau[26].name= "Actuateur_J416.setpointPosition = TO_ORC";
		this.Tableau[27].name= "Rpump_isLeaking";
		this.Tableau[28].name= "OPERATING_MODE_Change_Ack";
		this.Tableau[29].name= "SAFETY_IS_OK";
		this.Tableau[30].name= "IC01.CONV_OBI_Marche";
		this.Tableau[31].name= "IC01.CONV_OBI_Pret";
		this.Tableau[32].name= "IC01.CONV_OBI_Defaut";
		this.Tableau[33].name= "IC01.CONV_OBI_FreinOn";
		this.Tableau[34].name= "IC01.AFE_OBI_Defaut";
		this.Tableau[35].name= "IC01.OND1_OBI_Defaut";
		this.Tableau[36].name= "IC01.OND2_OBI_Defaut";
		this.Tableau[37].name= "IC01.OND3_OBI_Defaut";
		this.Tableau[38].name= "IC01.OND4_OBI_Defaut";
		this.Tableau[39].name= "IC01.AQY_OBI_DefautCom";
		this.Tableau[40].name= "IC01.AQY_OBI_AlimVentilDef";
		this.Tableau[41].name= "IC01.AQY_OBI_AlimRelayDef";
		this.Tableau[42].name= "IC01.AQY_OBI_AlimCPIDef";
		this.Tableau[43].name= "IC01.AQY_OBI_Alim24VdcDef";
		this.Tableau[44].name= "IC01.AQY_OBI_Alim24VdcDriveDef";
		this.Tableau[45].name= "IC01.AQY_OBI_AlimFreinageDef";
		this.Tableau[46].name= "IC01.AQY_OBI_DefautAU";
		this.Tableau[47].name= "IC01.CONV_OBI_EtherDef";
		this.Tableau[48].name= "IC01.CONV_OBI_EL3208Def";
		this.Tableau[49].name= "IC01.KTY1S1_OBI_CapteurDef";
		this.Tableau[50].name= "IC01.KTY2S1_OBI_CapteurDef";
		this.Tableau[51].name= "IC01.KTY1S2_OBI_CapteurDef";
		this.Tableau[52].name= "IC01.KTY2S2_OBI_CapteurDef";
		this.Tableau[53].name= "IC01.KTY1S3_OBI_CapteurDef";
		this.Tableau[54].name= "IC01.KTY2S3_OBI_CapteurDef";
		this.Tableau[55].name= "IC01.KTY1S4_OBI_CapteurDef";
		this.Tableau[56].name= "IC01.KTY2S4_OBI_CapteurDef";
		this.Tableau[57].name= "IC01.GENS1_OBI_DefautPTC";
		this.Tableau[58].name= "IC01.GENS2_OBI_DefautPTC";
		this.Tableau[59].name= "IC01.GENS3_OBI_DefautPTC";
		this.Tableau[60].name= "IC01.GENS4_OBI_DefautPTC";
		this.Tableau[61].name= "IC01.CONV_OBI_Def30F1F2";
		this.Tableau[62].name= "IC01.CONV_OBI_Def35F1F2";
		this.Tableau[63].name= "IC01.CONV_OBI_Def40F1F2";
		this.Tableau[64].name= "IC01.CONV_OBI_Def45F1F2";
		this.Tableau[65].name= "IC01.CONV_OBI_AlaCPI";
		this.Tableau[66].name= "IC01.CONV_OBI_DefCPI";
		this.Tableau[67].name= "IC01.CONV_OBI_DefSynchro";
		this.Tableau[68].name= "IC01.CONV_OBI_22QF1Def";
		this.Tableau[69].name= "ERR_MSGS.NidecAlarme";
		this.Tableau[70].name= "ERR_MSGS.NidecDefaut";
		this.Tableau[71].name= "ERR_MSGS.NidecBR";
		this.Tableau[72].name= "ERR_MSGS.NidecTooHot";
		this.Tableau[73].name= "ERR_MSGS.NidecADSerror";
		this.Tableau[74].name= "ERR_MSGS.NidecADSWatchdogError";
		this.Tableau[75].name= "ERR_MSGS.Wpump1_NoLiquid";
		this.Tableau[76].name= "ERR_MSGS.Wpump1a_alarm";
		this.Tableau[77].name= "ERR_MSGS.Wpump1b_alarm";
		this.Tableau[78].name= "ERR_MSGS.Wpump1_WriteModbusError";
		this.Tableau[79].name= "ERR_MSGS.Wpump2_NoLiquid";
		this.Tableau[80].name= "ERR_MSGS.Wpump2a_alarm";
		this.Tableau[81].name= "ERR_MSGS.Wpump2b_alarm";
		this.Tableau[82].name= "ERR_MSGS.Wpump2_WriteModbusError";
		this.Tableau[83].name= "ERR_MSGS.Rpump_NoLiquid";
		this.Tableau[84].name= "ERR_MSGS.Rpump_alarm";
		this.Tableau[85].name= "ERR_MSGS.Rpump_WriteModbusError";
		this.Tableau[86].name= "ERR_MSGS.PRS_tooHigh";
		this.Tableau[87].name= "ERR_MSGS.PRIT_tooHigh";
		this.Tableau[88].name= "ERR_MSGS.PRST_tooHigh";
		this.Tableau[89].name= "ERR_MSGS.RPUMP_pIn_tooHigh";
		this.Tableau[90].name= "ERR_MSGS.RPUMP_pOut_tooHigh";
		this.Tableau[91].name= "ERR_MSGS.WPUMP1_pIn_tooHigh";
		this.Tableau[92].name= "ERR_MSGS.WPUMP1_pOut_tooHigh";
		this.Tableau[93].name= "ERR_MSGS.WPUMP2_pIn_tooHigh";
		this.Tableau[95].name= "ERR_MSGS.WPUMP2_pOut_tooHigh";
		this.Tableau[96].name= "ERR_MSGS.ALT1_oilTooLow";
		this.Tableau[97].name= "ERR_MSGS.Actuateur_J320_BLOCKED";
		this.Tableau[98].name= "ERR_MSGS.Actuateur_J416_BLOCKED";
		this.Tableau[99].name= "Reset_ESB_Ack";
		this.Tableau[100].name= "Reset_IC01_Ack";
		this.Tableau[101].name= "Reset_Control_Ack";
	}
}
