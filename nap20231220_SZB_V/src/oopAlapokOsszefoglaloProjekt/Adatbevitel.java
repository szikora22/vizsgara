package oopAlapokOsszefoglaloProjekt;

import java.io.BufferedReader;
import java.io.IOException;

public class Adatbevitel {

	public Allat adatBekeres(BufferedReader br) {

		Allat allat = null;
		
		String nev;
		int suly, marmagassag;
		boolean hosszuszoru;
		char kutyaVagyMacska;
		char rovidVagyHosszu;
		
		boolean joAdat = false;
		
		do {
			
			System.out.println("Kérem az adatokat: ");
			
			try {
				System.out.print("Adja meg az állat nevét: ");
				nev = br.readLine();
				
				System.out.println("Adja meg az állat súlyát");
				suly = Integer.parseInt(br.readLine());
				
				do {
					System.out.println("Adja meg kutya vagy macska (k/m)");
					kutyaVagyMacska = br.readLine().charAt(0);
				} while (kutyaVagyMacska != 'k' && kutyaVagyMacska != 'm');
				
				if(kutyaVagyMacska == 'k') {
					
					System.out.print("Kérem a marmagasságot: ");
					marmagassag = Integer.parseInt(br.readLine());
					
					allat = new Kutya(nev, suly, marmagassag);
				}
				else {
					
					do {
						
						System.out.print("Adja meg, hosszúszőrű vagy rövidszőrű (r/h): ");
						rovidVagyHosszu = br.readLine().charAt(0);
						
					} while (rovidVagyHosszu != 'r' && rovidVagyHosszu != 'h');
					
					hosszuszoru = (rovidVagyHosszu=='h') ;
					allat = new Macska(nev, suly, hosszuszoru);
					
				}
				
				joAdat = true;
				
			} catch (NumberFormatException e) {
				
				System.err.println("Nem megfelelő formátum!");
				
			} catch (IllegalArgumentException e) {
				
				System.err.println(e.getMessage());
				
			} catch (IOException e) {
				
				System.err.println("I/O hiba!");
				
			}
			
			
			
		} while (!joAdat);
		
		
		return allat;
	}

}
