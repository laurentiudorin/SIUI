package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConection {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "SIUI";
	private static final String DB_PASSWORD = "parola";
	
	
	
	public static Connection getDBConnection() {

		Connection dbConnection = null;

		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {
			// Setup the connection with the DB
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return dbConnection;

	}
}
