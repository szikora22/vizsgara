package fajlrendszerFigyeloSajatEsemeny;

public class FoprogramfajlrendszerFigyelo implements IMappaFigyelesEsemeny {

	public static void main(String[] args) {
		
		FoprogramfajlrendszerFigyelo fff = new FoprogramfajlrendszerFigyelo();
		
		String mappaNev1 = System.getProperty("user.home")+"/desktop";
		// a rendszer jellemzőit kérhetjük le a propertyn keresztül:
		// https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
		
		FajlrendszerFigyelo mappaObj1 = new FajlrendszerFigyelo(mappaNev1);
		System.out.println(mappaNev1+" mappa figyelése megkezdődött");
		mappaObj1.getFeliratkozottObjektumok().add(fff);
		System.out.println(mappaNev1+" mappa változásaira sikeres feliratkozás történt (fff)");
		System.out.println();
		
		String mappaNev2 = "Sajatmappa";
		FajlrendszerFigyelo mappaObj2 = new FajlrendszerFigyelo(mappaNev2);
		System.out.println(mappaNev2+" mappa figyelése megkezdődött");
		mappaObj2.getFeliratkozottObjektumok().add(fff);
		System.out.println(mappaNev2+" mappa változásaira sikeres feliratkozás történt (fff)");
		System.out.println();
		
		MegegyFeliratkozoOsztaly megegyObj = new MegegyFeliratkozoOsztaly();
		mappaObj1.getFeliratkozottObjektumok().add(megegyObj);
		System.out.println(mappaNev1+" mappa változásaira sikeres feliratkozás történt (megegyObj)");
		
	}

	@Override
	public void mappaMegvaltozott(String mappaElerese) {
		
		System.out.println(mappaElerese+" mappa megváltozott\n");		
		
	}

}
