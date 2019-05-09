package mainpackage;

import java.util.ArrayList;

public class CaseDeChemin extends Case{

	public CaseDeChemin() {
		super();
		listeChevaux = new ArrayList<Pion>();
	}
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

}
