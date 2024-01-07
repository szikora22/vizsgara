package osztalyzatokOOPAdatbekeresselEllenorzessel;

import java.io.IOException;

public class OsztalyzatokFoprogram {

	public static void main(String[] args) throws IOException {
		
		
		Fajlkezeles fajlObj = new Fajlkezeles();
		
		Tanulo[] tanulok = fajlObj.fajlBeolvasas("osztalyzatok.csv",";");
		
		for (Tanulo tanulo : tanulok) {
			System.out.println(tanulo.toString());
			System.out.printf("Tanuló átlaga: %.2f%n" , tanulo.atlagSzamitas());
		}
		
		System.out.printf("\nAz osztály átlaga: %.2f%n",Tanulo.osztalyAtlag(tanulok));
		
		Adatkezeles adatObj = new Adatkezeles();
		fajlObj.fajlbaIras("osztalyzatok.csv",";",adatObj.adatokKonzolrol());

	}

}
