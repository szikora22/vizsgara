package oopAlapokOsszefoglaloProjekt;

public abstract class Allat {
	
	private String nev;
	private int suly;
	
	
	public Allat(String nev, int suly) {
		super();
		setNev(nev);
		setSuly(suly);
	}


	public String getNev() {
		return nev;
	}


	public void setNev(String nev) {
		if (nev != null && !nev.isEmpty()) {
			this.nev = nev;
		}
		else {
			throw new IllegalArgumentException("A név mező kitöltése kötelező!");
		}
	}


	public int getSuly() {
		return suly;
	}


	public void setSuly(int suly) {
		if (suly>=2) {
			this.suly = suly;
		}
		else {
			throw new IllegalArgumentException("Súly nem lehet kisebb, mint 2 kilogramm!");
		}
				
	}


	@Override
	public String toString() {
		return "Az állat neve: " + nev + " Testsúly: " + suly + " kg";
	}
	
	
	
	
	public abstract double napiEtelAdag();
		
	

}
