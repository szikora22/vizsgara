package cipoBoltArraylist;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Feladatok {

	List<Cipo> cipok = new ArrayList<Cipo>();
	FajlKezeles fajlObj = new FajlKezeles();
	
	public void fajlBeolvasas(String fajlnev, String elvalaszto) {
				
		cipok = fajlObj.fajlBeolvas(fajlnev,elvalaszto);
					
	}

	public void kilistaz() {
		
		kilistaz(cipok);		
		
	}

	public void kilistaz(List<Cipo> cipok) {
		
		for (Cipo cipo : cipok) {
			
			/*
			System.out.print(cipo.getCikkszam()+" ");
			System.out.print(cipo.getMegnevezes()+" ");
			System.out.print(cipo.getTipusSzovegesen()+" ");
			System.out.print(cipo.getAr()+" ");
			System.out.print(cipo.getKeszlet()+" ");
			System.out.printf("%tY.%tm.%td ",cipo.getGyartasiDatum(),cipo.getGyartasiDatum(),cipo.getGyartasiDatum());
			System.out.println(cipo.getHazaiTermekSzovegesen()+" ");
				*/		
			System.out.println(cipo.toString());
			
		}
		
		
	}
	
	
	public void tipusonkentiLista() {
		
		List<Cipo> alkalmiCipok = new ArrayList<Cipo>();
		List<Cipo> edzoCipok = new ArrayList<Cipo>();
		List<Cipo> csizmak = new ArrayList<Cipo>();
		List<Cipo> papucsok = new ArrayList<Cipo>();
		
		for (Cipo cipo : cipok) {
			
			switch (cipo.getTipus()) {
			
			case 1:
				
				alkalmiCipok.add(cipo);
				break;
				
			case 2:
				edzoCipok.add(cipo);
				break;
			
			case 3:
				csizmak.add(cipo);
				break;
				
			case 4:
				papucsok.add(cipo);
				break;
			}								
		}
		
		System.out.println("Alkalmi cipők listája:");
		kilistaz(alkalmiCipok);
		
		System.out.println("\nEdzőcipők listája:");
		kilistaz(edzoCipok);
		
		System.out.println("\nCsizmák listája:");
		kilistaz(csizmak);
		
		System.out.println("\nPapucsok listája:");
		kilistaz(papucsok);
		
	}

	public void arIntervallumLista() {
		
		List<Cipo> arSzerintiLista = new ArrayList<Cipo>();
		Scanner sc = new Scanner(System.in);
		
		boolean joErtek = false;
		int alsoHatar = 0;
		int felsoHatar = 0;
		
		do {
			
			try {
				
				System.out.print("Kérem adja meg az ár alsó határát: ");
				alsoHatar = Integer.parseInt(sc.nextLine());
				
				System.out.print("Kérem adja meg az ár felső határát: ");
				felsoHatar = Integer.parseInt(sc.nextLine());
				
				joErtek = true;
				
				
			} catch (NumberFormatException e) {
				
				System.out.println("Nem megfelelő formátum!");
				
			}
			
		}while(!joErtek || felsoHatar < alsoHatar);
		
		for (Cipo cipo : cipok) {
			
			if (cipo.getAr() >= alsoHatar && cipo.getAr() <= felsoHatar) {
				
				arSzerintiLista.add(cipo);
				
			}
			
		}
		System.out.println("\nAz ár szerinti lista:");
		kilistaz(arSzerintiLista);
		sc.close();
		
	}

	public double csizmaAtlagar() {
		
		int db = 0;
		int osszAr = 0;
		for (Cipo cipo : cipok) {
			
			if (cipo.getTipus() == 3) {
				
				osszAr += cipo.getAr();
				db++;
			}
			
		}
		
		return (double)osszAr / db;
	}

	public void keszletHiany() {
		
		Set<String> keszletHianyosTipus = new HashSet<String>(); // halmazt alkalmazunk, hogy csak egyszer jelenjen meg a típus
		//List<String> keszletHianyosTipus = new ArrayList<String>();
		
		for (Cipo cipo : cipok) {
			
			if (cipo.getKeszlet() <= 5) {
				
				keszletHianyosTipus.add(cipo.getTipusSzovegesen());
				
			}
		}
		
		for (String tipus : keszletHianyosTipus) {
			
			System.out.println(tipus);
			
		}
	}

	public int osszesDB() {
		
		int db = 0;
		for (Cipo cipo : cipok) {
			
			db += cipo.getKeszlet();
			
		}
		return db;
	}

	public void hazaiFajlba(String fajlnev, String elvalaszto) {
		 
		List<Cipo> hazai = new ArrayList<Cipo>();
		for (Cipo cipo : cipok) {
			
			if (cipo.isHazaiTermek()) {
				
				hazai.add(cipo);
				
			}
		}
		
		fajlObj.hazaiFajlbaIr(fajlnev,elvalaszto,hazai);
		
	}

	public int hanyHonapTeltel() {
	
		int legregebbiIndex = 0;
		int legujabbIndex = 0;
		
		for (int i=1; i<cipok.size(); i++) {
			
			if (cipok.get(i).getGyartasiDatum().isBefore(cipok.get(legregebbiIndex).getGyartasiDatum())) {
				
				legregebbiIndex = i;
				
			}
			
			if (cipok.get(i).getGyartasiDatum().isAfter(cipok.get(legujabbIndex).getGyartasiDatum())) {
				
				legujabbIndex = i;
				
			}
						
		}
		
		LocalDate regi = cipok.get(legregebbiIndex).getGyartasiDatum();
		LocalDate uj = cipok.get(legujabbIndex).getGyartasiDatum();
		
		return (Period.between(regi, uj).getYears()*12)+Period.between(regi, uj).getMonths();
		
	}
	
	

}
