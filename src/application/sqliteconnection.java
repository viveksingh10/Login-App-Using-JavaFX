package application;
import java.sql.*;
import java.sql.DriverManager;


public class sqliteconnection {

	public static Connection Connector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:Dummy_DB.db");
			return conn;
		}  catch ( Exception e) {
			System.out.println(e);
			return null;
			
		}

	}

}