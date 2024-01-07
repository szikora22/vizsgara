package felhasznaloArrayList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Fajlkezeles {

	public List<Felhasznalo> felhasznalokBeolvasasa(String fajlnev) throws IOException {


		List<Felhasznalo> felhasznalok = new ArrayList<Felhasznalo>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev),"UTF-8"));
		
		while(br.ready()) {
			
			felhasznalok.add(new Felhasznalo(br.readLine().split(";")));
			
			/* a másik konstruktoron keresztül is példányosíthatunk, akkor itt helyben dolgozzuk fel a String tömböt:
			String[] csvSor = br.readLine().split(";");
			felhasznalok.add(new Felhasznalo(csvSor[0],
					Integer.parseInt(csvSor[1]),
					csvSor[2]));
			*/
			
		}
		
		
		return felhasznalok;
	}

}
