package view.admin;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class CadastroCliente extends JPanel {
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public CadastroCliente() {
		setLayout(null);
		
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(26, 60, 73, 20);
		add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(102, 62, 150, 20);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(26, 111, 73, 14);
		add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(102, 110, 150, 20);
		add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(26, 158, 61, 14);
		add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(102, 157, 150, 20);
		add(textField);
		textField.setColumns(10);
	}
}