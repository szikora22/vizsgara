package szelvenykitoltoDinamikusGombok;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SzelvenyKitoltoFoframe {

	private JFrame frame;
	private JButton mentesGomb;
	private JButton szamGomb;
	
	private int tippekSzama = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SzelvenyKitoltoFoframe window = new SzelvenyKitoltoFoframe();
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
	public SzelvenyKitoltoFoframe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JComboBox cmbLottoTipus = new JComboBox();
		cmbLottoTipus.setModel(new DefaultComboBoxModel(LottoFajta.values()));
		
		JOptionPane.showMessageDialog(frame, cmbLottoTipus, "Lottójáték", JOptionPane.QUESTION_MESSAGE);
		
		System.out.println(cmbLottoTipus.getSelectedItem());
		
		frame = new JFrame();
		frame.setTitle("Szelvénykitöltő segéd");
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		szelvenyKitoltes(((LottoFajta)cmbLottoTipus.getSelectedItem()).getHanySzamotHuznak(),
				((LottoFajta)cmbLottoTipus.getSelectedItem()).getHanySzambolHuzzak());
		
		
		
		
		
		
	}

	private void szelvenyKitoltes(int hanySzamotHuznak, int hanySzambolHuzzak) {
		
		int fentrolPozicio = 20;
		int balrolPozicio = 20;
		
		for (int i=1; i<= hanySzambolHuzzak; i++ ) {
			
			szamGomb = new JButton();
			
			szamGomb.setText(String.valueOf(i));
			szamGomb.setBounds(balrolPozicio,fentrolPozicio,60,60);
			szamGomb.setForeground(Color.BLACK);
			
			frame.getContentPane().add(szamGomb);
			
			if (i % 10 == 0) {
				
				fentrolPozicio += 65;
				balrolPozicio = 20;
				
			}
			else {
				
				balrolPozicio += 65;
				
			}
			
			
			szamGomb.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					JButton aktualisGomb = (JButton)e.getSource();
					if (aktualisGomb.getForeground() == Color.BLACK) {
						
						if (tippekSzama < hanySzamotHuznak) {
							
							aktualisGomb.setForeground(Color.RED);
							tippekSzama++;
							
							if (tippekSzama == hanySzamotHuznak) {
								
								mentesGomb.setEnabled(true);
								
							}
							
						}
						else {
							
							JOptionPane.showMessageDialog(frame, "Nem jelölhet be több számot!","Figyelmeztetés",JOptionPane.WARNING_MESSAGE);
							
						}
						
					}
					else {
						
						tippekSzama--;
						aktualisGomb.setForeground(Color.BLACK);
						mentesGomb.setEnabled(false);
						
					}
					
					
				}
			});
			
			
		}
		
		
		if (hanySzambolHuzzak %10 != 0) {
			
			fentrolPozicio += 65;
			
		}
		
		mentesGomb = new JButton();
		mentesGomb.setText("Kész");
		mentesGomb.setBounds(300,fentrolPozicio, 100, 50);
		mentesGomb.setEnabled(false);
		frame.getContentPane().add(mentesGomb);
		
		mentesGomb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String szelveny = "A végleges tippek:\n";
				
				for (Component komponens: frame.getContentPane().getComponents()) {
					
					if (komponens.getClass() == JButton.class && komponens.getForeground() == Color.RED) {
						
						szelveny += ((JButton)komponens).getText()+"  ";
						
					}
					
				}
				
				JOptionPane.showMessageDialog(frame, szelveny, "Eredmény", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
				
			}
			
		});
		
		
	}

}
