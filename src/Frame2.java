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
    JButton r�ckg�ngig;
    JButton �bernehmen;
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

    Calculate calc;

    public Frame2(Calculate calc) {
	this.calc = calc;
	getContentPane().setLayout(null);

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

	Angabe = new JLabel("Bitte f�llen Sie folgende Angaben aus ");
	Angabe.setBounds(10, 10, 250, 30);
	add(Angabe);

	wand1 = new JLabel("Wand 1 in m");
	wand2 = new JLabel("Wand 2 in m");
	wand3 = new JLabel("Wand 3 in m");
	wand4 = new JLabel("Wand 4 in m");
	height = new JLabel("Raumh�he in m");

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
	JButton r�ckg�ngig = new JButton("R�ckg�ngig");
	JButton �bernehmen = new JButton("�bernehmen");
	final JCheckBox Top = new JCheckBox("Decke streichen");

	Top.setBounds(300, 300, 200, 30);
	calculate.setBounds(20, 500, 200, 30);
	r�ckg�ngig.setBounds(300, 500, 200, 30);
	�bernehmen.setBounds(20, 600, 200, 30);

	add(Top);
	add(calculate);
	add(r�ckg�ngig);
	add(�bernehmen);

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
			 * W�nden pro raum noch umsetzen, m�ssen wir hier eh
			 * nochmal ran ;)
			 */

			/*
			 * result = result1 + result2 + result3 + result4 + (m1
			 * * m2);
			 */

		    } else {
			calc.calcFl�che(h, m1);
			calc.calcFl�che(h, m2);
			calc.calcFl�che(h, m3);
			calc.calcFl�che(h, m4);

		    }

		    ergebnis.setText(Double.toString(calc.getFl�che()));

		} catch (Exception NumberFormatException) {

		    ergebnis.setText("Falsches Format");
		}
	    }

	});

	�bernehmen.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		if (Double.compare(calc.getFl�che(), 0) == 0) {
		    JOptionPane.showMessageDialog(null,
			    "Bitte klicken Sie erst auf Berechnen", "Achtung",
			    JOptionPane.INFORMATION_MESSAGE);
		} else {
		    calc.calcGesamtfl�cheFrame1();
		    calc.calcKostenvoranschlagFrame1();
		    dispose();
		}

	    }
	});
	r�ckg�ngig.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		int n = JOptionPane.showConfirmDialog(null,
			"Sind Sie sicher, dass Sie alle\n"
				+ " �nderungen verwerfen m�chten?", "Warnung",
			JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (n == 0) {
		    calc.resetFl�che();
		    clearWindow();
		}

	    }
	});

	addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent e) {

		int n = JOptionPane.showConfirmDialog(null,
			"Sind Sie sicher, dass Sie alle �nderungen verwerfen\n"
				+ " und das Fenster schlie�en m�chten?",
			"Warnung", JOptionPane.YES_NO_OPTION,
			JOptionPane.WARNING_MESSAGE);
		if (n == 0) {
		    dispose();
		} else {
		    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}

	    }
	});
    }

    public void clearWindow() {
	for (JTextField jtf : this.jtfAList) {
	    jtf.setText("");
	}

    }
}
