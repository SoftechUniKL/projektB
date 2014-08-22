import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Frame2Test testet die Methoden der Klasse Frame2
 */
public class Frame2Test {

    private Frame1 frame1;
    private Frame2 frame2;
    private double h�he;
    private double breite;
    private double ergebnis;

    /**
     * schafft eine Testumgebung mit definierten Variablen
     */
    protected void setUp() {

	frame1 = new Frame1();
	frame2 = new Frame2(frame1);
	h�he = 5;
	breite = 7;
	frame2.calcFl�che(h�he, breite);
	ergebnis = breite * h�he;

    }

    /**
     * setzt die Variablen zur�ck
     */

    protected void tearDown() {

	frame1 = null;
	frame2 = null;
	breite = 0;
	h�he = 0;

    }

    @Test
    /**
     * testet ob die Eingaben positiv waren
     */
    public void arePositiveTest() {
	setUp();
	assertTrue(frame2.arePositive(4, 4, 4, 4));
	tearDown();
    }

    @Test
    /**
     * testet ob die Eingaben negativ waren
     */
    public void areNegativeTest() {
	setUp();
	assertFalse(frame2.arePositive(-1, 2, 4, 4));
	tearDown();
    }

    @Test
    /**
     * testet ob die Eingaben ein Rechteck ergeben
     */
    public void isRechteckigTest() {
	setUp();
	assertTrue(frame2.isRechteckig(4, 4, 3, 3));
	tearDown();
    }

    @Test
    /**
     * testet ob die Eingaben kein Rechteck ergeben
     */
    public void isNotRechteckigTest() {
	setUp();
	assertFalse(frame2.isRechteckig(4, 1, 3, 15));
	tearDown();
    }

    @Test
    /**
     * testet ob die ausgerechnete Fl�che korrekt ist
     */
    public void testcalcFl�che() {
	setUp();
	assertEquals(ergebnis, frame2.fl�che, 0.0002);
	tearDown();
    }

}
