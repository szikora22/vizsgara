package cipoBoltArraylist;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class FajlKezeles {
	
	public List<Cipo> fajlBeolvas(String fajlnev, String elvalaszto){
		
		List<Cipo> cipok = new ArrayList<Cipo>(); 
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev),"UTF-8"))){
			
			br.readLine();
			
			int hibasTetelekSzama = hibasTetelek(br, elvalaszto, cipok);
			
			System.out.println("Fájl feldolgozva. Beimportált/hibás tételek száma: "+cipok.size()+"/"+hibasTetelekSzama);
			
		} catch (UnsupportedEncodingException e) {
			
			System.out.println("Hibás karakterkódolás!");
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Nem létező fájl!");
			
		} catch (IOException e) {
			
			System.out.println("I/O hiba!");
			
		}
		
		
		return cipok;
		
	}
	
	
	public int hibasTetelek(BufferedReader br, String elvalaszto, List<Cipo> cipok) throws IOException {
		
		int hibasTetelekSzama = 0;
		while(br.ready()) {
			
			String[] csvSor = br.readLine().split(elvalaszto);
			
			if (csvSor.length == 7) {
			
				cipok.add(new Cipo(csvSor));
				
			}
			else {
				
				hibasTetelekSzama++;
				
			}													
			
		}
		
		return hibasTetelekSzama;
		
	}
	
	
	
	
	

	public void hazaiFajlbaIr(String fajlnev, String elvalaszto, List<Cipo> hazai) {
		
		try {
			
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajlnev), "UTF-8");
			out.write("cikkszám"+elvalaszto+"ár\n");
			
			for (Cipo cipo : hazai) {
				
				out.write(cipo.getCikkszam()+elvalaszto+String.valueOf(cipo.getAr())+"\n");
				
			}
			
			out.close();
			System.out.println("Fájlba írás sikeres");
			
			
		}catch (IOException e) {
			
			System.out.println("I/O hiba!");
						
		}
		
	}
	
	
	

}
