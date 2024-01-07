package feladat02;

public class Fa extends Noveny {
	
	private int faMagassag;
	
	
	public Fa(String azonosito, String megnevezes, String latinNev, int felfedezesEve, int faMagassag) {
		super(azonosito, megnevezes, latinNev, felfedezesEve);
		this.faMagassag = faMagassag;
	}
	
	


	@Override
	public String toString() {
		return super.toString() + " " + faMagassag + " méter";
	}
	
	@Override
	public void tipus() {
		System.out.println("A növény egy fa");
	}
	
	
	
	
	

}
