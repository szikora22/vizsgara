package felsorolasTipus;

public enum Napok2 {
	
	HETFO("hétfő"), KEDD("kedd"), SZERDA("szerda"), CSUTORTOK("csütörtök"), PENTEK("péntek"), SZOMBAT("szombat"), VASARNAP("vasárnap");
	
	private final String megnevezes; 
	
	
	private Napok2(String megnevezes) {
		
		this.megnevezes = megnevezes;
		
	}
	
	public String toString() {
		
		return megnevezes;
		
	}
	
	public static Napok2 megnevezesKonvertalo(String megnevezes) {
		
		for (Napok2 egynap : Napok2.values()) {
			
			if (egynap.megnevezes.equals(megnevezes) || egynap.name().equals(megnevezes)) {
				
				return egynap;
				
			}
			
		}
		
		return null;
		
	}
	
	

}
