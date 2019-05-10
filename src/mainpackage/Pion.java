package mainpackage;

import java.util.Collection;

public class Pion {
	private Couleur couleur;
	private String id;
	private int pos;
	private CaseEcurie caseEc;
	public Pion(String id, Couleur c) 
	{
		this.id = id;
		caseEc = new CaseEcurie();
		this.couleur = c;
	}
	public Couleur getCouleur() 
	{
		return this.couleur;
	}
	public int getPos() 
	{
		// TODO Auto-generated method stub
		return pos;
	}
	public void augmentePos(int num) 
	{
		this.pos+=num;
	}
	public boolean deplacerPionA(int num, Plateau p) 
	{
		boolean peutDeplacer = true;
		int old_pos = this.pos;
		boolean doitManger = false;
		boolean estEnPiste=false;
		int indice = 0;
		
		for(Case c : p.getChemin()) { //vérifie que le pion est bien en piste
			if(c.getChevaux().contains(this)) {
				estEnPiste = true;
			}
		}
		if(estEnPiste)
		{
			for(int i=0; i<num;i++) 
			{
				if ( p.getChemin().get(this.getPos()+1).peutPasser(this) ) 
				{
					this.augmentePos(1);
				}
				else 
				{
					if(i==(num-1)) 
					{
						doitManger = true;
						indice=i;
					}
					peutDeplacer = false;
				}
		
			}
			if(doitManger) 
			{
				for(Pion pion : p.getChemin().get(indice).getChevaux()) {
					retourneEcurie(p);
					p.getChemin().get(this.getPos()+1).ajouteCheval(this);//on ajoute le cheval sur la nouvelle case
					p.getChemin().get(this.getPos()-num).retireCheval(this);//on retire le cheval de l'ancienne
				}
				
			}
			else if (peutDeplacer) 
			{
				p.getChemin().get(this.getPos()).ajouteCheval(this);//on ajoute le cheval sur la nouvelle case
				p.getChemin().get(this.getPos()-num).retireCheval(this);//on retire le cheval de l'ancienne
			}
			else
			{
				this.pos = old_pos;
				System.out.println("Impossible de se deplacer");
			}
			return true;
	}
	else 
	{
		System.out.println("Veuillez selectionner un cheval en piste...");
		return false;
	}
}
	public void retourneEcurie(Plateau p) {
		p.getChemin().remove(this);
		for(Case e : p.getEcuries()) 
		{
			if(e==caseEc) {
				e.ajouteCheval(this);
			}
		}
	}
	public CaseEcurie getCaseEc() {
		// TODO Auto-generated method stub
		return caseEc;
	}
}
