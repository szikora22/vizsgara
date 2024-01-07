package hazifeladatok;

import java.util.Scanner;

public class Nevbeker {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String[] nevek = new String[10];
		
		nevBeker(nevek);
		mindenMasodikKilistaz(nevek);
		leghosszabbNev(nevek);
		legtobbSbetu(nevek);
		
	}

	private static void legtobbSbetu(String[] nevek) {

		int legtobbSIndex = -1;
		int maxSbetuSzam = 0;
		
		for(int i=0; i<nevek.length;i++) {
			
			int sBetukSzama = 0;
			for(char c : nevek[i].toCharArray()) {
				
				if(c == 's' || c == 'S') {
					sBetukSzama++;
				}
				
			}
			
			if(sBetukSzama > maxSbetuSzam) {
				maxSbetuSzam = sBetukSzama;
				
				legtobbSIndex = i;
				
			}
			
		}
		
		if(legtobbSIndex >0) {
			System.out.println("A legtöbb 'S' betűt tartalmazó név: " + nevek[legtobbSIndex]);
		}
		else {
			System.out.println("Nincs 'S' betűt tartalmazó név");
		}
		
	}

	private static void leghosszabbNev(String[] nevek) {

		int leghosszabbIndex = 0;
		
		for(int i=1; i<nevek.length; i++) {
			
			if(nevek[leghosszabbIndex].length() < nevek[i].length()) {
				leghosszabbIndex = i;
			}
			
		}
		
		System.out.println("A leghosszabb név: " + nevek[leghosszabbIndex]);
		
	}

	private static void mindenMasodikKilistaz(String[] nevek) {

		for(int i=1; i<nevek.length; i+=2) {
			
			System.out.print(nevek[i] + " ");
			
		}
		
		System.out.println();
		
	}

	private static void nevBeker(String[] nevek) {

		for(int i=0; i<nevek.length; i++) {
			System.out.print("Kérem adja meg a(z) " + (i+1) + ". keresztnevet: ");
			String keresztnev = sc.nextLine();
			nevek[i] = keresztnev.toUpperCase();
		}
		
		
		
	}

}
