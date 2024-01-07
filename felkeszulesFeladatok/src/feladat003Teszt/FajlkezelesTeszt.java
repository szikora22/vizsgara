package feladat003Teszt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;


import org.junit.jupiter.api.Test;

import feladat003.Fajlkezeles;

class FajlkezelesTeszt {

	@Test
	void beolvasasTeszt() throws IOException {
		
		Fajlkezeles fajlObj = new Fajlkezeles();
		
		assertTrue(fajlObj.beolvasas("zeneszamok.csv", ";").size()>0);
		
		
	}

}
