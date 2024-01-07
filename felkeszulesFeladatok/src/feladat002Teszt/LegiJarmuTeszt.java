package feladat002Teszt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import feladat002.Jarmu;
import feladat002.Legijramu;

class LegiJarmuTeszt {

	@Test
	void repulesiIdoTeszt() {

		Legijramu legijarmu = new Legijramu("Airbus A320", "LJ001", 1988, 2800000,34.1);
		
		assertEquals(10,legijarmu.repulesiIdo(5000, 500));
	
	}

}
