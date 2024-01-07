package cipoBoltTeszt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import cipoBoltArraylist.Cipo;
import cipoBoltArraylist.FajlKezeles;

class FajlKezelesTeszt {

	@Test
	void fajlBeolvasTeszt() {
		
		FajlKezeles fajlobj = new FajlKezeles();
		
		assertEquals(12, fajlobj.fajlBeolvas("cipobolt.csv", ";").size());
		assertEquals("Alföldi", fajlobj.fajlBeolvas("cipobolt.csv", ";").get(3).getMegnevezes());
		
		// ha nem tudnánk hány elemű lista kell létrejöjjön és milyen adatokkal, akkor egyszerűbb tesztet kell írjunk:
		assertTrue(fajlobj.fajlBeolvas("cipobolt.csv", ";").size()>0);			
		
	}
	
	@Test
	void fajlBeolvasIntegraciosTeszt() {
	
		// ha az átvett paramétereket teszteljük, akkor két komponens közötti kommunikációt teszteljük,
		// tehát integrációs tesztet végzünk:
		
		FajlKezeles fajlobj = new FajlKezeles();
		
		// assertThrows(FileNotFoundException.class, () -> fajlobj.fajlBeolvas("cipo.csv", ";"));
		// mivel a fájlkezelés helyben lekezeli, ha nem létezik a fájl, a Throws nem vezet hibás teszthez
		// Ez esetben a lista hosszára tudunk ellenőrizni:
		assertTrue(fajlobj.fajlBeolvas("cipo.csv", ";").size()==0);
		assertTrue(fajlobj.fajlBeolvas("cipobolt.csv", "-").size()==0);
		
	}
	
	
	@Test
	void hibasTetelek() throws IOException {
		
		FajlKezeles fajlObj = new FajlKezeles();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("cipobolt.csv"),"UTF-8"));
		List<Cipo> cipok = new ArrayList<Cipo>(); 
		br.readLine();
		
		assertEquals(0, fajlObj.hibasTetelek(br, ";", cipok) );
		
	}
	
	@Test
	void hibasTetelek2() throws IOException {
		
		FajlKezeles fajlObj = new FajlKezeles();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("cipobolt2.csv"),"UTF-8"));
		List<Cipo> cipok = new ArrayList<Cipo>(); 
		br.readLine();
		
		assertEquals(2, fajlObj.hibasTetelek(br, ";", cipok) );
		
	}
	
	
	@Test
	void hazaiFajlbaIr() {
	
		FajlKezeles fajlObj = new FajlKezeles();
		List<Cipo> cipok = new ArrayList<Cipo>();
		cipok.add(new Cipo("A0010", "félcipő", (byte)1, 27000, 12, LocalDate.now(), true));
		
		fajlObj.hazaiFajlbaIr("hazai.txt", ";", cipok);				
		
		assertTrue(new File("hazai.txt").exists());		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
