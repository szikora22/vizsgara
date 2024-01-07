package pizzeria;

import java.time.Duration;
import java.time.LocalTime;

/* Egy pizzéria az alábbi árképzést alkalmazza kiszállítás esetén: az első 30 percben teljes árral,
 *  majd 10 perces sávokban, sávonként 25%-kal növekvő kedvezménnyel kalkulál (tehát 1 órán túl ingyen pizza!).
 *  Készítse el az ennek megfelelő applikációt és írjon hozzá egységteszteket! */

public class Kiszallitas {
	
	private String rendelesAzonosito;
	private int darabszam;
	private int ar;
	private LocalTime kiszallitasStart;
	private LocalTime kezbesitesIdeje;
	

	public Kiszallitas(String rendelesAzonosito, int darabszam) {
		
		setRendelesAzonosito(rendelesAzonosito);
		setDarabszam(darabszam);
		
		ar = 1600;
		kiszallitasStart = LocalTime.now();
		
	}



	public void setRendelesAzonosito(String rendelesAzonosito) {
		
		if (rendelesAzonosito != null && !rendelesAzonosito.isBlank()) {
			
			this.rendelesAzonosito = rendelesAzonosito;	
			
		}
		else {
			
			throw new IllegalArgumentException("Azonosító megadása kötelező!");
			
		}
		
	}



	public void setDarabszam(int darabszam) {
		
		if (darabszam > 0 && darabszam <= 5) {
			
			this.darabszam = darabszam;	
			
		}
		else {
			
			throw new IllegalArgumentException("Darabszám 1 és 5 közötti érték lehet!");
			
		}
		
		
	}
	
	
	public void setKezbesitesIdeje(LocalTime kezbesitesIdeje) {
		
		if (!kezbesitesIdeje.isBefore(kiszallitasStart)) {
			// vagy:
			// if (kezbesitesIdeje.equals(kiszallitasStart) || kezbesitesIdeje.isAfter(kiszallitasStart)) {			
			this.kezbesitesIdeje = kezbesitesIdeje;
			
		}
		else {
			
			throw new IllegalArgumentException("A kézbesítés ideje nem lehet korábbi, mint a kiszállítás!");
			
		}
				
	}



	public String getRendelesAzonosito() {
		return rendelesAzonosito;
	}



	public int getDarabszam() {
		return darabszam;
	}



	public int getAr() {
		return ar;
	}



	public LocalTime getKiszallitasStart() {
		return kiszallitasStart;
	}



	public LocalTime getKezbesitesIdeje() {
		return kezbesitesIdeje;
	}
	
	
	public long kalkulacio() {
		
		long kulonbseg = Duration.between(kiszallitasStart, kezbesitesIdeje).getSeconds();
		if (kulonbseg > 30 && kulonbseg <= 40) {
			
			ar = (int)(ar * 0.75);
			
		}
		else if (kulonbseg > 40 && kulonbseg <= 50) {
			
			ar = (int)(ar * .5);
			
		}
		else if (kulonbseg > 50 && kulonbseg <= 60) {
			
			ar = (int)(ar * .25);
			
		}
		else if (kulonbseg > 60) {
			
			ar = 0;
			
		}
		
		
		return kulonbseg;
		
	}
	

}
