package osztalyzatokOOPAdatbekeresselEllenorzessel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Fajlkezeles {

	public Tanulo[] fajlBeolvasas(String fajlnev, String elvalaszto) throws IOException {

		Tanulo[] tanulok = new Tanulo[fajlSorainakSzama(fajlnev)-1];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev),"UTF-8"));
		
		String fejlec = br.readLine(); // az első sor fejléc, mindig nézd meg a csv fájlt, hogy milyen felépítésű

		for(int i=0; i< tanulok.length; i++) {
			
			String sor = br.readLine();		
			String[] csvSor = sor.split(elvalaszto);
			
			Tanulo tanuloObj = new Tanulo(csvSor[0],
					Integer.parseInt(csvSor[1]),
					Integer.parseInt(csvSor[2]),
					Integer.parseInt(csvSor[3]));
			
			tanulok[i] = tanuloObj;
			
		}
		
		br.close();
		
		return tanulok;
	}

	private int fajlSorainakSzama(String fajlnev) throws IOException {

		Path utovonal = Paths.get(fajlnev);
		
		long sorokszama = Files.lines(utovonal).count();
		
		
		return (int)sorokszama;
	}

	public void fajlbaIras(String fajlnev, String elvalaszto, Tanulo tanulo) throws IOException {

		FileWriter fw = new FileWriter(fajlnev,Charset.forName("UTF-8"),true);
		
		String kiiras = tanulo.getNev()+elvalaszto+tanulo.getMatek()+elvalaszto+tanulo.getAngol()+elvalaszto+tanulo.getTortenelem();
		
		fw.write(kiiras+"\n");
		fw.close();
	}

}
