import java.rmi.RemoteException;

import org.junit.Assert;
import org.junit.Test;

public class calcFlächeTest {

    private Frame1 frame1;
    private Frame2 frame2;
    private double fläche;
    private double höhe;
    private double breite;
    private double output;

    protected void setUp() throws RemoteException {

	frame1 = new Frame1();
	frame2 = new Frame2(frame1);
	fläche = 35;
	höhe = 5;
	breite = 7;
	frame2.calcFläche(höhe, breite);

    }

    protected void tearDown() throws RemoteException {

	frame1 = null;
	frame2 = null;
	fläche = 0;
	breite = 0;
	höhe = 0;

    }

    @Test
    public void testCalcFläche() {
	setUp();
	frame2.calcFläche(höhe, breite);

	Assert.assertArrayEquals(35, frame2.calcFläche());
	tearDown();
    }

}
