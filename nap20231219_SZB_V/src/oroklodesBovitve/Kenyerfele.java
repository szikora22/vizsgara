package oroklodesBovitve;

public class Kenyerfele extends Pekaru {
	
	private String tipus;

	public Kenyerfele(String megnevezes, String cikkszam, int ar, int db, boolean teljeskiorlesu, String tipus) {
		super(megnevezes, cikkszam, ar, db, teljeskiorlesu);
		this.tipus = tipus;
	}
	
	public String toString() {
		
		return super.toString()+" "+tipus;
		
	}
	
	
	public void tesztAlprogram() {
		
		System.out.println("Ez a kenyérféle leszármazott 2. szintű felülírt metódusa");
		
	}
	

}
