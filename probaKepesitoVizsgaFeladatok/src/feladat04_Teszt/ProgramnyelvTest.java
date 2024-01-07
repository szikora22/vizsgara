package feladat04_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import feladat04_JavaFajlkezeles.Programnyelv;

class ProgramnyelvTest {

	@Test
	void valtozasMertekeTeszt() {
		
		Programnyelv nyelvObj = new Programnyelv("Ada", 1983, 12000, 14, 10000);
		double elvartEredmeny = 20.0;
		assertEquals(elvartEredmeny,nyelvObj.valtozasMerteke(),0.01);
		
	}
	
	
	
	
	

}
