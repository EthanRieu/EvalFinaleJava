package Model;

public abstract class Vehicule {
    private String modele;

    public Vehicule(String modele) {
        this.modele = modele;
    }

    public String getModele() {
        return modele;
    }

    public abstract void afficherDetails();
}
