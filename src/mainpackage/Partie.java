package mainpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Partie {
	private int de;
	private Plateau plateau;
	private ArrayList<Joueur> listeJoueur;
	private Joueur jCourant;
	public Partie() {
	
	}
	
	// Init;
	public void initialiserJoueurs(int nbJoueur) 
	{
		
	}
	public void initialiserPlateau() 
	{
		
	}
	
	
	private int lancerDe() {
		return 0;
	}
	
	// Game
	public void jouerUnTour()
	{
		int numeroTour=0;
		Scanner sc = new Scanner(System.in);
		int reponse;
		String reponseSortir;
		while(!estPartieTermine()) 
		{
			this.de = lancerDe();
			if(this.jCourant.getChevaux().isEmpty()) // si le jCourant n'a aucun cheval sur le plateau 
			{
				if(de == 6) 
				{
					System.out.println("Quel cheval voulez vous sortir ? :");
					reponse = sc.nextInt();
					jCourant.getCaseDeDepart().ajouteCheval(jCourant.getChevaux().get(reponse));
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
						System.out.println("Quel cheval voulez vous sortir ? :");
						reponse = sc.nextInt();
						jCourant.getCaseDeDepart().ajouteCheval(jCourant.choisirPion(reponse, plateau));
					}
					else 
					{
						System.out.println("Quel cheval voulez vous deplacer ? :");
						reponse = sc.nextInt();
						plateau.deplacerPionA(jCourant.getChevaux().get(reponse), jCourant.getChevaux().get(reponse).getPos()+de);
					}
				}
			}
			//choisirPion()
			//Avancer ou pas ajouterCheval sur case toussa... 
			
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
