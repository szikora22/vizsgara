package feladat04_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import feladat04.FajlKezeles;
import feladat04.Rendeles;

class FajlKezelesTest {

	@Test
	void ellenorizTeszt() {
		
		FajlKezeles fajlObj = new FajlKezeles();
		String[] tesztCsvSor = {"S00008","toll","100","4000","1"};
		
		assertTrue(fajlObj.ellenoriz(tesztCsvSor));
		
	}
	

}
