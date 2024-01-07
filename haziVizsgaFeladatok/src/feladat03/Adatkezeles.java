package feladat03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Adatkezeles {

	public List<SzervizMunka> szervizBekeres() {

		List<SzervizMunka> szervizmunkak = new ArrayList<SzervizMunka>();
		Scanner sc = new Scanner(System.in);
		String szervizTevekenyseg;
		int munkaOra;
		do {
			System.out.print("Kérem adja meg a szervíztevékenységet: ");
			szervizTevekenyseg = sc.nextLine();
			
			System.out.print("Kérem adja meg a munkaórát (üssön nullát, ha nem kíván több adatot megadni): ");
			munkaOra = Integer.parseInt(sc.nextLine());
					
			if (munkaOra > 0) {
				szervizmunkak.add(new SzervizMunka(szervizTevekenyseg, munkaOra));
			}
		} while (munkaOra != 0);
		
		sc.close();
		return szervizmunkak;
		
		
	}
	
	
	
	
	

}
