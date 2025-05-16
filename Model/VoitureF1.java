package Model;

public class VoitureF1 extends Vehicule {
    private Pilote pilote;

    public VoitureF1(String modele, Pilote pilote) {
        super(modele);
        this.pilote = pilote;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Voiture F1 - Modèle: " + getModele());
        System.out.println("Pilote: " + pilote.getPrenom() + " " + pilote.getNom());
    }
}
