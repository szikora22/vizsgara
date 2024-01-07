package szamBekeresSzazig;

import javax.swing.JOptionPane;

public class SzambekeresKonzolosan {

	public static void main(String[] args) {
		
		int osszeg = 0;
		int szorzat = 1;
		
		while (osszeg < 100) {
			
			try {
				
				int aktualisSzam = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Adja meg a következő számot ("+osszeg+")","Számbekérés",JOptionPane.QUESTION_MESSAGE));
				
				osszeg += aktualisSzam;
				szorzat *= aktualisSzam;
				
			}catch (NumberFormatException e) {
				
				JOptionPane.showMessageDialog(null,"Nem megfelelő számformátum!","Hiba", JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
		
		JOptionPane.showMessageDialog(null, "A számok szorzata: "+szorzat,"Eredmény",JOptionPane.INFORMATION_MESSAGE);
		
		
		

	}

}
