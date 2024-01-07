package szelvenykitoltoDinamikusGombok;

/* Készítsünk lottószelvény kitöltő alkalmazást.
A program indításakor generáljon a Frame-re combobox-ból kiválasztott játéktípusnak megfelelő számú JButton-t (soronként maximum tízet).
A gombok az egyes számokat jelenítsék meg.
Gombra kattintva a szám kijelöltté válik (piros betűszín), újrakattintva a kijelölés törlődik (fekete betűszín).
Legyen egy tippeket véglegesítő gomb, ami csak akkor aktív, ha annyi kijelölt szám van, amennyi kihúzásra kerül. */

public enum LottoFajta {
	
	OTOS("ötös",5,90), HATOS("hatos",6,45), HETES("skandi",7,35);
	
	private final String megnevezes;
	private final int hanySzamotHuznak;
	private final int hanySzambolHuzzak;
	
	public int getHanySzamotHuznak() {
		return hanySzamotHuznak;
	}

	public int getHanySzambolHuzzak() {
		return hanySzambolHuzzak;
	}

	private LottoFajta(String megnevezes, int hanySzamotHuznak, int hanySzambolHuzzak) {
		this.megnevezes = megnevezes;
		this.hanySzamotHuznak = hanySzamotHuznak;
		this.hanySzambolHuzzak = hanySzambolHuzzak;
	}
	
	public String toString() {
		
		return megnevezes;
		
	}
	

}
