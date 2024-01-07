package feladat03_JavaKollekciok;

public class Versenyzo {
	
	private String rajtszam;
	private String nev;
	private String egyesulet;
	private int helyezes;
	
	
	public Versenyzo(String rajtszam, String nev, String egyesulet, int helyezes) {

		this.rajtszam = rajtszam;
		this.nev = nev;
		this.egyesulet = egyesulet;
		this.helyezes = helyezes;
	}
	
	
	public boolean eremSzerzo() {
		
		return helyezes >=1 && helyezes <= 3;
		
	}


	@Override
	public String toString() {
		
		return "Versenyző rajtszáma: " + rajtszam + " neve: " + nev + " egyesülete: " 
				+ egyesulet + " helyezése: " + helyezes;
		
	}


	public int getHelyezes() {
		return helyezes;
	}

}
