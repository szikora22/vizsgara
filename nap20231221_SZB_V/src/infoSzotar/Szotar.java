package infoSzotar;

import java.util.Map;

public class Szotar {
	
	private Map<String, String> szotar = FajlKezeles.fajlbolOlvasas("szotar.csv",";");
	
	
	public void angolrolMagyarra(String forditandoSzo) {
		
		if(szotar.containsKey(forditandoSzo)) {
			
			System.out.println("magyarul: " + szotar.get(forditandoSzo));
			
		}
		else {
			
			System.out.println("Ez a szó nem szerepel a szótárban");
			
		}
				
	}
	
public void magyarrolAngolra(String forditandoSzo) {
		
		if (szotar.containsValue(forditandoSzo)) {
			
			for (Map.Entry<String,String> szo : szotar.entrySet()) {
				if (szo.getValue().equalsIgnoreCase(forditandoSzo)) {
					System.out.println("Angolul: "+szo.getKey());
				}
			}
			
		}
		else {
			System.out.println("Ez a szó nem szerepel a szótárban");
		}
		
	}
	

}
