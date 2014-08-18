import junit.framework.TestCase;


public class CalculateTest extends TestCase {
	
	 private Frame1 frame1;
	 private Utensilien utens;
	 private Calculate calc;
	 private double expectedFläche;
	 private double actualFläche;
	 private double höhe;
	 private double breite;
	 private double ergebnis;
	
	protected void setUp() {

		frame1 = new Frame1();
		utens = new Utensilien(frame1);
		calc = new Calculate(frame1,utens);
		expectedFläche = 35;
		höhe = 5;
		breite = 7;
		calc.calcFläche(höhe, breite);
		ergebnis = breite * höhe;

	    }

	    protected void tearDown(){

		frame1 = null;
		utens = null;
		calc = null;
		expectedFläche = 0;
		breite = 0;
		höhe = 0;

	    }
	    
	    public void testcalcFläche() {
	    	assertEquals(calc.getFläche(),ergebnis);
	    }

}
