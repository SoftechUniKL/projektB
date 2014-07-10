import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Frame2 extends JFrame {

    JTextField feld1;
    JTextField feld2, Ergebnis;

    JTextField feld3;
    JTextField feld4;
    JTextField feld5;

    JLabel wand1;
    JLabel wand2;
    JLabel wand3;
    JLabel wand4;
    JLabel height;
    JLabel Angabe;

    JButton calculate;
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

    public Frame2() {

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
	Ergebnis = new JTextField();

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
	Ergebnis.setBounds(20, 350, 200, 30);
	getContentPane().add(feld1);
	getContentPane().add(feld2);
	getContentPane().add(feld3);
	getContentPane().add(feld4);
	getContentPane().add(feld5);
	getContentPane().add(Ergebnis);

	JButton calculate = new JButton("Berechnen");
	final JCheckBox Top = new JCheckBox("Decke streichen");

	Top.setBounds(300, 300, 200, 30);
	calculate.setBounds(20, 500, 200, 30);

	add(Top);
	add(calculate);

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

			result = result1 + result2 + result3 + result4
				+ (m1 * m2);
			Calculate.addFläche(result);

		    } else {
			result = result1 + result2 + result3 + result4;
			Calculate.addFläche(result);
		    }
		    String r = String.valueOf(Calculate.getFläche());

		    Ergebnis.setText(r);

		    dispose();
		    setVisible(true);

		} catch (Exception NumberFormatException) {

		    Ergebnis.setText("Falsches Format");
		}
	    }

	});

    }

    void windowClosing(WindowEvent e) {
	setVisible(false);
    }
}
