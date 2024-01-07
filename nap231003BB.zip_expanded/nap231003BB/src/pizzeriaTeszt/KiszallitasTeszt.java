package pizzeriaTeszt;

import static org.junit.jupiter.api.Assertions.*; // statikus import, JUnit5-ös tesztmetódusait érhetjük el

import java.time.Duration;
import java.time.LocalTime;

// import org.junit.Assert; // JUnit4 importja

import org.junit.jupiter.api.Test; // annotációk importja

import pizzeria.Kiszallitas;
import pizzeria.PizzeriaFoprogram;

class KiszallitasTeszt {

	@Test
	public void KiszallitasTeszt() { // példányosítás tesztje, a megfelelő árat rendeli-e hozzá az objektumhoz
		
		Kiszallitas kiszallObj = new Kiszallitas("R001", 3);
		int elvartAr = 1600;
		assertEquals(elvartAr, kiszallObj.getAr());
		
		// helyes eredmény esetén zöld színnel, rossz eredmény esetén piros színnel jelzi a teszt eredményét
		
	}
	
	
	@Test
	public void KiszallitasTesztHibadobas() {
		
		assertThrows( IllegalArgumentException.class, () -> new Kiszallitas("", 2)  );
		
	}
	
	@Test
	public void KiszallitasTesztHibadobas2() {
		
		assertThrows(IllegalArgumentException.class, () -> new Kiszallitas("R0001", 0));
		
	}
	
	
	@Test
	public void setKezbesitesIdejeTeszt() {
		
		Kiszallitas kiszallObj = new Kiszallitas("R0001", 2);
		LocalTime hibasIdo = kiszallObj.getKiszallitasStart().minusSeconds(1);
		
		assertThrows(IllegalArgumentException.class, () -> kiszallObj.setKezbesitesIdeje(hibasIdo));
		
	}
	
	
	@Test
	public void KiszallitasTesztMelyikHibauzenet() {
		
		Exception e = assertThrows(IllegalArgumentException.class, () -> new Kiszallitas("R001", 9));
		String elvartUzenet = "Darab";
		
		assertTrue(e.getMessage().contains(elvartUzenet));
		
	}
	
	
	@Test
	public void PizzeriaFoprogramTeszt() {
		
		assertTimeout(Duration.ofSeconds(130), () -> PizzeriaFoprogram.main(null));
		
	}
	
	
	// ha nagy mennyiségű adatra van szükség, generáltathatunk a mockaroo.com oldalon
	
	
	
	
	

}
