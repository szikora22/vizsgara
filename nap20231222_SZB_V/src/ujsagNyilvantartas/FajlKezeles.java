package ujsagNyilvantartas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FajlKezeles {

	public Ujsag[] fajlBeolvas(String fajlNev, String elvalaszto) throws IOException, NumberFormatException {
		
		Ujsag[] ujsagok = new Ujsag[tombElemszamMeghataroz(fajlNev)];

			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fajlNev), "UTF-8"));		
			
			for (int i = 0; i < ujsagok.length; i++) {
								
				String sor = br.readLine();
			
				String[] csvSor = sor.split(elvalaszto);
						  
				Ujsag ujsagObj = null;
				switch (csvSor[0]) {
				case "Ujsag":
					ujsagObj = new Ujsag(csvSor);
					break;
				case "Napilap":
					ujsagObj = new Napilap(csvSor);
					break;
				case "Hetilap":
					ujsagObj = new Hetilap(csvSor);
					break;
				}	   						
				
				ujsagok[i] = ujsagObj;				
				
			}
			br.close();

		return ujsagok;
	}
	
	public int tombElemszamMeghataroz(String fajlNev) throws IOException {

		Path utvonal = Paths.get(fajlNev);	
		long sorokSzama;
		int tombMeret=0;

			sorokSzama = Files.lines(utvonal).count();
			tombMeret = (int)sorokSzama;	
			
		return tombMeret;
	}
	
	public void FajlbaIr(String fajlnev, String elvalaszto, Ujsag ujsagObj) throws IOException {
		
		FileWriter fw = new FileWriter(fajlnev, Charset.forName("UTF-8"), true);
		
		String kiirando = ujsagObj.getMegnevezes()+elvalaszto
				+ujsagObj.getKiado()+elvalaszto+ujsagObj.getAr();
		
		if (ujsagObj.getClass() == Ujsag.class) {
			kiirando = "Ujsag"+elvalaszto+kiirando;
		}
		else if (ujsagObj.getClass() == Napilap.class) {
			kiirando = "Napilap"+elvalaszto+kiirando+elvalaszto+((Napilap)ujsagObj).getHetiHanyszor();
		}
		else if (ujsagObj.getClass() == Hetilap.class) {
			kiirando = "Hetilap"+elvalaszto+kiirando+elvalaszto+((Hetilap)ujsagObj).getHanyadikNaponJelenikMeg();
		}
		kiirando +=  "\n";

		fw.write(kiirando);

		fw.close(); 
	}
	
}
