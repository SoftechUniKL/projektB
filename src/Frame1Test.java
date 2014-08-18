import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Frame1Test {

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

    protected void setUp() {
	frame = new Frame1();
	verbrauch = 0.177;
	frame.verbrauch = verbrauch;
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

	expectedGesamtKosten = expectedUtens + gesamtfläche * preisklasse;
    }

    protected void tearDown() {
	frame = null;
	verbrauch = 0;
	expectedFarbmenge = 0;

    }

    @Test
    public void test() {
	setUp();
	actualFarbmenge = frame.getMenge();
	frame.calcFarbmengeFrame1();
	assertEquals(expectedFarbmenge, actualFarbmenge, 0.00002);
	tearDown();
    }

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
