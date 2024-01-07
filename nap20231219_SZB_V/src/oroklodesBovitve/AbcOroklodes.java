package oroklodesBovitve;

import java.util.Scanner;

public class AbcOroklodes {

	public static void main(String[] args) {

		Termek obj1 = new Pekaru("kuglóf","C10",750,12,false);
		Termek obj2 = new Termek("liszt","C11",550,55);
		Termek obj3 = new Tejtermek("kakaó","C12",390,32,2.8f);
		
		Termek[] termekek = new Termek[6];
		
		termekek[0] = obj1;
		termekek[1] = obj2;
		termekek[2] = obj3;
		
		termekek[3] = new Pekaru("zsömle","C13",49,80,true);
		termekek[4] = new Termek("kenőmájas","C14",370,35);
		termekek[5] = new Kenyerfele("cipó", "C15", 640, 8, false, "rozs");
		
		System.out.println("1. példa: összes termék listázása:");
		
		for (Termek termek : termekek) {
			System.out.println(termek.toString());
			termek.keszletEllenorzes();
		}
		
		System.out.println("2. példa: pékárú kiíratása");
		
		for (Termek termek : termekek) {
			
			if(termek instanceof Pekaru) {
				System.out.println(termek.toString());
			}
			
		}
		
		System.out.println("3. példa: CSAK pékárú kiíratása");
		
		for (Termek termek : termekek) {
			
			if(termek instanceof Pekaru && !(termek instanceof Kenyerfele)) {
				System.out.println(termek.toString());
			}
			
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Adja meg a cikkszámot: ");
		String cikkszam = sc.nextLine();
		
		int i=0;
		
		while(i<termekek.length && !cikkszam.equals(termekek[i].getCikkszam())) {
			
			i++;
			
		}
		
		if(i<termekek.length) {
			System.out.println(termekek[i].toString());
		}
		else {
			System.out.println("Nem található ilyen termék a cikkszám alapján!");
		}
		
		sc.close();
		
		// objektum típusának megállapítása:
		// instanceof       isInstance()         getClass()
		
		if (termekek[0] instanceof Termek) {
			System.out.println("Az objektum egy Termek");			
		}else {
			System.out.println("Az objektum nem egy Termek");
		}
		if (termekek[0] instanceof Pekaru) {
			System.out.println("Az objektum egy Pekaru");	
		}else {
			System.out.println("Az objektum nem egy Pekaru");
		}
		if (termekek[0] instanceof Kenyerfele) {
			System.out.println("Az objektum egy kenyerfele");	
		}else {
			System.out.println("Az objektum nem egy kenyerfele");
		}
		if (termekek[0] instanceof Tejtermek) {
			System.out.println("Az objektum egy Tejtermek");	
		}else {
			System.out.println("Az objektum nem egy Tejtermek");
		}
		
		if (Termek.class.isInstance(termekek[0])) {
			System.out.println("Az objektum egy Termek");			
		}else {
			System.out.println("Az objektum nem egy Termek");
		}
		if (Pekaru.class.isInstance(termekek[0])) {
			System.out.println("Az objektum egy Pekaru");			
		}else {
			System.out.println("Az objektum nem egy Pekaru");
		}
		if (Kenyerfele.class.isInstance(termekek[0])) {
			System.out.println("Az objektum egy Kenyerfele");			
		}else {
			System.out.println("Az objektum nem egy Kenyerfele");
		}
		if (Tejtermek.class.isInstance(termekek[0])) {
			System.out.println("Az objektum egy Tejtermek");			
		}else {
			System.out.println("Az objektum nem egy Tejtermek");
		}
		
		
		if (termekek[0].getClass() == Termek.class) {
			System.out.println("Az objektum egy Termek");			
		}else {
			System.out.println("Az objektum nem egy Termek");
		}
		if (termekek[0].getClass() == Pekaru.class) {
			System.out.println("Az objektum egy Pekaru");			
		}else {
			System.out.println("Az objektum nem egy Pekaru");	
		}
		if (termekek[0].getClass() == Kenyerfele.class) {
			System.out.println("Az objektum egy Kenyerfele");			
		}else {
			System.out.println("Az objektum nem egy Kenyerfele");
		}
		if (termekek[0].getClass() == Tejtermek.class) {
			System.out.println("Az objektum egy Tejtermek");			
		}else {
			System.out.println("Az objektum nem egy Tejtermek");
		}
		

	}

}
