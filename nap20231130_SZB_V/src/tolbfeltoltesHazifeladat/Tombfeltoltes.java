package tolbfeltoltesHazifeladat;

import java.util.Scanner;

public class Tombfeltoltes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] tomb = new int[10];
		
		//tömb feltöltése
		
		for(int i=0; i<tomb.length;i++) {
			
			System.out.println("Kérem adja meg az " + (i+1) + ". számot: ");
			int szam = Integer.parseInt(sc.nextLine());
			tomb[i] = szam;
			
		}

		sc.close();
		
		System.out.println("A felhasználó általá bekért számok a következők: ");
		
		for(int i=0; i<tomb.length; i++) {
			
			System.out.print(tomb[i] + " ");
						
		}
		System.out.println();
				
		int negyzetSzam=0;
		
		while(negyzetSzam<tomb.length && Math.sqrt(tomb[negyzetSzam])%1 != 0) {
			
			negyzetSzam++;
			
		}
		if(negyzetSzam<tomb.length) {
			
			System.out.println("Az első négyzetszám: " + tomb[negyzetSzam]);
			
		}
		else {
			System.out.println("Nem található négyzetszám");
		}
		System.out.println();
		
		System.out.println("Az első elem négyzete: " + (tomb[0] * tomb[0]));
		System.out.println();
		
		System.out.println("Páratlan számok és azok indexei:");
		
		for(int i=0; i<tomb.length; i++) {
			
			if(tomb[i]%2 != 0) {
				
				System.out.println("Az " + (i+1) + ". páratlan szám a: " + tomb[i] + ", " + i + ". indexen található");
				
			}
			
		}
		System.out.println();
		
		System.out.println("Hárommal osztható számok listája visszafelé haladva: ");
		
		for(int i= tomb.length-1; i>=0;i--) {
			
			if(tomb[i]%3 ==0) {
				
				System.out.print(tomb[i] + " ");
				
			}
			
			
		}
		System.out.println();
		
		
		int elsoOtOsszege = 0;
		for(int i=0; i<5; i++) {
			
			elsoOtOsszege += tomb[i];
			
		}
		System.out.println("Az első 5 elem összege: " + elsoOtOsszege);
		
		int utolsoOtOsszege = 0;
		for(int i= tomb.length-5; i<tomb.length; i++) {
			
			utolsoOtOsszege += tomb[i];
			
		}
		System.out.println("Az utolsó 5 elem összege:" + utolsoOtOsszege);
		System.out.println();
		
		int[][] ketDimenziosTomb = new int[2][5];
		int index = 0;
		for(int i=0; i<ketDimenziosTomb.length; i++) {
			
			for(int j=0; j<ketDimenziosTomb[i].length; j++) {
				
				ketDimenziosTomb[i][j] = tomb[index];
				index++;
			}
			
		}
		
		System.out.println("Kétdimenziós tömb elemeinek kilistázása: ");
		for(int i=0; i<ketDimenziosTomb.length; i++) {
			
			for(int j=0; j<ketDimenziosTomb[i].length;j++) {
				
				System.out.print(ketDimenziosTomb[i][j] + " ");
				
			}
			
			System.out.println();
			
		}
		System.out.println();
		
		System.out.println("Kétdimenziós tömb elemei indexxel:");
		for (int i = 0; i < ketDimenziosTomb.length; i++) {
		    for (int j = 0; j < ketDimenziosTomb[i].length; j++) {
		        System.out.println("Szám: " + ketDimenziosTomb[i][j] + ", Sor index: " + i + ", Oszlop index: " + j);
		    }
		}
		
		// Ugyanezt megtehetjük a sima tömbre is
		for (int i = 0; i < tomb.length; i++) {
		    System.out.println("Szám: " + tomb[i] + ", Tömb index: " + i);
		}
		
	}

}
