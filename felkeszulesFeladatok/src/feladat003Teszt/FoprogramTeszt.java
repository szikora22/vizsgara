package feladat003Teszt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import feladat003.Foprogram;
import feladat003.Zeneszam;

class FoprogramTeszt {

	@Test
	void atoltesTeszt() {


		List<Zeneszam> zeneszamok = new ArrayList<Zeneszam>();
		
		zeneszamok.add(new Zeneszam("Hungária","Micsoda buli",1995));
		zeneszamok.add(new Zeneszam("asd","asdasfsadg buli",2000));
		zeneszamok.add(new Zeneszam("dfhdfh","sghsdh buli",2020));
		
		
		int elvartEredmeny = 3;
		
		assertEquals(elvartEredmeny, Foprogram.attoltes(zeneszamok));
		
		
	}

}
