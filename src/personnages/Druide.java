package personnages;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;

	
	private Chaudron chaudron = new Chaudron(0);
	private int forcePotion;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super();
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " +effetPotionMin + " à " + effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	
	public void fabriquerPotion(int force, int quantite) {
		forcePotion = force;
		chaudron.remplirChaudron(quantite);
		parler("J'ai concocté " + quantite + " doses de potion magique. Elle a une force de " + force + "." );	
	}
	
	public void boosterGaulois(Gaulois g) {
		if (g.getNom().equals("Obélix")) {
			parler("Non, Obélix Non !... Et tu le sais très bien !");
		} else {
			g.booster(forcePotion);
			parler("Tiens " + g.getNom() + " un peu de potion magique.");
			chaudron.remplirChaudron(-1);
		}
	}
}
