package mainpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Partie {
	private int de;
	private Plateau plateau;
	private ArrayList<Joueur> listeJoueur;
	private Joueur jCourant;
	private int numJ;
	private Scanner sc = new Scanner(System.in);
	public Partie() 
	{
		numJ = (int) (Math.random() * (4));
		listeJoueur = new ArrayList<Joueur>();
		plateau = new Plateau();
		initialiserPlateau();
		initialiserJoueurs(4);
		initEcurie();
		plateau.initTotalCases();
	}
	public Scanner getScan() {
		return sc;
	}
	//Init;
	public void initialiserJoueurs(int nbJoueur) 
	{
        Scanner sc = new Scanner(System.in);
        String nom="";
        if(nbJoueur>0 && nbJoueur<=4){
            for(int i=0; i<nbJoueur; i++)
            {
                System.out.println("Joueur" + (i+1) + " - Entrez votre nom : ");
                //nom = sc.nextLine();
                listeJoueur.add(new Joueur(nom, Couleur.values()[i]));
                listeJoueur.get(i).setCaseDeDepart(plateau.getChemin().get(i*14));
                for(int j=0; j<4;j++) {
                listeJoueur.get(i).getChevaux().get(j).setPos(i*14);
                }
                System.out.println(Couleur.values()[i]);
               
            }
        }
      
	}
	public void initEcurie() 
	{
		/*
		ton ancien code
			for(Joueur j : listeJoueur)
			{
				for(Pion p : j.getChevaux())
				{
					plateau.getEcuries().add(p.getCaseEc());
					p.getCaseEc().ajouteCheval(p);
				}
			}
		*/

		// TODO Il faut s'arranger pour placer les chevaux sur les bonnes cases dans la grande liste totalCases pour l'affichage.
		// TODO Il faut également modifier leur position de départ sur la bonne case dans totalCases.
		for(int j = 0;j<4;j++) {
			for(Pion p : listeJoueur.get(j).getChevaux())
			{
				plateau.getEcuries().add(p.getCaseEc());
				p.getCaseEc().ajouteCheval(p);
			}
			for(int i = 0; i < 32; i++) {
				plateau.getEcuries().add(new CaseEcurie());
			}
		}

	}
	public void initialiserPlateau() 
	{
		//Init du chemin
		for(int i=0; i<56;i++)
		{
			plateau.getChemin().add(new CaseDeChemin());
		}
		
		for(int i=0; i<4;i++) //Init case coloree
		{
			plateau.getEchelle().add(new ArrayList<CaseDEchelle>());
			for(int j=0; j<6;j++)
			{
				plateau.getEchelle().get(i).add(new CaseDEchelle(j+1));
			}
	
		}
		
		
	}
	
	
	private int lancerDe() {
		return (int) (Math.random() * (6)+1);
	}
	public void SortirCheval(int reponse)
	{
		jCourant.getCaseDeDepart().ajouteCheval(jCourant.getChevaux().get(reponse-1)); //On ajoute le cheval au chemin
		plateau.retirerEcurie(jCourant, jCourant.getChevaux().get(reponse-1)); //On retire de l'�curie
	}
	
	public boolean appDeplacement(int reponse) 
	{
		Pion cheval = jCourant.getChevaux().get(reponse-1);
		if(!cheval.aFiniTour())
		{
			return cheval.deplacerPionA(de, plateau, jCourant);
		}
		else 
		{
			return cheval.deplacementFinal(de, plateau);
		}
		
	}
	public void proposerChoixDeplacement()
	{
		int reponse;
		System.out.println("Quel cheval voulez vous deplacer ? :");
		reponse = sc.nextInt();
		appDeplacement(reponse);
	}
	
	public void proposerChoixSorti()
	{
		System.out.println("Quel cheval voulez vous sortir ? :");
		int reponse = sc.nextInt();
		
		SortirCheval(reponse);
	}
	// Game
	public void jouerUnTour()
	{
		plateau.affichage();
		//TEST SORTI ECURIE
		int i=0;
		for(Case c : plateau.getEcuries()) {
			for(Pion p : c.getChevaux()) {
				i++;
			}
		}
		System.out.println("Il y a "+i+" chevaux dans l'�curie..");
		// FIN TEST SORTI
		//TEST CHEMIN et POSITION DES CHEVAUX
		i=0;
		int j=0;
		for(Case c: plateau.getChemin()) {
			
			for(Pion p : c.getChevaux()) {
				i++;
				System.out.println("La position du cheval est "+p.getPos());
				System.out.println(j);
			}
			j++;
		}
		
		System.out.println("Il y a "+i+" chevaux sur le chemin");
		//FIN TEST CHEMIN
		
		//
		int reponse;
		String reponseSortir;
		this.de = lancerDe();
		de = 6;
		System.out.println("A Joueur "+(numJ+1)+" de jouer");
		System.out.println("La valeur du d� est : "+de);
		jCourant = listeJoueur.get(numJ);
		
		if(!jCourant.getSorti()) // si le jCourant n'a aucun cheval sur le plateau 
		{
				if(de == 6) 
				{
					proposerChoixSorti();
					numJ--;
				}
				else 
				{
					System.out.println("Vous passez votre tour...");
				}
				
		}
		else 
		{
			if(de == 6) 
			{
				sc.nextLine();
				System.out.println("Voulez vous sortir un pion ? o/n : ");
				reponseSortir = sc.nextLine();
				if(reponseSortir.equals("o"))
				{
					proposerChoixSorti();
					
				}
				else 
				{
					proposerChoixDeplacement();
				}
				numJ--;
			}
			else
			{
				proposerChoixDeplacement();
			}
		}
		if(numJ==3) 
		{
			numJ=0;
		}
		else 
		{
		numJ++;
		}
		
			
	}
	
	// Getter Setter
	public boolean estPartieTermine() 
	{
		int i=0;
		for(ArrayList<CaseDEchelle> ar : plateau.getEchelle()) {
			for(Case c : ar)
			{
				if(!c.listeChevaux.isEmpty())
				{
					for(Pion pion : c.listeChevaux) {
						i++;
						System.out.println(i);
						if(pion.getPosCaseNumerote()+1 == 1 || pion.getPosCaseNumerote()+1 == 2) {
							return false;
						}
					}
					return i==4;
				}
			}
		}
		return false;
	}
	public Joueur getJoueurCourant() {
		return this.jCourant;
	}
	public void setJoueurcourant(Joueur j) {
		this.jCourant = j;
	}
	public Plateau getPlateau() {
		return this.plateau;
	}
	public ArrayList<Joueur> getJoueurs() {
		return this.listeJoueur;
	}
	public void augmenteNum() {
		this.numJ++;
	}
	public void setNum(int i) {
		this.numJ = i;
	}
	public int getNum()
	{
		return this.numJ;
	}
	
}
