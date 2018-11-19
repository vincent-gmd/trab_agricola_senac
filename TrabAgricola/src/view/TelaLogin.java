package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ClienteController;
import view.admin.TelaPrincipalAdmin;
import view.cliente.TelaPrincipalCliente;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 341);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Login:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(23, 17, 59, 34);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(81, 26, 190, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(23, 81, 59, 14);
		contentPane.add(lblSenha);

		txtSenha = new JTextField();
		txtSenha.setBounds(81, 80, 190, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidarCampos(txtNome.getText(), txtSenha.getText());
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.setBounds(37, 148, 89, 34);
		contentPane.add(btnEntrar);

		JButton btnNewButton = new JButton("Criar Cadastro");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(187, 148, 121, 34);
		contentPane.add(btnNewButton);
	}

	private void ValidarCampos(String nome, String senha) {
		ClienteController clienteController = new ClienteController();
		String validacao = clienteController.validarLogin(nome, senha);
		if (txtNome.getText().isEmpty() || txtSenha.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		} else if (validacao == null) {
			JOptionPane.showMessageDialog(null, "Login e senha incorretos!");
		} else {
			JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
			if (validacao.equals("comon")) {
				TelaPrincipalCliente telaPrincipalCliente = new TelaPrincipalCliente();
				telaPrincipalCliente.setVisible(true);
				dispose();
			} else if (validacao.equals("2")) {
				TelaPrincipalAdmin telaPrincipalAdmin = new TelaPrincipalAdmin();
				telaPrincipalAdmin.setVisible(true);
				dispose();
			}
		}

	}
}
