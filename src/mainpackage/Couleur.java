package mainpackage;

public enum Couleur {
	JAUNE("Jaune",0), BLEU("Bleu",1), VERT("Vert",2), ROUGE("Rouge",3);
	private String symbole;
	private int num;
	
	Couleur(String s, int num) 
	{
		this.symbole = s;
		this.num = num;
	}
	
	
	
	public int getNum() {
		return num;
	}
	public String getSymbole() 
	{
		return this.symbole;
	}
}
