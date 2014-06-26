public class Calculate extends Frame2 {

    double length1;
    double length2;
    double length3;
    double length4;

    double hight;

    public void meassures(double l1, double l2, double l3, double l4, double h) {
	this.length1 = l1;
	this.length2 = l2;
	this.length3 = l3;
	this.length4 = l4;
	this.hight = h;
	double Ergebnis;
	Ergebnis = l1 * h + l2 * h + l3 * h + l4 * h;
    }

}
