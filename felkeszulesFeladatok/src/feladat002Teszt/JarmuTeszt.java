package feladat002Teszt;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import feladat002.Jarmu;

class JarmuTeszt {

	@Test
	void atlagKmPerEvTeszt() {
		
		int gyartasiEv = 2021;
		int osszesKm = 14000;
		Jarmu jarmuObj = new Jarmu("teszt jármű", "J001", gyartasiEv, osszesKm);
		
		int elvartEredmeny = osszesKm / (LocalDate.now().getYear()-gyartasiEv);
		
		assertEquals(elvartEredmeny, jarmuObj.atlagKmPerEv());
		
	}

}
