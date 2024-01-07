package masodikOOP;

public class TeruletSzamitasOOP {

	public static void main(String[] args) {
		
		System.out.println("A terület: " + teruletSzamitas(7));
		System.out.println("A terület: " + teruletSzamitas(3,8));
		
		Kor korObj = new Kor(7.5);
		System.out.printf("A terület: %.2f%n",teruletSzamitas(korObj));
		
		Haromszog haromszog = new Haromszog(4, 3);
		Haromszog haromszog2 = new Haromszog(5, 6);
		
		//System.out.printf("A terület: %.2f",teruletSzamitas(haromszog));
		System.out.printf("A terület: %.2f%n",haromszog.teruletSzamitas());
		System.out.printf("A terület: %.2f",haromszog2.teruletSzamitas());
		
		

	}
	
	public static double teruletSzamitas(Kor kor) {
		
		return kor.getSugar() * kor.getSugar() * Math.PI;
		
	}

	public static double teruletSzamitas(double negyzetAoldala) {
		
		return negyzetAoldala* negyzetAoldala;
	}

	public static double teruletSzamitas(double teglalapAoldal, double teglalapBoldal) {
		
		return teglalapAoldal* teglalapBoldal;
	}
	
	/* átemeltük a saját osztályába, mivel logikailag odatartozhat
	public static double teruletSzamitas(Haromszog haromszog) {
		
		return haromszog.getAOldal()*haromszog.getMagassag()/2;
		
	}
	*/


}
