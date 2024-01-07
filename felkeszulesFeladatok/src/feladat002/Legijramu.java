package feladat002;

public class Legijramu extends Jarmu implements IRepul {
	
	double fesztavolsag;

	
	public Legijramu(String megnevezes, String azonosito, int gyartasEve, int osszesMegtettKm, double fesztavolsag) {
		super(megnevezes, azonosito, gyartasEve, osszesMegtettKm);
		this.fesztavolsag = fesztavolsag;
	}


	@Override
	public double repulesiIdo(int megtettTavolsagKm, int atlagSebessegKmH) {
		// TODO Auto-generated method stub
		return (double)megtettTavolsagKm / atlagSebessegKmH;
	}


	@Override
	public String toString() {
		return super.toString() + " fesztávolság: " + fesztavolsag + " méter";
	}
	
	
	
	
	

}
