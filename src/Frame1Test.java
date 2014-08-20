import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Frame1Test {
    private double delta = 0.0002;
    private Frame1 frame;
    private double verbrauch;
    private double expectedFarbmenge;
    private double actualFarbmenge;
    private double gesamtfläche;
    private double preisklasse;
    private double preisPlane;
    private double preisAnzug;
    private double preisRolle;
    private double preisEimer;
    private double preisPinsel;
    private double actualUtens;
    private double expectedUtens;
    private double mengePinsel;
    private double mengeEimer;
    private double mengeRolle;
    private double mengeAnzug;
    private double mengePlane;
    private double actualGesamtKosten;
    private double expectedGesamtKosten;
    private int val;
    private double expectedPreisPlane, expectedPreisEimer, expectedPreisRolle,
	    expectedPreisAnzug, expectedPreisPinsel;
    private double actualPreisPlane, actualPreisEimer, actualPreisRolle,
	    actualPreisAnzug, actualPreisPinsel;

    /*
     * setUp()-Methoden
     */
    protected void SetUpPreisUtensAdd() {

    }

    protected void setUp() {
	frame = new Frame1();

	expectedFarbmenge = 8.85;
	frame.calcFarbmengeFrame1();
	gesamtfläche = 50;
	frame.gesamtfläche = gesamtfläche;
	preisklasse = 0.3;
	frame.preisklasse = preisklasse;

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

	expectedGesamtKosten = expectedUtens + gesamtfläche * preisklasse;
    }

    protected void setUpCase2() {
	setUp();
	expectedFarbmenge = 8.3;
	frame.calcFarbmengeFrame1();
	gesamtfläche = 50;
	frame.gesamtfläche = gesamtfläche;
	preisklasse = 0.5;
	frame.preisklasse = preisklasse;

    }

    protected void tearDown() {
	frame = null;
	verbrauch = 0;
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
    public void addPreisAnzugTest() {
	setUp();
	actualPreisAnzug = frame.getAnzugPreis();
	expectedPreisAnzug = 17.50;
	assertEquals(expectedPreisAnzug, actualPreisAnzug, delta);
	tearDown();
    }

    @Test
    public void addPreisPinselTest() {
	setUp();
	actualPreisPinsel = frame.getPinselPreis();
	expectedPreisPinsel = 18;
	assertEquals(expectedPreisPlane, actualPreisPlane, delta);
	tearDown();
    }

    @Test
    public void addPreisEimer() {
	setUp();
	actualPreisEimer = frame.getEimerPreis();
	expectedPreisEimer = 24;
	assertEquals(expectedPreisEimer, actualPreisEimer, delta);
	tearDown();
    }

    @Test
    public void addPreisPlane() {
	setUp();
	actualPreisEimer = frame.getPlanePreis();
	expectedPreisEimer = 28;
	assertEquals(expectedPreisPlane, actualPreisPlane, delta);
	tearDown();
    }

    @Test
    public void addPreisRolle() {
	setUp();
	actualPreisRolle = frame.getRollePreis();
	expectedPreisRolle = 20;
	assertEquals(expectedPreisRolle, actualPreisRolle, delta);

	tearDown();
    }

    /*
     * Restliche Methoden
     */
    @Test
    public void Farbmengentest() {
	setUp();
	actualFarbmenge = frame.getMenge();
	frame.calcFarbmengeFrame1();
	assertEquals(expectedFarbmenge, actualFarbmenge, 0.00002);
	tearDown();
    }

    @Test
    public void Farbmengentest2() {
	setUpCase2();
	actualFarbmenge = frame.getMenge();
	frame.calcFarbmengeFrame1();
	assertEquals(expectedFarbmenge, actualFarbmenge, 0.00002);
	tearDown();
    }

    @Test
    public void gesamtUtensTest() {

	setUp();
	actualUtens = frame.getGesamtUtens();
	frame.calcGesamtUtens();
	assertEquals(expectedUtens, actualUtens, 0.0002);
	tearDown();
    }

    public void calcKostenvoranschlagTest() {
	setUp();
	actualGesamtKosten = frame.getGesamtPreis();
	frame.calcKostenvoranschlag();
	assertEquals(expectedGesamtKosten, actualGesamtKosten, 0.002);
	tearDown();
    }
    // TODO Auto-generated method stub

}
