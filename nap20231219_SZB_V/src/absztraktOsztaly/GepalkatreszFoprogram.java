package absztraktOsztaly;

import java.io.IOException;

public class GepalkatreszFoprogram {

	public static void main(String[] args) throws IOException {

		GepAlkatresz[] alkatreszek = new GepAlkatresz[2];
			
		alkatreszek[0] = new Processzor("AMD","S001",99000,0.6,"PGA",2800);
		
		alkatreszek[1] = new Memoria("HyperX","S002",45000,1.5,"DDR4",(byte)16,2600);
			
		for (GepAlkatresz alkatresz : alkatreszek) {
			
			System.out.println(alkatresz.toString() + " : " + alkatresz.nemesfemTartalom() + " g/cm2");
			
		}
		
		FajlKezeles fajl = new FajlKezeles();
		
		fajl.fajlbaIras("gepalkatreszek.csv",";",alkatreszek);

	}

}
