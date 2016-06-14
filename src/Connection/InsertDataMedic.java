package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Encryption.Sha256;

public class InsertDataMedic extends DatabaseConection{
	
	private static String cnp;
	private static String parafa;
	private static String domeniu;
	private static String ambulatoriu;

	
	public static void setCnp(String cnp) {
		InsertDataMedic.cnp = cnp;
	}

	public static void setParafa(String parafa) {
		InsertDataMedic.parafa = parafa;
	}

	public static void setDomeniu(String domeniu) {
		InsertDataMedic.domeniu = domeniu;
	}

	public static void setAmbulatoriu(String ambulatoriu) {
		InsertDataMedic.ambulatoriu = ambulatoriu;
	}

	public static void insertRecordIntoTable() throws SQLException {
		
		System.out.println("am inceput DM");
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO MEDIC"
				+ "(CNP, ID_PARAFA, DOMENIU, AMBULATORIU) VALUES"
				+ "(?,?,?,?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, cnp);
			preparedStatement.setString(2, parafa);
			preparedStatement.setString(3, domeniu);
			preparedStatement.setString(4, ambulatoriu);


			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into DBUSER table!");

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

	}
	
	public void DeleteData(){
		 cnp		= null;
		 parafa		= null;
		 domeniu	= null;
		 ambulatoriu= null;
		 
	}


}
