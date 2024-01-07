package ujsagNyilvantartas;

public class Ujsag {

	private String megnevezes;
	private String kiado;
	private int ar;
	
	
	public Ujsag(String megnevezes, String kiado, int ar) {
		setMegnevezes(megnevezes);
		setKiado(kiado);
		setAr(ar);
	}
	
	public Ujsag(String[] csvSor) {
		this.megnevezes = csvSor[1];
		this.kiado = csvSor[2];
		this.ar = Integer.parseInt(csvSor[3]);
	}
	
	public String getMegnevezes() {
		return megnevezes;
	}

	public void setMegnevezes(String megnevezes) {
		if (megnevezes !=null && !megnevezes.isEmpty()) {
			this.megnevezes = megnevezes;
		}
		else {
			throw new IllegalArgumentException("Megnevezés mező kitöltése kötelező!");
		}
		
	}

	public String getKiado() {
		return kiado;
	}

	public void setKiado(String kiado) {
		if (kiado !=null && !kiado.isEmpty()) {
			this.kiado = kiado;
		}
		else {
			throw new IllegalArgumentException("Kiadó mező kitöltése kötelező!");
		}
	}

	public int getAr() {
		return ar;
	}

	public void setAr(int ar) {
		if (ar >=0 ) {
			this.ar = ar;	
		}
		else {
			throw new IllegalArgumentException("Az ár nem lehet negatív értékű!");
		}
		
	}
	
	public int afaTartalomSzamit() {
		
		return (int) (this.ar * 0.05);	
		
	}

	@Override
	public String toString() {
		return this.megnevezes + " " + this.kiado + " " + this.ar + " Ft";
	}	
	
}
