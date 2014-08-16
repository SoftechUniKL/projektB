import java.rmi.RemoteException;

import junit.framework.TestCase;

import org.junit.Test;

public class calcFlächeTest extends TestCase {

    private Frame1 frame1;
    private Frame2 frame2;
    private double expectedFläche;
    private double actualFläche;
    private double höhe;
    private double breite;

    // private double output;

    protected void setUp() throws RemoteException {

	frame1 = new Frame1();
	frame2 = new Frame2(frame1);
	expectedFläche = 35;
	höhe = 5;
	breite = 7;
	frame2.calcFläche(höhe, breite);

    }

    protected void tearDown() throws RemoteException {

	frame1 = null;
	frame2 = null;
	expectedFläche = 0;
	breite = 0;
	höhe = 0;

    }

    @Test
    public void testCalcFläche() throws RemoteException {
	setUp();

	frame2.calcFläche(höhe, breite);
	actualFläche = frame2.getFläche();
	assertEquals(expectedFläche, actualFläche, 0.0002);
	tearDown();

	/*
	 * ODER: assertEquals(expectedFläche, frame2.getFläche(), 0.0002
	 */
    }

}
