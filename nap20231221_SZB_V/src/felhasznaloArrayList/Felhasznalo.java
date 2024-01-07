package felhasznaloArrayList;

public class Felhasznalo {
	
	private String azonosito;
	private int jogosultsag;
	private String nev;
	
	
	public Felhasznalo(String azonosito, int jogosultsag, String nev) {
		super();
		this.azonosito = azonosito;
		this.jogosultsag = jogosultsag;
		this.nev = nev;
	}
	
	public Felhasznalo(String[] csvSor) {
		super();
		this.azonosito = csvSor[0];
		this.jogosultsag = Integer.parseInt(csvSor[1]);
		this.nev = csvSor[2];
	}
	
	
	

	private String getJogosultsag() {
		
		if (jogosultsag == 1) {
			
			return "vendég";
			
		}
		else if (jogosultsag == 2) {
			
			return "felhasználó";
		}
		else {
			
			return "admin";
		}
		
		
	}

	

	@Override
	public String toString() {
		return azonosito + " " + getJogosultsag() + " " + nev;
	}
	
	
	

}
