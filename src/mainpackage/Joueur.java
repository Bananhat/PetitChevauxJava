package mainpackage;
import java.util.ArrayList;
public class Joueur {
	private String nom;
	private ArrayList<Pion> listeChevaux;
	private Case CaseDeDepart;
	private Couleur couleur;
	public Joueur(String nom, Couleur c) 
	{
		this.nom = nom;
		this.couleur = c;
		listeChevaux = new ArrayList<Pion>(){ { add(new Pion("1", couleur)); add(new Pion("2", couleur)); add(new Pion("3", couleur)); add(new Pion("4", couleur)); } };
	}
	public Case getCaseDeDepart() {
		return CaseDeDepart;
		
	}
	public boolean aucunChevauxSorti(Plateau plateau)
	{
		int ct=0;
		for(Case c : plateau.getEcuries())
		{
			for(Pion p : c.getChevaux())
			{
				for(Pion p1 : listeChevaux)
				{
					if(p1 == p) 
					{
						ct++;
					}
				}
			}
		}
		return ct == 4;
	}
	
	public void setCaseDeDepart(Case c) {
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
