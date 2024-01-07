package vallalkozasApp;

import java.util.Random;
import java.util.Scanner;



public class VallalkozasokFoprogram {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int vallalkozasokSzama = vallalkozasokSzamaBeker(sc);
		Vallalkozasok[] vallalkozasok = vallalkozasokAdatbeker(sc, vallalkozasokSzama);
		vallalkozasokEredmenyei(vallalkozasok);
		randomHonapEredmenye(vallalkozasok);
		Vallalkozasok legjobbanteljesitoVallalkozas = legjobbanTeljseitoVallalat(vallalkozasok);		
		System.out.print("A legjobban teljesítő vállalat: " + legjobbanteljesitoVallalkozas.getId());
		vesztesegesHonapok(vallalkozasok);

	}
	
	
	
	private static void vesztesegesHonapok(Vallalkozasok[] vallalkozasok) {
		System.out.println("A veszteséges hónapok száma vállalkozásonként: ");
		
		for (Vallalkozasok vallalkozas : vallalkozasok) {
			
			int vesztesegesHonapSzamlalo = vallalkozas.vesztesegesHonapKiszamol();
			System.out.println("Vállalkozás " + vallalkozas.getId() + ": " + vesztesegesHonapSzamlalo + " veszteséges hónap.");
			
		}
		
	}



	private static Vallalkozasok legjobbanTeljseitoVallalat(Vallalkozasok[] vallalkozasok) {

		Vallalkozasok legjobbanteljesitoVallalkozas = null;
		int legjobbEredmeny = Integer.MIN_VALUE;
		
		for (Vallalkozasok vallalkozas : vallalkozasok) {
			
			int osszEredmeny = vallalkozas.nyeresegKiszamol();
			if(osszEredmeny>legjobbEredmeny) {
				
				legjobbEredmeny=osszEredmeny;
				legjobbanteljesitoVallalkozas = vallalkozas;
			}
			
		}
		
		return legjobbanteljesitoVallalkozas;
		
	}



	private static void randomHonapEredmenye(Vallalkozasok[] vallalkozasok) {

		Random r = new Random();
		int randomHonap = r.nextInt(12)+1;
		
		System.out.println("Véletlenszerű hónap eredménye - " + randomHonap + ". hónap: ");
		
		for(int i=0; i<vallalkozasok.length; i++) {
			
			System.out.println("Vállalkozás " + (i+1) + ": " + vallalkozasok[i].getHaviEredmenyek(randomHonap - 1));
			
		}
		
		
	}



	private static void vallalkozasokEredmenyei(Vallalkozasok[] vallalkozasok) {
		
		for(int i=0; i<vallalkozasok.length; i++) {
			
			System.out.println((i+1) + ". vállalat eredménye havi bontásban: ");
			haviEredmenyekMegjelenitese(vallalkozasok[i].getHaviEredmenyek());
			
			int haviEredmenyekOsszege = nyeresegKiszamaol(vallalkozasok[i].getHaviEredmenyek());
			System.out.println();
			System.out.println((i+1) + ". válallalat éves nyeresége: " + haviEredmenyekOsszege + " Ft");
			
		}
		
		
	}



	private static int nyeresegKiszamaol(int[] haviEredmenyek) {

		int osszeg = 0;
		for (int elem : haviEredmenyek) {
			osszeg += elem;
		}
		
		return osszeg;
	}



	private static void haviEredmenyekMegjelenitese(int[] gethaviEredmenyek) {

		for(int i=0; i<12; i++) {
			System.out.println("Hónap: " + (i+1) + ": " + gethaviEredmenyek[i] + " Ft");
		}
		
		
	}



	private static Vallalkozasok[] vallalkozasokAdatbeker(Scanner sc, int vallalkozasokSzama) {
		
		Vallalkozasok[] vallalkozasok = new Vallalkozasok[vallalkozasokSzama];
		
		for(int i=0; i<vallalkozasokSzama; i++) {
			
			System.out.print("Kérem adja meg az " + (i+1) + ". vállalkozások havi eredményét: ");
			int[] haviEredmeny = haviEredmenyBeker(sc);
			vallalkozasok[i] = new Vallalkozasok(haviEredmeny);
			
		}
		
		
		return vallalkozasok;
		
	}
	
	private static int[] haviEredmenyBeker(Scanner sc) {
		
		int[] haviEredmenyek = new int[12];
		
		for(int i=0; i<12; i++) {
			System.out.println("Hónap: " + (i+1) + ": ");
			haviEredmenyek[i] = Integer.parseInt(sc.nextLine());
		}
		
		
		
		return haviEredmenyek;
	}

	

	private static int vallalkozasokSzamaBeker(Scanner sc) {

		System.out.print("Kérem adja meg a vállalkozások számát: ");		
		return Integer.parseInt(sc.nextLine());
	}

}
