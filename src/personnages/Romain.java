package personnages;

import objets.Equipement;

public class Romain {
    private String nom;
    private int force;
    private String texte;
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

    public Equipement[] recevoirCoup(int forceCoup) {
        Equipement[] equipementEjecte = null;
        forceCoup = CalculResistanceEquipement(forceCoup);
        force -= forceCoup;
        if (force > 0) {
            parler("J'abandonne...");
            equipementEjecte = ejecterEquipement();
        } else {
            parler("Aïe");
        }
        return equipementEjecte;
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
    
    private int CalculResistanceEquipement(int forceCoup) {
        texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
        int resistanceEquipement = 0;
        if (!(nbEquipement == 0)) {
            texte += "\nMais heureusement, grâce à mon équipement sa force est diminuée de ";
            for (int i = 0; i < nbEquipement;) {
                if ((equipements[i] != null &&
                equipements[i].equals(Equipement.BOUCLIER)) == true) {
                    resistanceEquipement += 8;
                } else {
                    resistanceEquipement += 5;
                }
                i++;
            }
            texte += resistanceEquipement + "!";
        }
        parler(texte);
        
        if (forceCoup > resistanceEquipement) {
            forceCoup -= resistanceEquipement;
        } else {
            forceCoup = 0;
        }
        return forceCoup;
    }

    private Equipement[] ejecterEquipement() {
        Equipement[] equipementEjecte = new Equipement[nbEquipement];
        System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
        int nbEquipementEjecte = 0;
        for (int i = 0; i < nbEquipement; i++) {
            if (equipements[i] == null) {
                continue;
            } else {
                equipementEjecte[nbEquipementEjecte] = equipements[i];
                nbEquipementEjecte++;
                equipements[i] = null;
            }
        }
        nbEquipement = 0;
        return equipementEjecte;
    }

    public static void main(String[] args) {
        Romain minus = new Romain("Minus", 6);
    }
}