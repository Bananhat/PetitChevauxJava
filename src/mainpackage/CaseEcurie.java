package mainpackage;

import java.util.ArrayList;

public class CaseEcurie extends Case{
	private boolean caseUtile = false;

	public CaseEcurie() {
		super();
		listeChevaux = new ArrayList<Pion>();
	}

	public boolean getCaseUtile() {
		return caseUtile;
	}

	public void setCaseUtile() {
		this.caseUtile = true;
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


}
