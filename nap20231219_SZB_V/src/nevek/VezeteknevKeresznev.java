package nevek;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class VezeteknevKeresznev {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		String[] vezetekNev = {"Kovács","Kis","Nagy","Fehér","Kerekes"};
		String[] keresztNev = {"Edit","Zoltán","Orsolya","Szabolcs","Erika"};
		
		ArrayList<String> teljesNevek = new ArrayList<String>();
		
		for(int i=0; i<vezetekNev.length; i++) {
			
			for(int j=0; j<keresztNev.length; j++) {
				
				teljesNevek.add(vezetekNev[i] + " " + keresztNev[j]);
				
			}
			
		}
		

		String[] teljesNev = teljesNevek.toArray(new String[teljesNevek.size()]);
		
		char valasztottMenupont;
		
		do {
			
			System.out.println("Válasszon az alábbi menüpontok közül: ");
			System.out.println("1. A létrehozott névsor kilistázása a képernyőre");
			System.out.println("2. A létrehozott névsor fájlbaírása (nevek.txt)");
			System.out.println("3. A teljes név hossza alapján rendezett névsor listázása a képernyőre");
			System.out.println("4. Az átlaghosszal egyező hosszúságú nevek képernyőre listázása");
			System.out.println("5. Kilépés");
			
			valasztottMenupont = sc.nextLine().charAt(0);
			
			switch(valasztottMenupont) {
			
			case '1':
				nevsorKilistazasa(teljesNev);
				System.out.println();
				break;
			case '2':
				fajlbaIras(teljesNev,"nevek.txt");
				break;
			case '3':
				nevsorKilistazasRendezve(teljesNev);
				break;
			case '4':
				atlaghosszVizsgalat(teljesNev);
				break;
			
			}
			
			if(valasztottMenupont !='5') {
				System.out.println("Nyomja meg az Entert a folytatáshoz!");
				sc.nextLine();
			}
			
			
			
		} while (valasztottMenupont != '5');
		
		sc.close();
		
	}

	private static void atlaghosszVizsgalat(String[] teljesNev) {

		int teljesHossz = 0;
		
		for (String nevek : teljesNev) {
			
			teljesHossz += nevek.length();
			
		}
		
		double atlagHossz = (double)teljesHossz / teljesNev.length;
		
		System.out.print("A nevek átlaghossza: " + atlagHossz);
		System.out.println();
		System.out.println("Az áltaghosszal megegyező nevek:");
		
		for (String nevek : teljesNev) {
			
			if(nevek.length() == atlagHossz) {
				System.out.println(nevek);
			}
			
		}
		
	}

	private static void nevsorKilistazasRendezve(String[] teljesNev) {

		/*Arrays.sort(teljesNev, Comparator.comparingInt(String::length));
		System.out.println("\nNevek kilistázása a teljes név hossza alapján: \n" + Arrays.toString(teljesNev) + "\n"); */
		
		//Nevek rendezése hossza alapján buborékrendezéssel
		
		String[] rendezettNevek = Arrays.copyOf(teljesNev, teljesNev.length);
		
		for(int i=0; i<rendezettNevek.length; i++) {
			
			for(int j=0; j<rendezettNevek.length-i-1; j++) {
				
				if(rendezettNevek[j].length() > rendezettNevek[j+1].length()) {
					
					String temp = rendezettNevek[j];
					rendezettNevek[j] = rendezettNevek[j+1];
					rendezettNevek[j+1] = temp;
				}				
			}
						
		}
		
		System.out.println("Rendezett névsor: " + Arrays.toString(teljesNev));
		
	}

	private static void fajlbaIras(String[] teljesNev, String fajlnev) throws IOException {

		FileOutputStream fs = new FileOutputStream(fajlnev,true);
		OutputStreamWriter out = new OutputStreamWriter(fs,"UTF-8");
		
		for (String nev : teljesNev) {
			
			out.write(nev+"\n");
			
		}
		
		out.close();
		fs.close();
		System.out.println("A fájlbaírás sikeres!");
		
	}

	private static void nevsorKilistazasa(String[] teljesNev) {

		for(int i=0; i<teljesNev.length; i++) {
			
			System.out.print(teljesNev[i] + ", ");
			
		}
		
		
	}

}
