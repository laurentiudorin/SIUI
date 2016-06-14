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

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Name;
	private JTextField textField_Pname;
	private JTextField textField_CNP;
	private JTextField textField_Date;
	private JTextField textField_Addres;
	private JTextField textField_State;
	private JTextField textField_Parafa;
	private JTextField textField_Domain;
	private JTextField textField_Ambulatoriu;
	private JTextField textField_User;
	private JTextField textField_Password;
	
	InsertDataMedic dm = new InsertDataMedic();
	private JTextField textField_Mod;

	

	/**
	 * Create the frame.
	 */
	public Register() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 498);
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
		lblTara.setBounds(210, 161, 46, 14);
		panel.add(lblTara);
		
		textField_State = new JTextField();
		textField_State.setColumns(10);
		textField_State.setBounds(210, 180, 150, 20);
		panel.add(textField_State);
		
		JLabel lblUsser = new JLabel("ID Parafa");
		lblUsser.setBounds(10, 211, 150, 14);
		panel.add(lblUsser);
		
		textField_Parafa = new JTextField();
		textField_Parafa.setColumns(10);
		textField_Parafa.setBounds(10, 230, 150, 20);
		panel.add(textField_Parafa);
		
		JLabel lblParla = new JLabel("Domeniu");
		lblParla.setBounds(210, 211, 46, 14);
		panel.add(lblParla);
		
		textField_Domain = new JTextField();
		textField_Domain.setColumns(10);
		textField_Domain.setBounds(210, 230, 150, 20);
		panel.add(textField_Domain);
		
		JLabel lblAmbulatoriu = new JLabel("Ambulatoriu");
		lblAmbulatoriu.setBounds(10, 261, 150, 14);
		panel.add(lblAmbulatoriu);
		
		textField_Ambulatoriu = new JTextField();
		textField_Ambulatoriu.setColumns(10);
		textField_Ambulatoriu.setBounds(10, 280, 350, 20);
		panel.add(textField_Ambulatoriu);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(10, 311, 46, 14);
		panel.add(lblUser);
		
		textField_User = new JTextField();
		textField_User.setColumns(10);
		textField_User.setBounds(10, 330, 150, 20);
		panel.add(textField_User);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setBounds(210, 311, 46, 14);
		panel.add(lblParola);
		
		textField_Password = new JTextField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(210, 330, 150, 20);
		panel.add(textField_Password);
		
		JLabel lblMod = new JLabel("Mod");
		lblMod.setBounds(10, 365, 46, 14);
		panel.add(lblMod);
		
		textField_Mod = new JTextField();
		textField_Mod.setColumns(10);
		textField_Mod.setBounds(10, 384, 150, 20);
		panel.add(textField_Mod);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dm.setCnp		(textField_Name.getText());
				dm.setName		(textField_Pname.getText());
				dm.setPname		(textField_CNP.getText());
				dm.setBdate		(textField_Date.getText());
				dm.setAddres	(textField_Addres.getText());
				dm.setCountry	(textField_State.getText());
				dm.setUserName	(textField_User.getText());
				dm.setPassword	(textField_Password.getText());
				dm.setMod		(textField_Mod.getText());
				
				try {
					dm.insertRecordIntoTable();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dm.DeleteData();
				
				textField_Name.setText(null);
				textField_Pname.setText(null);
				textField_CNP.setText(null);
				textField_Date.setText(null);
				textField_Addres.setText(null);
				textField_State.setText(null);
				textField_Parafa.setText(null);
				textField_Domain.setText(null);
				textField_Ambulatoriu.setText(null);
				textField_User.setText(null);
				textField_Password.setText(null);
				textField_Mod.setText(null);		
				
				repaint();
				
			}
		});
		btnSave.setBounds(72, 415, 89, 23);
		panel.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(211, 415, 89, 23);
		panel.add(btnCancel);
		
		setVisible(true);
	}
}
