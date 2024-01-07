package osztalyzatokOOPStatikusan;

public class Tanulo {
	
	private String nev;
	private int matek;
	private int angol;
	private int tortenelem;
	
	
	public Tanulo(String nev, int matek, int angol, int tortenelem) {
		super();
		this.nev = nev;
		this.matek = matek;
		this.angol = angol;
		this.tortenelem = tortenelem;
	}
	
	public Tanulo() {
		
	}


	public String getNev() {
		return nev;
	}


	public int getMatek() {
		return matek;
	}


	public int getAngol() {
		return angol;
	}


	public int getTortenelem() {
		return tortenelem;
	}
	
	


	public void setNev(String nev) {
		this.nev = nev;
	}


	public void setMatek(int matek) {
		this.matek = matek;
	}


	public void setAngol(int angol) {
		this.angol = angol;
	}


	public void setTortenelem(int tortenelem) {
		this.tortenelem = tortenelem;
	}


	@Override
	public String toString() {
		return nev + " " + matek + " " + angol + " " + tortenelem;
	}
	
	public double atlagSzamitas() {
		
		return (matek+angol+tortenelem) / 3.0;
		
	}


	
	
	

}
