package GUI;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Connection.GetLoginData;
import Connection.GetRetetaData;
import Connection.GetRetetaData2;

public class Reteta extends JFrame {

	private JPanel contentPane;
	private JTextField textField_CNP;
	private JTextField textField_Nume;
	private JTextField textField_Prenume;
	private JTextField textField_DataNasteri;
	private JTextField textField_Adresa;
	private JTextField textField_Tara;
	private JTextField textField_NumeM;
	private JTextField textField_PrenumeM;
	private JTextField textField_Parafa;
	private JTextField textField_Domeniu;
	private JTextField textField_Ambulatoriu;
	private JTextField textField_Nr_Reteta;
	private JTextField textField_DataPrezenta;
	private JTextField textField_Diagnostic;
	private JTextField textField_DataDepisatarii;
	private JTextField textField_Medicamentatie;
	private JTextField textField_Cantitate;
	private JTextField textField_D;
	private JTextField textField_P;
	private JTextField textField_S;
	private JTextField textField_Pret;

	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Calendar cal = Calendar.getInstance();
	
	/**
	 * Create the frame.
	 */
	public Reteta() {
		setAlwaysOnTop (true);
		setBounds(100, 100, 800, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCnp = new JLabel("CNP");
		lblCnp.setBounds(30, 56, 46, 14);
		panel.add(lblCnp);
		
		textField_CNP = new JTextField();
		textField_CNP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					
					System.out.println("am apasat pe enter");
					try {
						GetRetetaData.selectRecordsFromTable(textField_CNP.getText());
						GetRetetaData2.selectRecordsFromTable(textField_CNP.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textField_Nume.setText(GetRetetaData.getNume());
					textField_Prenume.setText(GetRetetaData.getPrenume());
					textField_DataNasteri.setText(GetRetetaData.getDataNasteri());
					textField_Adresa.setText(GetRetetaData.getAdresa());
					textField_Tara.setText(GetRetetaData.getTara());
					textField_NumeM.setText(GetLoginData.getNume());
					textField_PrenumeM.setText(GetLoginData.getPrenume());
					textField_Parafa.setText(GetRetetaData.getParafa());
					textField_Domeniu.setText(GetRetetaData.getDomeniu());
					textField_Ambulatoriu.setText(GetRetetaData.getAmbulatoriu());
					
					textField_Nr_Reteta.setText(GetRetetaData2.getNrReteta());
					textField_DataPrezenta.setText(dateFormat.format(cal.getTime()));
					textField_Diagnostic.setText(GetRetetaData2.getDiagnostic());
					textField_DataDepisatarii.setText(GetRetetaData2.getDataDepistarii());
					textField_Medicamentatie.setText(GetRetetaData2.getMedicament());
					textField_Cantitate.setText(GetRetetaData2.getCantitate());
					textField_D.setText(GetRetetaData2.getD());
					textField_P.setText(GetRetetaData2.getP());
					textField_S.setText(GetRetetaData2.getS());
					//textField_Pret.setText(GetRetetaData2.get);   aici forula este extrasa din medicament.pret*cantitate
								}
			}
		});
		textField_CNP.setBounds(86, 53, 138, 20);
		panel.add(textField_CNP);
		textField_CNP.setColumns(10);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setBounds(30, 94, 46, 14);
		panel.add(lblNume);
		
		textField_Nume = new JTextField();
		textField_Nume.setBounds(86, 91, 138, 20);
		panel.add(textField_Nume);
		textField_Nume.setColumns(10);
		
		JLabel lblPrenume = new JLabel("Prenume");
		lblPrenume.setBounds(270, 94, 46, 14);
		panel.add(lblPrenume);
		
		textField_Prenume = new JTextField();
		textField_Prenume.setColumns(10);
		textField_Prenume.setBounds(338, 91, 138, 20);
		panel.add(textField_Prenume);
		
		JLabel lblDataNasteri = new JLabel("Data nasteri");
		lblDataNasteri.setBounds(514, 94, 70, 14);
		panel.add(lblDataNasteri);
		
		textField_DataNasteri = new JTextField();
		textField_DataNasteri.setColumns(10);
		textField_DataNasteri.setBounds(594, 91, 138, 20);
		panel.add(textField_DataNasteri);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setBounds(30, 119, 46, 14);
		panel.add(lblAdresa);
		
		textField_Adresa = new JTextField();
		textField_Adresa.setColumns(10);
		textField_Adresa.setBounds(86, 116, 390, 20);
		panel.add(textField_Adresa);
		
		JLabel lblTara = new JLabel("Tara");
		lblTara.setBounds(514, 119, 70, 14);
		panel.add(lblTara);
		
		textField_Tara = new JTextField();
		textField_Tara.setColumns(10);
		textField_Tara.setBounds(594, 116, 138, 20);
		panel.add(textField_Tara);
		
		JLabel lblNumeM = new JLabel("Nume");
		lblNumeM.setBounds(30, 182, 46, 14);
		panel.add(lblNumeM);
		
		textField_NumeM = new JTextField();
		textField_NumeM.setColumns(10);
		textField_NumeM.setBounds(86, 179, 138, 20);
		panel.add(textField_NumeM);
		
		JLabel lblPrenumeM = new JLabel("Prenume");
		lblPrenumeM.setBounds(270, 182, 46, 14);
		panel.add(lblPrenumeM);
		
