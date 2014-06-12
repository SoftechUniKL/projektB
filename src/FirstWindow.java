import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FirstWindow extends JFrame {

    JTextField feld1;
    JTextField feld2;

    JTextField feld3;
    JTextField feld4;
    JTextField feld5;
    JTextField Ergebnis;

    JLabel wand1;
    JLabel wand2;
    JLabel wand3;
    JLabel wand4;
    JLabel height;
    JLabel Angabe;
    JLabel paint;

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

    JButton calculate;
    JCheckBox Top;
    JButton next;

    public FirstWindow() {
	getContentPane().setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	InitializeWindow();

    }

    public void InitializeWindow() {
	feld1 = new JTextField();
	feld2 = new JTextField();
	feld3 = new JTextField();
	feld4 = new JTextField();
	feld5 = new JTextField();
	Ergebnis = new JTextField();

	Angabe = new JLabel("Bitte f�llen Sie folgende Angaben aus ");
	Angabe.setBounds(10, 10, 250, 30);
	add(Angabe);

	wand1 = new JLabel("Wand 1 in m");
	wand2 = new JLabel("Wand 2 in m");
	wand3 = new JLabel("Wand 3 in m");
	wand4 = new JLabel("Wand 4 in m");
	height = new JLabel("Raumh�he in m");
	paint = new JLabel("Angaben f�r die Farbauswahl");

	wand1.setBounds(20, 70, 80, 30);
	wand2.setBounds(300, 70, 80, 30);
	wand3.setBounds(20, 170, 80, 30);
	wand4.setBounds(300, 170, 80, 30);
	height.setBounds(20, 270, 90, 30);
	paint.setBounds(10, 600, 250, 30);

	add(wand1);
	add(wand2);
	add(wand3);
	add(wand4);
	add(height);
	add(paint);

	feld1.setBounds(20, 100, 200, 30);
	feld2.setBounds(300, 100, 200, 30);
	feld3.setBounds(20, 200, 200, 30);
	feld4.setBounds(300, 200, 200, 30);
	feld5.setBounds(20, 300, 200, 30);
	Ergebnis.setBounds(300, 500, 200, 30);

	getContentPane().add(feld1);
	getContentPane().add(feld2);
	getContentPane().add(feld3);
	getContentPane().add(feld4);
	getContentPane().add(feld5);
	getContentPane().add(Ergebnis);

	JButton calculate = new JButton("Berechnen");
	final JCheckBox Top = new JCheckBox("Decke streichen");
	JButton next = new JButton("Weiteren Raum hinzuf�gen");

	Top.setBounds(300, 300, 200, 30);
	next.setBounds(20, 400, 200, 30);
	calculate.setBounds(20, 500, 200, 30);

	add(Top);
	add(next);
	add(calculate);

	setVisible(true);
	setSize(700, 700);
	setTitle("Raum 1");

	// Berechnet Eingaben von "Wand1" und "H�he"
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
		    } else {
			result = result1 + result2 + result3 + result4;
		    }

		    String r = String.valueOf(result);
		    Ergebnis.setText(r);

		} catch (Exception NumberFormatException) {

		    Ergebnis.setText("Falsches Format");
		}
	    }
	});

	// �ffnet neues Fenster
	next.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		Frame2 F2 = new Frame2();
		setVisible(true);
	    }

	});

    }
}
