package feladat03_JavaKollekciok;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Adatkezeles {
	
	public List<Versenyzo> versenyzoAdatbekeres(){
		
		List<Versenyzo> versenyzok = new ArrayList<Versenyzo>();
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			
			System.out.print("Kérem a versenyző rajtszámát: ");
			String rajtszam = sc.nextLine();
			
			System.out.print("Kérem a versenyző nevét: ");
			String nev = sc.nextLine();
			
			System.out.print("Kérem a versenyző egyesületét: ");
			String egyesulet = sc.nextLine();
			
			System.out.print("Kérem a versenyző helyezését: ");
			int helyezes = Integer.parseInt(sc.nextLine());
			
			versenyzok.add(new Versenyzo(rajtszam, nev, egyesulet, helyezes));
			
			
		}
		
		sc.close();
		return versenyzok;
	}
	
	
	
	

}
