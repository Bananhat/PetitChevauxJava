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
		numJ = 0;
		listeJoueur = new ArrayList<Joueur>();
		plateau = new Plateau();
		initialiserPlateau();
		initialiserJoueurs(4);
		initEcurie();
		
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
                System.out.println(Couleur.values()[i]);
               
            }
        }
      
	}
	public void initEcurie() {
		
		for(int i=0; i<4;i++) //Init de l'écurie et on ajoute les chevaux a l'écurie par défaut
		{
			for(int j=0; j<4;j++)
			{
				plateau.getEcuries().add(new CaseEcurie());		
				plateau.getEcuries().get( (i*4) + j ).ajouteCheval(listeJoueur.get(i).getChevaux().get(j)); 
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
				plateau.getEchelle().get(i).add(new CaseDEchelle());
			}
	
		}
		
		
	}
	
	
	private int lancerDe() {
		return (int) (Math.random() * (6)+1);
	}
	
	// Game
	public void jouerUnTour()
	{

		int reponse;
		String reponseSortir;
		this.de = lancerDe();
		System.out.println("A Joueur "+(numJ+1)+" de jouer");
		System.out.println("La valeur du dé est : "+de);
		jCourant = listeJoueur.get((int) (Math.random() * (0)));
		
		if(!jCourant.getSorti()) // si le jCourant n'a aucun cheval sur le plateau 
		{
				if(de == 6) 
				{
					System.out.println("Quel cheval voulez vous sortir ? :");
					reponse = sc.nextInt();
					jCourant.getCaseDeDepart().ajouteCheval(jCourant.getChevaux().get(reponse));
					plateau.retirer(jCourant, jCourant.getChevaux().get(reponse));
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
					System.out.println("Quel cheval voulez vous sortir ? :");
					reponse = sc.nextInt();
					jCourant.getCaseDeDepart().ajouteCheval(jCourant.getChevaux().get(reponse));
				}
				else 
				{
					System.out.println("Quel cheval voulez vous deplacer ? :");
					reponse = sc.nextInt();
					jCourant.getChevaux().get(reponse).deplacerPionA(de, plateau);
				}
				numJ--;
			}
		}
		if(numJ==3) 
		{
			numJ=0;
		}
		else {
		numJ++;
		}
		
			
	}
	
	// Getter Setter
	public boolean estPartieTermine() 
	{
		return true;
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
	
	
	private void mangerLesPions(Case c) 
	{
		
	}
	
}
