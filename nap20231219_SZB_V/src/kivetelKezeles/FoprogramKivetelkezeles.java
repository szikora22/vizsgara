package kivetelKezeles;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FoprogramKivetelkezeles {

	public static void main(String[] args) {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int elso = 0 , masodik = 0 , harmadik = 0;
		
		boolean joErtek = false;
		
		do {
			
			try {
				
				System.out.print("Kérem az első számot: ");
				//br.close();
				elso = Integer.parseInt(br.readLine());
				
				System.out.print("Kérem az második számot: ");
				masodik = Integer.parseInt(br.readLine());
				
				System.out.print("Kérem az harmadik számot: ");
				harmadik = Integer.parseInt(br.readLine());
				
				joErtek = true;
				
			} catch (NumberFormatException  e) {
				System.out.println("Nem megfelelő formátum vagy értéktartomány! " + e.getMessage());
			} catch (IOException e) {
				System.out.println("I/O hiba! "); // detailedMessage adattag gettere, az eredeti üzenettel
			}
			
		} while (!joErtek);
		
		// 2.-3.-4 feladat:
		
		try {
			
			int[] tomb = new int[elso * masodik * harmadik];
			System.out.println(tomb.length);
			
			// System.out.println(tomb[tomb.length]); // logikailag lehetetlen utasítás a tömb elemszámadik elemét kiírni
			
			
			System.out.println((elso+masodik+harmadik) / Math.min(elso, Math.min(masodik, harmadik)));
			
		} catch (NegativeArraySizeException e) {
			System.out.println("Negatív elemszáma nem lehet a tömbnek");
		} catch (OutOfMemoryError e) {
			System.out.println("Túl nagy elemszám, nem fér be a memóriába!"+e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Nem létező indexre történt hivatkozás!");
		} catch (ArithmeticException e) {
			System.out.println("Nullával osztás nem megengedett!");
		}
		
		// 5. feladat:
		String szoveg = null;
		String fajlnev = null;
		
		System.out.print("Adja meg a fájl nevét: ");
		try {
			fajlnev = br.readLine();
			BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev),"UTF-8"));

		} catch (UnsupportedEncodingException e) {
			System.out.println("Karakterkódolási hiba!");
		} catch (FileNotFoundException e) {
			System.out.println("Nem található a fájl!");
		} catch (IOException e) {
			System.out.println("I/O hiba!");
		}
		
		// 6. feladat:
				try {
					System.out.println(fajlnev.charAt(0));
					System.out.println(szoveg.charAt(0));
				} catch (NullPointerException e) {
					System.out.println("Nincs értéke a változónak!");
				}

	}

}
