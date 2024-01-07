package szamKitalalosGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Szamkitalalos {

	private static Random r = new Random();
	
	private JFrame frmSzamkitalalos;
	private JTextField txtJatekosTippje;
	
	private int gepTippje;
	private JLabel lblEredmeny;
	private JButton btnTippEllenorzes;
	
	private DefaultListModel<String> listModel;
	private JList lstTortenet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Szamkitalalos window = new Szamkitalalos();
					window.frmSzamkitalalos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Szamkitalalos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSzamkitalalos = new JFrame();
		frmSzamkitalalos.setTitle("Számkitalálós");
		frmSzamkitalalos.setBounds(100, 100, 450, 370);
		frmSzamkitalalos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSzamkitalalos.getContentPane().setLayout(null);
		
		JButton btnVeletlenGeneralas = new JButton("Számgenerálás");
		btnVeletlenGeneralas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gepTippje = r.nextInt(100)+1;
				lblEredmeny.setText("Gondoltam egy számot 1 és 100 között");
				txtJatekosTippje.setEnabled(true);
				btnTippEllenorzes.setEnabled(true);
				btnVeletlenGeneralas.setEnabled(false);
				
				// JList feltöltése:
				// 1. tömb vagy kollekció feltöltése a megjelenítendő elemekkel
				// 2. Model létrehozása és adatok átemelése az adatszerkezetből (1. pont)
				// 3. A modell hozzárendelése a komponenshez
				
				listModel = new DefaultListModel<String>();
				lstTortenet.setModel(listModel);
				
				
			}
		});
		btnVeletlenGeneralas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVeletlenGeneralas.setBounds(140, 36, 140, 38);
		frmSzamkitalalos.getContentPane().add(btnVeletlenGeneralas);
		
		txtJatekosTippje = new JTextField();
		txtJatekosTippje.setEnabled(false);
		txtJatekosTippje.setBounds(140, 94, 140, 20);
		frmSzamkitalalos.getContentPane().add(txtJatekosTippje);
		txtJatekosTippje.setColumns(10);
		
		JLabel lblSzambekeres = new JLabel("Játékos tippje:");
		lblSzambekeres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSzambekeres.setBounds(20, 96, 110, 14);
		frmSzamkitalalos.getContentPane().add(lblSzambekeres);
		
		btnTippEllenorzes = new JButton("Tipp ellenőrzése");
		btnTippEllenorzes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int tipp= Integer.parseInt(txtJatekosTippje.getText());
					if (gepTippje > tipp) {
						
						lblEredmeny.setText("A gondolt szám nagyobb a tippnél");
						
					}
					else if (gepTippje < tipp) {
						
						lblEredmeny.setText("A gondolt szám kisebb a tippnél");
						
					}
					else {
						
						lblEredmeny.setText("Eltaláltad, nyertél!");
						btnTippEllenorzes.setEnabled(false);
						btnVeletlenGeneralas.setEnabled(true);
						txtJatekosTippje.setEnabled(false);
						
					}
					
					listModel.addElement(txtJatekosTippje.getText()+" - "+lblEredmeny.getText());
					txtJatekosTippje.setText("");
					txtJatekosTippje.grabFocus();
					
				} catch (NumberFormatException e1) {
					
					lblEredmeny.setText("Hibás számformátum!");
					txtJatekosTippje.setText("");
				}
				
			}
		});
		btnTippEllenorzes.setEnabled(false);
		btnTippEllenorzes.setBounds(290, 92, 134, 23);
		frmSzamkitalalos.getContentPane().add(btnTippEllenorzes);
		
		lblEredmeny = new JLabel("");
		lblEredmeny.setBounds(140, 136, 140, 14);
		frmSzamkitalalos.getContentPane().add(lblEredmeny);
		
		lstTortenet = new JList();
		lstTortenet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lstTortenet.setBounds(20, 165, 306, 155);
		frmSzamkitalalos.getContentPane().add(lstTortenet);
		
		JButton btnKilepes = new JButton("Kilépés");
		btnKilepes.setMnemonic('K');
		//btnKilepes.setMnemonic(KeyEvent.VK_F5); --> funkcióbillentyűt is hozzárendelhetünk gyorsbillentyűként
		btnKilepes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnKilepes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnKilepes.setBackground(new Color(255, 0, 0));
		btnKilepes.setBounds(335, 274, 89, 46);
		frmSzamkitalalos.getContentPane().add(btnKilepes);
	}
}
