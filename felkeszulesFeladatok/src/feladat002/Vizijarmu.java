package feladat002;

public class Vizijarmu extends Jarmu {
	
	private int viszkiszoritas;
	
	

	public Vizijarmu(String megnevezes, String azonosito, int gyartasEve, int osszesMegtettKm, int viszkiszoritas) {
		super(megnevezes, azonosito, gyartasEve, osszesMegtettKm);
		this.viszkiszoritas = viszkiszoritas;
	}



	@Override
	public String toString() {
		
		return super.toString() +  " Vízkiszorítás: " + viszkiszoritas + " liter";
	}
	
	
	
	
	
	
	

}
