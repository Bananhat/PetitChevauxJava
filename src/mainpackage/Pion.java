package mainpackage;

import java.util.Collection;

public class Pion {
	private Couleur couleur;
	private String id;
	private int pos;
	private int posCaseNumerote;
	private CaseEcurie caseEc;
	private boolean FiniTour;
	public Pion(String id, Couleur c) 
	{
		this.id = id;
		caseEc = new CaseEcurie();
		this.couleur = c;
		FiniTour=false;
	}
	public int getPosCaseNumerote() {
		return posCaseNumerote;
	}
	public Couleur getCouleur() 
	{
		return this.couleur;
	}
	public boolean aFiniTour()
	{
		return FiniTour;
	}
	public int getPos() 
	{
		// TODO Auto-generated method stub
		return pos%56;
	}
	public void augmentePos(int num) 
	{
		this.pos+=num;
	}
	public boolean deplacementFinal(int num, Plateau p) // throws CasePleineException //retourne false quand le pion ne peut se d�placer
	{
		posCaseNumerote++;
		Case oldCase;
		Case caseARemplir = p.getEchelle().get(this.couleur.getNum()).get(posCaseNumerote);
		if(posCaseNumerote == 0) 
		{
			 oldCase = (CaseDeChemin) p.getChemin().get(this.getPos());
		}
		else {
			oldCase = (CaseDEchelle) p.getEchelle().get(this.couleur.getNum()).get(posCaseNumerote-1);
		}
		if(caseARemplir.listeChevaux.isEmpty()) //on v�rifie que la case est libre
		{ 
			caseARemplir.ajouteCheval(this);
			oldCase.retireCheval(this);
			return true;
		}
		else {
			posCaseNumerote--;
			// throw new CasePleineException("La case est d�j� occup�..");
			return false;
		}
	}
	public boolean deplacementFinalTest(int num, Plateau p) // throws CasePleineException
	{
		if(posCaseNumerote+1 == 6) //on v�rifie que le joueur ne d�passe pas 6
		{
			return false;
		}
		else {
			
		
		if(posCaseNumerote == -1 && num==1) { //on commence l'entr�e � 0
			return this.deplacementFinal(num, p);
		}
		else {
			if(posCaseNumerote+2 == num) //si le num vaut la case sur laquelle il veut aller c'est bon
			{
				return this.deplacementFinal(num, p);
			}
		}
		}
		return false;
	
	}
	public void deplacement(Plateau p, int num)
	{
		p.getChemin().get(this.getPos()).ajouteCheval(this);//on ajoute le cheval sur la nouvelle case
		int oldPos = ( this.getPos() -num ) % 56;
		if (oldPos<0) oldPos += 56;
		System.out.println("OLDPOS VAUT" + oldPos);
		p.getChemin().get(oldPos).retireCheval(this);//on retire le cheval de l'ancienne
	}
	public boolean getEstEnPiste(Plateau p)
	{
		boolean estEnPiste = false;
		for(Case c : p.getChemin()) { //v�rifie que le pion est bien en piste
			if(c.getChevaux().contains(this)) {
			
				estEnPiste = true;
			}
		}
		return estEnPiste;
	}
	public boolean deplacerPionA(int num, Plateau p, Joueur jCourant) 
	{
		boolean peutDeplacer = true;
		int old_pos = this.pos;
		boolean doitManger = false;
		boolean estEnPiste=this.getEstEnPiste(p);
		int indice = 0;
		int i=0;
		
		if(estEnPiste)
		{
			 
			while(i < num && p.getChemin().get((this.getPos()+1)%56) != jCourant.getCaseDeDepart() )
			{
				if ( p.getChemin().get((this.getPos()+1)%56).peutPasser(this) ) 
				{
					//v�rification fin tour
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
				i++;
		
			}
			if (p.getChemin().get((this.getPos()+1)%56) == jCourant.getCaseDeDepart())
			{
				this.FiniTour = true;
				posCaseNumerote=-1;
				peutDeplacer = false;
			}
			else
				{
				if(doitManger) 
				
			{
				for(Pion pion : p.getChemin().get(indice).getChevaux()) {
					if(pion.couleur != this.couleur) 
					{
						retourneEcurie(p);
						this.pos++;
						deplacement(p, num);
					}
					else 
					{
						this.pos = old_pos;
						System.out.println("Impossible de se deplacer");
					}
				}
				
			}
			else if (peutDeplacer) 
			{
				deplacement(p, num);
			}
			else if(this.FiniTour)
			{
				System.out.println("la valeur de l'indice est : "+i);
				System.out.println("c'est la fin du tour");
				deplacement(p, i);
			}
			else
			{
				this.pos = old_pos;
				System.out.println("Impossible de se deplacer");
				return false;
			}
				}
			return true;
	}
	else //faire une exception plut�t
	{
		System.out.println("Veuillez selectionner un cheval en piste...");
		return false;
	}
}
	public void retourneEcurie(Plateau p) 
	{
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
	public void setPos(int i) {
		// TODO Auto-generated method stub
		this.pos = i;
	}
}
