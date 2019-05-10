package mainpackage;

public class Pion {
	private Couleur couleur;
	private String id;
	private int pos;
	public Pion(String id, Couleur c) 
	{
		this.id = id;
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
	public void deplacerPionA(int num, Plateau p) 
	{
		boolean peutDeplacer = true;
		int old_pos = this.pos;
		for(int i=0; i<num;i++) 
		{
			if ( p.getChemin().get(this.getPos()+1).peutPasser(this) ) 
			{
				this.augmentePos(1);
			}
			else 
			{
				peutDeplacer = false;
			}
	
		}
		if (peutDeplacer) 
		{
			p.getChemin().get(this.getPos()).ajouteCheval(this);//on ajoute le cheval sur la nouvelle case
			p.getChemin().get(this.getPos()-num).retireCheval(this);//on retire le cheval de l'ancienne
		}
		else
		{
			this.pos = old_pos;
			System.out.println("Impossible de se deplacer");
		}
	}
}
