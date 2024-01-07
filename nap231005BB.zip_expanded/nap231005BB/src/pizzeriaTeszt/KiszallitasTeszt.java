package pizzeriaTeszt;

import static org.junit.jupiter.api.Assertions.*; // statikus import, JUnit5-ös tesztmetódusait érhetjük el
//import org.junit.Assert; // JUnit4 importja

import java.time.Duration;
import java.time.LocalTime;

import org.junit.jupiter.api.Test; // annotációk importja

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import pizzeria.Kiszallitas;
import pizzeria.PizzeriaFoprogram;

@TestMethodOrder(OrderAnnotation.class)
class KiszallitasTeszt {
	
	/* osztályszintűre is hozhatnánk a tesztekhez használt objektumot, amit minden egységteszt előtt inicializálunk:
	Kiszallitas obj;
	
	@BeforeEach
	void inicializalas() {
		
		obj = new Kiszallitas("R001", 2);
		
	}
	*/

	@Test
	public void KiszallitasTeszt() { // példányosítás tesztje, a megfelelő árat rendeli-e hozzá az objektumhoz

		Kiszallitas kiszallObj = new Kiszallitas("R001", 3);

		int elvartAr = 1600;
		assertEquals(elvartAr, kiszallObj.getAr());

		// assertEquals(1600, kiszallObj.getAr());

		// helyes eredmény esetén zöld színnel, rossz eredmény esetén piros színnel
		// jelzi a teszt eredményét

	}

	@Test
	public void KiszallitasTesztHibadobas() {

		assertThrows(IllegalArgumentException.class, () -> new Kiszallitas("", 2));

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

		// az assertek utolsó paramétereként saját üzenetet is kiírathatunk, ha nem fut
		// le sikeresen a teszt:
		// assertTrue(e.getMessage().contains(elvartUzenet),"A kivétel objektum nem
		// tartalmazza az elvárt üzenetet, helyette amit dob: "+e.getMessage());

	}

	  @Disabled
	  @Test 
	  @Order(1) // ez a teszt fog elsőként lefutni. Ha van teszt ütemtervünk, az order segítségével állíthatjuk be a sorrendet
	  public void PizzeriaFoprogramTeszt() {
	  
	  assertTimeout(Duration.ofSeconds(130), () -> PizzeriaFoprogram.main(null));
	  
	  }
	 

	// ha nagy mennyiségű adatra van szükség, generáltathatunk a mockaroo.com
	// oldalon

	// feketedoboz teszttechnikát alkalmazva állapíthatjuk meg az optimális
	// teszteset számot és a konkrét tesztadatokat
	// ekvivalencia partíciók:
	// x < 0 (érvénytelen) ; 0 <= X <= 30 (teljes ár); 30 < X <= 40 (25%
	// kedvezmény); 40 < X <= 50 (50%) ; 50 < X <= 60 (75%) ; X > 60 (100%)

	// tesztadatok a bővített határérték elemzés alapján:
	// -1, 0, 1, 29, 30, 31, 39, 40, 41, 49, 50, 51, 59, 60, 61 vagyis 15 teszteset
	// szükséges

	// X = 61
	@Test
	public void kalkulacioTeszt() {

		Kiszallitas obj = new Kiszallitas("R0001", 3);

		obj.setKezbesitesIdeje(obj.getKiszallitasStart().plusSeconds(61));

		int elvartAr = 0;
		obj.kalkulacio();

		assertEquals(elvartAr, obj.getAr());

	}

	// X = 60
	@Test
	public void kalkulacioTeszt2() {

		Kiszallitas obj = new Kiszallitas("R0001", 3);

		obj.setKezbesitesIdeje(obj.getKiszallitasStart().plusSeconds(60));

		int elvartAr = 400;
		obj.kalkulacio();

		assertEquals(elvartAr, obj.getAr());

	}

	// X = 59
	@Test
	public void kalkulacioTeszt3() {

		Kiszallitas obj = new Kiszallitas("R0001", 3);

		obj.setKezbesitesIdeje(obj.getKiszallitasStart().plusSeconds(59));

		int elvartAr = 400;
		obj.kalkulacio();

		assertEquals(elvartAr, obj.getAr());

	}

	
	// ha túl sok tesztet kellene írni, ahol a kód nem változik, csak a tesztadatok, akkor ott érdemes paraméterezett tesztet készíteni:
	// a paramétereket adatszerkezetben kell tárolni, amit egy statikus metódus visszatérési értéke kell tartalmazzon:
	
	public static int[][] tesztadatok(){
		
		return new int[][] {
			
			{0,1600},
			{1, 1600},
			{29, 1600},
			{30, 1600},
			{31, 1200},
			{39, 1200},
			{40, 1200},
			{41, 800},
			{49, 800},
			{50, 800},
			{51, 400}
			
		};
		
	}
	
	@ParameterizedTest
	@MethodSource(value = "tesztadatok")
	public void kalkulacioParameterezettTeszt(int[] adat) {
		
		Kiszallitas obj = new Kiszallitas("R0001", 3);

		obj.setKezbesitesIdeje(obj.getKiszallitasStart().plusSeconds(adat[0]));

		int elvartAr = adat[1];
		obj.kalkulacio();

		assertEquals(elvartAr, obj.getAr());
		
	}
	
	
	// néhány további annotáció:
	// @BeforeEach --> minden teszteset előtt le fog futni a jelölt metódus
	// @BeforeAll --> egyszer, a tesztelés kezdetekor lefutó metódust jelöl
	// @AfterEach --> minden teszteset lefutása után aktivizálódó metódust jelöl
	// @AfterAll --> egyszer, a tesztelés végén lefutó metódust jelöl
	// @Disable --> kihagyja a tesztet
	// @RepeatedTest(x) --> x alkalommal futtatja az adott tesztet
	
	
	// assertEquals esetén megadható egy 'delta' paraméter, ami egy tűréshatárt ad meg az elvárt és a valós eredmény között
	// főleg valós számoknál érdemes használni, ahol a kerekítés miatt lehet eltérés
	
	@Test
	public void deltaTeszt() {
		
		double elvart = 3.33333;
		assertEquals(elvart, 10/(double)3, 0.00001);
		
	}
	
	
	
	
	
	
	
}
