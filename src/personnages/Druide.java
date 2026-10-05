package personnages;

public class Druide {
    private String nom;
    private int force;
    private int effetPotionMin = 1;
    private int effetPotionMax = 3;
    private Chaudron chaudron = new Chaudron();

    public Druide(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "\"" + texte + "\"");
    }

    private String prendreParole() {
        return "Le druide " + nom + " : ";
    }

    public void fabriquerPotion(int nbDoses, int forcePotion) {
        chaudron.remplirChaudron(nbDoses);
        parler("J'ai concocté " + nbDoses + " doses de potion magique. Elle a une force de " + forcePotion + ".");
    }

    public void boosterGaulois(Gaulois gaulois) {
        if ("Obélix".equals(gaulois.getNom())) {
            parler("Non, Obélix Non !... Et tu le sais très bien !");
        } else {
            parler("Tiens " + gaulois.getNom() + " un peu de potion magique.");
            gaulois.boirePotion(3);
        }
    }
}