package absztraktOsztaly;

public abstract class GepAlkatresz {
	
	private String megnevezes;
	private String szeriaszam;
	private int ar;
	private double meret; //cm2
	
	
	public GepAlkatresz(String megnevezes, String szeriaszam, int ar, double meret) {
		super();
		this.megnevezes = megnevezes;
		this.szeriaszam = szeriaszam;
		this.ar = ar;
		this.meret = meret;
	}


	public String getMegnevezes() {
		return megnevezes;
	}


	public String getSzeriaszam() {
		return szeriaszam;
	}


	public int getAr() {
		return ar;
	}


	public double getMeret() {
		return meret;
	}
	
	@Override
	public String toString() {
		
		return megnevezes + " " + szeriaszam + " " + ar + " Ft " + meret + " cm2";
		
	}
	
	
	public abstract double nemesfemTartalom();
	

}
