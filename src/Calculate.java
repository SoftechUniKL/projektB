public class Calculate {
    static double fl�che;
    static double farbmenge;

    // preis?
    double preis;

    // Statische Klassenvariablen
    static double endpreis;
    static double gesamtfl�che;

    // Konstruktor
    Calculate() {

    }

    public static double getFl�che() {
	return fl�che;
    }

    public static void setFl�che(double area) {
	fl�che = area;
    }

    public static void addFl�che(double area) {
	fl�che += area;
    }

}