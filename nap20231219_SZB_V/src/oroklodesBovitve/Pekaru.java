package oroklodesBovitve;

public class Pekaru extends Termek {
	
	private boolean teljeskiorlesu;

	public Pekaru(String megnevezes, String cikkszam, int ar, int db, boolean teljeskiorlesu) {
		super(megnevezes, cikkszam, ar, db);
		this.teljeskiorlesu = teljeskiorlesu;
	}

	@Override
	public String toString() {
		return super.toString() + " " + (teljeskiorlesu ? "teljes kiőrlésű" : "nem teljes kiőrlésű");
	}
	
	public void tesztAlprogram() {
		System.out.println("Ez a pékárú leszármazott felülírt metódusa");
	}

}
