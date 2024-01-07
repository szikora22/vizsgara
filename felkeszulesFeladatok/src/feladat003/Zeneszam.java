package feladat003;

public class Zeneszam {
	
	private String egyuttes;
	private String lemezCime;
	private int kiadasEve;
	
	public String getEgyuttes() {
		return egyuttes;
	}

	public Zeneszam(String egyuttes, String lemezCime, int kiadasEve) {
		super();
		this.egyuttes = egyuttes;
		this.lemezCime = lemezCime;
		this.kiadasEve = kiadasEve;
	}

	@Override
	public String toString() {
		return egyuttes + " " + lemezCime + " " + kiadasEve;
	}	
	
	
	
	
	

}
