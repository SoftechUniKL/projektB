import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Frame2Test {

    private Frame1 frame1;
    private Frame2 frame2;
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

    protected void tearDown() {

	frame1 = null;
	frame2 = null;
	breite = 0;
	höhe = 0;

    }

    @Test
    public void arePositiveTest() {
	setUp();
	assertTrue(frame2.arePositive(4, 4, 4, 4));
	tearDown();
    }

    @Test
    public void areNegativeTest() {
	setUp();
	assertFalse(frame2.arePositive(-1, 2, 4, 4));
	tearDown();
    }

    @Test
    public void isRechteckigTest() {
	setUp();
	assertTrue(frame2.isRechteckig(4, 4, 3, 3));
	tearDown();
    }

    @Test
    public void isNotRechteckigTest() {
	setUp();
	assertFalse(frame2.isRechteckig(4, 1, 3, 15));
	tearDown();
    }

    @Test
    public void testcalcFläche() {
	setUp();
	assertEquals(ergebnis, frame2.fläche, 0.0002);
	tearDown();
    }

}
