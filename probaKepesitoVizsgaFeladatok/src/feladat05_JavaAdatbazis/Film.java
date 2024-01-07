package feladat05_JavaAdatbazis;

public class Film {
	
	private String azonosito;
	private String filmCim;
	private int bemutatoEve;
	private long osszBevetel;
	private boolean oscar;
	
	
	public Film(String azonosito, String filmCim, int bemutatoEve, long osszBevetel, boolean oscar) {

		this.azonosito = azonosito;
		this.filmCim = filmCim;
		this.bemutatoEve = bemutatoEve;
		this.osszBevetel = osszBevetel;
		this.oscar = oscar;
	}


	public String getAzonosito() {
		return azonosito;
	}


	public String getFilmCim() {
		return filmCim;
	}


	public int getBemutatoEve() {
		return bemutatoEve;
	}


	public long getOsszBevetel() {
		return osszBevetel;
	}


	public boolean isOscar() {
		return oscar;
	}
	
	
	@Override
	public String toString() {
		return  filmCim + ", bemutató éve: " + bemutatoEve + ", összbevétel: " + osszBevetel + " $" 
				+ ((oscar)?"Oscar díjas":"nem kapott Oscar díjat");
	}
	

}
