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
			System.out.print("Kérem adja meg a szervíztevékenységet (kilépéshez nyomja meg a 'q' - betűt): ");
			szervizTevekenyseg = sc.nextLine();
			
			if(szervizTevekenyseg.toLowerCase().equals("q")) {
				
				break;
				
			}
					
			System.out.print("Kérem adja meg a munkaórát (kilépéshez nyomja meg a '0' billentyűt): ");			
			munkaOra = Integer.parseInt(sc.nextLine());
					
			if(munkaOra==0) {
				break;
			}
	
				szervizmunkak.add(new SzervizMunka(szervizTevekenyseg, munkaOra));
			
		} while (true);
		
		sc.close();
		
		return szervizmunkak;
		
		
	}
	
	
	
	
	

}
