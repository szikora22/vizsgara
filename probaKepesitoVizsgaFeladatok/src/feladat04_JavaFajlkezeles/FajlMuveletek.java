package feladat04_JavaFajlkezeles;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FajlMuveletek {
	
	public List<Programnyelv> fajlBeolvasas(String fajlnev, String elvalaszto) throws IOException{
		
		List<Programnyelv> programNyelvek = new ArrayList<Programnyelv>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev),"UTF-8"));
		
		br.readLine();
		
		while(br.ready()) {
			
			String[] csvSor = br.readLine().split(elvalaszto);
			
			programNyelvek.add(new Programnyelv(csvSor[0], 
								Integer.parseInt(csvSor[1]),
								Long.parseLong(csvSor[2]),
								Integer.parseInt(csvSor[3]),
								Long.parseLong(csvSor[4])));
	
		}
		
		br.close();
		return programNyelvek;
		
	}
	
	

}
