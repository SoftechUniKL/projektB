public class Calculate {

    int numberOfRooms;

    private double height;
    private double width;

    private double fläche;
    private double farbmenge;

    // preis?
    private double preis;

    // Statische Klassenvariablen
    static double endpreis;
    static double gesamtfläche;

    Frame1 frame1;

    Calculate(Frame1 frame1) {
	this.frame1 = frame1;
    }

    // Methoden
    // Getter und Setter
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

    public void setGesamtflächeFrame1() {
	this.numberOfRooms += 1;
	gesamtfläche += this.fläche;
	this.resetFläche();
	frame1.setSqm(gesamtfläche);
    }

}