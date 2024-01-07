package feladat05_Teszt;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import feladat05_JavaAdatbazis.ABKezelo;
import feladat05_JavaAdatbazis.Film;

class ABKezeloTeszt {


	@Test
	void ujFilmTeszt() {
		
		Film ujFilmObj = new Film("F00009","Shrek",2000,250000000,true);
		
		try {
			
			ABKezelo.csatlakozas();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		assertDoesNotThrow(() -> ABKezelo.ujFilm(ujFilmObj));
		
	}
	
	@Test
	void filmekBeolvasaTeszt() {
		
		try {
			
			ABKezelo.csatlakozas();
			assertTrue(ABKezelo.filmekBeolvasasa().size()>0);
			
		}catch (Exception e) {
			
		}
		
		
	}

}
