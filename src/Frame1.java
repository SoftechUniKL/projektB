import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*  Die Frame1 Klasse ist für die Auswahl der Preisklasse der Farbe,
 *  für das Hinzufügen neuer Räume  und für die Auswahl der  Anzahl der utensilien verantwortlich.
 *  Frame1 greift auf alle Endergebnisse der anderen Klassen zu, um aus ihnen die benötigte Farbmenge 
 *  und den Kostenvoranschlag zu berechnen.
 * 
 */
public class Frame1 extends JFrame {

    double m1 = 0;
    double m2 = 0;
    double m3 = 0;
    double m4 = 0;
    double h = 0;
    double result = 0;
    double result1 = 0;
    double result2 = 0;
    double result3 = 0;
    double result4 = 0;
    double gesamtfläche, kostenvoranschlag, farbmenge;
    double verbrauch;
    double preisklasse;

    Frame1 thisFrame1 = this;

    Frame2 frame2;
    // Doubles für Utensilienmethoden
    double preisAnzug, preisPinsel, preisPlane, preisEimer, preisRolle;
    double utensGesamt;

    JLabel Angabe, flaeche, preis, menge, labelPinsel, labelAnzug, labelPlane,
	    labelRolle, labelEimer;
    JTextField price, sqm, liter;
    JButton next;
    JRadioButton low, middle, high;
    JPanel PreisKLasse;
    JPanel utensilien;
    JSlider pinsel, anzug, plane, rolle, eimer;

    public Frame1() {
	getContentPane().setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	InitializeWindow();

    }

