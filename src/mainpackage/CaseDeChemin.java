package mainpackage;

import java.util.ArrayList;

public class CaseDeChemin extends Case{

	public CaseDeChemin() {
		super();
		listeChevaux = new ArrayList<Pion>();
	}
	public ArrayList<Pion> getChevaux() {
		return listeChevaux;
	}
	public boolean peutPasser(Pion p) {
		// TODO Auto-generated method stub
		if(listeChevaux.isEmpty()) {
			return true;
		}
		else {
			for(Pion p1 : listeChevaux) {
				if(p1.getCouleur() == p.getCouleur()) {
					return true;
				}
			}
		}
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
	public void retireCheval(Pion p) {
		listeChevaux.remove(p);
		
	}

}
