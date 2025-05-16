package Model;

public class Pilote extends Personne implements Pilotable {
    private boolean enPiste;

    public Pilote(String nom, String prenom) {
        super(nom, prenom);
        this.enPiste = false;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Pilote: " + getPrenom() + " " + getNom());
        System.out.println("Statut: " + (enPiste ? "En piste" : "Au stand"));
    }

    @Override
    public void sortir() {
        enPiste = true;
        System.out.println(getPrenom() + " " + getNom() + " est sorti sur la piste.");
    }

    @Override
    public void rentrer() {
        enPiste = false;
        System.out.println(getPrenom() + " " + getNom() + " est rentré aux stands.");
    }
}
