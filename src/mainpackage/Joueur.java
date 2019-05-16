package mainpackage;
import java.util.ArrayList;

import vue.Plateau;
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
		Joueur self = this;
		listeChevaux = new ArrayList<Pion>(){ { add(new Pion("1", couleur, self)); add(new Pion("2", couleur, self)); add(new Pion("3", couleur, self)); add(new Pion("4", couleur, self)); } };
	}
	
	
	public boolean sortirCheval(Pion pion, Plateau plateau) 
	{
		if (!pion.getEstEnPiste(plateau))
		{
			
			if(!this.getCaseDeDepart().getListeChevaux().isEmpty())
			{
				pion.ejecterChevaux(plateau, pion.getPos());
			}
			this.getCaseDeDepart().ajouteCheval(pion); //On ajoute le cheval au chemin
			plateau.retirerEcurie(this, pion); //On retire de l'�curie
			pion.setSorti(true);
		
			return true;
		}
		return false;

	}
	
	public boolean resteASortir(Plateau p)
	{
		int i=0;
		for(Case ec : p.getEcuries())
		{
			for(Pion p1 : listeChevaux)
			{
				if(ec.getListeChevaux().contains(p1))
				{
					i++;
				}
			}
		}
		return i>0;
	}
	
	
	
	//Getter & Setter
	public CaseDeChemin getCaseDeDepart() 
	{
		
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


	public boolean aDautrePionSorti(Pion pion) {
		// TODO Auto-generated method stub
		for(Pion cheval : this.listeChevaux)
		{
			if(cheval != pion && cheval.getSorti() == true && !cheval.aFiniTour())
			{
				System.out.println("Vous avez d'autre pions sortis, deplacez vous avec..");
				return true;
			}
		}
		return false;
	}


}
