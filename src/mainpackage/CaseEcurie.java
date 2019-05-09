package mainpackage;

import java.util.ArrayList;

public class CaseEcurie extends Case{

	public CaseEcurie() {
		super();
		listeChevaux = new ArrayList<Pion>();
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


}
