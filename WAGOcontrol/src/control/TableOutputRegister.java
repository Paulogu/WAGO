package control;

public class TableOutputRegister{

	class CaseT extends CaseTable{
		public short value;
	}
	public CaseT[] Tableau;
	public int taille;
	
	public TableOutputRegister(){
		this.taille=9;
		this.Tableau=new CaseT[this.taille];
		
		this.Tableau[0].name="TCRR_J416"; //Moteur
		this.Tableau[1].name="TCRR_J320"; //Moteur
		this.Tableau[2].name="COND1_2"; //Aerocondenseur
		this.Tableau[3].name="COND3_4"; //Aerocondenseur
		this.Tableau[4].name="ContainerCooling";
		this.Tableau[5].name="TES_OUT";
		this.Tableau[6].name="ACCV1";
		this.Tableau[7].name="ACCV2";
		this.Tableau[8].name="IC01.setpoint_rotSpeed";
		
	}
}
