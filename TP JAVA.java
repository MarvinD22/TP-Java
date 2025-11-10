public class TestEtudiant {
    public static void main(String[] args) {
        Notation[] notesAlice = {
            new Notation(12.5, 2.0),
            new Notation(9.0, 1.0),
            new Notation(15.0, 3.0)
        };

        Etudiant alice = new Etudiant("Alice Dupont", notesAlice);
        alice.afficher();

        // Modifier seuil d'avis si on veut
        double seuil = 10.0;
        System.out.printf("%s a pour moyenne %.2f et avis : %s%n",
                alice.getNom(), alice.getMoyenne(), alice.getAvis());

        // Autre étudiant sans notes
        Etudiant bob = new Etudiant("Bob Martin", new Notation[0]);
        bob.afficher();
    }
}
