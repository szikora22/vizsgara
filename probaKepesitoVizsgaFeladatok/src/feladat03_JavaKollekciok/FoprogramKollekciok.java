package feladat03_JavaKollekciok;

import java.util.List;

public class FoprogramKollekciok {

	public static void main(String[] args) {
		
		
		Adatkezeles adatObj = new Adatkezeles();
		List<Versenyzo> versenyzok = adatObj.versenyzoAdatbekeres();		
		
		listaz(versenyzok); 	// ha nem kéri objektumosan a feladat, létre lehet hozni a főprogramban is a metódust
		
		System.out.println("A verseny utolsó helyezettje: ");
		System.out.println(versenyzok.get(utolsohelyezett(versenyzok)).toString());
		
		

	}



	public static int utolsohelyezett(List<Versenyzo> versenyzok) {
		
		int maxIndex = 0;
		
		for(int i =1; i<versenyzok.size(); i++) {
			
			if(versenyzok.get(maxIndex).getHelyezes() < versenyzok.get(i).getHelyezes()) {
				
				maxIndex = i;
							
			}
			
		}
		
		
		
		return maxIndex;
	}



	private static void listaz(List<Versenyzo> versenyzok) {

		for (Versenyzo versenyzo : versenyzok) {
			
			System.out.println(versenyzo.toString());			
			System.out.println((versenyzo.eremSzerzo() ? "szerzett érmet" : "nem szerzett érmet"));
			
		}
		
		
		
	}


}
