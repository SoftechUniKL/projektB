public class Calculate {

    int numberOfRooms;

    private double height;
    private double width;

    private double fläche;

    // preis?
    private double preis;

    // Statische Klassenvariablen
    private static double kostenvoranschlag;
    private static double gesamtfläche;
    private static double farbmenge;

    Frame1 frame1;

    Calculate(Frame1 frame1) {
	this.frame1 = frame1;
    }

    // Methoden
    // Getter und Setter

    public void setPreis(double preis) {
	this.preis = preis;
    }

    public void calcFläche(double height, double width) {
	this.fläche += height * width;
    }

    public void resetFläche() {
	this.fläche = 0;
    }

    public void setHeight(double height) {
	this.height = height;
    }

    public void setWidth(double width) {
	this.width = width;
    }

    public double getFläche() {
	return fläche;
    }

    public void setFläche(double fläche) {
	this.fläche = fläche;
    }

    public void addFläche(double fläche) {
	fläche += fläche;
    }

    public void calcGesamtflächeFrame1() {
	this.numberOfRooms += 1;
	gesamtfläche += this.fläche;
	this.resetFläche();
	frame1.setSqm(gesamtfläche);
    }

    public void calcFarbmengeFrame1() {
	/*
	 * benötigte variablen: gesamtfläche preis(if abfrage)--> ml/l pro qm
	 * switch case
	 */
	this.farbmenge = this.gesamtfläche + 999999;
	frame1.setLiter(this.farbmenge);
    }

    public void calcKostenvoranschlagFrame1() {
	this.kostenvoranschlag = this.preis * this.gesamtfläche;
	frame1.setEndprice(this.kostenvoranschlag);
    }

}