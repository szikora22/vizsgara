package vallalkozasApp;

public class Vallalkozasok {

	private static int idSzamlalo = 1;
	
	private int[] haviEredmenyek;
	private int id;
	
	public Vallalkozasok(int[] haviEredmenyek) {
		super();		
		this.id = idSzamlalo++;
		this.haviEredmenyek = haviEredmenyek;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int[] getHaviEredmenyek() {
		return haviEredmenyek;
	}
	
	public int getHaviEredmenyek(int honapIndex) {
		
		return haviEredmenyek[honapIndex];
		
	}

	public int nyeresegKiszamol() {
		int osszeg = 0;		
		for (int elem : haviEredmenyek) {			
			osszeg += elem;			
		}		
		return osszeg;
	}

	public int vesztesegesHonapKiszamol() {
		int vesztesegesHonapokSzama = 0;			
		for (int elem : haviEredmenyek) {			
			if(elem<0) {				
				vesztesegesHonapokSzama++;								
			}			
		}		
		return vesztesegesHonapokSzama;
	}

	
	
	
}
