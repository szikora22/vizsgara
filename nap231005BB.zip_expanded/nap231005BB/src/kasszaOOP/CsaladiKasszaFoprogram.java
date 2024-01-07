package kasszaOOP;

import java.util.Scanner;

public class CsaladiKasszaFoprogram {

	public static void main(String[] args) {
		
		Kassza kasszaObj = new Kassza(300000);
		Scanner sc = new Scanner(System.in);
		
		char menuOpcio;
		
		do {
			
			System.out.println("Válasszon az alábbi menüpontok közül:");
			System.out.println("1. bevétel rögzítése");
			System.out.println("2. kiadás rögzítése");
			System.out.println("3. Egyenleg lekérdezése");
			System.out.println("4. Kilépés");
			
			menuOpcio = sc.nextLine().charAt(0);
			
			switch (menuOpcio) {
			
			case '1':
				System.out.print("Adja meg a bevétel összegét: ");
				int bevetel = Integer.parseInt(sc.nextLine());
				kasszaObj.bevetelKonyveles(bevetel);
				break;
			case '2':
				System.out.print("Adja meg a kiadás összegét: ");
				int kiadas = Integer.parseInt(sc.nextLine());
				kasszaObj.kiadasKonyveles(kiadas);
				break;
			case '3':
				System.out.println("A kassza egyenlege: "+kasszaObj.getEgyenleg()+" Ft");
				break;
			}
			
		}while(menuOpcio != '4');
		
		sc.close();
		

	}

}
