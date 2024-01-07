package osztalyzatokOOPAdatbekeresselEllenorzesselKivetelDobassal;

import java.util.Scanner;

public class Adatkezeles {
	
	
	
	public Tanulo adatokKonzolrol() {
		
		Scanner sc = new Scanner(System.in);
		
		String nev;
		int matek, angol, tortenelem;
		
		boolean joAdat = false;
		Tanulo ujtanulo = null;
		do {
			try {
				System.out.print("Kérem a tanuló nevét: ");
				nev = sc.nextLine();

				System.out.print("Kérem " + nev + " matek osztályzatát: ");
				matek = Integer.parseInt(sc.nextLine());

				System.out.print("Kérem " + nev + " angol osztályzatát: ");
				angol = Integer.parseInt(sc.nextLine());

				System.out.print("Kérem " + nev + " történelem osztályzatát: ");
				tortenelem = Integer.parseInt(sc.nextLine());

				ujtanulo = new Tanulo();
				ujtanulo.setNev(nev);
				ujtanulo.setMatek(matek);
				ujtanulo.setAngol(angol);
				ujtanulo.setTortenelem(tortenelem);

				joAdat = true;

			} catch (NumberFormatException e) {

				System.out.println("Nem megfelelő formátum!");

			} catch (IllegalArgumentException e) {

				System.err.println(e.getMessage());

			} 
		} while (!joAdat);
		
		sc.close();
		return ujtanulo;
		
	}
	

}
