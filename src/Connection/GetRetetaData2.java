package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GetRetetaData2 extends DatabaseConection{
	 
	private static String nrReteta;
	private static String diagnostic;
	private static String dataDepistarii;
	private static String observatii;
	private static String medicament;
	private static String cantitate;
	private static String d;
	private static String p;
	private static String s;
	
	public static boolean selectRecordsFromTable(String cnpIn) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL =	  "select PACIENT.NRRETETA as NRRETETA,"
									 +"PACIENT.DIAGNOSTIC as DIAGNOSTIC,"
									 +"PACIENT.DATADEPISTARII as DATADEPISTARII,"
									 +"RETETA.DATAPREZENTA as DATAPREZENTA,"
									 +"RETETA.OBSERVATII as OBSERVATII,"
									 +"RETETA.MEDICAMENT as MEDICAMENT,"
									 +"RETETA.CANTITATE as CANTITATE,"
									 +"RETETA.DIMINEATA as DIMINEATA,"
									 +"RETETA.PRANZ as PRANZ,"
									 +"RETETA.SEARA as SEARA "
						        +"from PERSOANA PERSOANA,"
									 +"RETETA RETETA,"
									 +"PACIENT PACIENT "
							   +"where PERSOANA.CNP =?";
									
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			
			
			preparedStatement.setString(1, cnpIn);
			
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				nrReteta 		= rs.getString(1);
				diagnostic 		= rs.getString(2);
				dataDepistarii 	= rs.getString(3);
				observatii 		= rs.getString(5);
				medicament 		= rs.getString(6);
				cantitate 		= rs.getString(7);
				d 				= rs.getString(8);
				p 				= rs.getString(9);
				s 				= rs.getString(10);
				
				
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

	public static String getNrReteta() {
		return nrReteta;
	}

	public static String getDiagnostic() {
		return diagnostic;
	}

	public static String getDataDepistarii() {
		return dataDepistarii;
	}

	public static String getObservatii() {
		return observatii;
	}

	public static String getMedicament() {
		return medicament;
	}

	public static String getCantitate() {
		return cantitate;
	}

	public static String getD() {
		return d;
	}

	public static String getP() {
		return p;
	}

	public static String getS() {
		return s;
	}


}
