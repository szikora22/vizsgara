package feladat03_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import feladat03_JavaKollekciok.Versenyzo;

class VersenyzoTest {

	@Test
	void eremSzerzoTeszt() {
		
		Versenyzo tesztObj = new Versenyzo("0123", "Teszt Elek", "Maraton SC", 1);
		assertTrue(tesztObj.eremSzerzo());
		
	}
	
	@Test 
	void getHelyezesTeszt(){
		
		Versenyzo tesztObj = new Versenyzo("0123", "Teszt Elek", "Maraton SC", 1);
		
		assertEquals(1, tesztObj.getHelyezes());
		
		
	}
	


}
