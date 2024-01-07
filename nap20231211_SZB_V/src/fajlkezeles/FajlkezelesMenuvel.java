package fajlkezeles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
Egy osztály névsorának tárolását kell megoldanunk.
Készítsünk egy menüt, ahol a felhasználó a következő lehetőségek közül választhat:
1. Adatok bekérése konzolról
2. Adatok beolvasása fájlból
3. Névsor kilistázása
4. Adatok kiírása fájlba
5. Kilépés
Hajtsuk végre a választott feladatot. A menü minden feladat után térjen vissza mindaddig,
amíg a felhasználó kilépést nem választ.
*/

public class FajlkezelesMenuvel {
	
	static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) throws IOException, InterruptedException {

		char valasztottMenupont;
		String[] nevsor = new String[10];
		
		do {
			kepernyoTorles();
			System.out.println("Válasszon az alábbi menüpontok közül:");
			System.out.println("1. Adatok bekérése konzolról");
			System.out.println("2. Adatok beolvasása fájlból");
			System.out.println("3. Névsor listázása");
			System.out.println("4. Adatok kiírása fájlba");
			System.out.println("5. kilépés");
			valasztottMenupont = sc.nextLine().charAt(0);
			
			switch (valasztottMenupont) {
			case '1':
				manualisBekeres(nevsor);
				break;
			case '2':
				fajlbolOlvasas(nevsor,"nevsor.txt");
				break;
			case '3':
				nevsorListazas(nevsor);
				break;
			case '4':
				fajlbaIras(nevsor,"nevsor.txt");
				break;
			}
			
			if (valasztottMenupont !='5') {
				System.out.println("Nyomja meg az Entert a folytatáshoz!");
				sc.nextLine();
			}
			
		}while(valasztottMenupont!='5');
		
		sc.close();

	}


	private static void kepernyoTorles() throws InterruptedException, IOException {

		new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		
	}


	private static void fajlbaIras(String[] nevsor, String fajlnev) throws IOException {

		FileOutputStream fs = new FileOutputStream(fajlnev,true);
		OutputStreamWriter out = new OutputStreamWriter(fs,"UTF-8");
		
		for (String nev : nevsor) {
			
			out.write(nev + "\n");
			
		}
		
		out.close();
		fs.close();
		System.out.println("Fájlbaírás sikeres!");
	}


	private static void nevsorListazas(String[] nevsor) {

		for(int i=0; i<nevsor.length; i++) {
			
			System.out.print(nevsor[i] + ", ");
			
		}
		
	}


	private static void fajlbolOlvasas(String[] nevsor, String fajlnev) throws IOException {

		File fajl = new File(fajlnev);
		
		if(fajl.exists() && !fajl.isDirectory()) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev), "UTF-8"));
			int sorokSzama = 0;
			
			while(br.ready() && sorokSzama<nevsor.length) {
				
				nevsor[sorokSzama] = br.readLine();
				sorokSzama++;
				
			}
			
			br.close();
			System.out.println("A fájlból olvasás sikeres!");
			
		}
		
	}


	private static void manualisBekeres(String[] nevsor) {

		for(int i=0; i<nevsor.length;i++) {
			
			System.out.println("Kérem a(z) " + (i+1) + ". tanuló nevét");
			nevsor[i] = sc.nextLine();
			
		}
		
		
	}

}
