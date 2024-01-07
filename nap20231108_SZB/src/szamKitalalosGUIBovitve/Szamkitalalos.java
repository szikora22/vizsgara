package szamKitalalosGUIBovitve;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class Szamkitalalos {

	private static Random r = new Random();
	
	private JFrame frmSzamkitalalos;
	private JTextField txtJatekosTippje;
	
	private int gepTippje;
	private JLabel lblEredmeny;
	private JButton btnTippEllenorzes;
	int tippekSzama;
	
	private DefaultListModel<String> listModel;
	private JList lstTortenet;
	private JButton btnVeletlenGeneralas;

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
		frmSzamkitalalos.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				// JOptionPane a leggyakrabban használt dialógusablak:
				// https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
				
				Object[] opciok = {"Igen","Nem"};
				ImageIcon ikon = new ImageIcon("kilepes.png");
				
				int valasz = JOptionPane.showOptionDialog(frmSzamkitalalos,"Biztosan ki akar lépni a programból?",
						"Kilépés",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,ikon,opciok,opciok[1]);
				
				if (valasz == JOptionPane.YES_OPTION) {
					
					// frmSzamkitalalos.dispose(); az ablakot zárja be
					System.exit(0);
					
				}
				
			}
		});
		frmSzamkitalalos.setTitle("Számkitalálós");
		frmSzamkitalalos.setBounds(100, 100, 450, 387);
		frmSzamkitalalos.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmSzamkitalalos.getContentPane().setLayout(null);
		
		btnVeletlenGeneralas = new JButton("Számgenerálás");
		btnVeletlenGeneralas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ujJatek();
				
				
				
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
				
				tippEllenorzes();
				
				
			}

			
		});
		btnTippEllenorzes.setEnabled(false);
		btnTippEllenorzes.setBounds(290, 92, 134, 23);
		frmSzamkitalalos.getContentPane().add(btnTippEllenorzes);
		
		lblEredmeny = new JLabel("");
		lblEredmeny.setBounds(140, 136, 140, 14);
		frmSzamkitalalos.getContentPane().add(lblEredmeny);
		
		JButton btnKilepes = new JButton("Kilépés");
		btnKilepes.setMnemonic('K');
		//btnKilepes.setMnemonic(KeyEvent.VK_F5); --> funkcióbillentyűt is hozzárendelhetünk gyorsbillentyűként
		btnKilepes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//System.exit(0);
				frmSzamkitalalos.dispatchEvent(new WindowEvent(frmSzamkitalalos, WindowEvent.WINDOW_CLOSING));
				
			}
		});
		btnKilepes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnKilepes.setBackground(new Color(255, 0, 0));
		btnKilepes.setBounds(335, 274, 89, 46);
		frmSzamkitalalos.getContentPane().add(btnKilepes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 168, 315, 152);
		frmSzamkitalalos.getContentPane().add(scrollPane);
		
		lstTortenet = new JList();
		scrollPane.setViewportView(lstTortenet);
		lstTortenet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JMenuBar menuBar = new JMenuBar();
		frmSzamkitalalos.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menü");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmUjJatek = new JMenuItem("Új játék");
		mntmUjJatek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ujJatek();
				
			}
		});
		mnNewMenu.add(mntmUjJatek);
		
		JMenuItem mntmStatisztika = new JMenuItem("Statisztika");
		mntmStatisztika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(frmSzamkitalalos, "A szám kitalálásához "+tippekSzama+" lépésre volt szükséged!","Statisztika",JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		mnNewMenu.add(mntmStatisztika);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmKilepes = new JMenuItem("Kilépés");
		mntmKilepes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmSzamkitalalos.dispatchEvent(new WindowEvent(frmSzamkitalalos, WindowEvent.WINDOW_CLOSING));
				
			}
		});
		mnNewMenu.add(mntmKilepes);
		
		JMenuItem mntmNevjegy = new JMenuItem("Névjegy");
		mntmNevjegy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(frmSzamkitalalos, "Számkitalálós játék\nCopyright BB", "Névjegy", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		menuBar.add(mntmNevjegy);
	}
	
	
	private void tippEllenorzes() {
		
		try {
			
			tippekSzama++;
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
				
				JOptionPane.showMessageDialog(frmSzamkitalalos, "Eltaláltad, nyertél!", "Eredmény", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			listModel.addElement(txtJatekosTippje.getText()+" - "+lblEredmeny.getText());
			txtJatekosTippje.setText("");
			txtJatekosTippje.grabFocus();
			
		} catch (NumberFormatException e1) {
			
			lblEredmeny.setText("Hibás számformátum!");
			txtJatekosTippje.setText("");
			
			JOptionPane.showMessageDialog(frmSzamkitalalos, "Hibás számformátum!", "Hiba", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	
	private void ujJatek() {
		
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
		
		tippekSzama = 0;
		
	}
	
	
	
}
