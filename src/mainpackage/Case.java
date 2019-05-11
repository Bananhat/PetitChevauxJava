package mainpackage;

import java.util.ArrayList;

public abstract class Case
{
	private String color = "null";
	protected ArrayList<Pion> listeChevaux;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public abstract void ajouteCheval(Pion p);
	public ArrayList<Pion> getChevaux()
	{
		return listeChevaux; 
	}
	public abstract boolean peutPasser(Pion p);
	public abstract boolean peutSArreter(Pion p);

}
