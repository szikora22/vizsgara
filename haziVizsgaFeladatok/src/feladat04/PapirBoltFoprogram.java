package feladat04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PapirBoltFoprogram {

	public static void main(String[] args) throws IOException {
		
		List<Rendeles> rendelesek = new ArrayList<Rendeles>();
		FajlKezeles fajlObj = new FajlKezeles();
		
		fajlObj.beolvas(rendelesek,"SzallitoiRendelesek.csv");
		
		for (Rendeles rendeles : rendelesek) {
			System.out.println(rendeles.toString());
		}
		
		
		System.out.println("Fájl beolvasva. Hibás tételek száma: "+fajlObj.beolvas(rendelesek,"SzallitoiRendelesek.csv"));

	}

}
