package mainpackage;

import java.util.ArrayList;

public class Plateau {
	private ArrayList<CaseDeChemin> caseDeChemin;
	private ArrayList<ArrayList<CaseDEchelle>> echelles;
	private ArrayList<CaseEcurie> caseEcurie;
	
	public Plateau() {
		caseDeChemin = new ArrayList<CaseDeChemin>();
		echelles = new ArrayList<ArrayList<CaseDEchelle>>();
		caseEcurie = new ArrayList<CaseEcurie>();
	}


	public ArrayList<CaseEcurie> getEcuries() 
	{
		return caseEcurie;
	}
	public ArrayList<CaseDeChemin> getChemin() 
	{
		return caseDeChemin;
	}
	public ArrayList<ArrayList<CaseDEchelle>> getEchelle()
	{
		return echelles; 
	}


	public void retirer(Joueur jCourant, Pion pion) {
		for(Case c : caseEcurie) 
		{
			for(Pion p : c.getChevaux()) {
				for(Pion p1 : jCourant.getChevaux()) {
					if (p1.equals(p)) {
						caseEcurie.remove(p);
					}
				}
			}
		}
		
	}

}
