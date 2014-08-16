import java.rmi.RemoteException;

import junit.framework.TestCase;

public class ProjektTest extends TestCase {
    
     private *Frame2 frame;
      
     protected void setUp() throws RemoteException {
	 frame = new *Frame2();
	 }
     
      protected void tearDown() throws RemoteException { 
	  wand = null; }
      
      @Test public void test() throws RemoteException { setUp();
      assertEquals(48, wand.flaeche(), 0.002); 
      tearDown(); }
     
}
