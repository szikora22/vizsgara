package feladat03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FoprogramAutoSzerviz {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Adja meg az aktuális óradíjat");
		
		int oradij = Integer.parseInt(sc.nextLine());
		
		Adatkezeles adatObj = new Adatkezeles();
		List<SzervizMunka> szervizmunkak = adatObj.szervizBekeres();	
		System.out.println("A legrövidebb ideig tartó szervíztevékenység: ");
		System.out.println(szervizmunkak.get(legrovidebbSzerviz(szervizmunkak)).toString());
		
		// Map létrehozása
		Map<String, SzervizMunka> szervizek = new HashMap<>();
		
		//Adatszerkezet feltöltése
		
		szervizek.put("Általános Szerviz", new SzervizMunka("Altalános szervíz", 10));
		szervizek.put("Olajcsere", new SzervizMunka("Olajcsere", 3));
		szervizek.put("Fékcsere", new SzervizMunka("Fékcsere", 5));
		
		//Adatok kilistázása
		
		/*for(Map.Entry<String, SzervizMunka> entry : szervizek.entrySet()) {
			
			String nev = entry.getKey();
			
			SzervizMunka szerviz = entry.getValue();
			
			integer munkadij = szerviz.arKepzes();
			
			System.out.println("Szerviz neve: " + nev + " , Munkadíj: " + munkadij);
			
		} */
		
		
		
		
		
		
			
	}
	
	public static int legrovidebbSzerviz(List<SzervizMunka> szervizmunkak) {
		
		int minIndex = 0;
		
		for(int i=1; i< szervizmunkak.size(); i++ ) {
			
			if(szervizmunkak.get(minIndex).getMunkaOra() > szervizmunkak.get(i).getMunkaOra()) {
				
				
				minIndex = i;
				
			}
			
			
		}
		
		
		return minIndex;
		
	}
	
	
	
}
