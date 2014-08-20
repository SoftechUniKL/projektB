import junit.framework.TestCase;

public class Frame2Test extends TestCase {

    private Frame1 frame1;
    private Utensilien utens;
    private Frame2 frame2;
    private double expectedFl�che;
    private double actualFl�che;
    private double h�he;
    private double breite;
    private double ergebnis;

    protected void setUp() {

	frame1 = new Frame1();
	frame2 = new Frame2(frame1);
	h�he = 5;
	breite = 7;
	frame2.calcFl�che(h�he, breite);
	ergebnis = breite * h�he;

    }

    protected void setUp2() {
	setUp();
	// Switches
	breite = -7;
    }

    protected void tearDown() {

	frame1 = null;
	utens = null;
	frame2 = null;
	breite = 0;
	h�he = 0;

    }

    public void testcalcFl�che() {
	assertEquals(frame2.getFl�che(), ergebnis);
    }

}
