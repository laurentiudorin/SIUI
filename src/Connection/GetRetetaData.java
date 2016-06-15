package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GetRetetaData extends DatabaseConection{
	 
	private static String CNP;
	private static String nume;
	private static String prenume;
	private static String dataNasteri;
	private static String adresa;
	private static String tara;
	private static String parafa;
	private static String domeniu;
	private static String ambulatoriu;
	
	
	
	public static boolean selectRecordsFromTable(String cnpIn) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL =	"select PERSOANA.CNP as CNP,"
									 +"PERSOANA.NUME as NUME,"
									 +"PERSOANA.PRENUME as PRENUME,"
									 +"PERSOANA.DATANASTERII as DATANASTERII,"
									 +"PERSOANA.ADRESA as ADRESA,"
									 +"PERSOANA.TARA as TARA,"
									 +"MEDIC.ID_PARAFA as ID_PARAFA,"
									 +"MEDIC.DOMENIU as DOMENIU,"
									 +"MEDIC.AMBULATORIU as AMBULATORIU,"
									 +"MEDIC.CNP as CNP "
							+"FROM MEDIC MEDIC,"
									 +"PERSOANA PERSOANA "
							+"where PERSOANA.CNP = ? "
							+"and MEDIC.CNP = ?";
									
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			
			
			preparedStatement.setString(1, cnpIn);
			preparedStatement.setString(2, GetLoginData.getCnp());
			
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				CNP 		= rs.getString(1);
				nume 		= rs.getString(2);
				prenume 	= rs.getString(3);
				dataNasteri = rs.getString(4);
				adresa 		= rs.getString(5);
				tara 		= rs.getString(6);
				parafa 		= rs.getString(7);
				domeniu 	= rs.getString(8);
				ambulatoriu = rs.getString(9);
				
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getString(7));
				System.out.println(rs.getString(8));
				System.out.println(rs.getString(9));
				System.out.println(rs.getString(10));
				
				
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

	public static String getCNP() {
		return CNP;
	}

	public static String getNume() {
		return nume;
	}

	public static String getPrenume() {
		return prenume;
	}

	public static String getDataNasteri() {
		return dataNasteri;
	}

	public static String getAdresa() {
		return adresa;
	}

	public static String getTara() {
		return tara;
	}

	public static String getParafa() {
		return parafa;
	}

	public static String getDomeniu() {
		return domeniu;
	}

	public static String getAmbulatoriu() {
		return ambulatoriu;
	}
	
	

}
