package allatmenhelyTeszt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import allatmenhely.Kutya;

class KutyaTeszt {

	@Test
	void KutyaTeszt() {
		
		Kutya kutya = new Kutya("Blöki",20,40);
		
		assertEquals(40, kutya.getMarmagassag());	
		
	}
	
	
	@Test
	void setMarmagassagTeszt() {
		
		assertThrows(IllegalArgumentException.class, () -> new Kutya("Blöki", 20, 5));
		
	}
	
	
	@Test
	void napiEtelAdagTeszt() {
		
		Kutya kutya = new Kutya("Blöki",20,40);
		
		assertEquals(0.4, kutya.napiEtelAdag());
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
