package feladat02;

import java.time.LocalDate;

public class Noveny {
	
	private String azonosito;
	private String megnevezes;
	private String latinNev;
	private int bekerulesEve;
	
	
	public Noveny(String azonosito, String megnevezes, String latinNev, int felfedezesEve) {
		
		this.azonosito = azonosito;
		this.megnevezes = megnevezes;
		this.latinNev = latinNev;
		this.bekerulesEve = felfedezesEve;
		
	}
	

	public int hanyEveLatogathato() {
		
		return LocalDate.now().getYear() - bekerulesEve;
		
	}
	
	public void tipus() {
		System.out.println("A növény egy általános növény");
	}


	@Override
	public String toString() {
		return azonosito + " " + megnevezes + " " + latinNev + " " + bekerulesEve;
	}
	
	
	
	

}
