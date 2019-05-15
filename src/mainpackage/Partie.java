package mainpackage;
/**
 * La classe <b> Partie </p> contient la boucle principale du jeu et les m�thodes d'initialisations 
 * @author Samuel	
 */
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
		
		//Test Sauv
		Pion p = this.listeJoueur.get(0).getChevaux().get(0);
		p.setPos(52);
		plateau.retirerEcurie(this.listeJoueur.get(0), p);
		plateau.getChemin().get(p.getPos()).getChevaux().add(p);
		Pion p2 = this.listeJoueur.get(3).getChevaux().get(0);
		p2.setPos(51);
		plateau.retirerEcurie(this.listeJoueur.get(3), p2);
		plateau.getChemin().get(p2.getPos()).getChevaux().add(p2);
		
		
		
		plateau.initTotalCases();
	}
	public Scanner getScan() {
		return sc;
	}
	/**
     * Initialise chaque joueur en demandant son nom et en lui ajoutant des chevaux
     * 
     * @param nbJoueur le nombre de joueur
     */
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
	public void ajouteEcurie(int indice) {
		for(int i = 0; i < indice; i++) {
			plateau.getEcuries().add(new CaseEcurie());
		}
	}
	public void initEcurie() 
	{
		ajouteEcurie(12);
		for(Pion p : listeJoueur.get(0).getChevaux())
		{
			plateau.getEcuries().add(p.getCaseEc());
			p.getCaseEc().ajouteCheval(p);
		}
		ajouteEcurie(4);
		for(Pion p : listeJoueur.get(1).getChevaux())
		{
			plateau.getEcuries().add(p.getCaseEc());
			p.getCaseEc().ajouteCheval(p);
		}
		ajouteEcurie(60);
		for(Pion p : listeJoueur.get(3).getChevaux())
		{
			plateau.getEcuries().add(p.getCaseEc());
			p.getCaseEc().ajouteCheval(p);
		}
		ajouteEcurie(4);
		for(Pion p : listeJoueur.get(2).getChevaux())
		{
			plateau.getEcuries().add(p.getCaseEc());
			p.getCaseEc().ajouteCheval(p);
		}
		ajouteEcurie(48);
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
	

	
	public boolean appDeplacement(int reponse) 
	{
		Pion cheval = jCourant.getChevaux().get(reponse-1);
		if(!cheval.aFiniTour())
		{
			return cheval.deplacerPionA(de, plateau, jCourant);
		}
		else 
		{
			return cheval.deplacementFinalTest(de, plateau);
		}
		
	}
	public void proposerChoixDeplacement()
	{
		int reponse;
		String ouiounon;
	
		System.out.println("Voulez vous vous deplacer ?");
		ouiounon = sc.nextLine();
		
		if(ouiounon.equals("o")) 
		{
		do {
		System.out.println("Quel cheval voulez vous deplacer ? :");
		reponse = sc.nextInt();
		}while(reponse <=0 || reponse > 4);
		appDeplacement(reponse);
		}
	}
	
	public void proposerChoixSorti()
	{
	
		int reponse;
		do {
			System.out.println("Quel cheval voulez vous sortir ? :");
			reponse = sc.nextInt();
		}while(!jCourant.sortirCheval(jCourant.getChevaux().get(reponse-1), plateau));
	}
	// Game
	public void jouerUnTour()
	{
		plateau.affichage();
		
	
		
		int reponse;
		String reponseSortir;
		this.de = lancerDe();

		System.out.println("A Joueur "+Couleur.values()[numJ].getSymbole()+" de jouer");
		System.out.println("La valeur du de est : "+de);
		
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
