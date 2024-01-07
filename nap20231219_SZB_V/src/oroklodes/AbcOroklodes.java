package oroklodes;

public class AbcOroklodes {

	public static void main(String[] args) {

		Termek altalanosObj = new Termek("kristálycukor", "C01", 490, 50);
		Tejtermek tejObj = new Tejtermek("tejföl", "C02", 550, 28, 20.0f);
		Pekaru pekObj = new Pekaru("kifli", "C03", 59, 70, false);
		
		System.out.println(altalanosObj.toString());
		altalanosObj.tesztAlprogram();
		
		System.out.println(tejObj.toString());
		tejObj.tesztAlprogram();
		
		System.out.println(pekObj.toString());
		pekObj.tesztAlprogram();
		
		Kenyerfele kenyerObj = new Kenyerfele("szeletelt kenyér", "C04", 530, 10, false, "fehér");
		System.out.println(kenyerObj.toString());
		kenyerObj.tesztAlprogram();

	}

}
