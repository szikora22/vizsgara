package osztalyzatok;

import java.util.Scanner;

public class OsztalyzatokFoprogram {
	
	public static void main(String[] args) {
		
		int[] osztalyzatok = new int[6];
		int[] osztalyzatok1 = new int[6];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Megolds for-ciklussal:");
		
		for(int i=0; i<osztalyzatok.length;i++) {
			
			System.out.print("Kérem adja meg a tanuló " + (i+1) + ". jegyét: ");
			int erdemjegy = Integer.parseInt(sc.nextLine());
			
			osztalyzatok[i] = erdemjegy;
			
		}
		
		System.out.println("A tanuló érdemjegyei for ciklussal: ");
		
		for(int i=0; i<osztalyzatok.length; i++) {
			
			System.out.print(osztalyzatok[i] + " ");
			
		}
		
		System.out.println();
		int osszeg = 0;
		
		for(int i=0; i<osztalyzatok.length; i++) {
			
			osszeg += osztalyzatok[i];
			
		}
		
		double atlag = (double)osszeg / osztalyzatok.length;
		
		System.out.printf("A tanuló átlaga: %.2f",atlag);
		
	}
	

}
