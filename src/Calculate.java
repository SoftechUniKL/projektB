public class Calculate {
    static double fläche;
    static double farbmenge;

    // preis?
    double preis;

    // Statische Klassenvariablen
    static double endpreis;
    static double gesamtfläche;

    FirstWindow first;

    Calculate(FirstWindow first) {
	this.first = first;
    }

    public static double getFläche() {
	return fläche;
    }

    public static void setFläche(double area) {
	fläche = area;
    }

    public static void addFläche(double area) {
	fläche += area;
    }

    public void setGesamtfläche() {
	first.setSqm(this.fläche);
    }

}