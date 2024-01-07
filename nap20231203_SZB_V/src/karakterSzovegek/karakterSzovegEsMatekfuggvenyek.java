package karakterSzovegek;

public class karakterSzovegEsMatekfuggvenyek {

	public static void main(String[] args) {

		char[] karakterTomb = {'T','e','s','z','t'};
		String szoveg = new String(karakterTomb);
		
		System.out.println(szoveg);
		
		
		karakterTomb[1] = 'i';
		System.out.println(szoveg);
		String szoveg2 = new String(karakterTomb);
		System.out.println(szoveg2);
		
		// szoveg[1] = 'i'; mivel a String immutable (módosíthatatlan), nem változtathatjuk meg a karaktereit sem
		// hivatkozni viszont tudjuk a karaktereit: string.charAt(index)
		char karakter = szoveg.charAt(2);
		System.out.println(karakter);
		
		if(Character.isDigit(karakter)) {
			System.out.println("számjegy");
		}
		else if(Character.isUpperCase(karakter)) {
			System.out.println("nagybetű");
		}
		else if(Character.isLowerCase(karakter)) {
			System.out.println("kisbetű");
		}
		else {
			System.out.println("egyéb karakter");
		}
		
		System.out.println(szoveg.length());
		System.out.println(szoveg.toUpperCase());
		System.out.println(szoveg.toLowerCase());

		System.out.println(szoveg.substring(2)); // rész String képzés, a kezdő indextől a szó végéig
		System.out.println(szoveg.substring(1,4)); // első paraméter a kezdő index, második paraméter az utolsó karakter-1. index
		
		System.out.println(szoveg.indexOf("sz"));
		System.out.println(szoveg.lastIndexOf("sz"));
		
		System.out.println(szoveg.indexOf("T"));
		System.out.println(szoveg.lastIndexOf("t"));
		
		System.out.println(szoveg.startsWith("te"));
		System.out.println(szoveg.startsWith("Te"));
		System.out.println(szoveg.startsWith("Te",2));
		
		
		String szin = "piros";
		String szin2 = "piros";
		String szin3 = new String("piros");
		
		System.out.println(szin +" "+szin2+" "+szin3);
		System.out.println(szin == szin2); //objektumegyezőségre történő vizsgálat
		System.out.println(szin == szin3);
		
		System.out.println(szin2.equalsIgnoreCase(szin3)); // nem tesz különbséget kisbetű/nagybetű között
		
		szin2 = "zöld";
		System.out.println(szin+" "+szin2);
		// szin nem lesz zöld, mert szin2 már egy másik (új) objektum, mivel a string típus immutable, azaz módosíthatatlan
		// vagyis amikor látszólag új értéket adunk neki, akkor az objektum megszűnik és egy másik jön létre ugyanazzal a névvel
		// a megszűnő objektumok kivezetését a memóriából a garbage collector (szemétgyüjtő) végzi automatikusan.
		
		System.out.println(Math.round(8.49));
		System.out.println(Math.round(8.5));
		System.out.println(Math.floor(8.49));
		System.out.println(Math.ceil(8.05));
		System.out.println(Math.floor(-8.49));
		System.out.println(Math.ceil(-8.05));
		
	}

}
