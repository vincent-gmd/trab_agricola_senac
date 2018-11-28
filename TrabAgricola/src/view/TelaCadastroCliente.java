package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ClienteController;
import model.vo.conector.Cliente;

public class TelaCadastroCliente extends JFrame {

	public JPanel getContentJPanel() {
		return contentPane;
	}

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTextField txtEmail;
	private TelaLogin telaLogin;
	private static TelaCadastroCliente frameCadastro = new TelaCadastroCliente();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameCadastro.setVisible(true);
					frameCadastro.setTitle("TrabGricola");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroCliente() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaCadastroCliente.class.getResource("/icones/icons8-ovelha-2-26.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNome = new JLabel("Login:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBackground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtLogin = new JTextField();
		txtLogin.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		JButton btnRealizarCadastro = new JButton("Realizar Cadastro");
		btnRealizarCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRealizarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteController clienteController = new ClienteController();
				Cliente cliente = new Cliente();
				String login = txtLogin.getText();
				String senha = txtSenha.getText();
				String email = txtSenha.getText();
				cliente.setEmail(email);
				cliente.setLogin(login);
				cliente.setSenha(senha);
				cliente.setNivelAcesso("comon");


				if (clienteController.validarCadastro(login, email) == true) {
					
					clienteController.inserir(cliente);
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				}

			}
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				telaLogin = new TelaLogin();
				//JPanel contentPane = telaLogin.getContentJPanel();
				//setContentPane(contentPane);
				//contentPane.setVisible(true);
				//contentPane.updateUI();
				telaLogin.setVisible(true);
				dispose();


			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblNewLabel = new JLabel("TrabGricola");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Ink Free", Font.BOLD, 18));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setIcon(
				new ImageIcon(TelaCadastroCliente.class.getResource("/icones/icons8-ovelha-2-filled-100.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addContainerGap(101, Short.MAX_VALUE)
								.addComponent(btnRealizarCadastro).addGap(18).addComponent(btnVoltar).addGap(117))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING,
										gl_contentPane.createSequentialGroup().addGap(
												108).addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 196,
														Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(91)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblSenha).addComponent(lblEmail).addComponent(lblNome))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(txtSenha).addComponent(txtEmail).addComponent(txtLogin,
														GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))))
						.addGap(120)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNome))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSenha))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblEmail)
										.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnRealizarCadastro).addComponent(btnVoltar))
								.addGap(27)));
		contentPane.setLayout(gl_contentPane);

	}
}
