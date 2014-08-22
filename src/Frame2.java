import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Die Frame2 Klasse hat Eingabefelder fuer die Waende und die Raumhoehe und
 * berechnet aus diesen diesen die Flaeche der einzelnen Raeume. ( Decke
 * optional). Die Flaeche wird dann ueber den "Uebernehmen Button" an Frame1
 * uebergeben und dort im "Gesamtflaeche in qm" Feld angezeigt.
 * 
 */

public class Frame2 extends JFrame {

    JTextField feld1;
    JTextField feld2, ergebnis;

    JTextField feld3;
    JTextField feld4;
    JTextField feld5;

    ArrayList<JTextField> jtfAList;

    JLabel wand1;
    JLabel wand2;
    JLabel wand3;
    JLabel wand4;
    JLabel height;
    JLabel Angabe;

    JButton calculate;
    JButton rückgängig;
    JButton übernehmen;
    JCheckBox Top;

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

    double höhe;
    double width;
    double verbrauch;
    double fläche;

    Frame1 frame1;

    public Frame2(Frame1 frame1) {
	getContentPane().setLayout(null);
	this.frame1 = frame1;
	InitializeNextWindow();

    }

    /**
     * InitializeNextWindow erstellt das GUI des Frame2, welches fuer das
     * hinzufuegen neuer Raeume verantwortlich ist.
     */
    public void InitializeNextWindow() {
	feld1 = new JTextField();
	feld2 = new JTextField();
	feld3 = new JTextField();
	feld4 = new JTextField();
	feld5 = new JTextField();
	ergebnis = new JTextField();

	/**
	 * cleart alle Felder von Frame 2
	 */

	jtfAList = new ArrayList<JTextField>(Arrays.asList(feld1, feld2, feld3,
		feld4, feld5, ergebnis));

	Angabe = new JLabel("Bitte füllen Sie folgende Angaben aus ");
	Angabe.setBounds(10, 10, 250, 30);
	add(Angabe);

	wand1 = new JLabel("Querwand 1 in m");
	wand2 = new JLabel("Querwand 2 in m");
	wand3 = new JLabel("Längswand 3 in m");
	wand4 = new JLabel("Längswand 4 in m");
	height = new JLabel("Raumhöhe in m");

	wand1.setBounds(20, 70, 100, 30);
	wand2.setBounds(300, 70, 100, 30);
	wand3.setBounds(20, 170, 100, 30);
	wand4.setBounds(300, 170, 100, 30);
	height.setBounds(20, 270, 90, 30);

	add(wand1);
	add(wand2);
	add(wand3);
	add(wand4);
	add(height);

	feld1.setBounds(20, 100, 200, 30);
	feld2.setBounds(300, 100, 200, 30);
	feld3.setBounds(20, 200, 200, 30);
	feld4.setBounds(300, 200, 200, 30);
	feld5.setBounds(20, 300, 200, 30);
	ergebnis.setBounds(20, 350, 200, 30);
	getContentPane().add(feld1);
	getContentPane().add(feld2);
	getContentPane().add(feld3);
	getContentPane().add(feld4);
	getContentPane().add(feld5);
	getContentPane().add(ergebnis);

	JButton calculate = new JButton("Berechnen");
	JButton rückgängig = new JButton("Rückgängig");
	JButton übernehmen = new JButton("Übernehmen");
	final JCheckBox Top = new JCheckBox("Decke streichen");

	Top.setBounds(300, 300, 200, 30);
	calculate.setBounds(20, 500, 200, 30);
	rückgängig.setBounds(300, 500, 200, 30);
	übernehmen.setBounds(20, 600, 200, 30);

	add(Top);
	add(calculate);
	add(rückgängig);
	add(übernehmen);

	setVisible(true);
	setSize(700, 700);
	setTitle("Angaben zum Raum");
	// Berechnet qm

	calculate.addActionListener(new ActionListener() {
	    /**
	     * Wenn Berechnen gedrueckt wird werden die Eingaben der einzelnen
	     * Felder in double zurückgegeben und dann die Flaeche der einzelnen
	     * Raeume berechnet und im Ergebnis Feld angezeigt. ( Sofern die
	     * Eingabe ein falsches Format hat gibt es einen Fehler, Decke ist
	     * optional durch checkbox
	     */
	    public void actionPerformed(ActionEvent e) {

		try {

		    m1 = Double.parseDouble(feld1.getText());
		    m2 = Double.parseDouble(feld2.getText());
		    m3 = Double.parseDouble(feld3.getText());
		    m4 = Double.parseDouble(feld4.getText());
		    h = Double.parseDouble(feld5.getText());

		    // result1 = m1 * h;
		    // result2 = m2 * h;
		    // result3 = m3 * h;
		    // result4 = m4 * h;
		    if (arePositive()) {
			if (Top.isSelected()) {
			    /*
			     * Ist der Raum rechteckig? Decke=Länge*Breite wenn
			     * nicht schließe programm
			     */

			    if (isRechteckig()) {
				calcFläche(m1, m3);// Decke über CalcFläche
						   // berechnet
				calcFläche(h, m1);
				calcFläche(h, m2);
				calcFläche(h, m3);
				calcFläche(h, m4);
			    } else {
				JOptionPane.showMessageDialog(null,
					"Die Decke kann nur berechnet werden wenn der Raum"
						+ " rechteckig ist.",
					"Achtung", JOptionPane.WARNING_MESSAGE);
			    }

			} else {
			    calcFläche(h, m1);
			    calcFläche(h, m2);
			    calcFläche(h, m3);
			    calcFläche(h, m4);

			}

			ergebnis.setText(Double.toString(fläche));
		    } else {
			JOptionPane.showMessageDialog(null,
				"Bitte nur positive Zahlen eingeben.",
				"Achtung", JOptionPane.WARNING_MESSAGE);
		    }
		} catch (Exception NumberFormatException) {

		    ergebnis.setText("Falsches Format");
		}
	    }

	});

	übernehmen.addActionListener(new ActionListener() {
	    /**
	     * Wenn Berechnen gedrueckt wird werden die Eingaben der einzelnen
	     * Felder in double zurückgegeben und dann die Flaeche der einzelnen
	     * Raeume berechnet und im Ergebnis Feld angezeigt. ( Sofern die
	     * Eingabe ein falsches Format hat gibt es einen Fehler, Decke ist
	     * optional durch checkbox
	     */
	    @Override
	    public void actionPerformed(ActionEvent e) {
		if (Double.compare(fläche, 0) == 0) {
		    JOptionPane.showMessageDialog(null,
			    "Bitte klicken Sie erst auf Berechnen", "Achtung",
			    JOptionPane.INFORMATION_MESSAGE);
		} else {
		    frame1.calcGesamtfläche(fläche);
		    frame1.calcKostenvoranschlag();
		    dispose();
		}

	    }
	});

	rückgängig.addActionListener(new ActionListener() {
	    /**
	     * Wenn rueckgaengig gedrueckt wird, erscheint eine erneute Abfrage,
	     * ob man wirklich die derzeitigen Eingaben loeschen moechte. Wenn
	     * man Ja drueckt, werden alle Eingaben in den Feldern geloescht.
	     */
	    @Override
	    public void actionPerformed(ActionEvent e) {
		int n = JOptionPane.showConfirmDialog(null,
			"Sind Sie sicher, dass Sie alle\n"
				+ " Änderungen verwerfen möchten?", "Warnung",
			JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (n == 0) {
		    resetFläche();
		    clearWindow();
		}

	    }
	});
	addWindowListener(new WindowAdapter() {
	    /**
	     * Wenn man das Fenster vom Nutzer geschlossen wird, kommt es zu
	     * einer Abfrage, ob man es wirklich tun will und alle Aenderungen
	     * verwerfen moechte.
	     */

	    @Override
	    public void windowClosing(WindowEvent e) {

		int n = JOptionPane.showConfirmDialog(null,
			"Sind Sie sicher, dass Sie alle Änderungen verwerfen\n"
				+ " und das Fenster schließen möchten?",
			"Warnung", JOptionPane.YES_NO_OPTION,
			JOptionPane.WARNING_MESSAGE);
		if (n == 0) {
		    dispose();
		} else {
		    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}

	    }
	});
    }

    /**
     * clearWindow loescht die Eingaben der Felder durch jtfAList
     */
    public void clearWindow() {
	for (JTextField jtf : this.jtfAList) {
	    jtf.setText("");
	}

    }

    // Methoden für Flächenberechnung
    /**
     * 
     * @param height
     * @param width
     * @return calcFlaeche berechnet die Flaeche einer Wand, ueber die Hoehe und
     *         Breite
     */

    public double calcFläche(double height, double width) {
	return this.fläche += height * width;
    }

    /**
     * resetFlaeche setzt den Wert von fläche auf 0
     */
    public void resetFläche() {
	this.fläche = 0;
    }

    /**
     * Prüft ob der Raum rechteckig ist.
     * 
     * @return true falls m1 == m2 und m3 == m4, ansonsten false
     */
    public boolean isRechteckig() {
	if (m1 == m2 && m3 == m4)
	    return true;
	else
	    return false;
    }

    /**
     * 
     * @param m1
     * @param m2
     * @param m3
     * @param m4
     * @return Raum ist Rechteckig
     */
    public boolean isRechteckig(double m1, double m2, double m3, double m4) {
	this.m1 = m1;
	this.m2 = m2;
	this.m3 = m3;
	this.m4 = m4;
	return isRechteckig();
    }

    /**
     * Prüft ob die Eingaben größer 0 sind.
     * 
     * @return true falls > 0, ansonsten false
     */
    public boolean arePositive() {
	if (m1 > 0 && m2 > 0 && m3 > 0 && m4 > 0)
	    return true;
	else
	    return false;
    }

    /**
     * 
     * @param m1
     * @param m2
     * @param m3
     * @param m4
     * @return die Variablen sind positiv.
     */
    public boolean arePositive(double m1, double m2, double m3, double m4) {
	this.m1 = m1;
	this.m2 = m2;
	this.m3 = m3;
	this.m4 = m4;
	return arePositive();
    }
}
