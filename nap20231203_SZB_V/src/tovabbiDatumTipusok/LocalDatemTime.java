package tovabbiDatumTipusok;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class LocalDatemTime {

	public static void main(String[] args) {

		// LocalDate --> immutable; szálbiztos; csak dátumot tartalmaz
		
		LocalDate datum = LocalDate.now();
		LocalDate datum2 = LocalDate.parse("2011-07-21");
		LocalDate datum3 = LocalDate.of(1999, 8, 17);
		
		System.out.println(datum);
		System.out.println(datum2);
		System.out.println(datum3);
		
		System.out.format("Dátum: %tY.%tm.%td%n",datum3,datum3,datum3);
		
		LocalTime ido = LocalTime.now();
		System.out.println(ido);

		System.out.println(ido.getHour() + " " + ido.getMinute());
		
		LocalDateTime datumIdo = LocalDateTime.now();
		System.out.println(datumIdo);

		System.out.println(Period.between(datum2, datum).getYears());
		System.out.println(Period.between(datum2, datum).getMonths());
		System.out.println(Period.between(datum2, datum).getDays());
		
		System.out.println(datum2.plus(Period.ofDays(10)));
		System.out.println(datum2);
		
		
	}

}
