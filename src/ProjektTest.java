import static org.junit.Assert.*;

import java.rmi.RemoteException;

import junit.framework.*;

import org.junit.Test;

public class ProjektTest extends TestCase {
    private Wand wand;
    
    protected void setUp() throws RemoteException {
	wand = new Wand(8,6);
    }
    
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
