package allatmenhelyTeszt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import allatmenhely.Allat;

class AllatTeszt {

	@Test
	void AllatTeszt() {
		
		// előfeltétel, Allat osztályból egy (leszármazott) példány:
		Allat allat = new Allat("állat",12) {
			
			@Override
			public double napiEtelAdag() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
		assertEquals(12, allat.getSuly());
		
	}
	
	
	@Test
	void setNevTeszt() {
		
		
		assertThrows(IllegalArgumentException.class, () -> new Allat(null, 10){
			
			@Override
			public double napiEtelAdag() {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		
		
	}
	
	
	@Test
	void setSulyTeszt() {
		
		
		assertThrows(IllegalArgumentException.class, () -> new Allat("kisállat", 1){
			
			@Override
			public double napiEtelAdag() {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
