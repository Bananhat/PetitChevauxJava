package mainpackage;
/**
 * La classe <b> Partie </p> contient la boucle principale du jeu et les m�thodes d'initialisations 
 * @author Samuel	
 */
import java.util.ArrayList;
import java.util.Scanner;

import vue.Plateau;

public class Partie {
	private int de;
	private Plateau plateau;
	private ArrayList<Joueur> listeJoueur;
	private Joueur jCourant;
	private int numJ;
	private Scanner sc = new Scanner(System.in);
	private Interface interf;
	public Partie() 
	{
		interf = new Interface();
		numJ = (int) (Math.random() * (4));
		listeJoueur = new ArrayList<Joueur>();
		plateau = new Plateau();
		initialiserPlateau();
		initialiserJoueurs();
		initEcurie();
		
		plateau.initTotalCases();
	}
	
	
	
	
	//SAUVEGARDE POUR SOUTENANCE....
	
	 /* SAUVEGARDE.... 
		//Test Sauv pour echelle arrêt;
		Pion p = this.listeJoueur.get(0).getChevaux().get(0);
		p.setPos(52);
		plateau.retirerEcurie(this.listeJoueur.get(0), p);
		plateau.getChemin().get(p.getPos()).getChevaux().add(p);
		p.setSorti(true);
		//
		Pion p2 = this.listeJoueur.get(3).getChevaux().get(0);
		p2.setPos(51);
		plateau.retirerEcurie(this.listeJoueur.get(3), p2);
		plateau.getChemin().get(p2.getPos()).getChevaux().add(p2);
		p2.setSorti(true);
		
		Pion p4 = this.listeJoueur.get(0).getChevaux().get(1);
		p4.setPos(52);
		plateau.retirerEcurie(this.listeJoueur.get(0), p4);
		plateau.getChemin().get(p4.getPos()).getChevaux().add(p4);
		p4.setSorti(true);
		
		Pion p5 = this.listeJoueur.get(0).getChevaux().get(2);
		p5.setPos(52);
		plateau.retirerEcurie(this.listeJoueur.get(0), p5);
		plateau.getChemin().get(p5.getPos()).getChevaux().add(p5);
		p5.setSorti(true);
		
		Pion p6 = this.listeJoueur.get(0).getChevaux().get(3);
		p6.setPos(52);
		plateau.retirerEcurie(this.listeJoueur.get(0), p6);
		plateau.getChemin().get(p6.getPos()).getChevaux().add(p6);
		p6.setSorti(true);
		//
		
		
		//testEject
		Pion p3 = this.listeJoueur.get(1).getChevaux().get(0);
		p3.setPos(0);
		plateau.retirerEcurie(this.listeJoueur.get(1), p3);
		plateau.getChemin().get(p3.getPos()).getChevaux().add(p3);
		p3.setSorti(true);
		
		//Test Sauv Passer Par dessus
		
		
		
		//Test SauvVictoire
		*/
	
	public Scanner getScan() 
	{
		return sc;
	}
	
	
	/**
     * Initialise chaque joueur en demandant son nom et en lui ajoutant des chevaux
     */
	public void initialiserJoueurs() 
	{
        Scanner sc = new Scanner(System.in);
        String nom="";
            for(int i=0; i<4; i++)
            {
                System.out.println("Joueur" + (i+1) + " - Entrez votre nom : ");
                //nom = sc.nextLine();
                listeJoueur.add(new Joueur(nom, Couleur.values()[i]));
                listeJoueur.get(i).setCaseDeDepart(plateau.getChemin().get(i*14));
                for(int j=0; j<4;j++) {
                listeJoueur.get(i).getChevaux().get(j).setPos(i*14);
                listeJoueur.get(i).getChevaux().get(j).setPosInit(i*14);
                }
                System.out.println(Couleur.values()[i]);
               
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
	
	
	//DE TRUC POUR SOUTENANCE
	private void deTrucF(char deTruc)
	{
		switch(deTruc)
		{
		case 'u':
			this.de = 1;
			break;
		case 'd':
			this.de = 2;
			break;
		case 't':
			this.de = 3;
			break;
		case 'q':
			this.de = 4;
			break;
		case 'c':
			this.de = 5;
			break;
		case 's':
			this.de = 6;
			break;
		}
		
	}

	// Game
	public void jouerUnTour()
	{
		plateau.affichage();
		
		
		int reponse;
		String reponseSortir;
		char deTruc;
		this.de = lancerDe();
		
		/*
		//SOUTENANCE
		System.out.println("Valeur du dé  : ? ");
		deTruc = sc.next().charAt(0);
		deTrucF(deTruc);
		sc.nextLine();
		this.numJ = 0;*/
		
		
		System.out.println("A Joueur "+Couleur.values()[numJ].getSymbole()+" de jouer");
		System.out.println("La valeur du de est : "+de);
		
		jCourant = listeJoueur.get(numJ);
		
		if(!jCourant.getSorti()) // si le jCourant n'a aucun cheval sur le plateau 
		{
				if(de == 6) 
				{
					interf.proposerChoixSorti(sc, jCourant, plateau);
				}
				else 
				{
					System.out.println("Vous passez votre tour...");
				}
				
		}
		else //si il a des chevaux sur le plateau
		{
			if(de == 6 && jCourant.resteASortir(plateau)) 
			{
				System.out.println("Voulez vous sortir un pion ? o/n : ");
				reponseSortir = sc.nextLine();
				
				
				if(reponseSortir.equals("o"))
				{
					interf.proposerChoixSorti(sc, jCourant, plateau);
					
				}
				else 
				{
					interf.proposerChoixDeplacement(sc, jCourant, plateau, de);
				}
				
			}
			else
			{
				interf.proposerChoixDeplacement(sc, jCourant, plateau, de);
				
			}
		}
		if(this.de == 6)
		{
			numJ--;
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
	
	
	//Test parti fini
	public boolean estPartieTermine() 
	{
		int i;
		for(ArrayList<CaseDEchelle> ar : plateau.getEchelle()) {
			i=0;
			for(Case c : ar)
			{
				if(!c.getListeChevaux().isEmpty())
				{
					for(Pion pion : c.getListeChevaux()) {
						i++;
						if( (pion.getPosCaseNumerote()+1) == 1 || (pion.getPosCaseNumerote()+1) == 2 ) {
							return false;
						}
					}
				}
			}
			if(i==4)
			{
				plateau.affichage();
				return true;
			}
		}
		return false;
	}
	
	
	// Getter & Setter
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
