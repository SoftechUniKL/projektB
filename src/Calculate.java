public class Calculate {
    // github sblödsinn
    private double fläche;
    private double farbmenge;

    // preis?
    private double preis;

    // Statische Klassenvariablen
    private static double endpreis;
    private static double gesamtfläche;

    FirstWindow first;

    // Konstruktor
    Calculate(FirstWindow first) {
	this.first = first;

    }

    public double getFläche() {
	return this.fläche;
    }

    public void setFläche(double area) {
	this.fläche = area;
    }

    public void addFläche(double area) {
	this.fläche += area;
    }

    public void setGesamtfläche() {
	first.setSqm(this.fläche);
    }

}