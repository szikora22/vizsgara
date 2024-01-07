package dmlJDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/* Írjunk konzolos alkalmazást, melyben az SQL alapok modulban használt dept/emp táblákon hajthatunk végre műveleteket.
  Ha a dml adatbázis nem áll rendelkezésre, telepítsük a mellékelt script futtatásával (DEPT_EMP_MYSQL.sql).
A., Listázzuk ki az összes olyan dolgozót (név, fizetés), akinek a fizetése kevesebb mint a felhasználó által megadott összeg.
B., Listázzuk ki az összes olyan dolgozót (név), aki a felhasználó által megadott azonosítójú vezető beosztottja.
C., Listázzuk ki az összes olyan dolgozót, aki a számviteli osztályon (ACCOUNTING) dolgozik. */

public class ABKezelo {
	
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

	private ABKezelo() {
		
		
	}
	
	
	public static Connection csatlakozas() {
		
		Connection kapcsolat = null;
		try {
			
			String connectionString = "jdbc:mysql://localhost:3306/dml?autoReconnect=true&useSSL=false";
			kapcsolat = DriverManager.getConnection(connectionString,"root","Ruander2010");
			
		} catch (Exception e) {
			
			System.err.println("A csatlakozás sikertelen, a program bezárul! "+e.getMessage());
			System.exit(0);
			
		}
		
		return kapcsolat;
		
	}
	
	
	
	
	public static void kevesetKeresok() {
		
		boolean ujra;
		do {
			ujra = false;
			try (Connection kapcsolat = csatlakozas()) {

				System.out.print("Adja meg az összeghatárt: ");
				int osszeg = Integer.parseInt(br.readLine());
				
				PreparedStatement ps = kapcsolat.prepareStatement("SELECT * from emp WHERE sal<?");
				ps.setInt(1, osszeg);
				
				System.out.println("A megadott összegnél kevesebbet keresők listája:");
				ResultSet res = ps.executeQuery();
				while (res.next()) {
					System.out.println(res.getString("ename")+" "+res.getInt("sal")+"$");
				}

			} catch (SQLException e) {

				System.err.println("DB hiba " + e.getMessage());

			} catch (NumberFormatException e) {

				System.err.println("Számformátum hiba!");
				ujra = true;

			} catch (IOException e) {

				System.err.println("I/O hiba! " + e.getMessage());

			} 
		} while (ujra);
		
		
	}


	public static void beosztottakListaja() {
		
		boolean ujra;
		do {
		
			ujra = false;
			try (Connection kapcsolat = csatlakozas()){
				
				System.out.print("Adja meg a főnök azonosítóját: ");
				int fonokID = Integer.parseInt(br.readLine());
						
				PreparedStatement ps = kapcsolat.prepareStatement("SELECT * from emp WHERE mgr=?");
				ps.setInt(1, fonokID);
				
				ResultSet res = ps.executeQuery();
				
				if (res.isBeforeFirst()) {
					
					System.out.println("A főnök beosztottjai:");
					while(res.next()) {
						
						System.out.println(res.getString("ename"));
						
					}
					
				}
				else {
					
					System.out.println("Nem létező ID vagy nincs beosztott");
					
				}

			} catch (SQLException e) {

				System.err.println("DB hiba " + e.getMessage());

			} catch (NumberFormatException e) {

				System.err.println("Számformátum hiba!");
				ujra = true;

			} catch (IOException e) {

				System.err.println("I/O hiba! " + e.getMessage());

			} 
			
			
		} while (ujra);
		
	}


	public static void osztalyDolgozoi(String osztaly) {
		
		try (Connection kapcsolat = csatlakozas()){
			
			String sqlUtasitas = "SELECT * from emp where deptno = ANY (SELECT deptno from dept where dname=?)";
			PreparedStatement ps = kapcsolat.prepareStatement(sqlUtasitas);
			ps.setString(1, osztaly);
			
			ResultSet res = ps.executeQuery();
			if (res.isBeforeFirst()) {
				
				System.out.println("Az " + osztaly+" osztály dolgozói");
				while (res.next()) {
					
					System.out.println(res.getString("ename"));
					
				}
				
			}
			else {
				
				System.out.println("Nem létező osztály vagy nincsenek dolgozói");
			}
			
		} catch (SQLException e) {
			
			System.err.println("DB hiba " + e.getMessage());
		}
		
		
	}

}
