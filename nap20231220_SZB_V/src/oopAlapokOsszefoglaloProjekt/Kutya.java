package oopAlapokOsszefoglaloProjekt;

public class Kutya extends Allat {
	
	private int marmagassag;
	

	public Kutya(String nev, int suly, int marmagassag) {
		super(nev, suly);
		this.marmagassag = marmagassag;
	}
	


	public int getMarmagassag() {
		return marmagassag;
	}




	public void setMarmagassag(int marmagassag) {
		if (marmagassag >= 10) {
			this.marmagassag = marmagassag;
		}
		else {
			throw new IllegalArgumentException("A marmagasság nem lehet kisebb, mint 10 centiméter!");
		}
	}




	@Override
	public String toString() {
		return super.toString() +  " marmagasság: " + marmagassag + " cm";
	}



	@Override
	public double napiEtelAdag() {
		
		return getSuly() / 50.0;
	}

}
