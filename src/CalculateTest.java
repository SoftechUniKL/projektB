import junit.framework.TestCase;

public class CalculateTest extends TestCase {

    private Frame1 frame1;
    private Utensilien utens;
    private Calculate calc;
    private double expectedFl�che;
    private double actualFl�che;
    private double h�he;
    private double breite;
    private double ergebnis;

    protected void setUp() {

	frame1 = new Frame1();
	utens = new Utensilien(frame1);
	calc = new Calculate(frame1, utens);
	h�he = 5;
	breite = 7;
	calc.calcFl�che(h�he, breite);
	ergebnis = breite * h�he;

    }

    protected void tearDown() {

	frame1 = null;
	utens = null;
	calc = null;
	breite = 0;
	h�he = 0;

    }

    public void testcalcFl�che() {
	assertEquals(calc.getFl�che(), ergebnis);
    }

}
