package mainpackage;

import java.util.ArrayList;

public class CaseEcurie extends Case{
	private String color = "null";

	public CaseEcurie() {
		super();
		listeChevaux = new ArrayList<Pion>();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public boolean peutPasser(Pion p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean peutSArreter(Pion p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ajouteCheval(Pion p) {
		listeChevaux.add(p);
	}
	public ArrayList<Pion> getChevaux(){
		return listeChevaux;
	}

	@Override
	public void retireCheval(Pion pion) {
		// TODO Auto-generated method stub
		
	}


}
