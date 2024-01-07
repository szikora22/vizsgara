package feladat001;

/* Feladatkiírás:
 * Kérje be, a program hány számot találjon ki és milyen intervallumban
 * A bekért adatokkal hívja meg feltolt() metódust, ami elvégzi a számok előállítását és egy tömbben adja vissza a sorsolt számokat
 * Listázza ki az összes számot egy külön metódusban
 * Írja ki a legnagyobb értékű elemet, amit szintén egy külön metódusban keressen meg.
 * 
 * A program alapszerkezete adott, a metódusok lehetnek hiányosak és/vagy hibásak
 * feladat001Teszt package egységtesztjei nem futnak le, úgy kell módosítani/bővíteni az alkalmazást,
 * hogy a tesztek is fussanak le jól és a program is a kiírásnak megfelelően működjön.
 */

import java.util.Random;
import java.util.Scanner;

public class FoprogramSzamsorok {
	
	public static Random r = new Random(); 
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int darab=0, min=0, max=0;
		
		// TODO adatok bekérése, a deklarált változókba töltése
		
		System.out.print("Kérem adja meg, hogy hány számot szeretne kisorsoltatni: ");
		darab = Integer.parseInt(sc.nextLine());
		
		System.out.print("Kérem adja meg a minimumértéket: ");
		min = Integer.parseInt(sc.nextLine());
		
		System.out.print("Kérem adja meg a maximumértéket: ");
		max = Integer.parseInt(sc.nextLine());

		
		
		int[] szamok = 	feltolt(darab,min,max);
		
		System.out.println("A kisorsolt számok listája:");
		
		// TODO kiir() metódus hívása
		
		kiir(szamok);
		
		
		
		System.out.println("A kisorsolt számok közötti legnagyobb értékű: ");
		
		// TODO a legnagyobb() metódus által visszakapott indexű tömbelem kiíratása
		
		System.out.println("A kisorsolt számok közül a legnagyobb értékű: " + szamok[legnagyobb(szamok)]);
		
		

	}

	


	public static int legnagyobb(int[] szamok) {
		
		int maxIndex = 0;
		for (int i=maxIndex+1; i<szamok.length; i++) {
			
			if (szamok[i]>szamok[maxIndex]) {
				
				maxIndex = i;
				
			}
			
		}
		
		return maxIndex;
		
	}

	public static void kiir(int[] szamok) {
		
		// TODO a tömb elemeinek listázása
		
		for(int i=0; i<szamok.length; i++) {
			
			System.out.print(szamok[i] + " ");
			
		}
		
	}

	public static int[] feltolt(int darab, int min, int max) {
		
		int[] szamok = new int[darab];
	
		for(int i=0; i<szamok.length; i++) {
			
			szamok[i] = r.nextInt(min,max+1);
			
			//szamok[i] = r.nextInt(max-min+1); --> ha régebbi a java 
			
		}
		
		return szamok;
		
	}

}
