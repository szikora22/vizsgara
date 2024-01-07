package cipoBoltTeszt;

// Az egységtesztek két fontos szabálya:
// @Test annotációval jelezni kell a metódus előtt, hogy tesztmetódusként akarjuk használni
// az egységteszt metódusok mindig void típusúak

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import cipoBoltArraylist.Cipo;

class CipoTeszt {

	@Test
	public void CipoTeszt() {
		
		Cipo cipo = new Cipo("A0010", "félcipő", (byte)1, 27000, 12, LocalDate.now(), false);
		
		assertEquals(27000, cipo.getAr());		
		
	}
	
	
	@Test
	public void CipoTeszt2() {
		
		Cipo cipo = new Cipo(new String[] {"A0010", "félcipő", "1", "27000", "12", LocalDate.now().toString(), "0"});
		
		assertEquals(27000, cipo.getAr());	
		
	}
	
	
	@Test
	public void getTipusSzovegesenTeszt() {
		
		Cipo cipo = new Cipo("A0010", "félcipő", (byte)1, 27000, 12, LocalDate.now(), false);
		
		String elvartEredmeny = "alkalmi cipő";
		
		assertEquals(1, cipo.getTipus());
		assertEquals(elvartEredmeny, cipo.getTipusSzovegesen());	
		
	}
	
	
	@Test
	public void getHazaiTermekSzovegesenTeszt() {
		
		Cipo cipo = new Cipo("A0010", "félcipő", (byte)1, 27000, 12, LocalDate.now(), false);
		
		String elvartEredmeny = "import termék";
		
		assertEquals(elvartEredmeny, cipo.getHazaiTermekSzovegesen());	
		
	}
	
	
	@Test
	public void getHazaiTermekSzovegesenTeszt2() {
		
		Cipo cipo = new Cipo("A0010", "félcipő", (byte)1, 27000, 12, LocalDate.now(), true);
		
		String elvartEredmeny = "hazai termék";
		
		assertEquals(elvartEredmeny, cipo.getHazaiTermekSzovegesen());	
		
	}
	
	
	@Test
	public void toStringTeszt() {
		
		Cipo cipo = new Cipo("A0010", "félcipő", (byte)1, 27000, 12, LocalDate.now(), true);
		
		String elvartEredmeny = "A0010 félcipő alkalmi cipő 27000 Ft 12 db 2023.10.12 hazai termék";
		
		assertEquals(elvartEredmeny, cipo.toString());
		
		
	}

}