    public void InitializeWindow() {

	flaeche = new JLabel("Gesamtfläche in qm:");
	preis = new JLabel("Kostenvoranschlag in Euro:");
	menge = new JLabel("Farbmenge in Liter:");
	Angabe = new JLabel("Bitte füllen Sie folgende Angaben aus ");

	Angabe.setBounds(10, 10, 250, 30);
	flaeche.setBounds(20, 510, 200, 30);
	menge.setBounds(200, 510, 200, 30);
	preis.setBounds(380, 510, 200, 30);

	add(preis);
	add(menge);
	add(flaeche);
	add(Angabe);

	sqm = new JTextField();
	liter = new JTextField();
	price = new JTextField();

	sqm.setBounds(20, 540, 150, 30);
	liter.setBounds(200, 540, 150, 30);
	price.setBounds(380, 540, 150, 30);

	add(price);
	add(sqm);
	add(liter);

	// Preisklasse via Radiobutton auswählen

	low = new JRadioButton("Niedrige Preisklasse, c.a 0.30 Euro/qm", true);
	middle = new JRadioButton("Mittlere Preisklasse, c.a 0.50 Euro/qm",
		true);
	high = new JRadioButton("Hohe Preisklasse, c.a 0.60 Euro/qm", true);

	ButtonGroup PriceGroup = new ButtonGroup();
	PriceGroup.add(low);
	PriceGroup.add(middle);
	PriceGroup.add(high);

	PreisKLasse = new JPanel();
	PreisKLasse.add(low);
	PreisKLasse.add(middle);
	PreisKLasse.add(high);
	PreisKLasse.setLayout(new GridLayout(3, 1));
	PreisKLasse.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createRaisedSoftBevelBorder(),
		"Preisklasse wählen"));
	PreisKLasse.setBounds(250, 70, 300, 300);
	getContentPane().add(PreisKLasse);

	// Utensilien
	JSlider pinsel = new JSlider();
	JSlider anzug = new JSlider();
	JSlider plane = new JSlider();
	JSlider eimer = new JSlider();
	JSlider rolle = new JSlider();

	// Utensilienlabels
	JLabel labelPinsel = new JLabel("Pinsel");
	JLabel labelAnzug = new JLabel("Anzüge");
	JLabel labelPlane = new JLabel("Planen");
	JLabel labelEimer = new JLabel("Eimer");
	JLabel labelRolle = new JLabel("Farbrollen");

	pinsel.setMinimum(0);
	pinsel.setMaximum(20);
	pinsel.setMajorTickSpacing(5);
	pinsel.setMinorTickSpacing(1);
	pinsel.createStandardLabels(1);
	pinsel.setPaintTicks(true);
	pinsel.setPaintLabels(true);
	pinsel.setValue(0);

	anzug.setMinimum(0);
	anzug.setMaximum(20);
	anzug.setMajorTickSpacing(5);
	anzug.setMinorTickSpacing(1);
	anzug.createStandardLabels(1);
	anzug.setPaintTicks(true);
	anzug.setPaintLabels(true);
	anzug.setValue(0);

	plane.setMinimum(0);
	plane.setMaximum(20);
	plane.setMajorTickSpacing(5);
	plane.setMinorTickSpacing(1);
	plane.createStandardLabels(1);
	plane.setPaintTicks(true);
	plane.setPaintLabels(true);
	plane.setValue(0);

	rolle.setMinimum(0);
	rolle.setMaximum(20);
	rolle.setMajorTickSpacing(5);
	rolle.setMinorTickSpacing(1);
	rolle.createStandardLabels(1);
	rolle.setPaintTicks(true);
	rolle.setPaintLabels(true);
	rolle.setValue(0);

	eimer.setMinimum(0);
	eimer.setMaximum(20);
	eimer.setMajorTickSpacing(5);
	eimer.setMinorTickSpacing(1);
	eimer.createStandardLabels(1);
	eimer.setPaintTicks(true);
	eimer.setPaintLabels(true);
	eimer.setValue(0);

	utensilien = new JPanel();
	utensilien.add(labelAnzug);
	utensilien.add(anzug);
	utensilien.add(labelPlane);
	utensilien.add(plane);
	utensilien.add(labelPinsel);
	utensilien.add(pinsel);
	utensilien.add(labelEimer);
	utensilien.add(eimer);
	utensilien.add(labelRolle);
	utensilien.add(rolle);
	utensilien.setLayout(new GridLayout(10, 1));
	utensilien.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createRaisedSoftBevelBorder(), "Utensilien"));
	utensilien.setBounds(600, 70, 300, 500);
	getContentPane().add(utensilien);

	anzug.addChangeListener(new ChangeListener() {

	    @Override
	    public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
		    int val = (int) source.getValue();
		    addAnzugPreis(val);
		    calcKostenvoranschlag();
		}
	    }
	});
	plane.addChangeListener(new ChangeListener() {

	    // TODO aus jedem jslider spearat preis rausholen, dann eine Methode
	    // die die 5 Preise entgegennimmt
	    // und zusammenaddiert und DANN übergibt
	    @Override
	    public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
		    int val = (int) source.getValue();
		    addPlanePreis(val);
		    calcKostenvoranschlag();
		}
	    }
	});
	pinsel.addChangeListener(new ChangeListener() {

	    @Override
	    public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
		    int val = (int) source.getValue();
		    addPinselPreis(val);
		    calcKostenvoranschlag();
		}
	    }
	});
	eimer.addChangeListener(new ChangeListener() {

	    @Override
	    public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
		    int val = (int) source.getValue();
		    addEimerPreis(val);
		    calcKostenvoranschlag();
		}
	    }
	});
	rolle.addChangeListener(new ChangeListener() {

	    @Override
	    public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
		    int val = (int) source.getValue();
		    addRollePreis(val);
		    calcKostenvoranschlag();
		}
	    }
	});
	JButton next = new JButton("Raum hinzufügen");

	next.setBounds(20, 150, 200, 30);

	add(next);

	setVisible(true);
	setSize(1000, 650);
	setTitle("Die MalerApp 25");

	// Öffnet neues Fenster und zählt die Anzahl neuer Räume
	next.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		frame2 = new Frame2(thisFrame1);
		// setVisible(false);
		// F2.toFront();

	    }

	});

	low.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		// low wert an calculate
		// calculate berechnet qm* low
		// calculate ändert kostenvoranschlag

		if (low.isSelected()) {
		    preisklasse = 0.3;
		    calcFarbmengeFrame1();
		    calcKostenvoranschlag();
		}

	    }

	});

	middle.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		// siehe low kommentare
		if (middle.isSelected()) {
		    preisklasse = 0.5;
		    calcFarbmengeFrame1();
		    calcKostenvoranschlag();
		}
	    }

	});

	high.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		// siehe low kommentare
		if (high.isSelected()) {
		    preisklasse = 0.6;
		    calcFarbmengeFrame1();
		    calcKostenvoranschlag();
		}
	    }

	});

    }

    public void setSqm(double ergebnis) {
	sqm.setText(Double.toString(ergebnis));
    }

    public void setEndprice(double kostenvoranschlag) {
	price.setText(Double.toString(kostenvoranschlag));
    }

    public void setLiter(double farbmenge) {
	liter.setText(Double.toString(farbmenge));
    }

    public double getGesamtPreis() {
	return kostenvoranschlag;
    }

    /*
     * Methoden für die Utensilien
     */
    public void addAnzugPreis(int val) {
	this.preisAnzug = val * 3.50;
    }

    public void addPlanePreis(int val) {
	this.preisPlane = val * 4;
    }

    public void addPinselPreis(int val) {
	this.preisPinsel = val * 6;
    }

    public void addEimerPreis(int val) {
	this.preisEimer = val * 6;
    }

    public void addRollePreis(int val) {
	this.preisRolle = val * 10;
    }

    public void calcGesamtUtens() {
	utensGesamt = preisAnzug + preisPlane + preisPinsel + preisEimer
		+ preisRolle;
    }

    public double getGesamtUtens() {

	return utensGesamt;
    }

    public void calcGesamtfläche(double fläche) {
	// this.numberOfRooms += 1;
	gesamtfläche += fläche;
	// this.resetFläche();
	setSqm(gesamtfläche);
    }

    public double getMenge() {
	this.calcFarbmengeFrame1();
	return farbmenge;
    }

    public void calcFarbmengeFrame1() {
	/*
	 * benötigte variablen: gesamtfläche preis(if abfrage)--> ml/l pro qm
	 * switch case
	 */
	switch (Double.toString(preisklasse)) {
	case "0.3":
	    verbrauch = 0.177;
	    break;

	case "0.5":
	    verbrauch = 0.166;
	    break;

	case "0.6":
	    verbrauch = 0.133;
	    break;
	}

	farbmenge = gesamtfläche * verbrauch;
	setLiter(farbmenge);
    }

    public void calcKostenvoranschlag() {
	// this.utensilien preis ist sehr hoch
	calcFarbmengeFrame1();
	calcGesamtUtens();
	this.kostenvoranschlag = (this.preisklasse * this.gesamtfläche)
		+ getGesamtUtens();
	// Calculate.kostenvoranschlag += utens.getGesamt();
	setEndprice(this.kostenvoranschlag);
    }
}
