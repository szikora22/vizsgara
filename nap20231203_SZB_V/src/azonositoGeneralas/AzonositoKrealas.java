package azonositoGeneralas;

import java.util.Scanner;

public class AzonositoKrealas {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String vezeteknev, keresztnev, azonosito;
		
		
		System.out.print("Kérem a felhasználó vezetéknevét: ");
		vezeteknev = sc.nextLine();
		
		System.out.print("Kérem a felhasználó keresztnevét: ");
		keresztnev = sc.nextLine();
		
		azonosito = vezeteknev.substring(0,Math.min(3, vezeteknev.length()));
		azonosito = azonosito + keresztnev.substring(0,Math.min(3, keresztnev.length()));
		azonosito = azonosito.toLowerCase();
		
		String teljesnev = vezeteknev + keresztnev;
		int ebetukSzama = 0;
		
		for(int i=0; i<vezeteknev.length(); i++) {
			
			if(Character.toLowerCase(vezeteknev.charAt(i))=='e') {
				ebetukSzama++;
			}
			
		}
		
		azonosito += Integer.toString(ebetukSzama);
		System.out.println(azonosito);
		
	}
	
	
	

}
