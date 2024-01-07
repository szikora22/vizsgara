package feladat05_JavaAdatbazis;

import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FilmkatalogusFrame {
	
	private JFrame frmFilmkatalgus;
	private DefaultListModel<Film> listModel;
	private JList list;

	/**
	 * Create the application.
	 */

	public FilmkatalogusFrame() {
		
		initialize();
		
		try {
			ABKezelo.csatlakozas();
			List<Film> filmek = ABKezelo.filmekBeolvasasa();
			
			listModel = new DefaultListModel<Film>();
			
			for (Film film : filmek) {
				
				listModel.addElement(film);
				
			}
			
			list.setModel(listModel);
			
			JButton btnFelvitel = new JButton("Felvitel");
			btnFelvitel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					JOptionPane.showMessageDialog(frmFilmkatalgus, "Fejlesztés alatt álló funkció!");
					
				}
			});
			btnFelvitel.setBounds(38, 338, 85, 21);
			frmFilmkatalgus.getContentPane().add(btnFelvitel);
			
			JButton btnModositas = new JButton("Modositas");
			btnModositas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					JOptionPane.showMessageDialog(frmFilmkatalgus, "Fejlesztés alatt álló funkció!");
					
					
				}
			});
			btnModositas.setBounds(148, 338, 85, 21);
			frmFilmkatalgus.getContentPane().add(btnModositas);
			
			JButton btnTorles = new JButton("Törlés");
			btnTorles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					JOptionPane.showMessageDialog(frmFilmkatalgus, "Fejlesztés alatt álló funkció!");
					
				}
			});
			btnTorles.setBounds(252, 338, 85, 21);
			frmFilmkatalgus.getContentPane().add(btnTorles);
			
			JButton btnKilepes = new JButton("Kilépés");
			btnKilepes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					JOptionPane.showMessageDialog(frmFilmkatalgus, "Fejlesztés alatt álló funkció!");
					
				}
			});
			btnKilepes.setBounds(473, 370, 85, 21);
			frmFilmkatalgus.getContentPane().add(btnKilepes);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frmFilmkatalgus = new JFrame();
		getFrmFilmkatalgus().setTitle("Filmkatalógus");
		getFrmFilmkatalgus().setBounds(100, 100, 600, 460);
		getFrmFilmkatalgus().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFilmkatalgus.getContentPane().setLayout(null);
		
		list = new JList();
		list.setBounds(28, 10, 405, 311);
		frmFilmkatalgus.getContentPane().add(list);
	}
	
	public JFrame getFrmFilmkatalgus() {
		return frmFilmkatalgus;
	}
}
