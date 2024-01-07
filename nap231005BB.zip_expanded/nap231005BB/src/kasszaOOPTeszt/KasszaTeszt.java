package kasszaOOPTeszt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kasszaOOP.Kassza;

class KasszaTeszt {
	
	Kassza kasszaObj;
	
	@BeforeEach
	public void kasszaInicializal() {
		
		kasszaObj = new Kassza(400000);
		
	}
	

	@Test
	void kasszaTeszt() {				
		
		// Kassza kasszaObj = new Kassza(400000);
		// ha nem BeforeEach, akkor minden teszt elejére kell az objektum létrehozás 
		
		assertEquals(400000,kasszaObj.getEgyenleg());
		
		/* TILOS!!! ilyenekért a képesítőn 0 pont jár:
		assertEquals(Kassza.class,kasszaObj.getClass());
		assertEquals(1,1);
		*/
		
	}
	
	
	@Test
	void setEgyenlegTesztJoErtekkel() {
		
		kasszaObj.setEgyenleg(500000);
		assertEquals(500000,kasszaObj.getEgyenleg());
		
	}
	
	
	@Test
	void setEgyenlegTesztRosszErtekkel() {
		
		
		assertThrows(IllegalArgumentException.class, () -> kasszaObj.setEgyenleg(-10000));
		
	}
	
	
	@Test
	void bevetelKonyvelesTeszt() {
		
		int elvart = 500000;
		kasszaObj.bevetelKonyveles(100000);
		
		assertEquals(elvart, kasszaObj.getEgyenleg() );
		
	}
	
	@Test
	void kiadasKonyvelesTeszt() {
		
		int elvart = 250000;
		kasszaObj.kiadasKonyveles(150000);
		assertEquals(elvart, kasszaObj.getEgyenleg());
		
	}
	
	

}
