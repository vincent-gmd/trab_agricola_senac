package view.cliente;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaProdutoCliente extends JPanel {
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtFiltro;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TelaProdutoCliente() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		final JPanel panelFiltro = new JPanel();
		panelFiltro.setBackground(SystemColor.activeCaption);
		panelFiltro.setBounds(0, 0, 971, 387);
		add(panelFiltro);
		panelFiltro.setLayout(null);
	
		final JPanel panelCadastro = new JPanel();
		panelCadastro.setBounds(590, 68, 403, 285);
		panelFiltro.add(panelCadastro);
		panelCadastro.setBackground(SystemColor.activeCaption);
		panelCadastro.setLayout(null);
		panelCadastro.setVisible(false);
		
		JLabel lblFiltro = new JLabel("Filtro Inteligente");
		lblFiltro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFiltro.setBounds(10, 11, 96, 17);
		panelFiltro.add(lblFiltro);
		
		txtFiltro = new JTextField();
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(116, 11, 190, 20);
		panelFiltro.add(txtFiltro);
		
		final JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
				
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(146, 231, 100, 30);
		panelCadastro.add(btnCadastrar);
		
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemover.setBounds(414, 302, 96, 30);
		panelFiltro.add(btnRemover);
		
		final JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(146, 231, 100, 30);
		panelCadastro.add(btnSalvar);
		
		final JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCadastro.setVisible(true);
				btnCadastrar.setVisible(false);
				btnSalvar.setVisible(true);
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterar.setBounds(215, 302, 100, 30);
		panelFiltro.add(btnAlterar);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProdutos.setBounds(10, 57, 76, 23);
		panelFiltro.add(lblProdutos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 500, 200);
		panelFiltro.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Descrição"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNovoProduto = new JButton("Novo Produto");
		btnNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCadastro.setVisible(true);
				btnSalvar.setVisible(false);
				btnCadastrar.setVisible(true);
				
			}
		});
		btnNovoProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovoProduto.setBounds(10, 302, 140, 30);
		panelFiltro.add(btnNovoProduto);
		
		
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(20, 26, 46, 14);
		panelCadastro.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(76, 24, 190, 20);
		panelCadastro.add(txtNome);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(20, 55, 67, 17);
		panelCadastro.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(20, 83, 324, 109);
		panelCadastro.add(txtDescricao);

	}
	private void limparTela() {
		txtNome.setText("");
		txtDescricao.setText("");
	}
	
	
}
