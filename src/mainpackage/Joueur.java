package mainpackage;
import java.util.ArrayList;
public class Joueur {
	private String nom;
	private ArrayList<Pion> listeChevaux;
	private Case CaseDeDepart;
	private Couleur couleur;
	public Joueur(String nom, Couleur c) {
		this.nom = nom;
		this.couleur = c;
	}
	public Case getCaseDeDepart() {
		return CaseDeDepart;
		
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
