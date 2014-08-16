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
    private double fläche; // muss an frame1 übergeben werden

    Frame1 frame1;

    public Frame2(Frame1 frame1) {
	getContentPane().setLayout(null);
	this.frame1 = frame1;
	// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	InitializeNextWindow();

    }

    public void InitializeNextWindow() {
	feld1 = new JTextField();
	feld2 = new JTextField();
	feld3 = new JTextField();
	feld4 = new JTextField();
	feld5 = new JTextField();
	ergebnis = new JTextField();

	jtfAList = new ArrayList<JTextField>(Arrays.asList(feld1, feld2, feld3,
		feld4, feld5, ergebnis));

	Angabe = new JLabel("Bitte füllen Sie folgende Angaben aus ");
	Angabe.setBounds(10, 10, 250, 30);
	add(Angabe);

	wand1 = new JLabel("Wand 1 in m");
	wand2 = new JLabel("Wand 2 in m");
	wand3 = new JLabel("Wand 3 in m");
	wand4 = new JLabel("Wand 4 in m");
	height = new JLabel("Raumhöhe in m");

	wand1.setBounds(20, 70, 80, 30);
	wand2.setBounds(300, 70, 80, 30);
	wand3.setBounds(20, 170, 80, 30);
	wand4.setBounds(300, 170, 80, 30);
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
	    public void actionPerformed(ActionEvent e) {

		try {

		    m1 = Double.parseDouble(feld1.getText());
		    m2 = Double.parseDouble(feld2.getText());
		    m3 = Double.parseDouble(feld3.getText());
		    m4 = Double.parseDouble(feld4.getText());
		    h = Double.parseDouble(feld5.getText());

		    result1 = m1 * h;
		    result2 = m2 * h;
		    result3 = m3 * h;
		    result4 = m4 * h;

		    if (Top.isSelected()) {
			/*
			 * Decke erstmal aussen vor. Wenn wirs mit mehreren
			 * Wänden pro raum noch umsetzen, müssen wir hier eh
			 * nochmal ran ;)
			 */

			// TODO Decke anders implementieren

			calcFläche(m1, m2);// Decke über CalcFläche
					   // berechnet
			calcFläche(h, m1);
			calcFläche(h, m2);
			calcFläche(h, m3);
			calcFläche(h, m4);

		    } else {
			calcFläche(h, m1);
			calcFläche(h, m2);
			calcFläche(h, m3);
			calcFläche(h, m4);

		    }

		    ergebnis.setText(Double.toString(fläche));

		} catch (Exception NumberFormatException) {

		    ergebnis.setText("Falsches Format");
		}
	    }

	});

	übernehmen.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		if (Double.compare(fläche, 0) == 0) {
		    JOptionPane.showMessageDialog(null,
			    "Bitte klicken Sie erst auf Berechnen", "Achtung",
			    JOptionPane.INFORMATION_MESSAGE);
		} else {
		    frame1.calcGesamtflächeFrame1();
		    frame1.calcKostenvoranschlagFrame1();
		    dispose();
		}

	    }
	});
	rückgängig.addActionListener(new ActionListener() {

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

    public void clearWindow() {
	for (JTextField jtf : this.jtfAList) {
	    jtf.setText("");
	}

    }

    // Methoden für Flächenberechnung

    public void calcFläche(double height, double width) {
	this.fläche += height * width;
	// wandert in "Wand"
    }

    public void resetFläche() {
	this.fläche = 0;
    }

    public void setHeight(double höhe) {
	this.höhe = höhe;
    }

    public void setWidth(double width) {
	this.width = width;
    }

    public double getFläche() {
	return this.fläche;
    }

    public void setFläche(double fläche) {
	this.fläche = fläche;
    }

    public double getFläche() {
	return this.fläche;
    }

}
