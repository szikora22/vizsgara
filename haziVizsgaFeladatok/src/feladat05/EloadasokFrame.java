package feladat05;

import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class EloadasokFrame {

	private JFrame frmEloadasok;
	private DefaultListModel<Eloadas> listModel;
	private JList list;

	public JFrame getFrmEloadasok() {
		return frmEloadasok;
	}

	
	public EloadasokFrame() throws SQLException {
		initialize();
		try {
			ABKezelo.csatlakozas();
			List<Eloadas> eloadasok = ABKezelo.eloadasokBeolvasasa();
			
			listModel = new DefaultListModel<Eloadas>();
			
			for (Eloadas eloadas : eloadasok) {
				
				listModel.addElement(eloadas);
				
			}
			
			list.setModel(listModel);
			
			JButton btnTorles = new JButton("Törlés");
			btnTorles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						AdatTorles();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}

				
			});
			btnTorles.setBounds(20, 308, 150, 45);
			frmEloadasok.getContentPane().add(btnTorles);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void initialize() {
		
		frmEloadasok = new JFrame();
		frmEloadasok.setTitle("Színházi előadások");
		frmEloadasok.setBounds(100, 100, 700, 400);
		frmEloadasok.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEloadasok.getContentPane().setLayout(null);
		
		list = new JList();
		list.setBounds(10, 10, 608, 288);
		frmEloadasok.getContentPane().add(list);
		
	}
	
	private void AdatTorles() throws SQLException {

		int selectedIndex = list.getSelectedIndex();
		
		if(selectedIndex != -1) {
			
			ABKezelo.torles(selectedIndex);
			
		}
		
		
	}
}
