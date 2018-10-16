package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarProduto extends JPanel {
	private JTextField textField;
	private JTextPane textPane;
	/**
	 * Create the panel.
	 */
	public CadastrarProduto() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		textPane = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, textPane, -66, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textPane, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textPane, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, textPane, 440, SpringLayout.WEST, this);
		add(textPane);
		
		JLabel lblDescrio = new JLabel("descri\u00E7\u00E3o:");
		springLayout.putConstraint(SpringLayout.WEST, lblDescrio, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblDescrio, -6, SpringLayout.NORTH, textPane);
		add(lblDescrio);
		
		JLabel lblNome = new JLabel("nome:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNome, -6, SpringLayout.NORTH, lblDescrio);
		springLayout.putConstraint(SpringLayout.EAST, lblNome, -395, SpringLayout.EAST, this);
		add(lblNome);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblNome);
		springLayout.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblNome);
		springLayout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, textPane);
		add(textField);
		textField.setColumns(10);
		
		JButton btnCadastrar = new JButton("cadastrar");
		springLayout.putConstraint(SpringLayout.SOUTH, btnCadastrar, -27, SpringLayout.NORTH, textField);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnCadastrar, 0, SpringLayout.WEST, textPane);
		add(btnCadastrar);

	}
}
