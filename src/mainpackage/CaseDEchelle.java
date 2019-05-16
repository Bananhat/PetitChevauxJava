package mainpackage;

import java.util.ArrayList;

public class CaseDEchelle extends Case
{

	private int num;
	public CaseDEchelle(int num) {
		this.setListeChevaux(new ArrayList<Pion>());
		this.num = num;
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
		getListeChevaux().add(p);
	}
	public int getNum()
	{
		return this.num;
	}
	public void retireCheval(Pion p) {
		getListeChevaux().remove(p);
	}
}
