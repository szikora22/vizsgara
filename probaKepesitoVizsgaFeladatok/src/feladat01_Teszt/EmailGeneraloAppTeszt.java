package feladat01_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import feladat01_JavaAlapok.EmailGeneraloApp;

class EmailGeneraloAppTeszt {

	@Test
	void emailCimKiosztasTeszt() {
		
		String vezetekNev = "Kiss";
		String keresztNev = "Benedek";
		assertTrue(EmailGeneraloApp.emailCimKiosztas(vezetekNev, keresztNev).startsWith("kiss.bened"),
				"Nem megfelelő email cím generálódott ->"+EmailGeneraloApp.emailCimKiosztas(vezetekNev, keresztNev));
		
	}
	
	
	//@Test
	@RepeatedTest(100)
	void veletlenSzamGeneratorTeszt() {
		
		
		/*
		assertTrue(EmailGeneraloApp.veletlenSzamGenerator(10, 20)<=20, "Az eredmény nagyobb húsznál!");
		assertTrue(EmailGeneraloApp.veletlenSzamGenerator(10, 20)>=10, "Az eredmény kisebb tíznél!");
		*/
		
		// másik verzió (ez jobb, mert egy számot néz és nem kétszer hívja meg egy másik számhoz a metódust):
			
		
		// Mindig úgy hozunk létre vizsgálandó változót, amit visszaad a metódus!
		
		int veletlenSzam = EmailGeneraloApp.veletlenSzamGenerator(10, 20);
		
		assertTrue(veletlenSzam >= 10 && veletlenSzam <= 20);
		
		
	}
	

}
