package osztalyzatokTeszt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import osztalyzatokOOPAdatbekeresselEllenorzesselKivetelDobassal.Adatkezeles;
import osztalyzatokOOPAdatbekeresselEllenorzesselKivetelDobassal.Tanulo;

class AdatkezelesTeszt {

	@Test
	public void adatokKonzolrolTeszt() {
		
		Adatkezeles adatobj = new Adatkezeles();
		
		// ellenőrizzük, hogy nem null értéket ad vissza a metódus:
		assertNotNull(adatobj.adatokKonzolrol());
				
	}
	
	@Test
	public void adatokKonzolrolTesztMeghatarozottAdatokkal() {
		
		Adatkezeles adatobj = new Adatkezeles();
		
		// közvetlenül nem adhatjuk meg az objektum adatait (hiszen a konzolról érkeznek),
		// de meghatározhatjuk milyen adatokkal legyen létrehozva az objektum:
		
		// a következő adatokkal történjen az adatbevitel:
		// név: "valaki" matek: 4, angol: 2, töri: 4);		
		
		assertEquals("valaki", adatobj.adatokKonzolrol().getNev() );
		
		
	}

}
