package osztalyzatokOOPAdatbekeresselEllenorzessel;

import java.util.Scanner;

public class Adatkezeles {

	public Tanulo adatokKonzolrol() {

Scanner sc = new Scanner(System.in);
		
		String nev;
		int matek, angol, tortenelem;
		
		System.out.print("Kérem a tanuló nevét: ");
		nev = sc.nextLine();
		
		System.out.print("Kérem "+nev+" matek osztályzatát: ");
		matek = Integer.parseInt(sc.nextLine());

		System.out.print("Kérem "+nev+" angol osztályzatát: ");
		angol = Integer.parseInt(sc.nextLine());
		
		System.out.print("Kérem "+nev+" történelem osztályzatát: ");
		tortenelem = Integer.parseInt(sc.nextLine());
		
		Tanulo ujtanulo = new Tanulo();
		ujtanulo.setNev(nev);
		ujtanulo.setMatek(matek);
		ujtanulo.setAngol(angol);
		ujtanulo.setTortenelem(tortenelem);
		
		return ujtanulo;
	}
	
	

}
