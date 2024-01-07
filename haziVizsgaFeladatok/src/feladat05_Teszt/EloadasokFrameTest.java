package feladat05_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import feladat05.EloadasokFrame;

class EloadasokFrameTest {

	@Test
	void initializeTeszt() throws SQLException {
		
		EloadasokFrame foAblak = new EloadasokFrame();
		
		// szélesség 700 ellenőrzése:
		assertTrue(foAblak.getFrmEloadasok().getBounds().width == 700);

	}

}
