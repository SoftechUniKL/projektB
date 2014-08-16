import java.rmi.RemoteException;

import junit.framework.TestCase;

import org.junit.Test;

public class calcFl�cheTest extends TestCase {

    private Frame1 frame1;
    private Frame2 frame2;
    private double expectedFl�che;
    private double actualFl�che;
    private double h�he;
    private double breite;

    // private double output;

    protected void setUp() throws RemoteException {

	frame1 = new Frame1();
	frame2 = new Frame2(frame1);
	expectedFl�che = 35;
	h�he = 5;
	breite = 7;
	frame2.calcFl�che(h�he, breite);

    }

    protected void tearDown() throws RemoteException {

	frame1 = null;
	frame2 = null;
	expectedFl�che = 0;
	breite = 0;
	h�he = 0;

    }

    @Test
    public void testCalcFl�che() throws RemoteException {
	setUp();

	frame2.calcFl�che(h�he, breite);
	actualFl�che = frame2.getFl�che();
	assertEquals(expectedFl�che, actualFl�che, 0.0002);
	tearDown();

	/*
	 * ODER: assertEquals(expectedFl�che, frame2.getFl�che(), 0.0002
	 */
    }

}
