package mainpackage;

import java.util.ArrayList;

public class CaseDEchelle extends CaseColoree
{

	public CaseDEchelle() {
		this.listeChevaux= new ArrayList<Pion>();
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
