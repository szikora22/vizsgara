package tombRendezesek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class TombFeltoltes {
	
	static Random r = new Random();

	public static void main(String[] args) throws IOException {

		int[] tomb = tombFeltolt(40,1,100);
		kilistaz(tomb,8);
		
		rendezesEgyszeruCserevel(tomb);
		
		System.out.println();
		kilistaz(tomb, 10);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Adja meg a keresett számot: ");
		int keresettSzam = Integer.parseInt(br.readLine());
		
		int binarisEredmeny = binarisKereses(tomb,keresettSzam);
		if (binarisEredmeny>=0) {
			
			System.out.println("A keresett szám megtalálható a tömbben ("+binarisEredmeny+" indexen található)");
		}
		else {
			System.out.println("A keresett szám nem eleme a tömbnek");
		}
		
		br.close();		
		
		// néhány beépített tömbművelet:
		
		Arrays.sort(tomb);
		kilistaz(tomb,20);
		
		System.out.println();
		Arrays.fill(tomb, 10); // feltölti a tömböt 10-es értékkel
		kilistaz(tomb, 4);
		
		
		

	}

private static int binarisKereses(int[] tomb, int keresettSzam) {
		
		int elsoIndex = 0;
		int utolsoIndex = tomb.length-1;
		int kozepsoIndex = -1;
		boolean megvan = false;
		
		while (elsoIndex<=utolsoIndex && !megvan) {
			
			kozepsoIndex = (elsoIndex + utolsoIndex)/2;
			if (tomb[kozepsoIndex] == keresettSzam) {
				megvan = true;
			}
			else if (tomb[kozepsoIndex] > keresettSzam) {
				elsoIndex = kozepsoIndex + 1;
			}
			else {
				utolsoIndex = kozepsoIndex - 1;
			}
		}
		
		if (megvan) {
			return kozepsoIndex;
		}
		
		return -1;
	}


	private static void rendezesEgyszeruCserevel(int[] tomb) {
		
		for (int i=0; i<tomb.length-1; i++) {
			for (int j=i+1; j<tomb.length; j++) {
				
				if (tomb[i] < tomb[j]) {
					
					int csere = tomb[i];
					tomb[i] = tomb[j];
					tomb[j] = csere;
				}
				
			}
		}
		
		
	}


	private static void kilistaz(int[] tomb, int elemszamPerSor) {
		
		for (int i=0; i<tomb.length; i++) {
			
			// System.out.print(tomb[i]+" ");
			System.out.print(tomb[i]+((tomb[i]<10)?"  ":" "));
			if ((i+1) %elemszamPerSor == 0 ) {
				System.out.println();
			}
			
		}
		
		
	}


	private static int[] tombFeltolt(int tombElemszam, int minErtek, int maxErtek) {
		
		int[] tomb = new int[tombElemszam];
		
		int sorsoltSzam;
		for (int i=0; i<tomb.length; i++) {
			
			do {
				sorsoltSzam = r.nextInt(minErtek, maxErtek+1);
			} while (elemeATombnek(tomb,sorsoltSzam));
			
			tomb[i] = sorsoltSzam;
			
		}
		
		return tomb;
	}


	private static boolean elemeATombnek(int[] tomb, int keresettSzam) {
		
		int i=0;
		while (i<tomb.length && tomb[i]!=keresettSzam) {
			i++;
		}
		
		return i<tomb.length;
	}

}
