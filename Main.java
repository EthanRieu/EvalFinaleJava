import Model.Pilote;

public class Main {
    public static void main(String[] args) {
        // ici on créer le pilote man
        Pilote pilote = new Pilote("Hamilton", "Lewis");

        // On affiche ses détails bro
        pilote.afficherDetails();

        // Il sort sur la piste gaté
        pilote.sortir();
        pilote.afficherDetails();

        // Il rentre au stand le salopard
        pilote.rentrer();
        pilote.afficherDetails();
    }
}
