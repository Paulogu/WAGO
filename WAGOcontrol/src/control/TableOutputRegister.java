package control;

public class TableOutputRegister{

	public CaseTable[] Tableau;
	public int taille;
	
	public TableOutputRegister(){
		this.taille=8;
		this.Tableau=new CaseTable[this.taille];
		
		this.Tableau[0].name="TCRR_J416";
		this.Tableau[1].name="TCRR_J320";
		this.Tableau[2].name="COND1_2";
		this.Tableau[3].name="COND3_4";
		this.Tableau[4].name="ContainerCooling";
		this.Tableau[5].name="TES_OUT";
		this.Tableau[6].name="ACCV1";
		this.Tableau[7].name="ACCV2";
		
	}
}
