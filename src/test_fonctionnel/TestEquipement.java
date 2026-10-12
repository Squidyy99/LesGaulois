package test_fonctionnel;

import personnages.Equipement;
import personnages.Romain;

public class TestEquipement {
    public static void main(String[] args) {
        Romain minus = new Romain("Minus", 6);

        // Test équipement ! 
        
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE); 
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE); 
    }
}