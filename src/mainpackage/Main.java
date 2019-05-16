package mainpackage;

import java.util.Scanner;

import control.Partie;
import model.Joueur;

public class Main {

	public static void main(String[] args) 
	{
		char rejoue='o';
		Partie game;
		Scanner monscan = new Scanner(System.in);
		do {
		 game = new Partie();
		int nbFois6;
		Joueur j=null;
		Joueur old_j = null;
		int ct=0;
		while(!game.estPartieTermine()) 
		{
			old_j = j;
			game.jouerUnTour();
			j = game.getJoueurCourant();
			if(j == old_j) 
			{
				ct++;
				if(ct ==1 && game.getNum() != 3) {
				game.augmenteNum();
				ct=0;
				}
				else {
					game.setNum(0);
					ct=0;
				}
			}
			
			
		}
		
		
		System.out.println("Le joueur "+j.getCouleur().getSymbole()+" a gagné !!");
		
		System.out.println("Voulez vous rejouer ?? o/n : ");
		rejoue = monscan.next().charAt(0);
		game.getScan().close();
		} while(rejoue!='n');
	
	}

}
