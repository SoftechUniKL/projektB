/* Die Utensilien Klasse bezieht die Anzahl der einzelnen Utensilien aus Frame1 und berechnet daraus
 * die Preise der einzelnen Utensilien und addiert diese zum Utensilien Gesamtpreis zusammen.
 * 
 */

public class Utensilien {
    Frame1 frame;

    // Preisvariablen initialisieren
    private double preisAnzug;
    private double preisPlane;
    private double preisPinsel;
    private double preisEimer;
    private double preisRolle;

    private static double gesamt = 0;

    // Konstruktor
    Utensilien(Frame1 frame) {
	this.frame = frame;
    }

    // Methoden
    public void addAnzugPreis(int val) {
	this.preisAnzug = val * 3.50;
    }

    public void addPlanePreis(int val) {
	this.preisPlane = val * 4;
    }

    public void addPinselPreis(int val) {
	this.preisPinsel = val * 6;
    }

    public void addEimerPreis(int val) {
	this.preisEimer = val * 6;
    }

    public void addRollePreis(int val) {
	this.preisRolle = val * 10;
    }

    public void calcGesamt() {
	Utensilien.gesamt = preisAnzug + preisPlane + preisPinsel + preisEimer
		+ preisRolle;
    }

    public double getGesamt() {
	this.calcGesamt();
	return Utensilien.gesamt;
    }

}
