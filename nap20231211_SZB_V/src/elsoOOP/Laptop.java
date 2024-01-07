package elsoOOP;

public class Laptop {
	
	// I. egység: változók / adattag / field / mező
	
	private String gyarto;
	private String tipus;
	private String cikkszam;
	private int ar;	
	

	
	// II. egység: konstruktor
	
	
	//1. példa: Ár kivételével az adatokat a példányt létrehozó adja meg, ár legye fix 300000;
	
	public Laptop(String gyar, String tip, String cikk) {
		super();
		gyarto = gyar;
		tipus = tip;
		cikkszam = cikk;
		ar = 30000;
	}

	


	
	// 2. példa: minden adat átadásra kerül példányosításkor:
	
	public Laptop(String gyarto, String tipus, String cikkszam, int ar) {
		super();
		this.gyarto = gyarto;
		this.tipus = tipus;
		this.cikkszam = cikkszam;
		this.ar = ar;
	}
	
	// 3. példa. objektum létrehozása értékek nélkül, későbbi értékadással
	
		public Laptop() {
			
		}


		// III. egység getter/setter:


		public String getGyarto() {
			return gyarto;
		}





		public void setGyarto(String gyarto) {
			this.gyarto = gyarto;
		}





		public String getTipus() {
			return tipus;
		}





		public void setTipus(String tipus) {
			this.tipus = tipus;
		}





		public String getCikkszam() {
			return cikkszam;
		}





		public void setCikkszam(String cikkszam) {
			this.cikkszam = cikkszam;
		}





		public int getAr() {
			return ar;
		}





		public void setAr(int ar) {
			this.ar = ar;
		}
		
		
		// IV. metódusok:
		
		public String mindenAdat() { // később ezt a toString() metódussal végezzük
			
			return gyarto + " " + tipus + " " + ar;
			
		}
		
		
	

}
