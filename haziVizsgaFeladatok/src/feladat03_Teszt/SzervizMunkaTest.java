package feladat03_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import feladat03.SzervizMunka;

class SzervizMunkaTest {

	@Test
	void arKepzesTeszt() {
		
		int oradij = 5000;
		SzervizMunka tesztObj = new SzervizMunka("olajcsere", 2);
		int elvartErtek = 10000;
		
		assertEquals(elvartErtek,tesztObj.arKepzes(oradij));
		
	}

}
