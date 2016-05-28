package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetLoginData extends DatabaseConection{
	
	private static String user;
	private static String password;

	
	public boolean ReturnComfirmation(String user, String password) throws SQLException{
		
		this.user = user;
		this.password = password;
		return selectRecordsFromTable();
	}
	
	private static boolean selectRecordsFromTable() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT ID, USERNAME, PASSWORD, MOD FROM LOGIN WHERE USERNAME = ? AND PASSWORD =?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			//preparedStatement.setInt(1, 12);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, password);
			
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				return true;
			}

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
		return false;

	}

}
