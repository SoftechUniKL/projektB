public class Calculate {
    double Ergebnis = (double) -1;

    // Empfängt das Ergebnis aus Frame2
    Calculate() {

    }

    Calculate(double result) {

	this.Ergebnis = result;

    }

    public double getResult() {
	return this.Ergebnis;
    }

}
