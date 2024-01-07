package orvosiAsszisztensSajatFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import orvosiAsszisztensSajatFrame.FelsorolasOsztaly.BetegsegLefolyas;
import orvosiAsszisztensSajatFrame.FelsorolasOsztaly.BetegsegTipus;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FelvitelModositAblak extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMegnevezes;

	private Betegseg betegseg;
	private JComboBox cmbLefolyas;
	private JComboBox cmbTipus;
	
	private DialogResult dialogresult = DialogResult.CANCEL;

	public DialogResult getDialogresult() {
		return dialogresult;
	}


	public Betegseg getBetegseg() {
		return betegseg;
	}


	public void setBetegseg(Betegseg betegseg) {
		
		this.betegseg = betegseg;
		txtMegnevezes.setText(betegseg.getMegnevezes());
		cmbLefolyas.setSelectedItem(betegseg.getLefolyas());
		cmbTipus.setSelectedItem(betegseg.getTipus());
		cmbTipus.setEnabled(false);
		
		
	}


	/**
	 * Create the dialog.
	 */
	public FelvitelModositAblak() {
		setModal(true);
		setTitle("Adatlap");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnMentes = new JButton("Mentés");
			btnMentes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ellenorzes();
					
				}

				
			});
			btnMentes.setBounds(89, 194, 80, 23);
			contentPanel.add(btnMentes);
			btnMentes.setActionCommand("OK");
			getRootPane().setDefaultButton(btnMentes);
		}
		{
			JButton btnMegsem = new JButton("Mégsem");
			btnMegsem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					dispose();
					
				}
			});
			btnMegsem.setBounds(256, 194, 80, 23);
			contentPanel.add(btnMegsem);
			btnMegsem.setActionCommand("Cancel");
		}
		
		txtMegnevezes = new JTextField();
		txtMegnevezes.setBounds(162, 35, 174, 20);
		contentPanel.add(txtMegnevezes);
		txtMegnevezes.setColumns(10);
		
		JLabel lblMegnevezes = new JLabel("Megnevezés:");
		lblMegnevezes.setBounds(47, 38, 92, 14);
		contentPanel.add(lblMegnevezes);
		
		cmbLefolyas = new JComboBox();
		cmbLefolyas.setModel(new DefaultComboBoxModel(BetegsegLefolyas.values()));
		cmbLefolyas.setBounds(162, 80, 174, 22);
		contentPanel.add(cmbLefolyas);
		
		JLabel lblLefolyas = new JLabel("Lefolyás:");
		lblLefolyas.setBounds(46, 84, 93, 14);
		contentPanel.add(lblLefolyas);
		
		cmbTipus = new JComboBox();
		cmbTipus.setModel(new DefaultComboBoxModel(BetegsegTipus.values()));
		cmbTipus.setBounds(162, 130, 174, 22);
		contentPanel.add(cmbTipus);
		
		JLabel lblTipus = new JLabel("Típus:");
		lblTipus.setBounds(47, 134, 92, 14);
		contentPanel.add(lblTipus);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	
	
	private void ellenorzes() {
	
		if (betegseg == null) { // ha még nincs értéke az objektumnak, akkor felvitelben vagyunk
			
			if (!txtMegnevezes.getText().isEmpty()) {
				
				betegseg = new Betegseg(txtMegnevezes.getText(), (BetegsegLefolyas)cmbLefolyas.getSelectedItem(),
								(BetegsegTipus)cmbTipus.getSelectedItem());
				dialogresult = DialogResult.OK;
				dispose();
			}
			else {
				
				JOptionPane.showMessageDialog(this, "Megnevezés mezőt ki kell tölteni!", "Figyelmeztetés", JOptionPane.WARNING_MESSAGE);
				
			}
			
		}
		else { // ha már fel van töltve értékekkel az objektum, akkor módosításban vagyunk
			
			if (!txtMegnevezes.getText().isEmpty()) {
				
				betegseg.setMegnevezes(txtMegnevezes.getText());
				betegseg.setLefolyas((BetegsegLefolyas)cmbLefolyas.getSelectedItem());
				dialogresult = dialogresult.OK;
				dispose();
				
			}
			else {
				
				JOptionPane.showMessageDialog(this, "Megnevezés mezőt ki kell tölteni!", "Figyelmeztetés", JOptionPane.WARNING_MESSAGE);
				
			}
			
			
		}
		
	}
	
	
	
	
	
	
	
}
