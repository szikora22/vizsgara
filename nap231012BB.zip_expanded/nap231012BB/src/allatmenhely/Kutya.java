package allatmenhely;

public final class Kutya extends Allat {
	
	private int marmagassag;

	public Kutya(String nev, int suly, int marmagassag) {
		
		super(nev, suly);
		setMarmagassag(marmagassag);
		
	}

	public int getMarmagassag() {
		return marmagassag;
	}

	private void setMarmagassag(int marmagassag) {
		
		if (marmagassag >= 10) {
			
			this.marmagassag = marmagassag;
			
		}
		else {
			
			throw new IllegalArgumentException("A marmagasság legalább 10 cm kell legyen!");
			
		}
		
	}

	
	@Override
	public double napiEtelAdag() {
		
		return getSuly()/50.0;
		
	}

	@Override
	public String toString() {
		
		return getNev() + " " + getSuly() + " kg " + marmagassag + " cm";
		
	}
	
	
	

}
