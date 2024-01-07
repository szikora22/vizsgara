package feladat05_JavaAdatbazis;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ABKezelo {
	
	private static Connection con;
	private static PreparedStatement ps;
	
	
	private ABKezelo() {
		
		
		
		
	}
	
	public static void csatlakozas() throws SQLException {
		
		try {
			
			String connectionString = "jdbc:mysql://localhost:3306/film_db";
			
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

	public static List<Film> filmekBeolvasasa() throws SQLException {

		List<Film> filmek = new ArrayList<Film>();
		
		
		try {
			ps = con.prepareStatement("SELECT * FROM filmkatalogus");
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				
				// táblából kell kiszedni a neveket
				
				filmek.add(new Film(res.getString("azonosito")
						,res.getString("megnevezes")
						,res.getInt("bemutatas")
						,res.getLong("bevetel")
						,res.getBoolean("oscar")));
				
			}
			
			res.close();
			
		} catch (SQLException e) {
			throw new SQLException("Adatbáziból olvasás sikertelen! "+e.getMessage());
		}
		
		
		
		return filmek;
	}
	
	public static void ujFilm(Film film) throws SQLException {
		
		try {
			
			ps = con.prepareStatement("INSERT INTO filmkatalogus VALUES (?,?,?,?,?)");
			
			ps.setString(1, film.getAzonosito());
			ps.setString(2, film.getFilmCim());
			ps.setInt(3, film.getBemutatoEve());
			ps.setLong(4, film.getOsszBevetel());
			ps.setBoolean(5, film.isOscar());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new SQLException("Adatbázisba írás sikertelen! "+e.getMessage());
		}
		
	}
	
	

}
