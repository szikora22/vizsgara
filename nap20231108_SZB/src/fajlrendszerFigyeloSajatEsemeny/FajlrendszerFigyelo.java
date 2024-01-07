package fajlrendszerFigyeloSajatEsemeny;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FajlrendszerFigyelo {
	
	private List<IMappaFigyelesEsemeny> feliratkozottObjektumok;
	
	public List<IMappaFigyelesEsemeny> getFeliratkozottObjektumok() {
		return feliratkozottObjektumok;
	}


	private String mappaEleres;
	
	long utolsoModositas;
	
	Timer idozito;

	
	public FajlrendszerFigyelo(String mappaEleres) {
		
		setMappaEleres(mappaEleres);
		feliratkozottObjektumok = new ArrayList<IMappaFigyelesEsemeny>();
		idozito = new Timer();
		
		TimerTask feladat = new TimerTask() {
			
			@Override
			public void run() {
				
				mappaEllenorzes();
				
			}

			
		};
		
		idozito.schedule(feladat, 0, 3000);
				
	}
	
	
	public void setMappaEleres(String mappaEleres) {
		
		// https://www.geeksforgeeks.org/file-class-in-java/
		File mappa = new File(mappaEleres);
		if (mappa.exists() && mappa.isDirectory()) {
			
			this.mappaEleres = mappaEleres;
			utolsoModositas = mappa.lastModified();
			
		}
		else {
			
			throw new IllegalArgumentException("A mappa nem található!");
			
		}
		
		
	}


	private void mappaEllenorzes() {
		
		File fajl = new File(mappaEleres);
		long aktualisModositasIdeje = fajl.lastModified();
		if (aktualisModositasIdeje > utolsoModositas) {
			
			setUtolsoModositas(aktualisModositasIdeje);
			
		}		
	}


	public void setUtolsoModositas(long utolsoModositas) {
		
		this.utolsoModositas = utolsoModositas;
		
		// mivel változott a mappa, az esemény kiváltódik:
		for (IMappaFigyelesEsemeny object :feliratkozottObjektumok) {
			
			object.mappaMegvaltozott(mappaEleres);
			
		}
		
	}
	

}
