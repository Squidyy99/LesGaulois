package personnages;

public class Romain {
    private String nom;
    private int force;
    private Equipement[] equipements = new Equipement[2];
    private int nbEquipement = 0;

    public Romain(String nom, int force) {
        this.nom = nom;
        this.force = force;
        assert isInvariantVerified();
    }

    public String getNom() {
        return nom;
    }

    public int getForce() {
        return force;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "\"" + texte + "\"");
    }

    private String prendreParole() {
        return "Le romain " + nom + " : ";
    }

    public void recevoirCoup(int forceCoup) {
        assert forceCoup > 0 : "La force du coup doit être positive !";

        int forceAvantCoup = this.force;

        force -= forceCoup;
        if (force > 0) {
            parler("Aïe");
        } else {
            parler("J'abandonne !");
        }

        assert this.force < forceAvantCoup : "La force n'a pas diminué !";
        assert isInvariantVerified();
    }

    private boolean isInvariantVerified() {
        return force >= 0;
    }

    public void sEquiper(Equipement equipement) {
        switch (nbEquipement) {
            case 2:
                System.out.println("Le soldat " + nom + " est déjà bien protégé !");
                break;
            case 1:
                if (equipements[0] == equipement) {
                    System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
                } else {
                    ajouterEquipement(equipement);
                }
                break;
            default:
                ajouterEquipement(equipement);
                break;
        }
    }

    private void ajouterEquipement(Equipement equipement) {
        equipements[nbEquipement] = equipement;
        nbEquipement++;
        System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
    }
    
    public static void main(String[] args) {
        Romain minus = new Romain("Minus", 6);  // -6 => ERROR  why ? => isInvariantVerified() => force >=0
    }
}
