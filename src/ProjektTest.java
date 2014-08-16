import java.rmi.RemoteException;

import junit.framework.TestCase;

import org.junit.Test;

public class ProjektTest extends TestCase {

    private Frame2 frame;

    protected void setUp() throws RemoteException {


    protected void tearDown() throws RemoteException {
	wand = null;
    }

    @Test
    public void test() throws RemoteException {
	setUp();
	assertEquals(48, wand.flaeche(), 0.002);
	tearDown();
    }

}
