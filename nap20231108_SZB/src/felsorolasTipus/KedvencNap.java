package felsorolasTipus;

public class KedvencNap {
	
	private String nev;
	private Napok2 kedvencnap;
	
	@Override
	public String toString() {
		return nev + "kedvenc napja: " + kedvencnap.toString();
	}


	public KedvencNap(String nev, Napok2 kedvencnap) {
		this.nev = nev;
		this.kedvencnap = kedvencnap;
	}
	
	
	public KedvencNap(String nev, String kedvencNapSzovegesen) {
		
		this.nev = nev;
		this.kedvencnap = Napok2.megnevezesKonvertalo(kedvencNapSzovegesen);
		
	}


	public Napok2 getKedvencnap() {
		return kedvencnap;
	}
	

}
