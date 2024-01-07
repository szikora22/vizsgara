package cipoBoltArrayList;

public class FoprogramCipobolt {

	public static void main(String[] args) {

		Feladatok feladatObj = new Feladatok();
		
		System.out.println("1. feladat - fájlbeolvasás");
		feladatObj.fajlBeolvasas("cipobolt.csv",";");
		System.out.println();
		
		System.out.println("2. feladat - kiiratás");
		feladatObj.kilistaz();
		
		System.out.println("3. feladat - típusonkénti lista");
		feladatObj.tipusonkentiLista();
		
		System.out.println("4. feladat - ár intervallum lista");
		feladatObj.arIntervallumLista();
		
		System.out.println("5. feladat - csizmák átlagára");
		System.out.printf("%.2f Ft%n" , feladatObj.csizmaAtlagAr());
		
		System.out.println("6. feladat - 5 vagy kevesebb darabszámú termékkel rendelkező típusok:");
		feladatObj.keszletHiany();
		System.out.println();
		
		System.out.print("7. feladat - A teljes készlet (db): ");
		System.out.println(feladatObj.osszesDB());
		System.out.println();
		
		System.out.println("8. feladat - hazai termékek fájlba írása");
		feladatObj.hazaiFajlba("hazai.txt",";");
		System.out.println();
		
		System.out.println("9. feladat - Legrégebbi és legújabb termék gyártása között eltelt hónapok száma: ");
		System.out.println(feladatObj.hanyHonapTeltel());

	}

}
