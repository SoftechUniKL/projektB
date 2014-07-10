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
import javax.swing.JTextField;

public class FirstWindow extends JFrame {

    int clicked;
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
    Calculate calc = new Calculate();

    JLabel Angabe, flaeche, preis, menge;
    JTextField price, sqm, liter;
    JButton next;
    JRadioButton low, middle, high;
    JPanel PreisKLasse;
    JPanel color;

    public FirstWindow() {
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
	flaeche.setBounds(20, 300, 200, 30);
	menge.setBounds(250, 300, 200, 30);
	preis.setBounds(480, 300, 200, 30);

	add(preis);
	add(menge);
	add(flaeche);
	add(Angabe);

	sqm = new JTextField();
	liter = new JTextField();
	price = new JTextField();

	price.setBounds(20, 330, 200, 30);
	liter.setBounds(250, 330, 200, 30);
	sqm.setBounds(480, 330, 200, 30);

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
	PreisKLasse.setBounds(250, 70, 300, 200);
	getContentPane().add(PreisKLasse);

	// Farbauswahl
	color = new JPanel();
	color.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createRaisedSoftBevelBorder(), "Farbauswahl"));
	color.setBounds(600, 70, 300, 200);
	getContentPane().add(color);

	JButton next = new JButton("Raum hinzufügen");

	next.setBounds(20, 150, 200, 30);

	add(next);

	setVisible(true);
	setSize(1000, 500);
	setTitle("");

	// Öffnet neues Fenster und zählt die Anzahl neuer Fenster
	next.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		// if(Ergebnis =anders) dann clicked ++

		clicked++;
		System.out.println(clicked);

		Frame2 F2 = new Frame2(calc);
		// setVisible(false);
		// F2.toFront();

	    }

	});

    }
}
