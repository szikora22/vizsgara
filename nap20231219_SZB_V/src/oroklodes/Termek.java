package oroklodes;

/*
Készítsünk programot, mely egy vegyeskereskedés (ABC) alapszintű raktárkezelését látja el.
 Alapvetően kétféle termékkategóriát kell tároljunk:
Tejtermék
Zsírtartalom
Pékáru
Teljeskiőrlésű-e
Minden termékről tudjuk a következőket:
Megnevezés
Cikkszám
Ár
Darabszám
Minden olyan termék, ami nem tartozik egyik kategóriába sem, általános termékként legyen tárolva. 
Hozzuk létre az adatszerkezetet és egy-egy objektumot minden típushoz.

*/

public class Termek {
	
	private String megnevezes;
	private String cikkszam;
	private int ar;
	private int db;
	
	public Termek(String megnevezes, String cikkszam, int ar, int db) {
		super();
		this.megnevezes = megnevezes;
		this.cikkszam = cikkszam;
		this.ar = ar;
		this.db = db;
	}

	public String getMegnevezes() {
		return megnevezes;
	}

	public String getCikkszam() {
		return cikkszam;
	}

	public int getAr() {
		return ar;
	}

	public int getDb() {
		return db;
	}

	@Override
	public String toString() {
		return "Termék megnevezése: " + megnevezes + ", cikkszáma: " + cikkszam + ", ára=" + ar + "Ft, " + db + "db";
	}
	
	
	public void tesztAlprogram() {
		System.out.println("Ez az ősosztály metódusa");
	}
	
	

}
