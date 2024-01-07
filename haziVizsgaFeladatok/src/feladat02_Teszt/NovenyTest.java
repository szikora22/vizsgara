package feladat02_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import feladat02.Fa;
import feladat02.Noveny;

class NovenyTest {

	@Test
	void hanyEveLatogathatoTeszt(){
		
		int bekerulesEve = 2003;
		int aktualisEv = LocalDate.now().getYear();
		int elvartEredmeny = aktualisEv-bekerulesEve;
		
		Noveny novenyObj = new Noveny("0001","magyar rózsa", "Rosa hungarica", bekerulesEve);
		
		assertEquals(elvartEredmeny, novenyObj.hanyEveLatogathato());
		
	}
	
	@Test 
	void toStringTeszt() {
		
		 Noveny novenyek  = new Noveny("N001", "Csalán", "Urtica dioica", 1890);
		
		String elvartEredmeny = "N001 Csalán Urtica dioica 1890";
		
		assertEquals(elvartEredmeny, novenyek.toString());
		
	}
	
	

}
