package testes;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class PesquisarTratamentos extends JPanel {
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public PesquisarTratamentos() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JTextArea txtrDescriaoTratamento = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtrDescriaoTratamento, -166, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtrDescriaoTratamento, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, txtrDescriaoTratamento, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, txtrDescriaoTratamento, 399, SpringLayout.WEST, this);
		txtrDescriaoTratamento.setText("descri\u00E7ao tratamento");
		add(txtrDescriaoTratamento);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -6, SpringLayout.NORTH, txtrDescriaoTratamento);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"nome"
			}
		));
		scrollPane.setViewportView(table);
		
		JTextArea txtrDescriaoProduto = new JTextArea();
		txtrDescriaoProduto.setText("descri\u00E7ao produto");
		springLayout.putConstraint(SpringLayout.NORTH, txtrDescriaoProduto, 0, SpringLayout.NORTH, txtrDescriaoTratamento);
		springLayout.putConstraint(SpringLayout.WEST, txtrDescriaoProduto, 6, SpringLayout.EAST, txtrDescriaoTratamento);
		springLayout.putConstraint(SpringLayout.SOUTH, txtrDescriaoProduto, 0, SpringLayout.SOUTH, txtrDescriaoTratamento);
		springLayout.putConstraint(SpringLayout.EAST, txtrDescriaoProduto, 391, SpringLayout.EAST, txtrDescriaoTratamento);
		add(txtrDescriaoProduto);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -6, SpringLayout.WEST, scrollPane_1);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 405, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, -6, SpringLayout.NORTH, txtrDescriaoProduto);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, -10, SpringLayout.EAST, this);
		add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"nome"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblProdutosUsadosNo = new JLabel("produtos usados no tratamento");
		springLayout.putConstraint(SpringLayout.NORTH, lblProdutosUsadosNo, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblProdutosUsadosNo, 405, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 13, SpringLayout.SOUTH, lblProdutosUsadosNo);
		add(lblProdutosUsadosNo);
		
		JLabel lblTratamentos = new JLabel("tratamentos");
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 13, SpringLayout.SOUTH, lblTratamentos);
		springLayout.putConstraint(SpringLayout.NORTH, lblTratamentos, 0, SpringLayout.NORTH, lblProdutosUsadosNo);
		springLayout.putConstraint(SpringLayout.WEST, lblTratamentos, 0, SpringLayout.WEST, txtrDescriaoTratamento);
		add(lblTratamentos);

	}

}
