public class Calculate {
    static double Ergebnis = (double) -1;

    static double Ergebnis;

    // Empfängt das Ergebnis aus Frame2
    Calculate() {

    }

    Calculate(double result) {

	this.Ergebnis = result;

    }

    public static double getResult() {
	return Ergebnis;
    }

<<<<<<< HEAD
	System.out.println(Ergebnis);
=======
    public static void addResult(double result) {
	Ergebnis += result;
    }
>>>>>>> origin/master

    }
}
