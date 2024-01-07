package pizzeria;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PizzeriaFoprogram {

	static Random r = new Random();
	static List<Kiszallitas> kiszallitasok = new ArrayList<Kiszallitas>();
	
	public static void main(String[] args) {
		
		/*
		double szam = 10;
		System.out.println(szam/0);
		
		A lebegőpontos számok tulajdonságai:
		https://hu.wikipedia.org/wiki/IEEE_lebeg%C5%91pontos_sz%C3%A1mform%C3%A1tum
		
		
		*/
		
		int rendelesekSzama = 0;
		
		System.out.println("A pizzéria kinyitott, fogad rendeléseket\n");
		
		try {
			
			for (int i=0; i<120; i++) {
				
				switch ( r.nextInt(4)) {
				
				case 0:
				case 1: // új kiszállítás indul
					
					rendelesekSzama++;
					String azonosito = "R"+String.valueOf(rendelesekSzama);
					int db = r.nextInt(5)+1;
					Kiszallitas ujkiszallitas = new Kiszallitas(azonosito, db);
					kiszallitasok.add(ujkiszallitas);
					System.out.print("\nÚj kiszállítás indult, azonosítója: "+azonosito+" "+db+" db, időpontja: ");
					System.out.println(ujkiszallitas.getKiszallitasStart().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
					
					break;
				case 2: // kézbesítés, kalkuláció
					
					if (kiszallitasok.size() > 0) {
						
						int melyikRendelesErtOda = r.nextInt(kiszallitasok.size());
						
						Kiszallitas kiszObj = kiszallitasok.get(melyikRendelesErtOda); 
						kiszObj.setKezbesitesIdeje(LocalTime.now());
						System.out.print("\nRendelés kézbesítve. Azonosító: "+kiszObj.getRendelesAzonosito());
						System.out.print(" indulási idő: "+kiszObj.getKiszallitasStart().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
						System.out.println(" kézbesítési idő: "+kiszObj.getKezbesitesIdeje().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
						System.out.print("A kézbesítés időtartama: "+kiszObj.kalkulacio()+" perc. ");
						System.out.println("Ára az eltelt idő függvényében: "+kiszObj.getAr()+" Ft");
						
						kiszallitasok.remove(melyikRendelesErtOda);
						
					}
					
					
					break;
				case 3:
					// üresjárat
					break;
					
				}
				
				
				
				Thread.sleep(1000);
				// minden iteráció végén várakoztatjuk 1 másodpercet (amivel 1 percet szimulálunk)
				
			}
			
			System.out.println("A pizzéria bezárt, nem fogad több rendelést");
			
		} catch (InterruptedException e) {
			
			System.out.println("Szál probléma!");
			
		} catch (IllegalArgumentException e) {
			
			System.out.println(e.getMessage());
			
		}

	}

}
