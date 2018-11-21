package view.cliente;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPropriedadesCliente extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtFiltro;
	private JTable table;
	private TelaPropriedadesCliente panelPropriedadesClientes;
	private JTextField txtDocumento;
	private JTextField txtEndereco;
	private JTextField txtLatitude;
	private JTextField txtLongitude;
	private JTextField txtHecatares;
	private JButton btnNovaPropriedade;
	private JButton btnAlterar;
	private JButton btnMinhasCulturas;
	private JButton btnRemover;

	/**
	 * Create the panel.
	 */
	public TelaPropriedadesCliente() {
		panelPropriedadesClientes = this;
		setBounds(new Rectangle(0, 0, 1000, 800));
		setBackground(SystemColor.activeCaption);
		setLayout(null);

		final JPanel panelFiltro = new JPanel();
		panelFiltro.setBackground(SystemColor.activeCaption);
		panelFiltro.setBounds(10, 11, 532, 678);
		add(panelFiltro);
		panelFiltro.setLayout(null);
		setVisible(false);

		JLabel lblFiltroInteligente = new JLabel("Filtro Inteligente");
		lblFiltroInteligente.setBounds(10, 11, 101, 17);
		panelFiltro.add(lblFiltroInteligente);
		lblFiltroInteligente.setFont(new Font("Tahoma", Font.PLAIN, 14));



		txtFiltro = new JTextField();
		txtFiltro.setBounds(132, 11, 190, 20);
		panelFiltro.add(txtFiltro);
		txtFiltro.setColumns(10);

		JLabel lblPropriedades = new JLabel("Propriedades");
		lblPropriedades.setBounds(10, 51, 79, 17);
		panelFiltro.add(lblPropriedades);
		lblPropriedades.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 500, 200);
		panelFiltro.add(scrollPane);
		

		table = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnAlterar.setEnabled(true);
				btnRemover.setEnabled(true);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Documento", "Hecatres", "Endere\u00E7o","Hectares Ocupados","Infectado","Tratamento Aplicado",
			}
		));
		scrollPane.setViewportView(table);

		btnNovaPropriedade = new JButton("Nova Propriedade");
		btnNovaPropriedade.setBounds(10, 290, 146, 30);
		panelFiltro.add(btnNovaPropriedade);
		btnNovaPropriedade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNovaPropriedade.setFont(new Font("Tahoma", Font.PLAIN, 13));

		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnAlterar.setBounds(214, 290, 100, 30);
		panelFiltro.add(btnAlterar);
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 13));

		btnRemover = new JButton("Remover");
		btnRemover.setEnabled(false);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
			}
		});
		
		btnRemover.setBounds(410, 290, 100, 30);
		panelFiltro.add(btnRemover);
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 13));

		btnMinhasCulturas = new JButton("Minhas Culturas");
		btnMinhasCulturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				TelaPrincipalCliente pai = (TelaPrincipalCliente) SwingUtilities.windowForComponent(panelPropriedadesClientes);
				pai.mostrarTelaCulturas();
			}
		});
		btnMinhasCulturas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMinhasCulturas.setBounds(10, 336, 134, 30);
		panelFiltro.add(btnMinhasCulturas);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDocumento.setBounds(10, 404, 96, 17);
		panelFiltro.add(lblDocumento);
		
		txtDocumento = new JTextField();
		txtDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(95, 402, 190, 20);
		panelFiltro.add(txtDocumento);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEndereco.setBounds(10, 432, 75, 17);
		panelFiltro.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(95, 432, 190, 20);
		panelFiltro.add(txtEndereco);
		
		JLabel lblDataCadastro = new JLabel("Data de Cadastro");
		lblDataCadastro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDataCadastro.setBounds(10, 460, 119, 14);
		panelFiltro.add(lblDataCadastro);
		
		JLabel lblLatitude = new JLabel("Latitude");
		lblLatitude.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLatitude.setBounds(10, 485, 62, 14);
		panelFiltro.add(lblLatitude);
		
		txtLatitude = new JTextField();
		txtLatitude.setColumns(10);
		txtLatitude.setBounds(95, 485, 190, 20);
		panelFiltro.add(txtLatitude);
		
		JLabel lblLongitude = new JLabel("Longitude");
		lblLongitude.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLongitude.setBounds(10, 510, 75, 17);
		panelFiltro.add(lblLongitude);
		
		txtLongitude = new JTextField();
		txtLongitude.setColumns(10);
		txtLongitude.setBounds(95, 516, 190, 20);
		panelFiltro.add(txtLongitude);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.setBounds(10, 613, 100, 30);
		panelFiltro.add(btnCadastrar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalvar.setBounds(10, 613, 100, 30);
		panelFiltro.add(btnSalvar);
		
		JLabel lblHectares = new JLabel("Hectares");
		lblHectares.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHectares.setBounds(10, 538, 62, 17);
		panelFiltro.add(lblHectares);
		
		txtHecatares = new JTextField();
		txtHecatares.setColumns(10);
		txtHecatares.setBounds(95, 547, 190, 20);
		panelFiltro.add(txtHecatares);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
			}
		});
		btnLimpar.setBounds(173, 613, 96, 30);
		panelFiltro.add(btnLimpar);
		}
		
				

	private void limparTela() {
		txtDocumento.setText("");
		txtEndereco.setText("");
		txtLatitude.setText("");
		txtLongitude.setText("");
		txtHecatares.setText("");
	}

	private void ValidarCampos() {
		if (txtDocumento.getText().isEmpty() || txtEndereco.getText().isEmpty() || txtLatitude.getText().isEmpty()
				|| txtLongitude.getText().isEmpty() || txtHecatares.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		} else {
			JOptionPane.showMessageDialog(null, "Campos preenchidos corretamento");
		}
	}
}
