public class Calculate {
    static double Ergebnis = (double) -1;

    // Empf�ngt das Ergebnis aus Frame2
    Calculate() {

    }

    Calculate(double result) {

	this.Ergebnis = result;
	System.out.println(Ergebnis);

    }

    public static double getResult() {
	return Ergebnis;
    }

    public static void addResult(double result) {
	Ergebnis += result;
    }

}
