public class Wand {
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
	// this.fl�che = (this.hoehe * this.breite) - t�rFenster.fl�che;
	/*
	 * Wie greife ich auf alle WOM�GLICHEN "kindobjekte" von wand zu? also
	 * falls eine zu bestreichende Wand ein oder Mehrere(!) fenster hat- wie
	 * kann ich in der Klasse die Fensterfl�chen (automatisch) abziehen?
	 */

	// t�rfenster abzioehen?!?"�;
	return fl�che;
    }
    // void newT�rFenster(){
    // T�rFenster t�rFenster = new T�rFenster();
}
