package osztalyzatokTeszt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import osztalyzatokOOPAdatbekeresselEllenorzesselKivetelDobassal.Tanulo;

class TanuloTeszt {

	@Test
	public void Tanuloteszt() {
		
		Tanulo tanulo = new Tanulo("valaki", 4, 2, 4);
		
		assertEquals(2, tanulo.getAngol());
		assertEquals("valaki", tanulo.getNev());
		assertEquals(4, tanulo.getMatek());
		assertEquals(4, tanulo.getTortenelem());
		
	}
	
	
	@Test
	public void setNevTesztJoertekkel() {
		
		Tanulo tanulo = new Tanulo();
		tanulo.setNev("valaki");
		assertEquals("valaki", tanulo.getNev());
		
		// assertEquals(4, tanulo.getTortenelem()); // még nem kapott értéket, nincs értelme tesztelni
	}
	
	
	@Test
	public void setNevTesztRosszertekkel() {
		
		Tanulo tanulo = new Tanulo();
		
		assertThrows(IllegalArgumentException.class, () -> tanulo.setNev(""));
		
	}
	
	
	@Test
	public void setAngolTesztJoertekkel() {
		
		Tanulo tanulo = new Tanulo();
		tanulo.setAngol(4);
		
		assertEquals(4, tanulo.getAngol());
		
		/* tipikusabb az equals használata, de ugyanez vizsgálható assertTrue-val is:
		assertTrue(tanulo.getAngol() == 4);
		*/
		
		/* nem ajánlott módszer, de akár így is elvégezhető a teszt:
		if (tanulo.getAngol() != 4) {
			
			fail("Nem állítódott be a megfelelő érték az adattagba!");
			
		}
		*/
	}
	
	
	@Test
	public void setAngolTesztRosszertekkel() {
		
		Tanulo tanulo = new Tanulo();
		
		assertThrows(IllegalArgumentException.class, () -> tanulo.setAngol(8));
		
		/* alternatív vizsgálat lehet, ha a kivételt lementjük és a tartalmát vizsgáljuk:
		Exception e = assertThrows(IllegalArgumentException.class, () -> tanulo.setAngol(8));
		assertTrue(e.getMessage().contains("angol"));
		*/
		
	}
	
	
	@Test
	public void toStringTeszt() {
		
		Tanulo tanulo = new Tanulo("valaki", 4, 2, 4);

		String elvartErtek = "valaki, matek=4, angol=2, tortenelem=4";
		
		assertEquals(elvartErtek, tanulo.toString());
		
	}
	
	
	@Test
	public void atlagSzamitasTeszt() {
		
		Tanulo tanulo = new Tanulo("valaki", 4, 2, 4);
		
		double elvartAtlag = 3.33;
		
		// double értéknél a pontosságban nem lehetünk biztosak, érdemes deltát használni.
		// az elvárt érték tizedesjegyeinek számával megegyező +értékkel:
		assertEquals(elvartAtlag, tanulo.atlagSzamitas(), 0.01);
		
	}
	
	
	@Test
	public void osztalyAtlagTeszt() {
		
		Tanulo[] tanulok = new Tanulo[3];
		tanulok[0] = new Tanulo("valaki", 4, 2, 4);
		tanulok[1] = new Tanulo("még valaki", 3, 5, 5);
		tanulok[2] = new Tanulo("harmadik tanuló", 5, 3, 4);
		
		double elvartAtlag = 3.888;
		
		assertEquals(elvartAtlag, Tanulo.osztalyAtlag(tanulok), 0.001 );
		
	}
	

}
