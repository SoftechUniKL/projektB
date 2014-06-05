import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	
	
	JButton calculate;
	JCheckBox Top;
	JButton next;

		
	public FirstWindow(){
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
		Ergebnis= new JTextField();
	
		
		Angabe = new JLabel("Bitte f�llen Sie folgende Angaben aus ");
		Angabe.setBounds(10, 10, 250 , 30);
		add(Angabe);
		
		wand1 = new JLabel("Wand 1 in m");
		wand2 = new JLabel("Wand 2 in m");
		wand3 = new JLabel("Wand 3 in m");
		wand4 = new JLabel("Wand 4 in m");
		height = new JLabel("Raumh�he in m");
		
		wand1.setBounds(20, 70, 80, 30);
		wand2.setBounds(300, 70, 80, 30);
		wand3.setBounds(20, 170, 80, 30);
		wand4.setBounds(300, 170, 80 , 30);
		height.setBounds(20, 270 , 90 , 30);
		
		
		add(wand1);
		add(wand2);
		add(wand3);
		add(wand4);
		add(height);
	
		
		feld1.setBounds(20, 100 , 200, 30);
		feld2.setBounds(300, 100, 200, 30);
		feld3.setBounds( 20, 200, 200, 30);
		feld4.setBounds( 300, 200, 200 ,30);
		feld5.setBounds(20, 300, 200, 30);
		Ergebnis.setBounds(300, 500, 200, 30);
		   
		getContentPane().add(feld1);
		getContentPane().add(feld2);
		getContentPane().add(feld3);
		getContentPane().add(feld4);
		getContentPane().add(feld5);
		getContentPane().add(Ergebnis);
	
		
		JButton calculate = new JButton("Berechnen");
		JCheckBox Top = new JCheckBox ("Decke streichen");
		JButton next = new JButton ("Weiteren Raum hinzuf�gen");
		
		Top.setBounds(300, 300 , 200, 30);
		next.setBounds(20, 400, 200, 30);
		calculate.setBounds(20, 500, 200,30);
		
		add(Top);
		add(next);
		add(calculate);
		
		setVisible(true);
		setSize(700, 700);
		setTitle("Raum 1");
		
		   calculate.addActionListener(new ActionListener () {
			   public void actionPerformed(ActionEvent e) {
				   
				   double m1 = 0;
				   double h= 0;
				   double result = 0;
				   
				 try {
					 m1 = Double.parseDouble(feld1.getText());
				 
				   h = Double.parseDouble(feld5.getText());
				   result = m1 * h;
				   String r = String.valueOf(result);
				   Ergebnis.setText(r);
				
				 } catch (Exception NumberFormatException) {
					 
					 Ergebnis.setText("Falsches Format");
				 }
			   }
		   });
		

		
		next.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				Frame2 F2 = new Frame2();
				setVisible(true);
				}
				
			
		});
	
		
	}
	}
	
		
		
		
		
	
	
			
			
		
	
