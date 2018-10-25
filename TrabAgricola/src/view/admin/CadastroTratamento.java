package view.admin;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class CadastroTratamento extends JPanel {
	private JTextField txtNome;
	private JTextField txtDescricao;

	/**
	 * Create the panel.
	 */
	public CadastroTratamento() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(56, 36, 60, 14);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(126, 35, 157, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescrio.setBounds(201, 185, 90, 20);
		add(lblDescrio);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(59, 227, 406, 109);
		add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblImagem = new JLabel("Imagem:");
		lblImagem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImagem.setBounds(56, 91, 77, 20);
		add(lblImagem);

	}

}
