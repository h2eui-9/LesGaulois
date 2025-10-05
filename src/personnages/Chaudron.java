package personnages;

public class Chaudron {
	private int quantitePotion;
	
	public Chaudron(int quantite) {
		this.quantitePotion = quantite;
		
	}

	public boolean resterPotion() {
		return quantitePotion > 0;
		
	}
	
	public void remplirChaudron(int dose) {
		quantitePotion += dose;
	}
}
