package feladat01_JavaAlapok;

import java.util.Random;
import java.util.Scanner;

public class EmailGeneraloApp {

	static Random r = new Random();
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Kérem adja meg a vezetéknevet: ");
		String vezetekNev = sc.nextLine();
		
		System.out.print("Kérem adja meg a keresztnevet: ");
		String keresztNev = sc.nextLine();
		
		System.out.println("Az elkészült email cím: " + emailCimKiosztas(vezetekNev, keresztNev));
		
		sc.close();

	}


	public static String emailCimKiosztas(String vezetekNev, String keresztNev) {
		
		String emailCim;
		emailCim = vezetekNev.substring(0,Math.min(vezetekNev.length(), 5));
		emailCim = emailCim + ".";
		emailCim = emailCim + keresztNev.substring(0,Math.min(keresztNev.length(), 5));
		emailCim = emailCim + String.valueOf(veletlenSzamGenerator(10, 20));
		emailCim = emailCim + "@net.hu";
		emailCim = emailCim.toLowerCase();
		
		return emailCim;
		
	}
	
	
	public static int veletlenSzamGenerator(int minimumErtek, int maximumErtek) {
		
		
		return r.nextInt(maximumErtek-minimumErtek+1)+minimumErtek;
		
	}
	

}
