import junit.framework.TestCase;

public class Frame2Test extends TestCase {

    private Frame1 frame1;
    private Utensilien utens;
    private Frame2 frame2;
    private double expectedFläche;
    private double actualFläche;
    private double höhe;
    private double breite;
    private double ergebnis;

    protected void setUp() {

	frame1 = new Frame1();
	frame2 = new Frame2(frame1);
	höhe = 5;
	breite = 7;
	frame2.calcFläche(höhe, breite);
	ergebnis = breite * höhe;

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
	höhe = 0;

    }

    public void testcalcFläche() {
	assertEquals(frame2.getFläche(), ergebnis);
    }

}
