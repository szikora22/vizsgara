package kasszaOOP;

/*
 Írjunk meg egy egyszerűsített családi kasszát kezelő programot. A kezdő egyenlegünk 300ezer forint. 
 Az alábbi menüpontokat lehessen elérni:
1., Bevétel rögzítése
2., Kiadás könyvelése
3., Egyenleg lekérdezése
4., Kilépés
A kiválasztott feladatot a ”Kassza” osztály valósítsa meg. */

public class Kassza {
	
	private int egyenleg;

	public Kassza(int egyenleg) {
		this.egyenleg = egyenleg;
		// itt is lehetne setter hívás a közvetlen értékadás helyett, ha példányosításkor már szükség van ellenőrzésre:
		// setEgyenleg(egyenleg);
		
		// vagy konstruktor túltöltéssel paraméter nélküliként létrehozva
		// a létrejövő érték nélküli objektum (ellenőrzött) setterein keresztül adjuk meg a kezdőértékeket
	}

	public int getEgyenleg() {
		return egyenleg;
	}

	public void setEgyenleg(int egyenleg) {
		
		if (egyenleg >= 0) {
		
			this.egyenleg = egyenleg;
			
		}
		else {
			// hibadobás!
			throw new IllegalArgumentException("Az egyenleg nem mehet át mínuszba!");
			// System.err.println("Az egyenleg nem mehet át mínuszba!"); //serr --> error, hibaüzenet pirossal kiírva
			
		}
		
	}
	
	
	public void bevetelKonyveles(int bevetel) {
		
		//egyenleg += bevetel;
		setEgyenleg(egyenleg+bevetel);
		
	}
	
	public void kiadasKonyveles(int kiadas) {
		
		// egyenleg -= kiadas;
		setEgyenleg(egyenleg-kiadas);
		
	}
	
	
	
	// Házi feladat: Írjunk egységteszteket korábbi projektekhez!
	// pl. nap230425/osztalyzatok... package 
	// állatmenhelyes program
	// cipőboltos program
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
