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
			p.getChemin().get(this.getPos()).ajouteCheval(this);;
		}
		else
		{
			System.out.println("Impossible de se deplacer");
		}
	}
}
