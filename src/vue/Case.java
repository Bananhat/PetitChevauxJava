package vue;

import java.util.ArrayList;

import model.Pion;

public abstract class Case
{
	private ArrayList<Pion> listeChevaux;



	public abstract void ajouteCheval(Pion p);
	public ArrayList<Pion> getChevaux()
	{
		return getListeChevaux(); 
	}
	public abstract boolean peutPasser(Pion p);
	public abstract boolean peutSArreter(Pion p);

	public abstract void retireCheval(Pion pion);
	public ArrayList<Pion> getListeChevaux() {
		return listeChevaux;
	}
	public void setListeChevaux(ArrayList<Pion> listeChevaux) {
		this.listeChevaux = listeChevaux;
	}

}
