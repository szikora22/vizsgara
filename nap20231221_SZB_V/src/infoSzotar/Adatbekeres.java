package infoSzotar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Adatbekeres {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int menuValasztas() {
		
		int menupont = 0; 
		
		do {
			
			try {
				
				System.out.println("Válasszon egy menüpontot: ");
				System.out.println("1. magyar - angol fordítás");
				System.out.println("2. angol - magyar fordítás");
				System.out.println("3. kilépés");
				
				// önálló gyakorlási lehetőség --> plusz menüpont: új adat felvitele (és kilépéskor fájlba írás)
				
				menupont = Integer.parseInt(br.readLine());
				
				
			} catch (NumberFormatException e) {

				System.err.println("Hibás adatformátum!");
				
			}
			catch (IOException e) {

				System.err.println("I/O hiba!");
				
			}
			
			
			
		} while (menupont<1 || menupont>3);
		
		return menupont;
		
	}
	
	public String forditasBeker() {
		
		System.out.print("Adja meg a fordítandó szót: ");
		String forditasra = null;
		
		try {
			
			forditasra = br.readLine();
			
		} catch (IOException e) {
			System.err.println("I/O hiba!");
		}
		
		return forditasra;
		
	}
	
	
	

}
