package personnages;

import village_gaulois.Village;
import objets.Equipement;
import village_gaulois.Musee; 

public class Gaulois {
    private String nom;
    private Village village; 
    private int force, nb_trophees;
    private int effetPotion = 1;
    private Equipement trophees[] = new Equipement[100];

    public Gaulois(String nom, int force) {
        this.nom = nom;
        this.force = force;
        this.effetPotion = 1; // potion
    }
    
    public String getNom() {
        return nom;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "\"" + texte + "\"");
    }

    private String prendreParole() {
        String texte = "Le gaulois " + nom + " : ";
        return texte;
    }
    
    @Override
    public String toString() {
        return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
    }
    
    public void frapper(Romain romain) {
        System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
        Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
        effetPotion--;
        if (effetPotion < 1) {
            effetPotion = 1;
        }
        for (int i = 0; trophees != null && i < trophees.length; i++) {
            if (nb_trophees < this.trophees.length) {
                this.trophees[nb_trophees] = trophees[i];
                nb_trophees++;
            }
        }
        return;
    }
    
    public void boirePotion(int forcePotion) {
        effetPotion = forcePotion;
    }

    public void sePresenter() {
        if (village != null && this == village.getChef()) {
            System.out.println("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom + ". Je suis le chef du village : " + village.getNom() + ".\"");
        } else if (village != null) {
            System.out.println("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom + ". J'habite le village : " + village.getNom() + ".\"");
        } else {
            System.out.println("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.\"");
        }
    }
    
    public void faireUneDonnation(Musee musee) {
        if (nb_trophees > 0) {
            System.out.println("Le gaulois " + nom + " : \"Je donne au musee tous mes trophees :");
            for (int i = 0; i < nb_trophees; i++) {
                System.out.println("- " + trophees[i]);
                musee.donnerTrophees(this, trophees[i]);
            }
            System.out.println("\"");
            nb_trophees = 0;
        }
    }
    
}