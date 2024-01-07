package feladat003;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Fajlkezeles {
	
	public List<Zeneszam> beolvasas(String fajlnev, String elvalaszto) throws IOException {
		
		List<Zeneszam> zeneszamok = new ArrayList<Zeneszam>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev),"UTF-8"));
		
		br.readLine();
		
		while (br.ready()) {
			
			String[] csvSor = br.readLine().split(";");
			
			// TODO beolvasás és példányosítás megfelelő megvalósítása
			
			zeneszamok.add(new Zeneszam(csvSor[0],csvSor[1],Integer.parseInt(csvSor[2]))); 
			
		}
		br.close();
		
		return zeneszamok;
		
	}

	public void kiiras(Set<String> egyuttesek, String fajlnev, String elvalaszto) throws IOException {

		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajlnev),"UTF-8");
		out.write("együttes\n");	// ez csak a fejléc
		
		for(String egyuttes : egyuttesek) {
			
			out.write(egyuttes + "\n");
			
		}
		
		out.close();
	}

}
