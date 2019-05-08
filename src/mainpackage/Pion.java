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
	public int getPos() {
		// TODO Auto-generated method stub
		return pos;
	}
	public void augmentePos(int num) {
		this.pos+=num;
	}
}
