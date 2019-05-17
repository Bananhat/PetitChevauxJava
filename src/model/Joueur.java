package model;
import java.util.ArrayList;


import vue.Case;
import vue.CaseDeChemin;
import vue.Couleur;
import vue.Plateau;

/**
 * La classe joueur défini les propriété d'un joueur 
 */
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
	
	/**
	 * Sors un cheval sur le plateau et vérifie si il doit ejecter un cheval qui serait sur case de départ
	 *@param pion Le pion a ejecter
	 *@param plateau Le plateau de jeu
	 * @return si l'opération s'est bien déroulé
	 */
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
	
	/**
	 * Vérifie si le joueur peut encore sortir un pion ou si ils sont tous en piste
	 *@param p Le plateau de jeu
	 * @return le nombre de chevaux dans l'écurie
	 */
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

	/**
	 * Vérifie si il peut déplacer un autres pions si jamais l'exception de la case pleine apparait
	 *@param pion Le pion qu'on ne doit pas considérer comme sorti
	 * @return si d'autres pions sont déplacable en cas d'erreur
	 */
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
