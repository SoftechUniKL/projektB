import java.rmi.RemoteException;

import org.junit.Assert;
import org.junit.Test;

public class calcFl�cheTest {

    private Frame1 frame1;
    private Frame2 frame2;
    private double fl�che;
    private double h�he;
    private double breite;
    private double output;

    protected void setUp() throws RemoteException {

	frame1 = new Frame1();
	frame2 = new Frame2(frame1);
	fl�che = 35;
	h�he = 5;
	breite = 7;
	frame2.calcFl�che(h�he, breite);

    }

    protected void tearDown() throws RemoteException {

	frame1 = null;
	frame2 = null;
	fl�che = 0;
	breite = 0;
	h�he = 0;

    }

    @Test
    public void testCalcFl�che() {
	setUp();
	frame2.calcFl�che(h�he, breite);

	Assert.assertArrayEquals(35, frame2.calcFl�che());
	tearDown();
    }

}
