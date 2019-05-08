package mainpackage;

import java.util.ArrayList;

public class Plateau {
	private ArrayList<CaseDeChemin> caseDeChemin;
	private ArrayList<ArrayList<CaseDEchelle>> echelles;
	private ArrayList<CaseEcurie> caseEcurie;
	

	public void deplacerPionA(Pion p, int num) 
	{
		boolean peutDeplacer = true;
		
		for(int i=0; i<num;i++) 
		{
			if ( caseDeChemin.get(p.getPos()+1).peutPasser(p) ) 
			{
				p.augmentePos(1);
			}
			else 
			{
				peutDeplacer = false;
			}
	
		}
		if (peutDeplacer) 
		{
			caseDeChemin.get(p.getPos()).ajouteCheval(p);;
		}
		else
		{
			System.out.println("Impossible de se deplacer");
		}
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

}
