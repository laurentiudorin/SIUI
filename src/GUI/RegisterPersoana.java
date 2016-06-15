package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Connection.InsertDataMedic;
import Connection.InsertDataPersoana;

public class RegisterPersoana extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Name;
	private JTextField textField_Pname;
	private JTextField textField_CNP;
	private JTextField textField_Date;
	private JTextField textField_Addres;
	private JTextField textField_State;
	private JTextField textField_User;
	private JTextField textField_Password;
	private JTextField textField_Mod;
	
	InsertDataPersoana 	dp = new InsertDataPersoana();
		
	/**
	 * Create the frame.
	 */
	public RegisterPersoana() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setBounds(10, 11, 46, 14);
		panel.add(lblNume);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(10, 30, 150, 20);
		panel.add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Prenume");
		lblNewLabel.setBounds(210, 11, 46, 14);
		panel.add(lblNewLabel);
		
		textField_Pname = new JTextField();
		textField_Pname.setColumns(10);
		textField_Pname.setBounds(210, 30, 150, 20);
		panel.add(textField_Pname);
		
		JLabel lblCnp = new JLabel("CNP");
		lblCnp.setBounds(10, 61, 46, 14);
		panel.add(lblCnp);
		
		textField_CNP = new JTextField();
		textField_CNP.setColumns(10);
		textField_CNP.setBounds(10, 80, 150, 20);
		panel.add(textField_CNP);
		
		JLabel lblDataNasterii = new JLabel("Data Nasterii");
		lblDataNasterii.setBounds(210, 61, 80, 14);
		panel.add(lblDataNasterii);
		
		textField_Date = new JTextField();
		textField_Date.setColumns(10);
		textField_Date.setBounds(210, 80, 150, 20);
		panel.add(textField_Date);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setBounds(10, 111, 46, 14);
		panel.add(lblAdresa);
		
		textField_Addres = new JTextField();
		textField_Addres.setColumns(10);
		textField_Addres.setBounds(10, 130, 350, 20);
		panel.add(textField_Addres);
		
		JLabel lblTara = new JLabel("Tara");
		lblTara.setBounds(10, 161, 46, 14);
		panel.add(lblTara);
		
		textField_State = new JTextField();
		textField_State.setColumns(10);
		textField_State.setBounds(10, 180, 150, 20);
		panel.add(textField_State);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(10, 211, 46, 14);
		panel.add(lblUser);
		
		textField_User = new JTextField();
		textField_User.setColumns(10);
		textField_User.setBounds(10, 230, 150, 20);
		panel.add(textField_User);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setBounds(210, 211, 46, 14);
		panel.add(lblParola);
		
		textField_Password = new JTextField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(210, 230, 150, 20);
		panel.add(textField_Password);
		
		JLabel lblMod = new JLabel("Mod");
		lblMod.setBounds(10, 265, 46, 14);
		panel.add(lblMod);
		
		textField_Mod = new JTextField();
		textField_Mod.setColumns(10);
		textField_Mod.setBounds(10, 284, 150, 20);
		panel.add(textField_Mod);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dp.setCnp		(textField_CNP.getText());
				dp.setName		(textField_Name.getText());
				dp.setPname		(textField_Pname.getText());
				dp.setBdate		(textField_Date.getText());
				dp.setAddres	(textField_Addres.getText());
				dp.setCountry	(textField_State.getText());
				dp.setUserName	(textField_User.getText());
				dp.setPassword	(textField_Password.getText());
				dp.setMod		(textField_Mod.getText());
				
				
				try {
					dp.insertRecordIntoTable();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dp.DeleteData();
				
				textField_Name.setText(null);
				textField_Pname.setText(null);
				textField_CNP.setText(null);
				textField_Date.setText(null);
				textField_Addres.setText(null);
				textField_State.setText(null);
				textField_User.setText(null);
				textField_Password.setText(null);
				textField_Mod.setText(null);		
				
				repaint();
				
			}
		});
		btnSave.setBounds(72, 315, 89, 23);
		panel.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(211, 315, 89, 23);
		panel.add(btnCancel);
		
		setVisible(true);
	}
}
