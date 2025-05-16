package Model;

public class VoitureF1 {
    private String modele;
    private Pilote pilote;

    public VoitureF1(String modele, Pilote pilote) {
        this.modele = modele;
        this.pilote = pilote;
    }

    public String getModele() {
        return modele;
    }

    public Pilote getPilote() {
        return pilote;
    }

    public void afficherDetails() {
        System.out.println("Voiture F1 - Modèle: " + modele);
        System.out.println("Pilote: " + pilote.getPrenom() + " " + pilote.getNom());
    }
}
