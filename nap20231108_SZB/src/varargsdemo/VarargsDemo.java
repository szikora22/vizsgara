package varargsdemo;

public class VarargsDemo {

	public static void main(String[] args) {
		
		Integer szam = 10, szam2=27, szam3 =55;
		
		System.out.println(formazo("Helyettesítsük ide be a %s számot", szam));
		System.out.println(formazo("Helyettesítsük ide be a %s és %s számokat", szam, szam2));
		System.out.println(formazo("Helyettesítsük ide be a %s és %s és %s számokat", szam, szam2, szam3));
		System.out.println();
		
		Integer[] szamok = new Integer[] {10};
		System.out.println(formazo("Helyettesítsük ide be a %s számot", szamok));
		
		Integer[] szamok2 = new Integer[] {10,27};
		System.out.println(formazo("Helyettesítsük ide be a %s és %s számot", szamok2));
		
		Integer[] szamok3 = new Integer[] {10,27,55};
		System.out.println(formazo("Helyettesítsük ide be a %s és %s és %s számot", szamok3));
		System.out.println();
		
		System.out.println(formazoVarargs("Helyettesítsük ide be a %s számot", szam));
		System.out.println(formazoVarargs("Helyettesítsük ide be a %s és %s számokat", szam, szam2));
		System.out.println(formazoVarargs("Helyettesítsük ide be a %s és %s és %s számokat", szam, szam2, szam3));

	}
	
	
	public static String formazo(String szoveg, Object formazoParameter) {
		
		szoveg = szoveg.replaceFirst("%s", String.valueOf(formazoParameter));
		
		return szoveg;
		
		
	}
	
	public static String formazo(String szoveg, Object formazoParameter, Object formazoParameter2) {
		
		szoveg = szoveg.replaceFirst("%s", String.valueOf(formazoParameter));
		szoveg = szoveg.replaceFirst("%s", String.valueOf(formazoParameter2));
		
		return szoveg;
		
		
	}
	

	public static String formazo(String szoveg, Object formazoParameter, Object formazoParameter2, Object formazoParameter3) {
		
		szoveg = szoveg.replaceFirst("%s", String.valueOf(formazoParameter));
		szoveg = szoveg.replaceFirst("%s", String.valueOf(formazoParameter2));
		szoveg = szoveg.replaceFirst("%s", String.valueOf(formazoParameter3));
		
		return szoveg;
		
		
	}
	
	// spagettikód vagy boilerplate code --> hosszú, feleslegesen ismétlődő kódrészleteket tartalmazó, rosszul tervezett kód
	
	
	public static String formazo(String szoveg, Object[] formazoParameterek) {
		
		for (int i=0; i<formazoParameterek.length; i++) {
			
			szoveg = szoveg.replaceFirst("%s", String.valueOf(formazoParameterek[i]));
			
		}
		
		return szoveg;
		
	}
	
	// Java5-től lehetőség van varargs paraméterezést használni:
	public static String formazoVarargs(String szoveg, Object... formazoParameterek) {
		
		for (int i=0; i<formazoParameterek.length; i++) {
			
			szoveg = szoveg.replaceFirst("%s", String.valueOf(formazoParameterek[i]));
			
		}
		
		return szoveg;
		
	}
	
	// varargs használatának fontos szabálya, hogy egy metódus paraméterlistájában max. 1 varargs lehet,
	// és neki kell az utolsó paraméternek lenni, mert csak így egyértelmű a paraméterek hovatartozása 
	
	
	
	
	
}
