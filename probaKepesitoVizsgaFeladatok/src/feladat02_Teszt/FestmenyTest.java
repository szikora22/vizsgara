package feladat02_Teszt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import feladat02_JavaOOP.Festmeny;

class FestmenyTest {

	@Test
	void ertekkovetesTeszt() {
		
		Festmeny tesztObj = new Festmeny("Teszt", "Teszt", 2022, 16000000);
		int tesztSzazalek = 5;
		long elvartErtek = 16800000;
		assertEquals(elvartErtek,tesztObj.ertekkovetes(tesztSzazalek));
		
	}
	
	@Test
	void setBecsultErtekTeszt() {
		
		Festmeny tesztObj = new Festmeny("Teszt", "Teszt", 2022, 16000000);
		
		int ujErtek = 180000;
		
		
		assertThrows(IllegalArgumentException.class, () -> tesztObj.setBecsultErtek(ujErtek));
		
		
	}
	
	@Test
	void getCimTeszt() {
		
		Festmeny tesztObj = new Festmeny(null, "Teszt", 2022, 16000000);
		
		
		assertThrows(IllegalArgumentException.class, () -> tesztObj.getCim());
		
	}
	
	
	
	
}
