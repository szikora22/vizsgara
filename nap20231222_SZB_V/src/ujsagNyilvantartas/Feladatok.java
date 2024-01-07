package ujsagNyilvantartas;

import java.io.IOException;

public class Feladatok {

	private Ujsag[] ujsagok = null;
	private Ujsag ujsagObj;
	private FajlKezeles fajl = new FajlKezeles();
	
	public void ujsagBeolvas() {
		try {
			ujsagok = fajl.fajlBeolvas("ujsagok.csv", "-");
			System.out.println("Feladat II. - sikeres fájlbeolvasás");
		} 
		catch (Exception e) {
			System.err.println("Fájlbeolvasás sikertelen!");
		}
	}
	
	public void hetilapLista() {
		System.out.println("\nFeladat IV. - hetilapok listája:");
		for (Ujsag ujsag : ujsagok) {
			if (ujsag.getClass() == Hetilap.class) {
				System.out.println(ujsag.toString());
			}						
		}
	}
	
	/**
	 * Azon napilapok listája, melyek legalább 6x megjelennek egy héten
	 * @author BB
	 */
	public void napilap6x() {
		System.out.println("\nFeladat V. - legalább 6x megjelenő napilapok listája:");
		for (Ujsag ujsag : ujsagok) {
			if (ujsag.getClass() == Napilap.class && ((Napilap)ujsag).getHetiHanyszor()>=6) {
				System.out.println(ujsag.toString());
			}						
		}
	}
	
	public void altalanosUjsagSzam() {
		System.out.print("\nFeladat VI. - általános újságok száma: ");
		int ujsagSzam = 0;
		for (Ujsag ujsag : ujsagok) {
			if (ujsag.getClass() == Ujsag.class) {
				ujsagSzam++;
			}						
		}
		System.out.println(ujsagSzam);
	}
	
	public void legdragabb() {
		System.out.println("\nFeladat VII. - legdrágább sajtótermék megnevezése és áfatartalma: ");
		int max=0;
		for (int i=1;i<ujsagok.length;i++) {
			if (ujsagok[i].getAr()>ujsagok[max].getAr()) {
				max=i;
			}				
		}
		System.out.println(ujsagok[max].getMegnevezes()+" Áfatartalom: "+ujsagok[max].afaTartalomSzamit()+" Ft");
		
	}
	
	public void elsoNapilap() {
		System.out.println("\nFeladat VIII. - az első napilap és heti költsége: ");
		
		int i=0;
		while(i<ujsagok.length && ujsagok[i].getClass()!=Napilap.class) {
			i++;
		}
		if (i<ujsagok.length) {
			System.out.print(ujsagok[i].getMegnevezes()+" heti költsége: "
					+((Napilap)ujsagok[i]).hetiArkalkulacio()+" Ft\n");
		}
		else {
			System.out.println("Nincs napilap az adatok között...");
		}
	}
	
	public void ujsagBeker() {
		System.out.println("\nFeladat IX. - objektum létrehozása adatbekéréssel:");
		
		ujsagObj = new Adatkezeles().adatbekeresKonzolrol();
	}
	
	public void ujsagKiir() {
		System.out.print("Feladat X. - objektum fájlba kiírása ");
		try {
			fajl.FajlbaIr("ujsagok.csv", "-", ujsagObj);
			System.out.println(" - sikeres!");
		} catch (IOException e) {
			System.out.println(" - sikertelen!");
			System.err.println(e.getMessage());
		}
	}
}