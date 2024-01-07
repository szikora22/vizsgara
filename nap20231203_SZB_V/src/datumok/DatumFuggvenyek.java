package datumok;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatumFuggvenyek {

	public static void main(String[] args) throws ParseException {


		// Date
		
		Date datum = new Date(98,10,15);
		System.out.println(datum);
		
		Date datum2 = new Date(122,16,38); // az év 1900-tól számítva, hónap 0..11, nap 1..31
		System.out.println(datum2);
		
		Date datum3 = new Date(); // az aktuális dátum és idő
		System.out.println(datum3);
		
		//az elvault konstruktor helyett formázott értékként adhatjuk meg a dátumot a SimpleDateFormat használatával:
		
		Date datum4 = new SimpleDateFormat("yy/dd/MM hh:mm:ss").parse("21/08/09 15:33:10");
		Date datum5 = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").parse("2015.01.27 12:30:10");
		
		System.out.println(datum4);
		System.out.println(datum5);
		
		System.out.format("%tY.%tm.%te %n",datum5,datum5,datum5);

		Calendar calendar = new GregorianCalendar();
		Calendar naptar = Calendar.getInstance(); 
		System.out.println(naptar);
		System.out.println(naptar.get(Calendar.YEAR));
		System.out.println(naptar.get(Calendar.MONTH));
		
		
	}

}
