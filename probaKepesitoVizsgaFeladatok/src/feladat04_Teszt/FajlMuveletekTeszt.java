package feladat04_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import feladat04_JavaFajlkezeles.FajlMuveletek;

class FajlMuveletekTeszt {

	@Test
	void fajlBeolvasasTeszt() throws IOException {


		FajlMuveletek fajlObj = new FajlMuveletek();
		
		
		assertTrue(fajlObj.fajlBeolvasas("meroszamok.csv", ";").size()>0);
		assertEquals(25, fajlObj.fajlBeolvasas("meroszamok.csv", ";").size());
		assertThrows(FileNotFoundException.class, () -> fajlObj.fajlBeolvasas("nincsilyenfajl.csv",";"));
		
	}

}
