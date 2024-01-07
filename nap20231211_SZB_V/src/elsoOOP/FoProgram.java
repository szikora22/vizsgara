package elsoOOP;

public class FoProgram {

	public static void main(String[] args) {


		Laptop laptopObj = new Laptop();
		
		Laptop laptopObj2 = new Laptop("Gyarto","Tipus","C001");
		
		Laptop laptopObj3 = new Laptop("HP","Pavilion","C002",400000);
		
		/* próbaképpen public láthatóságra állítva ar adattagot, elérhetjük azt:
		System.out.println(laptopObj.ar);
		System.out.println(laptopObj2.ar);
		System.out.println(laptopObj3.ar);
		
		laptopObj.ar = 150000;
		
		System.out.println(laptopObj.ar);
		 */
		
		// de az elérés "hivatalosan" getter/setteren keresztül valósítható meg:
		
				System.out.println(laptopObj2.getAr());
				System.out.println(laptopObj2.getCikkszam());
				System.out.println(laptopObj2.getGyarto());
				System.out.println(laptopObj2.getTipus());
				
				laptopObj2.setAr(250000);
				
				System.out.println(laptopObj2.getAr());
				
				System.out.println(laptopObj3.mindenAdat());
		

	}

}
