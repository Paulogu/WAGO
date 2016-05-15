package control;

public class TableInputRegister{

	public CaseTable[] Tableau;
	public int taille;
		
	public TableInputRegister(){
			this.taille=127;
			this.Tableau=new CaseTable[this.taille];
			
			this.Tableau[0].address=0;
			for (int i=1;i<this.taille;i++){
				this.Tableau[i].address=i+2;
			}
			
			this.Tableau[1].name="TESI_J320";
			this.Tableau[2].name="TESI_J416";
			this.Tableau[3].name="TCRA_J320";
			this.Tableau[4].name="TCRA_J416";
			this.Tableau[5].name="TCRR_J320";
			this.Tableau[6].name="TCRR_J416";
			this.Tableau[7].name="TFA_J320";
			this.Tableau[8].name="TFA_J416";
			this.Tableau[9].name="TFR_J320";
			this.Tableau[10].name="TFR_J416";
			
			this.Tableau[11].name= "J320W_SP.tOut";
			this.Tableau[12].name= "J320W_SP.tIn";
			this.Tableau[13].name= "J320W_SP.volumeFlow";
			this.Tableau[14].name= "J320W_SP.thermalPower";
			this.Tableau[15].name= "J320W_SP.totalEnergy";
			
			this.Tableau[16].name= "J416W_SP.tOut";
			this.Tableau[17].name= "J416W_SP.tIn";
			this.Tableau[18].name= "J416W_SP.volumeFlow";
			this.Tableau[19].name= "J416W_SP.thermalPower";
			this.Tableau[20].name= "J416W_SP.totalEnergy";
			
			this.Tableau[21].name= "TRS";
			this.Tableau[22].name= "TRIT";
			this.Tableau[23].name= "TRST";
			this.Tableau[24].name= "TRSA"; //Aerocondenseur
			this.Tableau[25].name= "TRSP";
			
			this.Tableau[26].name= "TES";
			this.Tableau[27].name= "PRS";
			this.Tableau[28].name= "T_RPUMP_SEALING";
			this.Tableau[29].name= "PRST";
			this.Tableau[30].name= "DR";
			this.Tableau[31].name= "T_AMB";
			this.Tableau[32].name= "T_CONT";
			this.Tableau[33].name= "ALT1";
			this.Tableau[34].name= "ACLT1";
			
			this.Tableau[35].name= "COND1";
			this.Tableau[36].name= "COND3";
			this.Tableau[37].name= "COND_EnergyMeter.activePower";
			this.Tableau[38].name= "COND_EnergyMeter.positiveActiveEnergy";
			this.Tableau[39].name= "COND_EnergyMeter.negativeActiveEnergy";
			this.Tableau[40].name= "GLOBAL_EnergyMeter.activePower";
			this.Tableau[41].name= "GLOBAL_EnergyMeter.reactivePower";
			this.Tableau[42].name= "GLOBAL_EnergyMeter.positiveActiveEnergy";
			this.Tableau[43].name= "GLOBAL_EnergyMeter.negativeActiveEnergy";
			
			this.Tableau[44].name= "RPUMP.pump_A.pIn"; // Aerocondenseur
			this.Tableau[45].name= "RPUMP.pump_A.pOut";
			this.Tableau[46].name= "RPUMP.regulation_setpoint";
			this.Tableau[47].name= "RPUMP.temperature";
			this.Tableau[48].name= "RPUMP.pump_A.elec_consumption";
			this.Tableau[49].name= "RPUMP.pump_A.flow";
			this.Tableau[50].name= "RPUMP.pump_A.rotation_speed";
			this.Tableau[51].name= "RPUMP.pump_A.time_to_maintenance";
			this.Tableau[52].name= "RPUMP.pump_A.status";
			
			this.Tableau[53].name= "WPUMP1.regulation_setpoint";
			this.Tableau[54].name= "WPUMP1.temperature";
			this.Tableau[55].name= "WPUMP1.pump_A.pIn";
			this.Tableau[56].name= "WPUMP1.pump_A.pOut";
			this.Tableau[57].name= "WPUMP1.pump_A.elec_consumption";
			this.Tableau[58].name= "WPUMP1.pump_A.flow";
			this.Tableau[59].name= "WPUMP1.pump_A.rotation_speed";
			this.Tableau[60].name= "WPUMP1.pump_A.time_to_maintenance";
			this.Tableau[61].name= "WPUMP1.pump_A.status";
			this.Tableau[62].name= "WPUMP1.pump_B.pIn";
			this.Tableau[63].name= "WPUMP1.pump_B.pOut";
			this.Tableau[64].name= "WPUMP1.pump_B.elec_consumption";
			this.Tableau[65].name= "WPUMP1.pump_B.flow";
			this.Tableau[66].name= "WPUMP1.pump_B.rotation_speed";
			this.Tableau[67].name= "WPUMP1.pump_B.time_to_maintenance";
			this.Tableau[68].name= "WPUMP1.pump_B.status";
			
			this.Tableau[69].name= "WPUMP2.regulation_setpoint";
			this.Tableau[70].name= "WPUMP2.temperature";
			this.Tableau[71].name= "WPUMP2.pump_A.pIn";
			this.Tableau[72].name= "WPUMP2.pump_A.pOut";
			this.Tableau[73].name= "WPUMP2.pump_A.elec_consumption";
			this.Tableau[74].name= "WPUMP2.pump_A.flow";
			this.Tableau[75].name= "WPUMP2.pump_A.rotation_speed";
			this.Tableau[76].name= "WPUMP2.pump_A.time_to_maintenance";
			this.Tableau[77].name= "WPUMP2.pump_A.status";
			this.Tableau[78].name= "WPUMP2.pump_B.pIn";
			this.Tableau[79].name= "WPUMP2.pump_B.pOut";
			this.Tableau[80].name= "WPUMP2.pump_B.elec_consumption";
			this.Tableau[81].name= "WPUMP2.pump_B.flow";
			this.Tableau[82].name= "WPUMP2.pump_B.rotation_speed";
			this.Tableau[83].name= "WPUMP2.pump_B.time_to_maintenance";
			this.Tableau[84].name= "WPUMP2.pump_B.status";
			
			this.Tableau[85].name= "ACCV1";
			this.Tableau[86].name= "ACCV2";
			this.Tableau[87].name= "ContainerCooling";
			
			this.Tableau[88].name= "IC01.currentSpeed";
			this.Tableau[89].name= "IC01.AFE_OLI_PremierDef";
			this.Tableau[90].name= "IC01.setpoint_rotSpeed";
			this.Tableau[91].name= "IC01.currentPower";
			
			this.Tableau[92].name= "IC01.tempKTY1S1";
			this.Tableau[93].name= "IC01.tempKTY1S2";
			this.Tableau[94].name= "IC01.tempKTY1S3";
			this.Tableau[95].name= "IC01.tempKTY1S4";
			this.Tableau[96].name= "IC01.tempKTY2S1";
			this.Tableau[97].name= "IC01.tempKTY2S2";
			this.Tableau[98].name= "IC01.tempKTY2S3";
			this.Tableau[99].name= "IC01.tempKTY2S4";
			
			this.Tableau[100].name= "IC01.AFE_ORI_Vdc";
			this.Tableau[101].name= "IC01.AFE_ORI_Iac";
			this.Tableau[102].name= "IC01.AFE_ORI_Freq";
			this.Tableau[103].name= "IC01.AFE_ORI_Vac";
			this.Tableau[104].name= "IC01.AFE_OLI_StatusW1";
			
			this.Tableau[105].name= "IC01.OND1_ORI_Iac";
			this.Tableau[106].name= "IC01.OND1_ORI_Vac";
			this.Tableau[107].name= "IC01.OND1_ORI_Iq";
			this.Tableau[108].name= "IC01.OND1_ORI_Id";
			this.Tableau[109].name= "IC01.OND1_OLI_StatusW1";
			
			this.Tableau[110].name= "IC01.OND2_ORI_Iac";
			this.Tableau[111].name= "IC01.OND2_ORI_Vac";
			this.Tableau[112].name= "IC01.OND2_ORI_Iq";
			this.Tableau[113].name= "IC01.OND2_ORI_Id";
			this.Tableau[114].name= "IC01.OND2_OLI_StatusW1";
			
			this.Tableau[115].name= "IC01.OND3_ORI_Iac";
			this.Tableau[116].name= "IC01.OND3_ORI_Vac";
			this.Tableau[117].name= "IC01.OND3_ORI_Iq";
			this.Tableau[118].name= "IC01.OND3_ORI_Id";
			this.Tableau[119].name= "IC01.OND3_OLI_StatusW1";
			
			this.Tableau[120].name= "IC01.OND4_ORI_Iac";
			this.Tableau[121].name= "IC01.OND4_ORI_Vac";
			this.Tableau[122].name= "IC01.OND4_ORI_Iq";
			this.Tableau[123].name= "IC01.OND4_ORI_Id";
			this.Tableau[124].name= "IC01.OND4_OLI_StatusW1";
			
			this.Tableau[125].name= "IC01.AFE_OLI_PremierDef";
			this.Tableau[126].name= "IC01.OND1_OLI_PremierDef";
			this.Tableau[127].name= "IC01.OND2_OLI_PremierDef";
			
	}
}

