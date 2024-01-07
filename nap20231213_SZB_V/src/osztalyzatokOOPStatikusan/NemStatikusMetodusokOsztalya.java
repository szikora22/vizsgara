package osztalyzatokOOPStatikusan;

public class NemStatikusMetodusokOsztalya {
	
	public double osztalyAtlag(Tanulo[] tanulok) {
		
		double osszeg = 0.0;
		for (int i=0; i<tanulok.length; i++) {
			
			osszeg += tanulok[i].atlagSzamitas();			
			
		}
		double atlag = (double)osszeg / tanulok.length;
		
		return atlag;
		
	}
	

}
