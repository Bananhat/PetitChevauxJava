package mainpackage;

import java.util.ArrayList;

public abstract class Case 
{
	
	public ArrayList<Pion> listeChevaux;
	
	public void ajouteCheval(Pion p) {
		// TODO Auto-generated method stub
		listeChevaux.add(p);
	}
	public ArrayList<Pion> getChevaux()
	{
		return listeChevaux; 
	}
	public abstract boolean peutPasser(Pion p);
	public abstract boolean peutSArreter(Pion p);
	

}
