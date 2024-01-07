package absztraktOsztaly;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FajlKezeles {

	public void fajlbaIras(String fajlnev, String elvalaszto, GepAlkatresz[] alkatreszek) throws IOException {


		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajlnev,false), "UTF-8");
		
		for (GepAlkatresz alkatresz : alkatreszek) {
			
			String kiirasra = alkatresz.getMegnevezes()+elvalaszto+alkatresz.getSzeriaszam()+elvalaszto+
					alkatresz.getAr()+elvalaszto+alkatresz.getMeret();
			
			if(alkatresz instanceof Processzor) {
				
				kiirasra = "Processzor"+elvalaszto+kiirasra+elvalaszto
						+((Processzor)alkatresz).getTokozas()+elvalaszto+((Processzor)alkatresz).getOrajel();
				
			}
			else if (alkatresz instanceof Memoria) {
			
			Memoria memObj = (Memoria)alkatresz;
			
			kiirasra = "Memoria"+elvalaszto+kiirasra+elvalaszto+memObj.getTipus()+elvalaszto
					+memObj.getKesleltetes()+elvalaszto+memObj.getOrajel();
			
		}
		
		out.write(kiirasra+"\n");
		
			
		}
		
		out.close();
		
	}

}
