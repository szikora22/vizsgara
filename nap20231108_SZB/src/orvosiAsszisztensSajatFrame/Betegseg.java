package orvosiAsszisztensSajatFrame;

import orvosiAsszisztensSajatFrame.FelsorolasOsztaly.BetegsegLefolyas;
import orvosiAsszisztensSajatFrame.FelsorolasOsztaly.BetegsegTipus;

/* Készítsünk háziorvosi asszisztens alkalmazást, melyben betegségekről lehet adatokat tárolni.
Minden betegségről tudjuk a következőket:
Megnevezés
Típus {bakteriális, vírusos}
Lefolyás {enyhe, heveny, veszélyes}
Oldjuk meg, hogy a fő ablakban egy JList-ben jelenjenek meg az adatok.
Tudjunk adatot felvinni, módosítani és törölni is.
A felvitelt és a módosítást egy saját ablak segítségével oldjuk meg.
Program induláskor az adatokat olvassuk be fájlból, program bezárásakor pedig írjuk ki az adatokat a fájlba. */

public class Betegseg {
	
	private String megnevezes;
	private BetegsegLefolyas lefolyas;
	private BetegsegTipus tipus;
	
	
	public Betegseg(String megnevezes, BetegsegLefolyas lefolyas, BetegsegTipus tipus) {
		this.megnevezes = megnevezes;
		this.lefolyas = lefolyas;
		this.tipus = tipus;
	}


	public String getMegnevezes() {
		return megnevezes;
	}


	public void setMegnevezes(String megnevezes) {
		this.megnevezes = megnevezes;
	}


	public BetegsegLefolyas getLefolyas() {
		return lefolyas;
	}


	public void setLefolyas(BetegsegLefolyas lefolyas) {
		this.lefolyas = lefolyas;
	}


	public BetegsegTipus getTipus() {
		return tipus;
	}
	
	
	public String toString() {
		
		return megnevezes + ": lefolyása "+lefolyas.toString()+" típusa: "+tipus.toString();
		
	}
	
	

}