		textField_PrenumeM = new JTextField();
		textField_PrenumeM.setColumns(10);
		textField_PrenumeM.setBounds(338, 179, 138, 20);
		panel.add(textField_PrenumeM);
		
		JLabel lblParafa = new JLabel("Parafa");
		lblParafa.setBounds(514, 182, 70, 14);
		panel.add(lblParafa);
		
		textField_Parafa = new JTextField();
		textField_Parafa.setColumns(10);
		textField_Parafa.setBounds(594, 179, 138, 20);
		panel.add(textField_Parafa);
		
		JLabel lblDomeniu = new JLabel("Domeniu");
		lblDomeniu.setBounds(30, 210, 46, 14);
		panel.add(lblDomeniu);
		
		textField_Domeniu = new JTextField();
		textField_Domeniu.setColumns(10);
		textField_Domeniu.setBounds(86, 207, 138, 20);
		panel.add(textField_Domeniu);
		
		JLabel lblAmbulatoriu = new JLabel("ambulatoriu");
		lblAmbulatoriu.setBounds(270, 210, 46, 14);
		panel.add(lblAmbulatoriu);
		
		textField_Ambulatoriu = new JTextField();
		textField_Ambulatoriu.setColumns(10);
		textField_Ambulatoriu.setBounds(338, 207, 394, 20);
		panel.add(textField_Ambulatoriu);
		
		JLabel lblNrReteta = new JLabel("NR. Ret.");
		lblNrReteta.setBounds(30, 278, 46, 14);
		panel.add(lblNrReteta);
		
		textField_Nr_Reteta = new JTextField();
		textField_Nr_Reteta.setColumns(10);
		textField_Nr_Reteta.setBounds(86, 275, 138, 20);
		panel.add(textField_Nr_Reteta);
		
		JLabel lblDataPrez = new JLabel("Data Prez.");
		lblDataPrez.setBounds(514, 275, 70, 14);
		panel.add(lblDataPrez);
		
		textField_DataPrezenta = new JTextField();
		textField_DataPrezenta.setColumns(10);
		textField_DataPrezenta.setBounds(594, 272, 138, 20);
		panel.add(textField_DataPrezenta);
		
		JLabel lblDiagnostic = new JLabel("Diagnostic");
		lblDiagnostic.setBounds(30, 303, 46, 14);
		panel.add(lblDiagnostic);
		
		textField_Diagnostic = new JTextField();
		textField_Diagnostic.setColumns(10);
		textField_Diagnostic.setBounds(86, 300, 390, 20);
		panel.add(textField_Diagnostic);
		
		JLabel lblDataDep = new JLabel("Data Dep.");
		lblDataDep.setBounds(514, 303, 70, 14);
		panel.add(lblDataDep);
		
		textField_DataDepisatarii = new JTextField();
		textField_DataDepisatarii.setColumns(10);
		textField_DataDepisatarii.setBounds(594, 300, 138, 20);
		panel.add(textField_DataDepisatarii);
		
		JLabel lblObservatii = new JLabel("Observatii");
		lblObservatii.setBounds(30, 337, 89, 14);
		panel.add(lblObservatii);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 353, 702, 67);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblMedicament = new JLabel("Medicament");
		lblMedicament.setBounds(30, 431, 46, 14);
		panel.add(lblMedicament);
		
		JLabel lblCantitate = new JLabel("Cantitate");
		lblCantitate.setBounds(356, 431, 46, 14);
		panel.add(lblCantitate);
		
		JLabel lblD = new JLabel("    D");
		lblD.setBounds(430, 431, 46, 14);
		panel.add(lblD);
		
		JLabel lblP = new JLabel("    P");
		lblP.setBounds(470, 431, 46, 14);
		panel.add(lblP);
		
		JLabel lblS = new JLabel("    S");
		lblS.setBounds(510, 431, 46, 14);
		panel.add(lblS);
		
		JLabel lblPret = new JLabel("Pret");
		lblPret.setBounds(570, 431, 46, 14);
		panel.add(lblPret);
		
		textField_Medicamentatie = new JTextField();
		textField_Medicamentatie.setBounds(30, 446, 295, 20);
		panel.add(textField_Medicamentatie);
		textField_Medicamentatie.setColumns(10);
		
		textField_Cantitate = new JTextField();
		textField_Cantitate.setBounds(356, 446, 64, 20);
		panel.add(textField_Cantitate);
		textField_Cantitate.setColumns(10);
		
		textField_D = new JTextField();
		textField_D.setColumns(10);
		textField_D.setBounds(430, 446, 30, 20);
		panel.add(textField_D);
		
		textField_P = new JTextField();
		textField_P.setColumns(10);
		textField_P.setBounds(470, 446, 30, 20);
		panel.add(textField_P);
		
		textField_S = new JTextField();
		textField_S.setColumns(10);
		textField_S.setBounds(510, 446, 30, 20);
		panel.add(textField_S);
		
		textField_Pret = new JTextField();
		textField_Pret.setColumns(10);
		textField_Pret.setBounds(570, 446, 79, 20);
		panel.add(textField_Pret);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 477, 619, 88);
		panel.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(659, 445, 89, 23);
		panel.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(659, 477, 89, 23);
		panel.add(btnDelete);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(659, 511, 89, 54);
		panel.add(btnSave);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("D:\\Workspace\\java\\SIUI\\Img\\Reteta_Background.jpg"));
		Background.setBounds(0, 10, 779, 581);
		panel.add(Background);
		
		setVisible(true);
	}
}
