package view.cliente;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCulturasCliente extends JPanel {
	private JTextField textField;
	private JTextField txtNome;
	private JTextField txtTipo;
	private JTextField textField_1;
	private JTextField txtDataInicio;
	private JTextField txtDataColheita;
	private JTextField txtHecataresOcupados;
	private JTable tblCulturas;

	/**
	 * Create the panel.
	 */
	public TelaCulturasCliente() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JPanel panelFiltro = new JPanel();
		panelFiltro.setBackground(SystemColor.activeCaption);
		panelFiltro.setBounds(0, 0, 982, 576);
		add(panelFiltro);
		panelFiltro.setLayout(null);
		
		JLabel label = new JLabel("Filtro Inteligente");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 11, 114, 17);
		panelFiltro.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(118, 11, 190, 20);
		panelFiltro.add(textField);
		
		JLabel label_1 = new JLabel("Culturas");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 53, 59, 17);
		panelFiltro.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 500, 200);
		panelFiltro.add(scrollPane);
		
		tblCulturas = new JTable();
		tblCulturas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Tipo", "Descrição"
			}
		));
		scrollPane.setViewportView(tblCulturas);
		
		JButton button = new JButton("Nova Cultura");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(10, 289, 114, 35);
		panelFiltro.add(button);
		
		JButton button_1 = new JButton("Alterar");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(207, 289, 101, 35);
		panelFiltro.add(button_1);
		
		JButton button_2 = new JButton("Remover");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.setBounds(409, 289, 101, 35);
		panelFiltro.add(button_2);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setBackground(SystemColor.activeCaption);
		panelCadastro.setBounds(609, 11, 363, 314);
		panelFiltro.add(panelCadastro);
		panelCadastro.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 11, 46, 14);
		panelCadastro.add(lblNome);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(10, 36, 46, 22);
		panelCadastro.add(lblTipo);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(10, 70, 76, 22);
		panelCadastro.add(lblDescricao);
		
		JLabel lblDataDeIncio = new JLabel("Data de In\u00EDcio");
		lblDataDeIncio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeIncio.setBounds(10, 114, 100, 22);
		panelCadastro.add(lblDataDeIncio);
		
		JLabel lblDataDeColheita = new JLabel("Data de Colheita");
		lblDataDeColheita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeColheita.setBounds(10, 158, 100, 22);
		panelCadastro.add(lblDataDeColheita);
		
		JLabel lblHectaresOcupados = new JLabel("Hectares Ocupados");
		lblHectaresOcupados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHectaresOcupados.setBounds(10, 198, 124, 22);
		panelCadastro.add(lblHectaresOcupados);
		
		txtNome = new JTextField();
		txtNome.setBounds(54, 10, 190, 20);
		panelCadastro.add(txtNome);
		txtNome.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(54, 39, 190, 20);
		panelCadastro.add(txtTipo);
		txtTipo.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(77, 73, 190, 20);
		panelCadastro.add(textField_1);
		textField_1.setColumns(10);
		
		txtDataInicio = new JTextField();
		txtDataInicio.setBounds(100, 117, 190, 20);
		panelCadastro.add(txtDataInicio);
		txtDataInicio.setColumns(10);
		
		txtDataColheita = new JTextField();
		txtDataColheita.setBounds(120, 161, 190, 20);
		panelCadastro.add(txtDataColheita);
		txtDataColheita.setColumns(10);
		
		txtHecataresOcupados = new JTextField();
		txtHecataresOcupados.setBounds(142, 201, 190, 20);
		panelCadastro.add(txtHecataresOcupados);
		txtHecataresOcupados.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(120, 255, 100, 38);
		panelCadastro.add(btnSalvar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(120, 255, 100, 38);
		panelCadastro.add(btnCadastrar);

	}

}
