package control;

public class TableOutputBoolean{

	class CaseT extends CaseTable{
		public boolean value;
	}
	public CaseT[] Tableau;
	public int taille;
	
	public TableOutputBoolean(){
		this.taille=21;
		this.Tableau=new CaseT[this.taille];
		
		this.Tableau[0].name="Actuateur_J416_SET_TO_ORC";
		this.Tableau[1].name="Actuateur_J416_SET_TO_BYPASS";
		this.Tableau[2].name="Actuateur_J320_SET_TO_ORC";
		this.Tableau[3].name="Actuateur_J320_SET_TO_BYPASS";
		this.Tableau[4].name="J416W_V1_SET_TO_ORC";
		this.Tableau[5].name="J416W_V1_SET_TO_BYPASS";
		this.Tableau[6].name="J320W_V1_SET_TO_ORC";
		this.Tableau[7].name="J320W_V1_SET_TO_BYPASS";
		
		this.Tableau[8].name="ACP1_OUT";
		this.Tableau[9].name="ACP2_OUT";
		
		this.Tableau[10].name="ALAC1";
		this.Tableau[11].name="BYPASS_TURBINE_SET_TO_ORC";
		this.Tableau[12].name="BYPASS_TURBINE_SET_TO_BYPASS";
		this.Tableau[13].name="BR_isNotConnected_OUT";
		
		this.Tableau[14].name="SAFETY_IS_OK";
		this.Tableau[15].name="SAFETY_FB_ERR";
		this.Tableau[16].name="SAFETY_COM_ERR";
		this.Tableau[17].name="SAFETY_OUT_ERR";
		this.Tableau[18].name="SAFETY_CAN_RESTART";
		this.Tableau[19].name="SAFETY_RUN";
		this.Tableau[20].name="SAFETY_ERR_ACK";
		
	}
}
