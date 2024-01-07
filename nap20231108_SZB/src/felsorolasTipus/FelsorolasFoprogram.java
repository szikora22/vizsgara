package felsorolasTipus;

public class FelsorolasFoprogram {

	public static void main(String[] args) {
		
		Napok nap = Napok.SZERDA;
		
		System.out.println(nap);
		
		System.out.println(nap.ordinal());
		
		switch (nap) {
		
		case HETFO:
		case KEDD:
			System.out.println("hét eleje van");
			break;
		case SZERDA:
		case CSUTORTOK:
			System.out.println("hét közepe van");
			break;
		default:
			System.out.println("HÉTVÉGE!!!");
			break;
		}

		System.out.println(nap.getClass());
		System.out.println(nap.getClass().getSuperclass());
		
		Napok[] napok = Napok.values();
		for (Napok egyNap : napok) {
			
			System.out.println(egyNap.name()+" "+egyNap.ordinal());
		}
		
		Napok2 masiknap = Napok2.VASARNAP;
		System.out.println(masiknap.toString());
		System.out.println(masiknap.name());
		
		
		KedvencNap napObj1 = new KedvencNap("Teszt Elek", Napok2.KEDD);
		System.out.println(napObj1.getKedvencnap());
		System.out.println(napObj1.toString());
		
		KedvencNap napObj2 = new KedvencNap("botlik Béla", "PENTEK");
		System.out.println(napObj2.getKedvencnap());
		System.out.println(napObj2.toString());
		
		KedvencNap napObj3 = new KedvencNap("valaki", "vasárnap");
		System.out.println(napObj3.getKedvencnap());
		System.out.println(napObj3.toString());
		

		
		
	}

}
