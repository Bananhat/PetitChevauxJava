package vue;

import java.util.ArrayList;

import model.Joueur;
import model.Pion;

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

	public void ajouteChemin(int indice) {
		indice--;
		this.totalCases.add(this.caseDeChemin.get(indice));
	}

	public void ajouteLigneChemin(int l1, int l2) {
		l1--;
		l2--;
		if(l1 > l2) {
			for(int i = l1; i >= l2; i--) {
				this.totalCases.add(this.caseDeChemin.get(i));
			}
		}
		else {
			for(int i = l1; i <= l2; i++) {
				this.totalCases.add(this.caseDeChemin.get(i));
			}
		}
	}

	public void ajouteLigneEchelle(int indiceEchelle, int indice, int ordre) {
		if(ordre==0) {
			for(int i = 0; i < indice; i++) {
				this.totalCases.add(this.echelles.get(indiceEchelle).get(compteurEchelle % 6));
				compteurEchelle += 1;
			}
		}
		else {
			for(int i = 0; i < indice; i++) {
				this.totalCases.add(this.echelles.get(indiceEchelle).get(Math.abs((compteurEchelle % 6)-5)));
				compteurEchelle += 1;
			}
		}

	}

	public void initTotalCases() {
		ajouteLigneEcurie("j");
		ajouteLigneChemin(13,15);
		ajouteLigneEcurie("b");

		int a = 12;
		int b = 16;
		for(int i = 0; i < 5; i++) {
			ajouteLigneEcurie("j");
			ajouteChemin(a);
			// Echelle bleue
			ajouteLigneEchelle(1,1,0);
			ajouteChemin(b);
			ajouteLigneEcurie("b");
			a--;
			b++;
		}

		ajouteLigneChemin(1,7);
		// Echelle bleue
		ajouteLigneEchelle(1,1,0);
		ajouteLigneChemin(21,27);

		ajouteChemin(56);
		// Echelle Jaune
		ajouteLigneEchelle(0,6,0);
		this.totalCases.add(new CaseEcurie());
		// Echelle Verte
		ajouteLigneEchelle(2,6,1);
		ajouteChemin(28);

		ajouteLigneChemin(55,49);
		// Echelle Rouge
		ajouteLigneEchelle(3,1,1);
		ajouteLigneChemin(35,29);

		a = 48;
		b = 36;
		for(int i = 0; i < 5; i++) {
			ajouteLigneEcurie("r");
			ajouteChemin(a);
			// Echelle rouge
			ajouteLigneEchelle(3,1,1);
			ajouteChemin(b);
			ajouteLigneEcurie("v");
			a--;
			b++;
		}

		ajouteLigneEcurie("r");
		ajouteLigneChemin(43,41);
		ajouteLigneEcurie("v");
	}

	public void affichage() {
		int i = 0;

		for(Case case1 : this.totalCases) {
			// System.out.println(case1.getClass());
			if(case1.getChevaux().size() != 0) {
				Pion pi = case1.getChevaux().get(0);
				String size = String.valueOf(case1.getChevaux().size());
				if(case1.getChevaux().size() == 1) {
					size = " ";
				}
				if(pi.getCouleur() == Couleur.BLEU) {
					System.out.print(ANSI_WHITE_BACKGROUND + size + "B " + ANSI_RESET);
				}
				else if (pi.getCouleur() == Couleur.ROUGE) {
					System.out.print(ANSI_WHITE_BACKGROUND + size + "R " + ANSI_RESET);
				}
				else if (pi.getCouleur() == Couleur.VERT) {
					System.out.print(ANSI_WHITE_BACKGROUND + size + "V " + ANSI_RESET);
				}
				else if (pi.getCouleur() == Couleur.JAUNE) {
					System.out.print(ANSI_WHITE_BACKGROUND + size + "J " + ANSI_RESET);
				}
			}
			else if(case1 instanceof CaseEcurie) {
				if(((CaseEcurie) case1).getColor() == "r") {
					System.out.print(ANSI_RED_BACKGROUND + "   " + ANSI_RESET);
				}
				else if(((CaseEcurie) case1).getColor() == "v") {
					System.out.print(ANSI_GREEN_BACKGROUND + "   " + ANSI_RESET);
				}
				else if(((CaseEcurie) case1).getColor() == "j") {
					System.out.print(ANSI_YELLOW_BACKGROUND + "   " + ANSI_RESET);
				}
				else if(((CaseEcurie) case1).getColor() == "b") {
					System.out.print(ANSI_BLUE_BACKGROUND + "   " + ANSI_RESET);
				}
				else {
					System.out.print(ANSI_BLACK_BACKGROUND + "   " + ANSI_RESET);
				}
			}
			else if (case1 instanceof CaseDEchelle) {
				System.out.print(ANSI_PURPLE_BACKGROUND + " " + ((CaseDEchelle) case1).getNum() + " " + ANSI_RESET);
			}
			else {
				System.out.print(ANSI_CYAN_BACKGROUND + " . " + ANSI_RESET);
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
		for(CaseEcurie c : caseEcurie) 
		{
			if(c.getChevaux().contains(pion)) 
			{
				c.getListeChevaux().remove(pion);
			}
		}
		jCourant.setSorti(true);
		pion.setSorti(true);
	}

}
