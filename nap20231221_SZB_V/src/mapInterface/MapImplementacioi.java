package mapInterface;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class MapImplementacioi {

	public static void main(String[] args) {


		Hashtable<String, Integer> etlap = new Hashtable<String, Integer>();
		
		etlap.put("Halászlé",3300);
		etlap.put("Hagymás rostélyos", 3900);
		etlap.put("Bécsi szelet", 3700);
		etlap.put("Somlói galuska", 1700);
		
		System.out.println(etlap.size());
		System.out.println(etlap); //debuggos kiírás
		
		
		System.out.println(etlap.get("Bécsi szelet"));
		System.out.println(etlap.get("Milánói"));
		
		etlap.remove("Bécsi szelet");
		System.out.println(etlap);
		
		System.out.println(etlap.containsKey("Bécsi szelet"));
		System.out.println(etlap.containsKey("Somlói galuska"));
		
		etlap.put("Somlói galuska", 1900);
		System.out.println(etlap);
		
		etlap.put("Mákos guba", 1900);
		System.out.println(etlap);
		
		// nem bejárható szerkezet, keys() metódusa enumerátorként adja vissza a kulcsokat és ennek mentén tudjuk ciklussal bejárni:
		
		Enumeration<String> kulcsok = etlap.keys();
		
		while(kulcsok.hasMoreElements()) {
			
			
			String kulcs = kulcsok.nextElement();
			System.out.println(kulcs + " ára: " + etlap.get(kulcs) + " Ft");
			
		}
		
		etlap.clear();
		System.out.println(etlap);
		
		// HashMap --> egy darab null értékű kulcsa lehet.
		// ha nem többszálú programot írunk, akkor HashMap ajánlott
		// szinkronizált változata a SynchronizedHashMap
		// általánosságban is igaz, hogy a nem szinkronizált objektumok jobb hatásfokkal használhatók
		
		
		Map<String, Double> tanulokAtlaga = new HashMap<String, Double>();
		
		tanulokAtlaga.put("Lilla",4.66);
		tanulokAtlaga.put("Lali",3.5);
		tanulokAtlaga.put("Luca",4.33);
		tanulokAtlaga.put("Laci",4.0);
		
		System.out.println(tanulokAtlaga);
		
		tanulokAtlaga.put("Lali",3.8);
		System.out.println(tanulokAtlaga);
		
		System.out.println(tanulokAtlaga.containsValue(3.33));
		System.out.println(tanulokAtlaga.containsValue(3.8));
		
		System.out.println(tanulokAtlaga.isEmpty());
		System.out.println(tanulokAtlaga.size());
		
		System.out.println(tanulokAtlaga.get("Lilla"));
		
		// entrySet metódussal a bővített for ciklus idejére gyűjtemény nézetet készíthetünk az adatszerkezetből:
		
		for(Map.Entry<String, Double> tanulo : tanulokAtlaga.entrySet()) {
			
			System.out.println(tanulo.getKey() + " átlaga: " + tanulo.getValue());
			
		}
		
		tanulokAtlaga.remove("Lilla");
		System.out.println(tanulokAtlaga);
		
		tanulokAtlaga.replace("Luca",4.1,4.8);
		System.out.println(tanulokAtlaga);
		
		tanulokAtlaga.replace("Luca",4.33,4.8);
		System.out.println(tanulokAtlaga);
		
		//TreeMap rendezve tárol:
		
		TreeMap<String, Double> rendezettMap = new TreeMap<String, Double>(tanulokAtlaga);
		System.out.println(rendezettMap);

	}

}
