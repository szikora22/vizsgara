package veletlenszam;

import java.util.Random;

public class RandomTomb {
	
	public static Random r = new Random();

	public static void main(String[] args) {

		int[] tomb1 = new int[elemSzam(r)];
		int[] tomb2 = new int[elemSzam(r)];
		
		
		tombFeltoltes(tomb1);
		tombFeltoltes(tomb2);
		kilistaz(tomb1);
		kilistaz(tomb2);
		System.out.println("Tömb1 páros elemeinek száma: " + parosDarab(tomb1) + " db");
		System.out.println("Tömb2 páros elemeinek száma: " + parosDarab(tomb2) + " db");
		legnagyobbElem(tomb1);
		legnagyobbElem(tomb2);
		elsonegyzetSzam(tomb1);
		elsonegyzetSzam(tomb2);

	}

	private static void elsonegyzetSzam(int[] tomb) {
		int i=0;
		
		while(i<tomb.length && (Math.sqrt(tomb[i])) %1 != 0 ) {
			
			i++;
						
		}
		if(i<tomb.length) {
			System.out.println("A tömb első négyzetszáma: " + tomb[i]);
		}
		else {
			System.out.println("Az adott tömb nem tartalmaz négyzetszámot");
		}
		
	}

	private static void legnagyobbElem(int[] tomb) {

		int maxIndex = 0;
		
		for(int i=1; i<tomb.length; i++) {
			if(tomb[maxIndex] < tomb[i]) {
				maxIndex = i;
			}
		}
		
		System.out.println("A tömb legnagyobb eleme: " + tomb[maxIndex]);
		
	}

	private static int parosDarab(int[] tomb) {
		int parosDarab = 0;
		for(int i=0; i<tomb.length; i++) {
			
			if(tomb[i]%2 == 0) {
				parosDarab++;
			}
			
		}
		return parosDarab;
		
	}

	private static void kilistaz(int[] tomb) {
		for(int i=0; i<tomb.length;i++) {
			System.out.print(tomb[i] + " ");
		}
		System.out.println();
		
	}

	private static void tombFeltoltes(int[] tomb) {
		for(int i=0; i<tomb.length;i++) {
			
			tomb[i] = r.nextInt(1,51);
			
		}
	}

	private static int elemSzam(Random r) {
		int elemszam = r.nextInt(5,11);
		return elemszam;
	}

}
