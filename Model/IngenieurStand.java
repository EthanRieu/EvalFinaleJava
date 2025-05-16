package Model;

public class IngenieurStand extends Personne {
    private String specialite;

    public IngenieurStand(String nom, String prenom, String specialite) {
        super(nom, prenom);
        this.specialite = specialite;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Ingénieur de Stand: " + getPrenom() + " " + getNom());
        System.out.println("Spécialité: " + specialite);
    }
}
