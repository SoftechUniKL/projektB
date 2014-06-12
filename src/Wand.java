public class Wand {
    double hoehe;
    double breite;

    double flaeche() {
	return this.hoehe * this.breite;
    }

    public Wand(double breite, double hoehe) {
	this.hoehe = hoehe;
	this.breite = breite;
    }
}
