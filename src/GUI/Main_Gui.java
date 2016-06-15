package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Main_Gui extends JFrame {

	private JPanel contentPane;

	
	public Main_Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNew = new JMenu("New");
		menuBar.add(mnNew);
		
		JMenuItem mntmReteta = new JMenuItem("Reteta");
		mntmReteta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Reteta();
			}
		});
		mnNew.add(mntmReteta);
		
		JMenu mnRegister = new JMenu("Register");
		menuBar.add(mnRegister);
		
		JMenuItem mntmRegister = new JMenuItem("Medic");
		mntmRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Register();
			}
		});
		
		JMenuItem mntmPersoana = new JMenuItem("Persoana");
		mntmPersoana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterPersoana();
			}
		});
		mnRegister.add(mntmPersoana);
		mnRegister.add(mntmRegister);
		
		JMenu mnExit = new JMenu("Exit");
		menuBar.add(mnExit);
		
		JMenuItem mntmExit = new JMenuItem("exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LogIn log = new LogIn();
				log.setVisible(true);
			}
		});
		mnExit.add(mntmLogOut);
		mnExit.add(mntmExit);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 1276, 726);
		lblNewLabel.setIcon(new ImageIcon("D:\\Workspace\\java\\SIUI\\Img\\Main_App_Background.jpg"));
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//setUndecorated(true);
		setVisible(true);
	}
}
