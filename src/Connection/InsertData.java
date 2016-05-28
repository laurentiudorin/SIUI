package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData extends DatabaseConection{
	
	public static void main(String[] argv) {

		try {

			insertRecordIntoTable();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	private static void insertRecordIntoTable() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO login"
				+ "(ID, USERNAME, PASSWORD, MOD) VALUES"
				+ "(?,?,?,?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, 13);
			preparedStatement.setString(2, "Medic");
			preparedStatement.setString(3, "pass");
			preparedStatement.setString(4, "Medic");
			//preparedStatement.setTimestamp(4, getCurrentTimeStamp());

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

}
