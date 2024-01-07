package sajatInterface;

import java.io.IOException;

public class KapcsolatSzolgaltatasFoprogram {
	
	public static void main(String[] args) {
		
		Szolgaltatas szolgObj1 = new Szolgaltatas("Adóbevallás", 70000);
		Szolgaltatas szolgObj2 = new Szolgaltatas("Cégalapítás", 40000);
		Szolgaltatas szolgObj3 = new Szolgaltatas("Könyvelés", 50000);
		Szolgaltatas szolgObj4 = new Szolgaltatas("Bérszámfejtés", 30000);
		
		Kapcsolat kapcsObj1 = new Kapcsolat("Alfa Bt", "1051 Bp.", "alfabt1@gmail.com", "+36123456",
						new Szolgaltatas[] {szolgObj1,szolgObj3});
		
		Kapcsolat kapcsObj2 = new Kapcsolat("Béta Kft.", "5000 Szolnok", "betakft@gmail.com", "+36345678",
				new Szolgaltatas[] { szolgObj2 });

		Kapcsolat kapcsObj3 = new Kapcsolat("Gamma Rt.", "2225 Üllő", "gammart@gmail.com", "+36123456",
				new Szolgaltatas[] { szolgObj2, szolgObj3, szolgObj4 });
		
		Kapcsolat[] kapcsolatok = new Kapcsolat[] {kapcsObj1,kapcsObj2,kapcsObj3};
		
		Szolgaltatas[] szolgaltatasok = new Szolgaltatas[] { szolgObj1, szolgObj2, szolgObj3, szolgObj4 };
		
		
		try(CSVKiiro csv = new CSVKiiro("KapcsolatSzolgaltatasok.csv")) {
			
			for (Kapcsolat kapcsolat : kapcsolatok) {
				
				csv.fajlbaIr(kapcsolat);
				for (Szolgaltatas szolgaltatas : szolgaltatasok) {
					csv.fajlbaIr(szolgaltatas);
				}
				
				
			}
			
			System.out.println("Sikeres a teljes kiírás");
			
		} catch (IOException e) {

			System.err.println("I/O hiba!");

		}
		
		
		try (CSVKiiro csv = new CSVKiiro("Kapcsolat.csv")){
			
			for (Kapcsolat kapcsolat : kapcsolatok) {
				
				csv.fajlbaIr(kapcsolat);
				
			}
			
			System.out.println("Sikeres a kapcsolatok kiírása");
			
		} catch (IOException e) {
			
			System.err.println("I/O hiba!");

		}
		
		
		try (CSVKiiro csv = new CSVKiiro("Szolgaltatasok.csv")){
			
			for (Szolgaltatas szolgaltatas : szolgaltatasok) {
				
				csv.fajlbaIr(szolgaltatas);
				
			}
			
			System.out.println("Sikeres a szolgáltatások kiírása");
			
		} catch (IOException e) {
			
			System.err.println("I/O hiba!");

		}
		
		// több erőforrás is hozzárendelhető a try-with-resources blokkhoz:
				/*try (CSVKiiro csv = new CSVKiiro("Kapcsolat.csv");
					CSVKiiro csv2 = new CSVKiiro("Szolgaltatasok.csv")) {
						
					for (Kapcsolat kapcsolat : kapcsolatok) {
						
						csv.fajlbaIr(kapcsolat);
						
					}
					
					for (Szolgaltatas szolgaltatas : szolgaltatasok) {
						
						csv2.fajlbaIr(szolgaltatas);
						
					}
						
						
					}catch (IOException e) {
						
						System.err.println("I/O hiba!");
						
					}*/
		
		
	}
	
	
	
	

}
