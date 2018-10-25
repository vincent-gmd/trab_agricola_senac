package view.admin;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controller.ProdutoController;
import model.vo.Produto;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Component;
import javax.swing.Box;

public class CadastrarProduto extends JPanel {
	private JTextField txtNome;
	private JTextPane textPaneDescricao;
	private ProdutoController controller=new ProdutoController();
	private Produto produto;
	private String prob = "";
	/**
	 * Create the panel.
	 */
	public CadastrarProduto() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		textPaneDescricao = new JTextPane();
		textPaneDescricao.setBounds(36, 152, 415, 108);
		add(textPaneDescricao);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(208, 113, 73, 20);
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblDescricao);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(122, 50, 48, 20);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(176, 52, 150, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(171, 285, 98, 28);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(validar()) {
					produto =new Produto();
					produto.setNome( txtNome.getText());
					produto.setDescricao(textPaneDescricao.getText());
					controller.inserir(produto);
				}else {
					
				}
			}
		});
		add(btnCadastrar);

	}
	String validarCampoString(String text,String prob,String nomeCampo) {
		if(text==null || text.trim().equals("")) {
			return prob +="preencha campo: " + nomeCampo+"\n";
			
		}else {
			return prob;
		}
	}
	protected boolean validar() {
		prob = "";
		prob = validarCampoString(txtNome.getText(),prob,"nome");
		prob = validarCampoString(textPaneDescricao.getText(),prob,"descrição");
		if(prob.equals("")) {
			return true;
		}else {
			JOptionPane.showMessageDialog(this, prob, "erro campos", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
}
