package absztraktOsztaly;

public class Processzor extends GepAlkatresz {
	
	private String tokozas;
	private double orajel;
	
	public Processzor(String megnevezes, String szeriaszam, int ar, double meret, String tokozas, double orajel) {
		super(megnevezes, szeriaszam, ar, meret);
		this.tokozas = tokozas;
		this.orajel = orajel;
	}

	


	public String getTokozas() {
		return tokozas;
	}




	public double getOrajel() {
		return orajel;
	}




	@Override
	public double nemesfemTartalom() {
		
		return 20 * getMeret();
		
	}

}
