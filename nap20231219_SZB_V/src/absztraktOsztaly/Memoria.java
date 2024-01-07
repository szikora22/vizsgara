package absztraktOsztaly;

public class Memoria extends GepAlkatresz {
	
	private String tipus;
	private byte kesleltetes;
	private double orajel;
	
	
	public Memoria(String megnevezes, String szeriaszam, int ar, double meret, String tipus, byte kesleltetes,
			double orajel) {
		super(megnevezes, szeriaszam, ar, meret);
		this.tipus = tipus;
		this.kesleltetes = kesleltetes;
		this.orajel = orajel;
	}


	public String getTipus() {
		return tipus;
	}


	public byte getKesleltetes() {
		return kesleltetes;
	}


	public double getOrajel() {
		return orajel;
	}


	@Override
	public double nemesfemTartalom() {
		
		return 15 * getMeret();
	}
	
	
	

}
