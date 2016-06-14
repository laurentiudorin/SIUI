package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Encryption.Sha256;

public class InsertDataPersoana extends DatabaseConection{
	
	private static String cnp;
	private static String name;
	private static String pname;
	private static String bdate;
	private static String addres;
	private static String country;
	private static String userName;
	private static String password;
	private static String mod;
	
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMod(String mod) {
		this.mod = mod;
	}

	

	public static void insertRecordIntoTable() throws SQLException {
		
		System.out.println("Am inceput DP");
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO persoana"
				+ "(CNP, NUME, PRENUME, DATANASTERII, ADRESA, TARA, USERNAME, PASSWORD, MOD) VALUES"
				+ "(?,?,?,?,?,?,?,?,?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, cnp);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, pname);
			preparedStatement.setString(4, bdate);
			preparedStatement.setString(5, addres);
			preparedStatement.setString(6, country);
			preparedStatement.setString(7, userName);
			preparedStatement.setString(8, Sha256.sha256(password));
			preparedStatement.setString(9, mod);

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
		System.out.println("Am terminat DP");
	}
	
	public void DeleteData(){
		 cnp= null;
		 name= null;
		 pname= null;
		 bdate= null;
		 addres= null;
		 country= null;
		 userName= null;
		 password= null;
		 mod= null;
	}


}
