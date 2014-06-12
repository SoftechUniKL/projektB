public class Wand extends Raum {
    double hoehe;
    double breite;
    double fläche;

    public Wand() {
	TürFenster türFenster = new TürFenster();
    }

    public Wand(double breite, double hoehe) {
	this.hoehe = hoehe;
	this.breite = breite;
    }

    double flaeche() {
	this.fläche = (this.hoehe * this.breite) - türFenster.fläche;
	// türfenster abzioehen?!?"ß;
	return fläche;
    }
    // void newTürFenster(){
    // TürFenster türFenster = new TürFenster();
}
