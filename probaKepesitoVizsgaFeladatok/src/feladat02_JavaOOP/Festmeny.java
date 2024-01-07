package feladat02_JavaOOP;


public class Festmeny {
	
	private String cim;
	private String festo;
	private int alkotasEve;
	private long becsultErtek;
	
	
	public Festmeny(String cim, String festo, int alkotasEve, long becsultErtek) {

		this.cim = cim;
		this.festo = festo;
		this.alkotasEve = alkotasEve;
		setBecsultErtek(becsultErtek);

	}
	
	


	public void setBecsultErtek(long becsultErtek) {
		if (becsultErtek >= 1000000) {
			this.becsultErtek = becsultErtek;
		}
		else {
			throw new IllegalArgumentException("A festmény értéke nem lehet kisebb 1 millió forintnál!");
		}
	}



	public long ertekkovetes(int szazalek) {
		
		return (long)(becsultErtek + (becsultErtek * (szazalek/100.0)));
		
	}




	@Override
	public String toString() {
		return cim + " " + festo + " " + alkotasEve + " "
				+ becsultErtek + " EUR";
	}
	
	
	
	

}
