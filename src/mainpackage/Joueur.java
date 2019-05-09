package mainpackage;
import java.util.ArrayList;
public class Joueur {
	
	private String nom;
	private ArrayList<Pion> listeChevaux;
	private CaseDeChemin CaseDeDepart;
	private boolean sorti;
	private Couleur couleur;
	
	public Joueur(String nom, Couleur c) 
	{
		this.nom = nom;
		this.couleur = c;
		listeChevaux = new ArrayList<Pion>(){ { add(new Pion("1", couleur)); add(new Pion("2", couleur)); add(new Pion("3", couleur)); add(new Pion("4", couleur)); } };
	}
	public CaseDeChemin getCaseDeDepart() 
	{
		sorti = true;
		return CaseDeDepart;
		
	}
	public boolean getSorti()
	{
		return sorti;
	}
	public void setSorti(boolean s) {
		sorti = s;
	}
	
	public void setCaseDeDepart(CaseDeChemin c) {
		this.CaseDeDepart = c;
	}
	public ArrayList<Pion> getChevaux()
	{
		return listeChevaux;
	}
	public String getNom() 
	{
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Couleur getCouleur() 
	{
		return this.couleur;
	}
	public Pion choisirPion(int num, Plateau plateau) {
		return null;
	}
}
