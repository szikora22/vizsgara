package okjRajtszamok;

public class Versenyzo {
	
	private byte rajtszam;
	private String orszagkod;
	private String nev;
	
	
	public Versenyzo(byte rajtszam, String orszagkod, String nev) {
		super();
		this.rajtszam = rajtszam;
		this.orszagkod = orszagkod;
		this.nev = nev;
	}
	
	public Versenyzo(String[] csvSor) {
		super();
		this.rajtszam = Byte.parseByte(csvSor[0]);
		this.orszagkod = csvSor[1];
		this.nev = csvSor[2];
	}

	public byte getRajtszam() {
		return rajtszam;
	}

	public String getOrszagkod() {
		return orszagkod;
	}

	public String getNev() {
		return nev;
	}
	
	
	@Override
	public String toString() {
		return rajtszam + " " + orszagkod + " " + nev ;
	}
	

}
