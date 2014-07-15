public class Calculate {

    int numberOfRooms;

    private double height;
    private double width;

    private double fl�che;

    // preis?
    private double preis;

    // Statische Klassenvariablen
    private static double kostenvoranschlag;
    private static double gesamtfl�che;
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

    public void calcFl�che(double height, double width) {
	this.fl�che += height * width;
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

    public void addFl�che(double fl�che) {
	fl�che += fl�che;
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
	this.farbmenge = this.gesamtfl�che + 999999;
	frame1.setLiter(this.farbmenge);
    }

    public void calcKostenvoranschlagFrame1() {
	this.kostenvoranschlag = this.preis * this.gesamtfl�che;
	frame1.setEndprice(this.kostenvoranschlag);
    }

}