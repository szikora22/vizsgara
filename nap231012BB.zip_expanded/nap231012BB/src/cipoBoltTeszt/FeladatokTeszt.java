package cipoBoltTeszt;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import cipoBoltArraylist.Cipo;
import cipoBoltArraylist.Feladatok;

class FeladatokTeszt {

	@Test
	public void kilistazTeszt() {
		
		Feladatok feladatObj = new Feladatok();
		List<Cipo> cipok = new ArrayList<Cipo>();
		cipok.add(new Cipo("A0010", "félcipő", (byte)1, 27000, 12, LocalDate.now(), true));
		cipok.add(new Cipo("E0008", "edzőcipő", (byte)2, 34000, 10, LocalDate.now(), false));
		
		assertTimeout(Duration.ofMillis(100), () -> feladatObj.kilistaz(cipok));		
		
	}
	
	
	@Test
	public void csizmaAtlagarTeszt() {
		
		Feladatok feladatObj = new Feladatok();
		feladatObj.fajlBeolvasas("cipobolt.csv", ";");
		
		assertEquals(33633.33, feladatObj.csizmaAtlagar(), 0.01);
		
	}
	
	
	@Test
	public void osszesDBTeszt() {
		
		Feladatok feladatObj = new Feladatok();
		feladatObj.fajlBeolvasas("cipobolt.csv", ";");
		
		assertEquals(70, feladatObj.osszesDB());
		
		
	}
	
	
	@Test
	public void hanyHonapTeltelTeszt() {
		
		// előfeltétel: rendelkezésre áll egy adatokkal feltöltött lista:
		Feladatok feladatObj = new Feladatok();
		feladatObj.fajlBeolvasas("cipobolt.csv", ";");
		
		assertEquals(40, feladatObj.hanyHonapTeltel());
		
	}

}
