package testes;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PesquisarDoenças extends JPanel {
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PesquisarDoenças() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JTextArea txtrDescrio = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtrDescrio, 202, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtrDescrio, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, txtrDescrio, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, txtrDescrio, 440, SpringLayout.WEST, this);
		txtrDescrio.setText("descri\u00E7\u00E3o");
		add(txtrDescrio);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 87, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -6, SpringLayout.NORTH, txtrDescrio);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 440, SpringLayout.WEST, this);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"nome", "causador"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblFiltroInteligente = new JLabel("filtro inteligente:");
		springLayout.putConstraint(SpringLayout.NORTH, lblFiltroInteligente, -20, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, lblFiltroInteligente, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblFiltroInteligente, -6, SpringLayout.NORTH, scrollPane);
		add(lblFiltroInteligente);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblFiltroInteligente);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -6, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, scrollPane);
		add(textField);
		textField.setColumns(10);
		
		JButton btnVerTratamentos = new JButton("ver tratamentos");
		springLayout.putConstraint(SpringLayout.SOUTH, btnVerTratamentos, -6, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, btnVerTratamentos, 0, SpringLayout.EAST, scrollPane);
		add(btnVerTratamentos);

	}
}
