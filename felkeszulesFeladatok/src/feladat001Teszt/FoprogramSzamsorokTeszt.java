package feladat001Teszt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import feladat001.FoprogramSzamsorok;

class FoprogramSzamsorokTeszt {

	@Test
	void legnagyobbTeszt() {
		
		int[] tomb = new int[] {10,25,6};
		
		int elvartLegnagyobbIndex = 1;
		assertEquals(elvartLegnagyobbIndex, FoprogramSzamsorok.legnagyobb(tomb));
		
	}
	
	
	@Test
	void feltoltTeszt() {
		
		int darab=6;
		int minimumErtek=10;
		int maximumErtek=20;
		
		assertEquals(darab, FoprogramSzamsorok.feltolt(darab, minimumErtek, maximumErtek).length);
		
	}

}
