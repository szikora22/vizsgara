package ujsagNyilvantartas;

import java.util.Scanner;

public class Adatkezeles {

	public Ujsag adatbekeresKonzolrol() {
		 
		Scanner sc = new Scanner(System.in);
		String megnevezes, kiado;
		int ar;
		byte hanyadikNaponJelenikMeg, hetiHanyszor;
		
		
		boolean jo= false;
		String szoveg;
		Ujsag ujsag = null;
		do {
						
			try {								
				System.out.print("Kérem az újság megnevezését: ");
				megnevezes = sc.nextLine();
				
				System.out.print("Kérem "+megnevezes+" kiadója nevét: ");
				kiado = sc.nextLine();
				
				System.out.print("Kérem "+megnevezes+" árát: ");
				ar = Integer.parseInt(sc.nextLine());
				
				do {
					System.out.println("Kérem adja meg "+megnevezes+" típusát: ");
					System.out.print("általános újság (U) \t napilap (N) \t hetilap (H): ");				
				    szoveg = sc.nextLine();
				} while (!szoveg.toUpperCase().equals("U") && !szoveg.toUpperCase().equals("N")
							&& !szoveg.toUpperCase().equals("H"));
					
				
				if (szoveg.toUpperCase().equals("N")) {
					System.out.println("Kérem adja meg "+megnevezes+" heti megjelenésének számát: ");
					hetiHanyszor = Byte.parseByte(sc.nextLine());
					ujsag = new Napilap(megnevezes, kiado, ar, hetiHanyszor);
				}
				else if (szoveg.toUpperCase().equals("H")){
					System.out.println("Kérem adja meg "+megnevezes+" a hét hányadik napján jelenik meg: ");
					hanyadikNaponJelenikMeg = Byte.parseByte(sc.nextLine());
					ujsag = new Hetilap(megnevezes, kiado, ar,hanyadikNaponJelenikMeg);
				}
				else if (szoveg.toUpperCase().equals("U")){
					ujsag = new Ujsag(megnevezes, kiado, ar);				
				}							
							
				jo = true;
			} catch (NumberFormatException e) {				
				System.out.println("Nem megfelelő formátum, vagy értéktartomány");	
			}
			catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			
		} while (!jo);
			
		sc.close();
		
		return ujsag;	
			
	}
	
}