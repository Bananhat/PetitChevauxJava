package mainpackage;

public enum Couleur {
	JAUNE('j'), BLEU('b'), VERT('v'), ROUGE('r');
	private char symbole;
	
	Couleur(char s) 
	{
		this.symbole = s;
	}
	public char getSymbole() 
	{
		return this.symbole;
	}
}
