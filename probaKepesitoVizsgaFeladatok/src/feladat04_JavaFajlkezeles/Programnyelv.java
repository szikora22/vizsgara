package feladat04_JavaFajlkezeles;


public class Programnyelv {
	
	private String megnevezes;
	private int megjelenesEv;
	private long keresesekSzama;
	private int elozoHaviHelyezes;
	private long elozoHaviKeresesekSzama;
	
	
	public Programnyelv(String megnevezes, int megjelenesEv, long keresesekSzama, int elozoHaviHelyezes,
			long elozoHaviKeresesekSzama) {

		this.megnevezes = megnevezes;
		this.megjelenesEv = megjelenesEv;
		this.keresesekSzama = keresesekSzama;
		this.elozoHaviHelyezes = elozoHaviHelyezes;
		this.elozoHaviKeresesekSzama = elozoHaviKeresesekSzama;
	}
	
	
	public double valtozasMerteke() {
		
		return (((double)keresesekSzama / elozoHaviKeresesekSzama)-1)*100 ;
		
	}


	public String getMegnevezes() {
		return megnevezes;
	}


	public int getMegjelenesEv() {
		return megjelenesEv;
	}


	public long getKeresesekSzama() {
		return keresesekSzama;
	}


	public int getElozoHaviHelyezes() {
		return elozoHaviHelyezes;
	}


	public long getElozoHaviKeresesekSzama() {
		return elozoHaviKeresesekSzama;
	}
	
	
	

}
