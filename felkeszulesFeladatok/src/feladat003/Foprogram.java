package feladat003;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 A mellékelt zeneszamok.csv fájlban zeneszámok adatait tárolják, fejléccel ellátva és pontosvesszővel elválasztva.
 A fejléc adatai legyenek Zeneszam osztály adattagjai. Ennek alapján alakítsa ki az osztályt. 
 A beolvasást végző metódus egységtesztje nem fut le, bővítse úgy az alprogramot, 
 hogy a teszt is megjavuljon, illetve a fájl egyes sorai az osztály egy-egy példányát reprezentálják.
 Az objektumokat listában tárolja, ami a metódus visszatérési értéke is egyben! 
 A főprogramban egy metódus segítségével töltse át az adatszerkezetből csak az "egyuttes" adatokat 
 egy olyan adatszerkezetbe, ami kizárja a duplikációt, és abc sorrendet biztosít! Ezt az új adatszerkezetet adja át paraméterként
 Fajlkezeles osztály egy új, fájlba írást végző metódusának, amit az egyuttesek.csv fájlba írjon ki. Legyen fejléce is!
 
 Készítsen egységtesztet a főprogram azon metódusára, ami az áttöltést végzi. 
 */

public class Foprogram {

	public static void main(String[] args) throws IOException {
		
		Fajlkezeles fajlObj = new Fajlkezeles();
		
		List<Zeneszam> zeneszamok = fajlObj.beolvasas("zeneszamok.csv", ";");
		
		for (Zeneszam zeneszam : zeneszamok) {
			
			System.out.println(zeneszam.toString());
			
		}
		
		
		Set<String> egyuttesek = attoltes(zeneszamok);
		
		fajlObj.kiiras(egyuttesek,"egyuttesek.csv",";");
		
		

	}
	
	

	public static Set<String> attoltes(List<Zeneszam> zeneszamok) {

		Set<String> egyuttesek = new TreeSet<String>();
		int duplikaltElemek = 0;
		
		for (Zeneszam zene : zeneszamok) {
			
			if (!egyuttesek.add(zene.getEgyuttes())) {
				
				duplikaltElemek++;
				
			}
			
		}
		
		
		System.out.println("A halmaz töltés során " + duplikaltElemek + " duplikált elemet találtam.");
		
		return egyuttesek;
		
	}

	

}
