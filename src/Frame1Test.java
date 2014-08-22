import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Frame1Test testet die Methoden der Klasse Frame1
 */

public class Frame1Test {
    private double delta = 0.0002;
    private Frame1 frame;
    private double expectedFarbmenge;
    private double actualFarbmenge;
    private double gesamtfläche;
    private double preisklasse;
    private double actualUtens;
    private double expectedUtens;
    private double actualGesamtKosten;
    private double expectedGesamtKosten;
    private double expectedPreisPlane, expectedPreisEimer, expectedPreisRolle,
	    expectedPreisAnzug, expectedPreisPinsel;
    private double actualPreisPlane, actualPreisEimer, actualPreisRolle,
	    actualPreisAnzug, actualPreisPinsel;

    /*
     * setUp()-Methoden
     */
    protected void SetUpPreisUtensAdd() {

    }

    /**
     * initialisiert die Klassenvariablen und schafft eine Testumgebung
     */
    protected void setUp() {
	frame = new Frame1();

	expectedFarbmenge = 8.85;
	frame.calcFarbmengeFrame1();
	gesamtfläche = 50;
	frame.gesamtfläche = gesamtfläche;
	preisklasse = 0.3;
	frame.preisklasse = preisklasse;
	frame.utensGesamt = 80;

	frame.preisAnzug = 0;
	frame.preisEimer = 12;
	frame.preisPinsel = 18;
	frame.preisPlane = 20;
	frame.preisRolle = 30;
	expectedUtens = 80;
	frame.calcGesamtUtens();
	frame.addAnzugPreis(5);
	frame.addPinselPreis(3);
	frame.addEimerPreis(4);
	frame.addRollePreis(2);
	frame.addPlanePreis(7);

	expectedGesamtKosten = 95;
    }

    /**
     * schafft eine Testumgebung mit den initialisierten Variablen
     */
    protected void setUpCase2() {
	setUp();
	expectedFarbmenge = 8.3;
	frame.calcFarbmengeFrame1();
	frame.gesamtfläche = 50;
	frame.preisklasse = 0.5;

    }

    /**
     * schafft eine Testumgebung mit den initialisierten Variablen
     */
    protected void setUpCase3() {
	setUp();
	expectedFarbmenge = 6.65;
	frame.calcFarbmengeFrame1();
	frame.gesamtfläche = 50;
	frame.preisklasse = 0.6;

    }

    /**
     * die zu erwartenden Werte werden auf 0 gesetzt
     */
    protected void tearDown() {
	frame = null;
	expectedFarbmenge = 0;
	expectedPreisAnzug = 0;
	expectedPreisPlane = 0;
	expectedPreisRolle = 0;
	expectedPreisEimer = 0;
	expectedPreisPinsel = 0;

    }

    /*
     * addX()-Methoden
     */
    @Test
    /**
     *  Testet PreisAnzug auf den richtigen Wert
     */
    public void addPreisAnzugTest() {
	setUp();
	actualPreisAnzug = frame.preisAnzug;
	expectedPreisAnzug = 17.50;
	assertEquals(expectedPreisAnzug, actualPreisAnzug, delta);
	tearDown();
    }

    @Test
    /**
     *  Testet PreisPinsel auf den richtigen Wert
     */
    public void addPreisPinselTest() {
	setUp();
	actualPreisPinsel = frame.preisPinsel;
	expectedPreisPinsel = 18;
	assertEquals(expectedPreisPinsel, actualPreisPinsel, delta);
	tearDown();
    }

    @Test
    /**
     *  Testet PreisEimer auf den richtigen Wert
     */
    public void addPreisEimer() {
	setUp();
	actualPreisEimer = frame.preisEimer;
	expectedPreisEimer = 24;
	assertEquals(expectedPreisEimer, actualPreisEimer, delta);
	tearDown();
    }

    @Test
    /**
     *  Testet PreisPlane auf den richtigen Wert
     */
    public void addPreisPlane() {
	setUp();
	actualPreisEimer = frame.preisPlane;
	expectedPreisEimer = 28;
	assertEquals(expectedPreisPlane, actualPreisPlane, delta);
	tearDown();
    }

    @Test
    /**
     *  Testet PreisRolle auf den richtigen Wert
     */
    public void addPreisRolle() {
	setUp();
	actualPreisRolle = frame.preisRolle;
	expectedPreisRolle = 20;
	assertEquals(expectedPreisRolle, actualPreisRolle, delta);

	tearDown();
    }

    /*
     * Restliche Methoden
     */
    @Test
    /**
     * testet Farbmenge auf den richtigen Wert
     */
    public void Farbmengentest() {
	setUp();
	frame.calcFarbmengeFrame1();
	actualFarbmenge = frame.farbmenge;
	assertEquals(expectedFarbmenge, actualFarbmenge, delta);
	tearDown();
    }

    @Test
    /**
     * testet Farbmenge auf den richtigen Wert
     */
    public void Farbmengentest2() {
	setUpCase2();
	frame.calcFarbmengeFrame1();
	actualFarbmenge = frame.farbmenge;
	assertEquals(expectedFarbmenge, actualFarbmenge, delta);
	tearDown();
    }

    @Test
    /**
     * testet Farbmenge auf den richtigen Wert
     */
    public void FarbmengenTest3() {
	setUpCase3();
	frame.calcFarbmengeFrame1();
	actualFarbmenge = frame.farbmenge;
	assertEquals(expectedFarbmenge, actualFarbmenge, delta);
	tearDown();
    }

    @Test
    /**
     * testet gesamtUtens auf den richtigen Wert
     */
    public void gesamtUtensTest() {

	setUp();
	actualUtens = frame.utensGesamt;
	frame.calcGesamtUtens();
	assertEquals(expectedUtens, actualUtens, 0.0002);
	tearDown();
    }

    @Test
    /**
     * testet Kostenvoranschlag auf den richtigen Wert
     */
    public void calcKostenvoranschlagTest() {
	setUp();
	frame.calcKostenvoranschlag();
	actualGesamtKosten = frame.kostenvoranschlag;
	assertEquals(expectedGesamtKosten, actualGesamtKosten, delta);
	tearDown();
    }
    // TODO Auto-generated method stub

}
