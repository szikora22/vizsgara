package feladat03_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import feladat03_JavaKollekciok.FoprogramKollekciok;
import feladat03_JavaKollekciok.Versenyzo;

class FoprogramKollekCiokTeszt {

	@Test
	void utolsohelyezettTeszt() {
		
		List<Versenyzo> versenyzok = new ArrayList<Versenyzo>() {
			
			{
				add(new Versenyzo("0123", "Teszt Elek", "Maraton SC", 10));
				add(new Versenyzo("0234", "kettes versenyző", "Futó SE", 2));
				add(new Versenyzo("0345", "hármas versenyző", "SC", 4));
			}
			
		};
		
		assertEquals(0, FoprogramKollekciok.utolsohelyezett(versenyzok));
		
		
	}

}
