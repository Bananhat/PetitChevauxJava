package mainpackage;

import java.util.ArrayList;

public abstract class Case 
{
	
	protected ArrayList<Pion> listeChevaux;
	
	public abstract void ajouteCheval(Pion p);
	public ArrayList<Pion> getChevaux()
	{
		return listeChevaux; 
	}
	public abstract boolean peutPasser(Pion p);
	public abstract boolean peutSArreter(Pion p);
	

}
