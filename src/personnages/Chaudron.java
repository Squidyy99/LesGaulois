package personnages;

public class Chaudron {
    private int quantitePotion = 0;

    public void remplirChaudron(int quantite) {
        quantitePotion = quantite;
    }

    public boolean resterPotion() {
        return quantitePotion > 0;
    }

    public int getQuantitePotion() {
        return quantitePotion;
    }

    public void setQuantitePotion(int quantitePotion) {
        this.quantitePotion = quantitePotion;
    }
}