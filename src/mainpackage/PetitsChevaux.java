package mainpackage;

public class PetitsChevaux {

	public static void main(String[] args) 
	{
		Partie game = new Partie();
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
				if(ct ==2) {
				game.augmenteNum();
				ct=0;
				}
			}
			
			
		}
		game.getScan().close();
	}

}
