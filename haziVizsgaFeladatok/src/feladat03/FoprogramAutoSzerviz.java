package feladat03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class FoprogramAutoSzerviz {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		System.out.println("Adja meg az aktuális óradíjat");
		int ar = Integer.parseInt(sc.nextLine());
				
		Adatkezeles adatObj = new Adatkezeles();
		List<SzervizMunka> szervizmunkak = adatObj.szervizBekeres();	
		System.out.println("A legrövidebb ideig tartó szervíztevékenység: ");
		System.out.println(szervizmunkak.get(legrovidebbSzerviz(szervizmunkak)).toString());
		
		
		Map<String, Integer> munkadijak = new HashMap<String, Integer>();
		
		
		for (SzervizMunka szervizMunka : szervizmunkak) {
			
			int oraDij = szervizMunka.arKepzes(ar);
			munkadijak.put(szervizMunka.getSzervizTevekenyseg(), oraDij);			
		}
		
		System.out.println("Szervíztevékenységek és munkadíjak: ");
		
		for (Map.Entry<String, Integer> entry : munkadijak.entrySet()) {
			
			System.out.println(entry.getKey() + ": " + entry.getValue());
			
		}
		
		
				
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
