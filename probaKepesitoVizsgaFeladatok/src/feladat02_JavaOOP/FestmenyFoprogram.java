package feladat02_JavaOOP;

public class FestmenyFoprogram {

	public static void main(String[] args) {
		
		Festmeny festmenyObj = new Festmeny("Mona", "Lisa", 1540, 21000000);
		
		long festmenyUjErtek =festmenyObj.ertekkovetes(-20);
		
		festmenyObj.setBecsultErtek(festmenyUjErtek);
		System.out.println("A festmény új értéke: " + festmenyUjErtek);
		
		System.out.println(festmenyObj.toString());
		
	}

}
