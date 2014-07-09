public class Wand {
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
	// this.fläche = (this.hoehe * this.breite) - türFenster.fläche;
	/*
	 * Wie greife ich auf alle WOMÖGLICHEN "kindobjekte" von wand zu? also
	 * falls eine zu bestreichende Wand ein oder Mehrere(!) fenster hat- wie
	 * kann ich in der Klasse die Fensterflächen (automatisch) abziehen?
	 */

	// türfenster abzioehen?!?"ß;
	return fläche;
    }
    // void newTürFenster(){
    // TürFenster türFenster = new TürFenster();
}
