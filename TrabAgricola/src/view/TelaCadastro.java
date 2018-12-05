package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import controller.ClienteController;
import model.vo.conector.Cliente;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaCadastro extends JPanel {
	private JTextField txtEmail;
	private JTextField txtLogin;
	private TelaCadastro panelCadastro;
	private JPasswordField passSenha;

	/**
	 * Create the panel.
	 */
	public TelaCadastro() {
		panelCadastro = this;
		setBackground(new Color(85, 107, 47));

		JButton brnRealizarCadastro = new JButton("Realizar Cadastro");
		brnRealizarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteController clienteController = new ClienteController();
				Cliente cliente = new Cliente();
				String login = txtLogin.getText();
				String senha = new String(passSenha.getPassword());
				String email = txtEmail.getText();
				cliente.setEmail(email);
				cliente.setLogin(login);
				cliente.setSenha(senha);
				cliente.setNivelAcesso("comon");


				if (clienteController.validarCadastro(login, email) == true) {
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
					clienteController.inserir(cliente);
				} else {
					System.out.println("teste");
				}
			}
		});
		brnRealizarCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin pai = (TelaLogin) SwingUtilities.windowForComponent(panelCadastro);
				pai.mostrarTelaLogin();

			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel label = new JLabel("TrabGricola");
		label.setIcon(new ImageIcon(TelaCadastro.class.getResource("/icones/icons8-ovelha-2-filled-100.png")));
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Ink Free", Font.BOLD, 18));

		JLabel label_1 = new JLabel("Senha:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel label_2 = new JLabel("Email:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBackground(Color.WHITE);

		JLabel label_3 = new JLabel("Login:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		
		passSenha = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(103)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(brnRealizarCadastro, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(passSenha))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(7)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGap(4)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(115, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(37, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(passSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(brnRealizarCadastro)
						.addComponent(btnVoltar))
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
