package mainpackage;

import java.util.ArrayList;
import java.util.Collection;

import vue.Plateau;

public class Pion 
{
	private Couleur couleur;
	private String id;
	private int pos;
	private int posInit;
	private int posCaseNumerote;
	private CaseEcurie caseEc;
	private boolean FiniTour;
	private Joueur j;
	private boolean estSorti;
	
	public Pion(String id, Couleur c, Joueur j) 
	{
		estSorti = false;
		this.j = j;
		this.id = id;
		caseEc = new CaseEcurie();
		this.couleur = c;
		FiniTour=false;
	}


	
	//deplacement final
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
		if(caseARemplir.getListeChevaux().isEmpty()) //on v�rifie que la case est libre
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
		System.out.println("Je suis dans deplacementFinal");
		if(posCaseNumerote+1 == 6) //on v�rifie que le joueur ne d�passe pas 6
		{
			return false;
		}
		else {
			
		
		if(posCaseNumerote == -1 && num==1) { //on commence l'entr�e � 0
			System.out.println("Je suis dans la condition");
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
	
	
	
	
	//Deplacement normaux
	public void deplacement(Plateau p, int num)
	{
		p.getChemin().get(this.getPos()).ajouteCheval(this);//on ajoute le cheval sur la nouvelle case
		int oldPos = ( this.getPos() -num ) % 56;
		if (oldPos<0) oldPos += 56;
		System.out.println(oldPos);
		p.getChemin().get(oldPos).retireCheval(this);//on retire le cheval de l'ancienne
	}
	
	
	public boolean deplacerPionA(int num, Plateau p, Joueur jCourant) throws CasePleineException 
	{
		boolean peutDeplacer = true;
		int old_pos = this.pos;
		boolean doitManger = false;
		boolean estEnPiste=this.getEstEnPiste(p);
		int indice = 0;
		int i=0;
		
		
		if(estEnPiste)
		{
			while(i<num && p.getChemin().get((this.getPos()+1)%56) != jCourant.getCaseDeDepart() && !doitManger && peutDeplacer)
			{
				if ( p.getChemin().get((this.getPos()+1)%56).peutPasser(this) ) 
				{
					//vérification fin tour
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
			if(this.FiniTour == true)
			{
						System.out.println("c'est la fin du tour");
						deplacement(p, i);
			}

			else
			{
				
				if(doitManger) 
				{
					System.out.println("L'indice est de "+indice);
					System.out.println("La pos est de : "+this.getPos());
	
					
					if(!ejecterChevaux(p,(this.getPos()+1)%56))
					{
						this.pos = old_pos;
					}
				
					System.out.println("passer");
					this.augmentePos(1);
					deplacement(p, num);
				}
				else if (peutDeplacer) 
				{
					deplacement(p, num);
				}
				else //Impossible de se déplacer
				{
					this.pos = old_pos;
			
					throw new CasePleineException("Impossible de se déplacer..");
				}
			}	
			return true;
	}
	else //faire une exception plutot
	{
		System.out.println("Veuillez selectionner un cheval en piste...");
		return false;
	}
}
	public boolean ejecterChevaux(Plateau p, int position)
	{
		ArrayList<Pion> listeAEjecter = new  ArrayList<Pion>();
		for(Pion pion : p.getChemin().get(position).getChevaux()) 
		{
			if(pion.couleur != this.couleur) 
			{
				System.out.println("la position a ejecter "+position);
				listeAEjecter.add(pion);
				System.out.println("Je suis la !!");
				
			}
			else //Impossible de se deplcare
			{
				return false;
			}
		}
		for(Pion p2 : listeAEjecter)
		{
			p2.retourneEcurie(p, position);
		}
		return true;
	}
	
	//Verifi et ejecter..
	public void retourneEcurie(Plateau p, int pos) 
	{
		System.out.println("pos : "+pos);
		p.getChemin().get(pos).getChevaux().remove(this);
		for(Case e : p.getEcuries()) 
		{
			if(e==this.caseEc)
			{
				e.ajouteCheval(this);
			}
		}
		this.estSorti = false;
		this.setPos(this.posInit);
		verifJoueurSorti(p);
	}
	
	
	public void verifJoueurSorti(Plateau p)
	{
		int ct=0; 
		for(Case e1 : p.getEcuries())
		{
			for(Pion p1 : j.getChevaux())
			{
				if(e1.getChevaux().contains(p1))
				{
					ct++;
					System.out.println(ct);
				}
			}
		}
		if(ct == 4)
		{
			j.setSorti(false);
		}
	}
	
	
	
	//Getter & Setter
	
	public CaseEcurie getCaseEc() 
	{
		// TODO Auto-generated method stub
		return caseEc;
	}
	public void setPos(int i) 
	{
		// TODO Auto-generated method stub
		this.pos = i;
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
	public int getPosCaseNumerote() {
		return posCaseNumerote;
	}
	public void setPosCaseNumerote(int i) {
		// TODO Auto-generated method stub
		posCaseNumerote+=i;
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


	public void setSorti(boolean b) {
		// TODO Auto-generated method stub
		estSorti =  b;
	}
	public boolean getSorti()
	{
		return estSorti;
	}

	

	public void setPosInit(int i) {
		// TODO Auto-generated method stub
		this.posInit = i;
	}
	
}