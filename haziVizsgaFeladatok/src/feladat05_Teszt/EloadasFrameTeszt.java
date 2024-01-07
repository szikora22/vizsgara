package feladat05_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import feladat05.EloadasokFrame;

class EloadasFrameTeszt {

	@Test
	void EloadasokFrameTeszt() throws SQLException {
		
		EloadasokFrame TesztWindow = new EloadasokFrame();
		assertEquals("Színházi előadások", TesztWindow.getFrmEloadasok().getTitle());

		
		
		
	}

}
