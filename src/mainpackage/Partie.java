package mainpackage;

import java.util.ArrayList;

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
	
	
	public int lancerDe() {
		return 0;
	}
	
	// Game
	public void jouerUnTour()
	{
		int numeroTour=0;
		while(!estPartieTermine()) 
		{
			this.de = lancerDe();
			
			//choisirPion()
			//Avancer ou pas ajouterCheval sur case toussa... 
			
		}
	}
	
	// Getter Setter
	public boolean estPartieTermine() {
		return true;
	}
	public Joueur getJoueurCourant() {
		return null;
	}
	public void setJoueurcourant(Joueur j) {
		
	}
	public Plateau getPlateau() {
		return null;
	}
	public ArrayList<Joueur> getJoueurs() {
		return null;
	}
	
	
	public void mangerLesPions(Case c) {
		
	}
	
}
