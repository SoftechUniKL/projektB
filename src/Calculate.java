public class Calculate {

    int numberOfRooms;

    private double height;
    private double width;

    private double fl�che;
    private double farbmenge;

    // preis?
    private double preis;

    // Statische Klassenvariablen
    static double endpreis;
    static double gesamtfl�che;

    Frame1 frame1;

    Calculate(Frame1 frame1) {
	this.frame1 = frame1;
    }

    // Methoden
    // Getter und Setter
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

    public void setGesamtfl�cheFrame1() {
	this.numberOfRooms += 1;
	gesamtfl�che += this.fl�che;
	this.resetFl�che();
	frame1.setSqm(gesamtfl�che);
    }

}