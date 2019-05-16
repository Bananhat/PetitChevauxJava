package mainpackage;

import java.util.Scanner;

import vue.Plateau;

public class Interface {
	public Interface()
	{
		
	}
	
	public boolean appDeplacement(int reponse, Joueur jCourant, Plateau plateau, int de) 
	{
		Pion cheval = jCourant.getChevaux().get(reponse-1);
		if(!cheval.aFiniTour())
		{
			try {
				return cheval.deplacerPionA(de, plateau, jCourant);
			} catch (CasePleineException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		else 
		{
			return cheval.deplacementFinalTest(de, plateau);
		}
		return false;
		
	}
	public void proposerChoixDeplacement(Scanner sc, Joueur jCourant, Plateau plateau, int de)
	{
		int reponse;
		String ouiounon = null;
	
		System.out.println("Voulez vous vous deplacer ?");
		
		try
		{
			ouiounon = sc.nextLine();
		}
		catch(Exception e1)
		{
			e1.getMessage();
		}
		
		if(ouiounon.equals("o")) 
		{
			do {
			char reponseC; 
			do{
				System.out.println("Quel cheval voulez vous deplacer ? :");
				reponseC = sc.next().charAt(0);	
			} while(!Character.isDigit(reponseC) || Character.getNumericValue(reponseC) > 4 || Character.getNumericValue(reponseC)<=0 );
			
			
			reponse = Character.getNumericValue(reponseC);
			
			}while(!appDeplacement(reponse, jCourant, plateau, de) && jCourant.aDautrePionSorti(jCourant.getChevaux().get(reponse-1)));
		}
		
	}
	
	public void proposerChoixSorti(Scanner sc, Joueur jCourant, Plateau plateau)
	{
	
		char reponseC;
		int reponse;
			do {
				do {
					System.out.println("Quel cheval voulez vous sortir ? :");
					reponseC = sc.next().charAt(0);	
				} while(!Character.isDigit(reponseC) || Character.getNumericValue(reponseC) >= 5 || Character.getNumericValue(reponseC)<=0 );
				
			reponse = Character.getNumericValue(reponseC);
			
			
			}while(!jCourant.sortirCheval(jCourant.getChevaux().get(reponse-1), plateau));
			
	}
}
