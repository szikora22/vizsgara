package oopAlapokOsszefoglaloProjekt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllatmenhelyFoprogram {

	public static void main(String[] args) throws IOException {


		Allat[] allatok = new Allat[10];
		int aktivElemszam = 0;
		
		Adatbevitel adatObj = new Adatbevitel();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String menupont;
		
		
		do {
			
			System.out.println("1. menhelyre történő felvétel");
			System.out.println("2. menhely állatainak listázása");
			System.out.println("3. menhely felszabadítása");
			System.out.println("4. kilépés");
			
			menupont = br.readLine();
			
			switch(menupont) {
			case "1":
				if(aktivElemszam < allatok.length) {
					
					allatok[aktivElemszam] = adatObj.adatBekeres(br);
					aktivElemszam++;
					
				}
				break;
			case "2":
				if(aktivElemszam >0) {
					
					System.out.println("Az állatmenhely jelenlegi lakói:");
					for(int i=0; i<aktivElemszam; i++) {
						
						System.out.println(allatok[i].toString());
						System.out.printf(" napi ételadag: %.2f kg %n",allatok[i].napiEtelAdag());
						
					}
					
				}
				else {
					System.err.println("A menhely üres, nem lehet listát készíteni!");
				}
				
				
				
				break;
			case "3":
				if(aktivElemszam>0) {
					
					System.out.println(allatok[0].getNev() + " távozik a menhelyről");
					
					for(int i=1; i<=aktivElemszam-1;i++) {
						
						allatok[i-1] = allatok[i];
						
					}
					
					allatok[aktivElemszam-1] = null;
					aktivElemszam--;
				}
				else {
					System.err.println("A menhely üres, nem lehet helyet felszabadítani!");
				}
				break;
			
			
			
			}
			
			if(!menupont.equals("4")) {
				
				System.out.println("Nyomja meg az Entert a folytatáshoz");
				br.readLine();
			}
			
		} while (!menupont.equals("4"));
		
		br.close();

	}

}
