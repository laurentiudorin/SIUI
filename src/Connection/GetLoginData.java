package Connection;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetLoginData extends DatabaseConection{
	
	public static void main(String[] argv) {

		try {

			selectRecordsFromTable();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	private static void selectRecordsFromTable() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT ID, USERNAME, PASSWORD, MOD FROM LOGIN WHERE ID = ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, 12);
			
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				int userid = rs.getInt("ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String mod = rs.getString("MOD");
				
				System.out.println("userid : " + userid);
				System.out.println("username : " + username);

			}
			
			System.out.println("Am ajuns pana aici si nu am gasit nici un rezultat");

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
