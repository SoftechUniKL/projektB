public class Calculate {
    // github sbl�dsinn
    private double fl�che;
    private double farbmenge;

    // preis?
    private double preis;

    // Statische Klassenvariablen
    private static double endpreis;
    private static double gesamtfl�che;

    FirstWindow first;

    // Konstruktor
    Calculate(FirstWindow first) {
	this.first = first;

    }

    public double getFl�che() {
	return this.fl�che;
    }

    public void setFl�che(double area) {
	this.fl�che = area;
    }

    public void addFl�che(double area) {
	this.fl�che += area;
    }

    public void setGesamtfl�che() {
	first.setSqm(this.fl�che);
    }

}