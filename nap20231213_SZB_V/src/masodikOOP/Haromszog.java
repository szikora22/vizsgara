package masodikOOP;

public class Haromszog {
	
	private double aOldal;
	private double magassag;
	
	
	public Haromszog(double aOldal, double magassag) {
		super();
		this.aOldal = aOldal;
		this.magassag = magassag;
	}


	public double getaOldal() {
		return aOldal;
	}


	public double getMagassag() {
		return magassag;
	}
	
	
	public double teruletSzamitas() {
		
		return aOldal * magassag / 2;
		
	}
	
	
	
	

}
