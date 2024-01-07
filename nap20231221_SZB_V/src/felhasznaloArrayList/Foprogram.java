package felhasznaloArrayList;

import java.io.IOException;
import java.util.List;

public class Foprogram {

	public static void main(String[] args) throws IOException {

		Fajlkezeles fajlObj = new Fajlkezeles();
		
		List<Felhasznalo> felhasznalok = fajlObj.felhasznalokBeolvasasa("felhasznalok.txt");
		
		
		

	}

}
