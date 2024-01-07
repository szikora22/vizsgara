package infoSzotar;

public class FoprogramSzotar {

	public static void main(String[] args) {

		Adatbekeres adatObj = new Adatbekeres();
		Szotar szotar = new Szotar();
		
		int menupont;
		
		do {
			
			menupont = adatObj.menuValasztas();
			
			if(menupont==1) {
				
				szotar.magyarrolAngolra(adatObj.forditasBeker());
				
			}
			else if (menupont == 2) {
				
				szotar.angolrolMagyarra(adatObj.forditasBeker());
				
			}
			
			
		}while(menupont !=3);
		
		

	}

}
