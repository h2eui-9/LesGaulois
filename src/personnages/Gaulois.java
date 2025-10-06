package personnages;

public class Gaulois {
    private String nom;
    private int force;
    private int effetPotion = 1;
    private Village village; // pour savoir s'il est dans un village

    public Gaulois(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public String getNom() {
        return nom;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "«" + texte + "»");
    }

    private String prendreParole() {
        return "Le Gaulois " + nom + " : ";
    }

    public void frapper(Romain romain) {
        System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
        int forceCoup = (force * effetPotion) / 3;
        romain.recevoirCoup(forceCoup);
        effetPotion--;
        if (effetPotion < 1) effetPotion = 1;
    }

    public void booster(int forcePotion) {
        effetPotion = forcePotion;
    }

    public void sePresenter() {
        if (this.equals(village != null ? village.getChef() : null)) {
            System.out.println("Le Gaulois " + nom + " : Bonjour, je m'appelle " + nom + ". Je suis le chef le village " + (village != null ? village.getNom() : "") + ".");
        } else if (village != null) {
            System.out.println("Le Gaulois " + nom + " : Bonjour, je m'appelle " + nom + ". J'habite le village " + village.getNom() + ".");
        } else {
            System.out.println("Le Gaulois " + nom + " : Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
        }
    }

    @Override
    public String toString() {
        return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
    }
}


