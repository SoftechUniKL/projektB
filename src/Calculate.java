public class Calculate {

    /**
     * Die Calculate class berechnet die Flaeche der Raeume bzw. die
     * Gesamtflaeche aller Raeume. Daraus wird dann die benoetigte Farbmenge und
     * deren Preis berechnet. Dieser Preis wird zusammen mit dem Preis fuer die
     * Utensilien zum Kostenvoranschlag zusammengerechnet
     */

    int numberOfRooms;
    // TODO hashset ode r�hnliches mti menge von raum/wand objekten zur
    // berechnung �ber elemente iterieren
    private double height;
    private double width;
    private double verbrauch;

    private double fl�che;

    // preis?
    private double preis;

    // Statische Klassenvariablen
    private static double kostenvoranschlag;
    private static double gesamtfl�che;
    private static double farbmenge;

    Frame1 frame1;
    Utensilien utens;

    Calculate(Frame1 frame1, Utensilien utens) {
	this.frame1 = frame1;
	this.utens = utens;
	this.fl�che = 0;

    }

    // Methoden
    // Getter und Setter

    public void setPreis(double preis) {
	this.preis = preis;
    }

    public void calcFl�che(double height, double width) {
	this.fl�che += height * width;
	// wandert in "Wand"
    }

    public void resetFl�che() {
	this.fl�che = 0;
    }

    public void setHeight(double height) {
	this.height = height;
    }

    public void setWidth(double width) {
	this.width = width;
    }

    public double getFl�che() {
	return fl�che;
    }

    public void setFl�che(double fl�che) {
	this.fl�che = fl�che;
    }

    public void calcGesamtfl�cheFrame1() {
	this.numberOfRooms += 1;
	gesamtfl�che += this.fl�che;
	this.resetFl�che();
	frame1.setSqm(gesamtfl�che);
    }

    public void calcFarbmengeFrame1() {
	/*
	 * ben�tigte variablen: gesamtfl�che preis(if abfrage)--> ml/l pro qm
	 * switch case
	 */
	switch (Double.toString(preis)) {
	case "0.3":
	    verbrauch = 0.177;
	    break;

	case "0.5":
	    verbrauch = 0.166;
	    break;

	case "0.6":
	    verbrauch = 0.133;
	    break;
	}

	Calculate.farbmenge = Calculate.gesamtfl�che * verbrauch;
	frame1.setLiter(Calculate.farbmenge);
    }

    public void calcKostenvoranschlagFrame1() {
	// this.utensilien preis ist sehr hoch
	Calculate.kostenvoranschlag = (this.preis * Calculate.gesamtfl�che)
		+ utens.getGesamt();
	// Calculate.kostenvoranschlag += utens.getGesamt();
	frame1.setEndprice(Calculate.kostenvoranschlag);
    }

}