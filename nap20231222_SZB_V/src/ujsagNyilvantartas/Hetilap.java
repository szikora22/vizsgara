package ujsagNyilvantartas;

public class Hetilap extends Ujsag {
	
	private byte hanyadikNaponJelenikMeg;

	public Hetilap(String megnevezes, String kiado, int ar, byte hanyadikNaponJelenikMeg) {
		super(megnevezes, kiado, ar);
		this.hanyadikNaponJelenikMeg = hanyadikNaponJelenikMeg;
	}
	
	public Hetilap(String[] csvSor) {
		super(csvSor);
		this.hanyadikNaponJelenikMeg = Byte.parseByte(csvSor[4]);
	}
	
	public byte getHanyadikNaponJelenikMeg() {
		return hanyadikNaponJelenikMeg;
	}

	public void setHanyadikNaponJelenikMeg(byte hanyadikNaponJelenikMeg) {
		if (hanyadikNaponJelenikMeg >= 1 && hanyadikNaponJelenikMeg <= 7) {
			this.hanyadikNaponJelenikMeg = hanyadikNaponJelenikMeg;	
		}
		else {
			throw new IllegalArgumentException("Megjelenés napja 1 és 7 közé kell essen!");
		}
		
	}

	@Override
	public String toString() {
		return super.toString() + " a hét " + this.hanyadikNaponJelenikMeg + ". napján megjelenő hetilap";
	}
	

}
