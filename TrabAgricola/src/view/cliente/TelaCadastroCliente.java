package view.cliente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controller.ClienteController;
import model.vo.conector.Cliente;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNome = new JLabel("Login:");

		JLabel lblSenha = new JLabel("Senha:");

		JLabel lblEmail = new JLabel("Email:");

		txtLogin = new JTextField();
		txtLogin.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		JButton btnRealizarCadastro = new JButton("Realizar Cadastro");
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

				if (clienteController.validarCadastro(login, email) == true) {
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
					clienteController.inserir(cliente);
				}

			}
		});

		JButton btnVoltar = new JButton("Voltar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(36)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblEmail)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(txtEmail))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNome).addComponent(lblSenha))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
														.addComponent(txtSenha).addComponent(txtLogin,
																GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)))))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(91).addComponent(btnRealizarCadastro)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnVoltar)))
				.addContainerGap(117, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(25)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNome).addComponent(
						txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblSenha).addComponent(
						txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblEmail).addComponent(
						txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(41).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRealizarCadastro).addComponent(btnVoltar))
				.addContainerGap(90, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
