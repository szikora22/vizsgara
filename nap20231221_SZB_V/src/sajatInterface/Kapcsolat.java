package sajatInterface;

public class Kapcsolat implements ICSVMentheto	 {
	
	private String nev, cim, email, telefon;
	private Szolgaltatas[] szolgaltatasok;
	
	

	public Kapcsolat(String nev, String cim, String email, String telefon, Szolgaltatas[] szolgaltatasok) {
		super();
		this.nev = nev;
		this.cim = cim;
		this.email = email;
		this.telefon = telefon;
		this.szolgaltatasok = szolgaltatasok;
	}



	@Override
	public String CSVFormatum(String elvalaszto) {
		
		return "Kapcsolat" + elvalaszto + nev + elvalaszto + cim + elvalaszto + email + elvalaszto + telefon + "\n";
		
	}
	
	

}
