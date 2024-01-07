package oopAlapokOsszefoglaloProjekt;

public class Macska extends Allat {
	
	private boolean hosszuszoru;
	
	

	public Macska(String nev, int suly, boolean hosszuszoru) {
		super(nev, suly);
		this.hosszuszoru = hosszuszoru;
	}

	


	@Override
	public String toString() {
		return super.toString() + (hosszuszoru? "hosszúszőrű" : "rövidszőrű");
	}




	@Override
	public double napiEtelAdag() {
		// TODO Auto-generated method stub
		return getSuly() / 70.0;
	}

}
