package view.cliente;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class PesquisarCultura extends JPanel {

	/**
	 * Create the panel.
	 */
	public PesquisarCultura() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblTipo = new JLabel("tipo:");
		add(lblTipo);
		
		JLabel lblNome = new JLabel("nome:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNome, 38, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNome, 193, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, lblTipo, 0, SpringLayout.NORTH, lblNome);
		add(lblNome);
		
		JLabel lblDescrio = new JLabel("descri\u00E7\u00E3o:");
		springLayout.putConstraint(SpringLayout.NORTH, lblDescrio, 78, SpringLayout.SOUTH, lblTipo);
		springLayout.putConstraint(SpringLayout.EAST, lblTipo, 0, SpringLayout.EAST, lblDescrio);
		springLayout.putConstraint(SpringLayout.WEST, lblDescrio, 10, SpringLayout.WEST, this);
		add(lblDescrio);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 34, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -6, SpringLayout.WEST, lblNome);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, -4, SpringLayout.NORTH, lblTipo);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 6, SpringLayout.EAST, lblNome);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_1, 57, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, 147, SpringLayout.EAST, lblNome);
		add(comboBox_1);
		
		JTextArea textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 122, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -139, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, -65, SpringLayout.NORTH, textArea);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, textArea);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 6, SpringLayout.EAST, lblDescrio);
		springLayout.putConstraint(SpringLayout.EAST, textArea, 321, SpringLayout.EAST, lblDescrio);
		add(textArea);
		
		JButton btnVerificarDoenas = new JButton("verificar doen\u00E7as");
		springLayout.putConstraint(SpringLayout.NORTH, btnVerificarDoenas, 18, SpringLayout.SOUTH, textArea);
		springLayout.putConstraint(SpringLayout.WEST, btnVerificarDoenas, 160, SpringLayout.WEST, this);
		add(btnVerificarDoenas);

	}
}