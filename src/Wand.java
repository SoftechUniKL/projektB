public class Wand extends Raum {
    double hoehe;
    double breite;
    double fl�che;

    public Wand() {
	T�rFenster t�rFenster = new T�rFenster();
    }

    public Wand(double breite, double hoehe) {
	this.hoehe = hoehe;
	this.breite = breite;
    }

    double flaeche() {
	this.fl�che = (this.hoehe * this.breite) - t�rFenster.fl�che;
	// t�rfenster abzioehen?!?"�;
	return fl�che;
    }
    // void newT�rFenster(){
    // T�rFenster t�rFenster = new T�rFenster();
}
