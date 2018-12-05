package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ClienteController;
import controller.TelaClienteControler;
import model.vo.conector.Cliente;
import view.admin.TelaPrincipalAdmin;
import view.cliente.TelaPrincipalCliente;
import javax.swing.JPasswordField;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private TelaCadastro telaCadastro;
	private static TelaLogin frameLogin = new TelaLogin();
	private JPasswordField passSenha;

	public JPanel getContentJPanel() {
		return contentPane;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameLogin.setVisible(true);
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
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/icones/icons8-ovelha-2-26.png")));
		setTitle("TrabGricola");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 341);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Login:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(94, 146, 59, 34);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(153, 155, 190, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(94, 191, 59, 14);
		contentPane.add(lblSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidarCampos(txtNome.getText(),new String(passSenha.getPassword()));
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.setBounds(94, 221, 89, 25);
		contentPane.add(btnEntrar);

		JButton btnCadastro = new JButton("Criar Cadastro");
		btnCadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				telaCadastro = new TelaCadastro();
				setContentPane(telaCadastro);
				telaCadastro.setVisible(true);
				telaCadastro.updateUI();

			}
		});
		btnCadastro.setBounds(222, 221, 121, 25);
		contentPane.add(btnCadastro);

		JLabel label = new JLabel("TrabGricola");
		label.setIcon(new ImageIcon(TelaLogin.class.getResource("/icones/icons8-ovelha-2-filled-100.png")));
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Ink Free", Font.BOLD, 18));
		label.setBounds(136, 32, 207, 100);
		contentPane.add(label);
		
		passSenha = new JPasswordField();
		passSenha.setBounds(153, 190, 190, 20);
		contentPane.add(passSenha);
	}

	private void ValidarCampos(String nome, String senha) {
		ClienteController clienteController = new ClienteController();

		if (txtNome.getText().isEmpty() )/*|| passSenha.getPassword().isEmpty)*/ {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			return;
		}
		Cliente cliente = clienteController.validarLogin(nome, senha);
		if (cliente == null) {
			JOptionPane.showMessageDialog(null, "Login ou senha incorretos!");
		} else {
			if(cliente.getNivelAcesso()==null) {
				JOptionPane.showMessageDialog(null, "errol assesso invalido!");
				return;
			}

			if (cliente.getNivelAcesso().equals("admin")) {
				TelaPrincipalAdmin telaPrincipalAdmin = new TelaPrincipalAdmin();
				telaPrincipalAdmin.setVisible(true);
				dispose();
			} else if (cliente.getNivelAcesso().equals("comon")) {
				TelaClienteControler telaClienteControler = new TelaClienteControler();
				telaClienteControler.setCliente(cliente);
				TelaPrincipalCliente telaPrincipalCliente = new TelaPrincipalCliente(telaClienteControler);
				telaPrincipalCliente.setVisible(true);
				dispose();
			} else if (cliente.getNivelAcesso().equals("certified")) {
				TelaClienteControler telaClienteControler = new TelaClienteControler();
				telaClienteControler.setCliente(cliente);
				TelaPrincipalCliente telaPrincipalCliente = new TelaPrincipalCliente(telaClienteControler);
				telaPrincipalCliente.setVisible(true);
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "errol assesso invalido!");

			}
		}

	}

	public void mostrarTelaLogin() {
		setContentPane(contentPane);
		contentPane.setVisible(true);
		contentPane.updateUI();

	}
}
