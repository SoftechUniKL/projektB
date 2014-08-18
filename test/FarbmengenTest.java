import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

public class FarbmengenTest {

    private Frame1 frame;
    private double verbrauch;
    private double expectedFarbmenge;
    private double actualFarbmenge;
    private double gesamtfläche;
    private double preisklasse;

    protected void setUp() throws RemoteException {
	frame = new Frame1();
	verbrauch = 0.177;
	expectedFarbmenge = 8.85;
	frame.calcFarbmengeFrame1(0.3);
	gesamtfläche = 50;
	preisklasse = 0.3;

    }

    protected void tearDown() throws RemoteException {
	frame = null;
	verbrauch = 0;
	expectedFarbmenge = 0;

    }

    @Test
    public void test() throws RemoteException {
	setUp();
	actualFarbmenge = frame.getMenge();
	frame.calcFarbmengeFrame1(0.3);
	assertEquals(expectedFarbmenge, actualFarbmenge, 0.00002);
	tearDown();
    }

}
