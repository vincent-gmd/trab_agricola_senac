package view.cliente;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroPropriedade extends JPanel {
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtLatitude;
	private JTextField txtLongitude;

	/**
	 * Create the panel.
	 */
	public CadastroPropriedade() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDocumento.setBounds(10, 11, 96, 17);
		add(lblDocumento);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setColumns(10);
		txtNome.setBounds(95, 9, 190, 20);
		add(txtNome);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereco.setBounds(10, 54, 75, 17);
		add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(95, 54, 190, 20);
		add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblDataDeCadastro = new JLabel("Data de Cadastro:");
		lblDataDeCadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeCadastro.setBounds(10, 95, 119, 14);
		add(lblDataDeCadastro);
		
		JLabel lblLatitude = new JLabel("Latitude:");
		lblLatitude.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLatitude.setBounds(10, 136, 62, 14);
		add(lblLatitude);
		
		JLabel lblLongitude = new JLabel("Longitude:");
		lblLongitude.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLongitude.setBounds(10, 176, 75, 17);
		add(lblLongitude);
		
		txtLatitude = new JTextField();
		txtLatitude.setBounds(95, 135, 190, 20);
		add(txtLatitude);
		txtLatitude.setColumns(10);
		
		txtLongitude = new JTextField();
		txtLongitude.setBounds(95, 176, 190, 20);
		add(txtLongitude);
		txtLongitude.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(141, 259, 100, 30);
		add(btnNewButton);

	}

}
