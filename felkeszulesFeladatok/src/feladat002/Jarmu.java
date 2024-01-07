package feladat002;

import java.time.LocalDate;

public class Jarmu {
	
	private String megnevezes;
	private String azonosito;
	private int gyartasEve;
	private int osszesMegtettKm;
	
	
	public Jarmu(String megnevezes, String azonosito, int gyartasEve, int osszesMegtettKm) {
		this.megnevezes = megnevezes;
		this.azonosito = azonosito;
		this.gyartasEve = gyartasEve;
		this.osszesMegtettKm = osszesMegtettKm;
	}
	
	
	public int atlagKmPerEv() {
		
		return ( osszesMegtettKm / (LocalDate.now().getYear() - gyartasEve));

	}


	@Override
	public String toString() {
		return "Megnevezés: " + megnevezes + " azonosító: " + azonosito + " gyártás éve: " + gyartasEve
				+ " összes megtett kilométer: " + osszesMegtettKm + " km";
	}
	
	


}
