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
	
	JLabel wand1;
	JLabel wand2;
	JLabel wand3;
	JLabel wand4;
	JLabel height;
	JLabel Angabe;
		
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
		
	
		
		Angabe = new JLabel("Bitte füllen Sie folgende Angaben aus ");
		Angabe.setBounds(10, 10, 250 , 30);
		add(Angabe);
		
		wand1 = new JLabel("Wand 1 in m");
		wand2 = new JLabel("Wand 2 in m");
		wand3 = new JLabel("Wand 3 in m");
		wand4 = new JLabel("Wand 4 in m");
		height = new JLabel("Raumhöhe in m");
		
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
		getContentPane().add(feld1);
		getContentPane().add(feld2);
		getContentPane().add(feld3);
		getContentPane().add(feld4);
		getContentPane().add(feld5);
		setVisible(true);
		setSize(700, 700);
		
		
		
	}
		
		
	}
		
		
		
		
	
	
			
			
		
	
