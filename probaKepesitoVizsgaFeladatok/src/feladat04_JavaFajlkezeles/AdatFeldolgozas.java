package feladat04_JavaFajlkezeles;

import java.util.List;

public class AdatFeldolgozas {
	
	public void legnepszerubb(List<Programnyelv> programNyelvek) {
		
		
		int maxIndex = 0;
		for(int i=1; i<programNyelvek.size(); i++) {
			
			if(programNyelvek.get(maxIndex).getKeresesekSzama() < programNyelvek.get(i).getKeresesekSzama()) {
				
				maxIndex = i;
				
			}
			
		}
		
		//Programnyelv p = programNyelvek.get(maxIndex); ezzel rövidebb
		
		System.out.println("Az aktuális hónap legnépszerűbb programnyelve: ");
		System.out.print(programNyelvek.get(maxIndex).getMegnevezes());
		System.out.print("Megjelenés éve: " + programNyelvek.get(maxIndex).getMegjelenesEv());
		System.out.println("Keresések: " + programNyelvek.get(maxIndex).getKeresesekSzama());
		
		
		
	}

	public void valtozas(List<Programnyelv> programNyelvek) {

		int i=0;
		
		while(i<programNyelvek.size() && programNyelvek.get(i).getElozoHaviHelyezes() != 1) {
			
			i++;
			
		}
		
		if(i<programNyelvek.size()) {
			
			System.out.println("Az előző havi első helyezett: " + programNyelvek.get(i).getMegnevezes());
			System.out.println("Az előző havi keresések száma: " + programNyelvek.get(i).getElozoHaviKeresesekSzama());
			System.out.println("Az aktuális havi keresések száma: " + programNyelvek.get(i).getKeresesekSzama());
			System.out.printf("A változás mértéke: %.2f%%%n " , programNyelvek.get(i).valtozasMerteke());
			
		}
		else {
			System.out.println("Nincs a keresésnek megfelelő elem!");
		}
		
		
		
	}
	
	
	
	

}
