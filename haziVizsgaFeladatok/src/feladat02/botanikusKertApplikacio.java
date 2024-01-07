package feladat02;



public class botanikusKertApplikacio {

	public static void main(String[] args) {
			
		Noveny[] novenyek = new Noveny[5];
				
		novenyek[0] = new Noveny("N001", "Csalán", "Urtica dioica", 1890);
		novenyek[1] = new Noveny("N002", "Harangvirág", "Campanula", 1712);
		novenyek[2] = new Fa("F001", "Tölgyfa", "Quercis", 1300, 45);
		novenyek[3] = new Fa("F002", "Majomkenyérfa", "Adansonia digitata", 1000, 30);
		novenyek[4] = new Noveny("N003", "Gyermekláncfű", "Taraxacum officinale", 1200);
		
				
		System.out.println("A botanikus kertben található növények listája és adatai: ");
		novenyekListaja(novenyek);
		

	}

	private static void novenyekListaja(Noveny[] novenyek) {
		
		for (Noveny noveny : novenyek) {
			
			System.out.println(noveny.toString()); 			
			System.out.print("A növény " + noveny.hanyEveLatogathato() + " éve látogatható.");
			noveny.tipus();
			
		}
		
	}



}
