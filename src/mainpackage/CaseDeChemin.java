package mainpackage;

import java.util.ArrayList;

public class CaseDeChemin extends Case {
	private int num;
	public static int num_cases;
	public CaseDeChemin() {
		super();
		setListeChevaux(new ArrayList<Pion>());
	}

	public ArrayList<Pion> getChevaux() {
		return getListeChevaux();
	}
	public boolean peutPasser(Pion p) {
		// TODO Auto-generated method stub
		if(getListeChevaux().isEmpty()) {
			return true;
		}
		else {
			for(Pion p1 : getListeChevaux()) {
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
		getListeChevaux().add(p);
	}
	public void retireCheval(Pion p) {
		getListeChevaux().remove(p);
	}

}
