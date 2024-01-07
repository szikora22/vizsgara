package szamBekeresSzazig;

/* Készítsünk programot, amely JOptionPane segítségével addig kér be számokat, 
 amíg a számok összértéke kisebb mint 100, majd ezután megadja a beírt számok szorzatát,
 szintén dialógusablakban. */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Szambekeres {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Szambekeres window = new Szambekeres();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Szambekeres() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int osszeg = 0;
		int szorzat = 1;
		
		while (osszeg < 100) {
			
			try {
				
				int aktualisSzam = Integer.parseInt(JOptionPane.showInputDialog(frame,
						"Adja meg a következő számot ("+osszeg+")","Számbekérés",JOptionPane.QUESTION_MESSAGE));
				
				osszeg += aktualisSzam;
				szorzat *= aktualisSzam;
				
			}catch (NumberFormatException e) {
				
				JOptionPane.showMessageDialog(frame,"Nem megfelelő számformátum!","Hiba", JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
		
		JOptionPane.showMessageDialog(frame, "A számok szorzata: "+szorzat,"Eredmény",JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
		
	}

}
