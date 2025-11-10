class Etudiant 

public class Etudiant {
    private String nom;
    private double moyenne;
    private String avis;
    private Notation[] notations;

    public Etudiant(String nom, Notation[] notations) {
        this.nom = nom;
        // Défensive copy
        this.notations = notations == null ? new Notation[0] : Arrays.copyOf(notations, notations.length);
        this.moyenne = 0.0;
        this.avis = "";
    }

    public String getNom() {
        return nom;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public String getAvis() {
        return avis;
    }

    public Notation[] getNotations() {
        return Arrays.copyOf(notations, notations.length);
    }

    public void setNotations(Notation[] notations) {
        this.notations = notations == null ? new Notation[0] : Arrays.copyOf(notations, notations.length);
    }

    // Calcule la moyenne pondérée et met à jour l'attribut moyenne
    public double moyenne() {
        double sommePonderee = 0.0;
        double sommeCoef = 0.0;
        for (Notation n : notations) {
            if (n != null) {
                sommePonderee += n.getNote() * n.getCoef();
                sommeCoef += n.getCoef();
            }
        }
        if (sommeCoef == 0) {
            this.moyenne = 0.0;
        } else {
            this.moyenne = sommePonderee / sommeCoef;
        }
        return this.moyenne;
    }

    // Détermine l'avis selon un seuil (par ex. seuil = 10.0). Possible avis : "Admis", "Rattrapage", "Ajourné"
    public String avis(double seuil) {
        // Assurer que la moyenne est calculée
        moyenne();
        if (moyenne >= seuil) {
            avis = "Admis";
        } else if (moyenne >= seuil - 2) {
            avis = "Rattrapage";
        } else {
            avis = "Ajourné";
        }
        return avis;
    }

    // Affiche toutes les informations de l'étudiant
    public void afficher() {
        System.out.println("----- Fiche Etudiant -----");
        System.out.println("Nom: " + nom);
        System.out.println("Notations:");
        if (notations.length == 0) {
            System.out.println("  (Aucune notation)");
        } else {
            for (Notation n : notations) {
                if (n != null) {
                    System.out.println("  - " + n.toString());
                }
            }
        }
        System.out.printf("Moyenne: %.2f%n", moyenne());
        String currentAvis = avis(10.0); // exemple : seuil par défaut 10.0
        System.out.println("Avis: " + currentAvis);
        System.out.println("--------------------------");
    }
}
