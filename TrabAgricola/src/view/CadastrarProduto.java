package view;

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

public class CadastrarProduto extends JPanel {
	private JTextField textFieldNome;
	private JTextPane textPaneDescricao;
	private ProdutoController controller=new ProdutoController();
	private Produto produto;
	private String prob = "";
	/**
	 * Create the panel.
	 */
	public CadastrarProduto() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		textPaneDescricao = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, textPaneDescricao, -66, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textPaneDescricao, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textPaneDescricao, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, textPaneDescricao, 440, SpringLayout.WEST, this);
		add(textPaneDescricao);
		
		JLabel lblDescrio = new JLabel("descri\u00E7\u00E3o:");
		springLayout.putConstraint(SpringLayout.WEST, lblDescrio, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblDescrio, -6, SpringLayout.NORTH, textPaneDescricao);
		add(lblDescrio);
		
		JLabel lblNome = new JLabel("nome:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNome, -6, SpringLayout.NORTH, lblDescrio);
		springLayout.putConstraint(SpringLayout.EAST, lblNome, -395, SpringLayout.EAST, this);
		add(lblNome);
		
		textFieldNome = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldNome, -3, SpringLayout.NORTH, lblNome);
		springLayout.putConstraint(SpringLayout.WEST, textFieldNome, 6, SpringLayout.EAST, lblNome);
		springLayout.putConstraint(SpringLayout.EAST, textFieldNome, 0, SpringLayout.EAST, textPaneDescricao);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JButton btnCadastrar = new JButton("cadastrar");
		springLayout.putConstraint(SpringLayout.SOUTH, btnCadastrar, -27, SpringLayout.NORTH, textFieldNome);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(validar()) {
					produto =new Produto();
					produto.setNome( textFieldNome.getText());
					produto.setDescricao(textPaneDescricao.getText());
					controller.inserir(produto);
				}else {
					
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnCadastrar, 0, SpringLayout.WEST, textPaneDescricao);
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
		prob = validarCampoString(textFieldNome.getText(),prob,"nome");
		prob = validarCampoString(textPaneDescricao.getText(),prob,"descrição");
		if(prob.equals("")) {
			return true;
		}else {
			JOptionPane.showMessageDialog(this, prob, "erro campos", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
}
