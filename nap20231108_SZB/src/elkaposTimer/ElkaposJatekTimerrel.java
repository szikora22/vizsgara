package elkaposTimer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class ElkaposJatekTimerrel {

	private JFrame frame;
	
	private Timer idozito;
	
	private static Random r = new Random();
	
	private long startIdo;
	private JButton btnEztKapdEl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElkaposJatekTimerrel window = new ElkaposJatekTimerrel();
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
	public ElkaposJatekTimerrel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ActionListener feladatFigyelo = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				akcio();
				
			}
			
		};
		
		idozito = new Timer(500, feladatFigyelo);
		idozito.setRepeats(true);
		idozito.start();
		
		startIdo = System.nanoTime();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnEztKapdEl = new JButton("Ide kattints!");
		btnEztKapdEl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				elkapva();
				
			}

			
		});
		btnEztKapdEl.setBounds(166, 82, 24, 23);
		frame.getContentPane().add(btnEztKapdEl);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Automatikus mentés");
		chckbxNewCheckBox.setBounds(80, 150, 136, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
	}

	
	private void elkapva() {
		
		idozito.stop();
		long stopIdo = System.nanoTime();
		double elteltIdo = (double)(stopIdo-startIdo)/1000000000;
		
		JOptionPane.showMessageDialog(frame, "Gratulálok, elkaptad!\n"+String.format("Az eredmény: %.3f mp", elteltIdo));
		System.exit(0);
		
	}
	
	
	private void akcio() {
		
		btnEztKapdEl.setVisible(false);
		
		int ujXPozicio = r.nextInt(Math.max(frame.getLayeredPane().getWidth()-btnEztKapdEl.getWidth(),1));
		int ujYPozicio = r.nextInt(Math.max(frame.getLayeredPane().getHeight()-btnEztKapdEl.getHeight(),1));
		
		btnEztKapdEl.setBounds(ujXPozicio,ujYPozicio,btnEztKapdEl.getWidth()+1,btnEztKapdEl.getHeight()+1);
		
		
		btnEztKapdEl.setVisible(true);
		
	}
}
