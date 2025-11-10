public class Notation {
    private double coef;
    private double note;

    public Notation(double note, double coef) {
        this.note = note;
        this.coef = coef;
    }

    public double getCoef() {
        return coef;
    }

    public double getNote() {
        return note;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public void afficher() {
        System.out.printf("Note: %.2f  (Coef: %.2f)%n", note, coef);
    }

    @Override
    public String toString() {
        return String.format("Note: %.2f (Coef: %.2f)", note, coef);
    }
}
