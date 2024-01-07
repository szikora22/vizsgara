package osztalyzatokOOPStatikusan;

import java.io.IOException;

public class OsztalyzatokFoprogram {

	public static void main(String[] args) throws IOException {
		
		
		Fajlkezeles fajlObj = new Fajlkezeles();
		
		Tanulo[] tanulok = fajlObj.fajlBeolvasas("osztalyzatok.csv",";");
		
		for (Tanulo tanulo : tanulok) {
			System.out.println(tanulo.toString());
			System.out.printf("Tanuló átlaga: %.2f%n" , tanulo.atlagSzamitas());
		}
		
		NemStatikusMetodusokOsztalya nemStatikObj = new NemStatikusMetodusokOsztalya();
		
		System.out.printf("\nAz osztály átlaga: %.2f%n",nemStatikObj.osztalyAtlag(tanulok));
		
/* ennek a verziónak a szépséghibája, hogy akárhány objektum létrehozható NemStatikus...-ból, aminek itt nem sok értelme van
		NemStatikusmetodusokOsztalya nemStatikObj2 = new NemStatikusmetodusokOsztalya();
		
		System.out.println(nemStatikObj.equals(nemStatikObj2));
		*/
		
		Adatkezeles adatObj = new Adatkezeles();
		fajlObj.fajlbaIras("osztalyzatok.csv",";",adatObj.adatokKonzolrol());

	}

}
