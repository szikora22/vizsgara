package ujsagNyilvantartas;

public class Napilap extends Ujsag {

	private byte hetiHanyszor;

	public Napilap(String megnevezes, String kiado, int ar, byte hetiHanyszor) {
		super(megnevezes, kiado, ar);
		setHetiHanyszor(hetiHanyszor);
	}
	
	public Napilap(String[] csvSor) {
		super(csvSor);
		this.hetiHanyszor = Byte.parseByte(csvSor[4]);
	}

	public byte getHetiHanyszor() {
		return hetiHanyszor;
	}

	public void setHetiHanyszor(byte hetiHanyszor) {
		if ( hetiHanyszor >=4 && hetiHanyszor <=7 ) {	
			this.hetiHanyszor = hetiHanyszor;
		}
		else {
			throw new IllegalArgumentException("A megjelenés heti száma 4 és 7 közé kell essen!");
		}
		
	}
	
	
	public final int hetiArkalkulacio(){
		
		return this.hetiHanyszor * this.getAr();
		
	}

	@Override
	public String toString() {
		return super.toString() + " " + this.hetiHanyszor + " alkalommal megjelenő napilap";
	}
	
}