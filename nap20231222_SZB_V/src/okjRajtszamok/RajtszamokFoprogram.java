package okjRajtszamok;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RajtszamokFoprogram {

	public static void main(String[] args) throws IOException {


		List<Versenyzo> versenyzok = new ArrayList<Versenyzo>();
		
		System.out.println("2. feladat - fájlbeolvasás, adattárolás");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("rajtszamok.csv"),"UTF-8"));
		
		br.readLine(); // a fejlécnek
		
		while(br.ready()) {
			
			// ha magát a csvSort adjuk át az egyparaméteres konstruktornak, akkor egy utasítással olvasunk, példányosítunk és tárolunk:
			versenyzok.add(new Versenyzo(br.readLine().split(";")));
			
			// ha a teljes kitöltésű konstruktoron keresztül példányosítunk, akkor előbb a sztring tömböt elő kell állítsuk, úgy tudjuk kihivatkozni a szükséges adatokat:
			/*String[] csvSor = br.readLine().split(";");
			versenyzok.add(new Versenyzo(Byte.parseByte(csvSor[0]),csvSor[1],csvSor[2]));*/
			
		}
		System.out.println("A fájlbeolvasás sikeres!");
		br.close();
		
		System.out.println("3. feladat - A versenyzők száma: " + versenyzok.size());
		
		System.out.println("4. feladat - Rajtszámkeresés");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Adjon meg egy rajtszámot: ");
		byte keresettRajtszam = Byte.parseByte(sc.nextLine());
		
		int i=0;
		while(i < versenyzok.size() && versenyzok.get(i).getRajtszam() != keresettRajtszam) {
			i++;
		}
		
		if(i<versenyzok.size()) {
			
			System.out.println(versenyzok.get(i).toString());
			
		}
		else {
			System.out.println("Nincs ilyen rajtszámú versenyző!");
		}
		
		sc.close();
		
		System.out.println("5. feladat brit versenyzők létszáma és neve:");
		int britVersenyzokSzama = 0;
		for (Versenyzo versenyzo : versenyzok) {
			
			if(versenyzo.getOrszagkod().equals("GBR")) {
				
				System.out.println(versenyzo.getNev());
				britVersenyzokSzama++;
			}
			
		}
		System.out.println("Brit versenyzők létszáma: " + britVersenyzokSzama);
		
		System.out.println("6. feladat - 'H' - betűvel kezdődő vezetéknevű versenyzők neve és rajtszáma: ");
		
		List<Versenyzo> hBetusek = new ArrayList<Versenyzo>();
		
		for (Versenyzo versenyzo : versenyzok) {
			
			if(versenyzo.getNev().split(" ")[1].charAt(0)=='H') {
				hBetusek.add(versenyzo);
			}
			
		}
		
		for (Versenyzo versenyzo : hBetusek) {
			System.out.println(versenyzo.getNev() + " ("+versenyzo.getRajtszam()+")");
		}
		
		Map<String,Integer> letszamok = new HashMap<String, Integer>();
		System.out.println("\n7. feladat - orszagok.csv létrehozása, adatok kiírása");
		
		for (Versenyzo versenyzo : versenyzok) {
			
			if (letszamok.containsKey(versenyzo.getOrszagkod())) {
				
				letszamok.replace(versenyzo.getOrszagkod(), letszamok.get(versenyzo.getOrszagkod())+1);
				
			}
			else {
				
				letszamok.put(versenyzo.getOrszagkod(), 1);
				
			}
			
		}
		
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("orszagok.csv"),"UTF-8");
		out.write("országkód;létszám\n");
		
		for (Map.Entry<String, Integer> elem : letszamok.entrySet()) {
			
			if (elem.getValue() > 1) {
				
				out.write(elem.getKey()+";"+elem.getValue()+"\n");
				
			}
			
		}
		out.close();
		
		out.close();
		System.out.println("A fájlbaírás megtörtént!");
	}

}
