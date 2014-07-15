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
    Calculate calc = new Calculate(this);

    JLabel Angabe, flaeche, preis, menge;
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
	preis = new JLabel("Kostenvoranschlag:");
	menge = new JLabel("Farbmenge in Liter:");
	Angabe = new JLabel("Bitte füllen Sie folgende Angaben aus ");

	Angabe.setBounds(10, 10, 250, 30);
	flaeche.setBounds(20, 370, 200, 30);
	menge.setBounds(250, 370, 200, 30);
	preis.setBounds(480, 370, 200, 30);

	add(preis);
	add(menge);
	add(flaeche);
	add(Angabe);

	sqm = new JTextField();
	liter = new JTextField();
	price = new JTextField();

	price.setBounds(480, 400, 200, 30);
	liter.setBounds(250, 400, 200, 30);
	sqm.setBounds(20, 400, 200, 30);

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
	utensilien.add(anzug);
	utensilien.add(plane);
	utensilien.add(pinsel);
	utensilien.add(eimer);
	utensilien.add(rolle);
	utensilien.setLayout(new GridLayout(5, 1));
	utensilien.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createRaisedSoftBevelBorder(), "Utensilien"));
	utensilien.setBounds(600, 70, 300, 300);
	getContentPane().add(utensilien);

	JButton next = new JButton("Raum hinzufügen");

	next.setBounds(20, 150, 200, 30);

	add(next);

	setVisible(true);
	setSize(1000, 500);
	setTitle("");

	// Öffnet neues Fenster und zählt die Anzahl neuer Räume
	next.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		Frame2 F2 = new Frame2(calc);
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
		    calc.setPreis(0.3);
		    calc.calcFarbmengeFrame1();
		    calc.calcKostenvoranschlagFrame1();
		}

	    }

	});

	middle.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		// siehe low kommentare
		if (middle.isSelected()) {
		    calc.setPreis(0.5);
		    calc.calcFarbmengeFrame1();
		    calc.calcKostenvoranschlagFrame1();
		}
	    }

	});

	high.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		// siehe low kommentare
		if (high.isSelected()) {
		    calc.setPreis(0.6);
		    calc.calcFarbmengeFrame1();
		    calc.calcKostenvoranschlagFrame1();
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
}
