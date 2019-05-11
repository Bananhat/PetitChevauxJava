package mainpackage;

import java.util.ArrayList;

public class Plateau {
	private ArrayList<CaseDeChemin> caseDeChemin;
	private ArrayList<ArrayList<CaseDEchelle>> echelles;
	private ArrayList<CaseEcurie> caseEcurie;
	private ArrayList<Case> totalCases;
	private static int compteurChemin = 0;
	private static int compteurEchelle = 0;
	private static int compteurEcurie = 0;

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public Plateau() {
		caseDeChemin = new ArrayList<CaseDeChemin>();
		echelles = new ArrayList<ArrayList<CaseDEchelle>>();
		caseEcurie = new ArrayList<CaseEcurie>();
		totalCases = new ArrayList<Case>();
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

	public void ajouteLigneEcurie(String color) {
		for(int i = 0; i < 6; i++) {
			this.caseEcurie.get(compteurEcurie).setColor(color);
			this.totalCases.add(this.caseEcurie.get(compteurEcurie));
			compteurEcurie += 1;
		}
	}

	public void ajouteLigneChemin(int indice) {
		for(int i = 0; i < indice; i++) {
			this.totalCases.add(this.caseDeChemin.get(compteurChemin));
			compteurChemin += 1;
		}
	}

	public void ajouteLigneEchelle(int indiceEchelle, int indice) {
		for(int i = 0; i < indice; i++) {
			this.totalCases.add(this.echelles.get(indiceEchelle).get(compteurEchelle % 6));
			compteurEchelle += 1;
		}
	}

	public void ajouteLigneEcurieUtile(String color, int indice) {
		for(int i = 0; i < indice; i++) {
			this.caseEcurie.get(compteurEcurie).setColor(color);
			this.caseEcurie.get(compteurEcurie).setCaseUtile();
			this.totalCases.add(this.caseEcurie.get(compteurEcurie));
			compteurEcurie += 1;
		}
	}

	public void initTotalCases() {
		ajouteLigneEcurie("r");
		ajouteLigneChemin(3);
		ajouteLigneEcurie("b");

		for(int i = 0; i < 5; i++) {
			ajouteLigneEcurie("r");
			ajouteLigneChemin(1);
			ajouteLigneEchelle(0,1);
			ajouteLigneChemin(1);
			ajouteLigneEcurie("b");
		}

		ajouteLigneChemin(7);
		ajouteLigneEchelle(0,1);
		ajouteLigneChemin(7);

		ajouteLigneChemin(1);
		ajouteLigneEchelle(1,6);
		// TODO revoir ca
		this.totalCases.add(new CaseEcurie());
		ajouteLigneEchelle(2,6);
		ajouteLigneChemin(1);

		ajouteLigneChemin(7);
		ajouteLigneEchelle(3,1);
		ajouteLigneChemin(7);

		for(int i = 0; i < 5; i++) {
			ajouteLigneEcurie("v");
			ajouteLigneChemin(1);
			ajouteLigneEchelle(3,1);
			ajouteLigneChemin(1);
			ajouteLigneEcurie("j");
		}

		ajouteLigneEcurie("v");
		ajouteLigneChemin(3);
		ajouteLigneEcurie("j");
	}

	public void affichage() {
		int i = 0;
		for(Case case1 : this.totalCases) {
			// System.out.println(case1.getClass());
			if(case1.getChevaux().size() != 0) {
				System.out.print(ANSI_BLACK_BACKGROUND + "   " + ANSI_RESET);
			}
			else if(case1.getColor() == "r") {
				System.out.print(ANSI_RED_BACKGROUND + "   " + ANSI_RESET);
			}
			else if(case1.getColor() == "v") {
				System.out.print(ANSI_GREEN_BACKGROUND + "   " + ANSI_RESET);
			}
			else if(case1.getColor() == "j") {
				System.out.print(ANSI_YELLOW_BACKGROUND + "   " + ANSI_RESET);
			}
			else if(case1.getColor() == "b") {
				System.out.print(ANSI_BLUE_BACKGROUND + "   " + ANSI_RESET);
			}
			else if(case1.getColor() == "null") {
				System.out.print(ANSI_WHITE_BACKGROUND + "   " + ANSI_RESET);
			}

			i++;
			if(i == 15) {
				i = 0;
				System.out.println("");
			}
		}
		System.out.println("");
	}

	public void retirerEcurie(Joueur jCourant, Pion pion)
	{
		for(Case c : caseEcurie) 
		{
			if(c.listeChevaux.contains(pion)) 
			{
				c.listeChevaux.remove(pion);
			}
		}
	}

}
