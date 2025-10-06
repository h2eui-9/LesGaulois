package personnages;

public class Village {
    private String nom;
    private Chef chef;
    private Gaulois[] villageois;
    private int nbVillageois = 0;

    public Village(String nom, Chef chef, int tailleMax) {
        this.nom = nom;
        this.chef = chef;
        this.villageois = new Gaulois[tailleMax];
    }

    public String getNom() {
        return nom;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public void ajouterVillageois(Gaulois gaulois) {
        if (nbVillageois < villageois.length) {
            villageois[nbVillageois] = gaulois;
            nbVillageois++;
            gaulois.setVillage(this); // on dit au gaulois dans quel village il est
        } else {
            System.out.println("Le village est plein !");
        }
    }

    public Gaulois trouverVillageois(int numero) {
        if (numero < 1 || numero > nbVillageois) {
            System.out.println("Il n'y a pas autant d'habitants dans notre village !");
            return null;
        }
        return villageois[numero - 1];
    }

    public void afficherVillageois() {
        System.out.println("Dans le village \"" + nom + "\" du chef " + chef.getNom());
        System.out.println("vivent les légendaires gaulois :");
        for (int i = 0; i < nbVillageois; i++) {
            System.out.println("- " + villageois[i].getNom());
        }
    }

    public static void main(String[] args) {
        Chef abraracourcix = new Chef("Abraracourcix", 6, 1, null);

        Village village = new Village("Village des Irréductibles", abraracourcix, 30);

        abraracourcix = new Chef("Abraracourcix", 6, 1, village);  // lien chef -> village
        village.setChef(abraracourcix);

        Gaulois asterix = new Gaulois("Astérix", 8);
        village.ajouterVillageois(asterix);

        village.afficherVillageois();

        Gaulois gaulois = village.trouverVillageois(30);
        System.out.println(gaulois);

        Gaulois obelix = new Gaulois("Obélix", 25);
        village.ajouterVillageois(obelix);

        village.afficherVillageois();

        Gaulois doublePolemix = new Gaulois("DoublePolémix", 4);

        abraracourcix.sePresenter();
        asterix.sePresenter();
        doublePolemix.sePresenter();
    }
}


