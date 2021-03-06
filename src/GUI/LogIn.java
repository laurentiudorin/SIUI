package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Connection.GetLoginData;
import Encryption.Sha256;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField user_textField;
	private JPasswordField password_textField;

	GetLoginData logindata = new GetLoginData();

	/**
	 * Create the frame.
	 */
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 395);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 640, 360);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(349, 104, 39, 14);
		panel.add(lblUser);
		
		user_textField = new JTextField();
		user_textField.setBounds(391, 101, 150, 20);
		panel.add(user_textField);
		user_textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(317, 150, 71, 14);
		panel.add(lblPassword);
		
		password_textField = new JPasswordField();
		password_textField.setBounds(391, 147, 150, 20);
		panel.add(password_textField);
		password_textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					if (logindata.ReturnComfirmation(user_textField.getText(), Sha256.sha256(password_textField.getText())))
					{
						new Main_Gui();
						setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null, "User or Password is INCORECT !!!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(317, 223, 89, 23);
		panel.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(451, 223, 89, 23);
		panel.add(btnCancel);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 640, 360);
		panel.add(lblBackground);
		lblBackground.setIcon(new ImageIcon("D:\\Workspace\\java\\SIUI\\Img\\Login_Background.jpg"));
	}
}
