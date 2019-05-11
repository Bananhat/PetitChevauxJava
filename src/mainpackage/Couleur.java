package mainpackage;

public enum Couleur {
	JAUNE('j',0), BLEU('b',1), VERT('v',2), ROUGE('r',3);
	private char symbole;
	private int num;
	
	Couleur(char s, int num) 
	{
		this.symbole = s;
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
	public char getSymbole() 
	{
		return this.symbole;
	}
}
