package osztalyzatokTeszt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.time.Duration;

import org.junit.jupiter.api.Test;

import osztalyzatokOOPAdatbekeresselEllenorzesselKivetelDobassal.Fajlkezeles;
import osztalyzatokOOPAdatbekeresselEllenorzesselKivetelDobassal.Tanulo;

class FajlkezelesTeszt {

	@Test
	public void fajlBeolvasasTeszt() throws IOException {
		
		Fajlkezeles fajlObj = new Fajlkezeles();
		
		int elvartEredmeny = 9;
		
		// 9 tanuló adata található a fájlban, ellenőrizzük az eredmény tömb méretét:
		assertEquals(elvartEredmeny,fajlObj.fajlBeolvasas("osztalyzatok.csv", ";" ).length);
		
		// a fájlban lévő 3. tanuló matek jegyére ellenőrzünk:
		assertEquals(1, fajlObj.fajlBeolvasas("osztalyzatok.csv", ";" )[2].getMatek() );
		
	}
	
	
	@Test
	public void fajlSorainakSzamaTesztkiveteldobas() throws IOException {
		
		Fajlkezeles fajlObj = new Fajlkezeles();
		
		assertThrows(NoSuchFileException.class, () -> fajlObj.fajlSorainakSzama("osztalyzat.csv") );
		
	}
	
	
	@Test 
	void fajlSorainakSzamaTeszt() throws IOException {
		
		Fajlkezeles fajlObj = new Fajlkezeles();
		
		int elvartEredmeny = 10;
		
		assertEquals(elvartEredmeny, fajlObj.fajlSorainakSzama("osztalyzatok.csv"));
		
	}
	
	
	@Test
	public void fajlbaIrasTeszt() throws IOException {
		
		Fajlkezeles fajlObj = new Fajlkezeles();
		
		int elvartEredmeny = fajlObj.fajlSorainakSzama("osztalyzatok2.csv")+1;
		
		Tanulo tanulo = new Tanulo("valaki", 4, 2, 4);
		
		fajlObj.fajlbaIras("osztalyzatok2.csv", ";", tanulo);
		
		assertEquals(elvartEredmeny, fajlObj.fajlSorainakSzama("osztalyzatok2.csv"));
		
		assertEquals(4, fajlObj.fajlBeolvasas("osztalyzatok2.csv", ";" )[9].getMatek() );
		
	}
	
	/*
	public void fajlBeolvasasTesztValaszido() throws IOException {
		
		// jelen esetben kevés adat van a fájlban, emiatt nincs szükség válaszidőt mérni,
		// de ha nagy mennyiségű adatot kellene feldolgozni, akkor lenne értelme:
		
		Fajlkezeles fajlObj = new Fajlkezeles();
		
		assertTimeout(Duration.ofSeconds(2), () -> fajlObj.fajlBeolvasas("osztalyzatok.csv", ";" ) );
		
	}
	*/

}
