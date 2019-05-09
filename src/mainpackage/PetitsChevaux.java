package mainpackage;

public class PetitsChevaux {

	public static void main(String[] args) 
	{
		Partie game = new Partie();
		
		while(game.estPartieTermine()) 
		{
			game.jouerUnTour();
		}
		game.getScan().close();
	}

}
