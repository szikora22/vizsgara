package feladat05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



public class ABKezelo {
	
	private static Connection con;
	private static PreparedStatement ps;
	
	
	private ABKezelo(){
		
	}
	
	public static void csatlakozas() throws SQLException {
		
		try {
			
			String connectionString = "jdbc:mysql://localhost:3306/szinhaz_eloadasok_db";
			
			
			
			con = DriverManager.getConnection(connectionString,"root","Ruander2023,.");
			
		} catch (Exception e) {
			throw new SQLException("A csatlakozás sikertelen!" + e.getMessage());
		}
		
	}
	
	public static void kapcsolatBontas() throws SQLException {
		
		try {
			con.close();
		} catch (Exception e) {
			throw new SQLException("A kapcsolat bontása sikertelen" + e.getMessage());
		}
		
		
	}

	public static List<Eloadas> eloadasokBeolvasasa() throws SQLException {

		List<Eloadas> eloadasok = new ArrayList<Eloadas>();
		
		try {
			ps = con.prepareStatement("SELECT * FROM eloadasok");
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				
				eloadasok.add(new Eloadas(res.getString("cim"),
						res.getString("rendezo"),
						res.getTimestamp("bemutato").toLocalDateTime().toLocalDate(),
						res.getInt("eloadas_szam")));
				
			}
			
			res.close();
			
			
		
			
			
		}  catch (SQLException e) {
			throw new SQLException("Adatbáziból olvasás sikertelen! "+e.getMessage());
		}
		
		return eloadasok;
	}

	public static void torles(int selectedIndex) throws SQLException {
		
		 String torlesQuery = "DELETE * FROM eloadasok where cim = ? ";
		 try (PreparedStatement preparedStatement = con.prepareStatement(torlesQuery)) {
			
			 preparedStatement.setInt(1, selectedIndex);
             preparedStatement.executeUpdate();
			
		}catch (Exception  e) {
			 e.printStackTrace();
			 throw new SQLException("Hiba törlés közben");
	            
		}
		
		
		
	}

	
	

}
