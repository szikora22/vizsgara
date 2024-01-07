package sajatInterface;

public class Szolgaltatas implements ICSVMentheto {
	
	private String megnevezes;
	private int ar;
	
	
	
	

	public Szolgaltatas(String megnevezes, int ar) {
		super();
		this.megnevezes = megnevezes;
		this.ar = ar;
	}





	@Override
	public String CSVFormatum(String elvalaszto) {
		
		return "Szolgaltatas" + elvalaszto + megnevezes + elvalaszto + ar + "\n";
	}

}
