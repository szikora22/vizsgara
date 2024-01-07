package allatmenhely;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllatmenhelyFoProgram {

	public static void main(String[] args) throws IOException {
		
		Allat[] allatok = new Allat[10];
		int aktivElemszam = 0;
		
		Adatbevitel adatObj = new Adatbevitel();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// char menupont;
		String menupont;
		
		do {
			
			System.out.println("1. menhelyre történő felvétel");
			System.out.println("2. menhely állatainak listázása");
			System.out.println("3. menhely felszabadítása");
			System.out.println("4. kilépés");
			
			// menupont = br.readLine().charAt(0); // --> üres Enterre kivételt kapunk
	// vagy catch ággal lekezeljük vagy egyszerűbb ha eleve nem karakterként hanem szövegként kérjük be a menüpontot
			menupont = br.readLine();
			
			switch (menupont) {
			//case '1':
			case "1":
				if (aktivElemszam < allatok.length) {
					
					// külön osztály valósítja meg az adatbekérést és példányosítást
					allatok[aktivElemszam] = adatObj.adatBekeres(br);
					aktivElemszam++;
					
				}
				else {
					System.err.println("A menhely megtelt!");
				}
				break;
			//case '2':
			case "2":
				if (aktivElemszam>0) {
					
					System.out.println("Az állatmenhely jelenlegi lakói:");
					for (int i=0; i<aktivElemszam; i++) {
						System.out.print(allatok[i].toString());
						System.out.printf(" napi ételadag: %.2f kg %n",allatok[i].napiEtelAdag());
					}
					
				}
				else {
					System.err.println("A menhely üres, nem lehet listát készíteni!");
				}
				break;
			// case '3':
			case "3":
				if (aktivElemszam>0) {
					
					System.out.println(allatok[0].getNev()+" távozik a menhelyről");
					
					for (int i=1; i<=aktivElemszam-1; i++) {
						allatok[i-1] = allatok[i];
					}
					allatok[aktivElemszam-1] = null;
					
					aktivElemszam--;
					
				}
				else {
					System.err.println("A menhely üres, nem lehet helyet felszabadítani!");
				}
			}
			
		// }while(menupont!='4');
		}while(!menupont.equals("4"));

		br.close();
	}
	
	
	/*
	 Gyakorló (házi) feladatok:
	 
	 A 2. menüpont (listázás) almenü létrehozása:
	 2.1 Teljes lista 
	 2.2 kutyák listája
	 2.3 Macskák listája
	 2.4 Hosszúszőrű macskák listája
	 2.5 20 kilónál nehezebb kutyák listája
	 2.6 Nevek alapján ABC-ber rendezett teljes lista (ügyelve az eredeti beviteli sorrend megtartására)
	 2.7 Visszatérés a főmenübe
	 
	 Kilépéskor amennyiben van lakója a menhelynek mentse ki egy fájlba az adatokat,
	 majd megírni azt az algoritmust, ami induláskor a fájlból betölti az adatokat a tömbbe.
	 
	 Adatbeviteli résznél is a bekérés ne karakteres típusú hanem szöveges típusú legyen (vagy legyen lekezelve)
	 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
