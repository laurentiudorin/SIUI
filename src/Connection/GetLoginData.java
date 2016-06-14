package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class GetLoginData extends DatabaseConection{
	
	private static String user;
	private static String password;
	private static String mod; 
	
	public boolean ReturnComfirmation(String user, String password) throws SQLException{
		
		this.user = user;
		this.password = password;
		return selectRecordsFromTable();
	}
	
	private static boolean selectRecordsFromTable() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT USERNAME, PASSWORD, MOD FROM PERSOANA WHERE USERNAME = ? AND PASSWORD =?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			//preparedStatement.setInt(1, 12);
			//preparedStatement.setString(1, Sha256.sha256(user));   // 
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, password);
			
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				user = rs.getString(1);
				password = rs.getString(2);
				mod = rs.getString(3);
				
				System.out.println(""+user+" "+password+" "+ mod);
				
				return true;
			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
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
