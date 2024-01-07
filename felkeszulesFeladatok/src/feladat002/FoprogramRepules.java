package feladat002;

/*
 * Adott Jarmu ősosztály: megnevezes, azonosito, gyartasEve, osszesMegtettKm adattagokkal.
 * Az osztály atlagKmPerEv metódusa kiszámolja az átlagkilométert: az aktuális év, gyártási év és megtett km adatokból
 * Az ősosztály leszármazottja ViziJarmu osztály, melynek saját adattagja a vizkiszoritas (int) tulajdonság
 * Az ősosztály másik leszármazottja LegiJarmu osztály,saját adattagja fesztavolsag (double)
 * Továbbá LegiJarmu implementálja IRepul interfészt, amely egy metódust ír elő: double repulesiIdo(int megtettTavolsagKm, int atlagSebessegKmH); 
 * Hozza létre az interfészt és alakítsa ki a specifikációnak megfelelően a hierarchiát!
 * 
 * Az ősosztály viselkedését ellenőrző egységteszt nem fut le, javítsa a metódust!
 * 
 * A főprogramban hozzon létre egy olyan tömböt, amely mindhárom típust képes tárolni. 
 * 3 tetszőleges adattal töltse is fel úgy, hogy mindhárom osztályt reprezentálja egy-egy objektum
 * Egy ciklussal írja ki soronként egy-egy objektum minden adatát, annak toString metódusát meghívva!
 * 
 * Végül ugyancsak tetszőleges paraméterel hívja meg a légi jármű példány repülési időt kiszámító metódusát és írja ki az eredményt
 * 
 * Hozzon létre egy egységtesztet repulesiIdo metódus tesztelésére
 */

public class FoprogramRepules {

	public static void main(String[] args) {
		
		// TODO tömb feltöltése típusonként egy-egy objektummal, majd kiíratásuk
		
		Jarmu[] jarmuvek = new Jarmu[3];
		
		jarmuvek[0] = new Jarmu("Audi", "J002", 2005, 340000);
		jarmuvek[1] = new Legijramu("Airbus A320", "LJ001", 1988, 2800000,34.1);
		jarmuvek[2] = new Vizijarmu("Titanic", "VJ003", 1911, 4800, 60000);
		
		
		for (Jarmu jarmu : jarmuvek) {
			
			System.out.println(jarmu.toString());
			System.out.println("Éves átlag kilométer: " + jarmu.atlagKmPerEv() + " km");
			
		}
		
		System.out.printf("A légijármű repülési ideje: %.2f óra", ((Legijramu)jarmuvek[1]).repulesiIdo(6900, 770));
		
		
		

	}

}
