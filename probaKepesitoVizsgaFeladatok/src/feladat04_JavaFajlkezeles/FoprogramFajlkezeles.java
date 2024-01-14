package feladat04_JavaFajlkezeles;

import java.io.IOException;
import java.util.List;

public class FoprogramFajlkezeles {

	public static void main(String[] args) throws IOException {
		
		//FajlMuveletek fajlObj = new FajlMuveletek();
		
		//List<Programnyelv> programNyelvek = fajlObj.fajlBeolvasas("meroszamok", ";");
		
		AdatFeldolgozas adatObj = new AdatFeldolgozas();
		
		//adatObj.valtozas(programNyelvek);
		
		Programnyelv nyelvObj = new Programnyelv("Ada", 1983, 12000, 14, 10000);
		
		System.out.println(nyelvObj.valtozasMerteke());

	}

}
