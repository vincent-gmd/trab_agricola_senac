package view.cliente;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPropriedadesCliente extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtFiltro;
	private JTable table;
	private JTextField txtDocumento;
	private JTextField txtEndereco;
	private JTextField txtLatitude;
	private JTextField txtLongitude;

	/**
	 * Create the panel.
	 */
	public TelaPropriedadesCliente() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		final JPanel panelFiltro = new JPanel();
		panelFiltro.setBackground(SystemColor.activeCaption);
		panelFiltro.setBounds(0, -2, 856, 508);
		add(panelFiltro);
		panelFiltro.setLayout(null);
		
		final JPanel panelCadastro = new JPanel();
		panelCadastro.setBounds(556, 79, 336, 310);
		panelFiltro.add(panelCadastro);
		panelCadastro.setBackground(SystemColor.activeCaption);
		panelCadastro.setLayout(null);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDocumento.setBounds(10, 13, 96, 17);
		panelCadastro.add(lblDocumento);
		
		txtDocumento = new JTextField();
		txtDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(95, 11, 190, 20);
		panelCadastro.add(txtDocumento);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereco.setBounds(10, 56, 75, 17);
		panelCadastro.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(95, 56, 190, 20);
		panelCadastro.add(txtEndereco);
		
		JLabel lblDataCadastro = new JLabel("Data de Cadastro");
		lblDataCadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataCadastro.setBounds(10, 97, 119, 14);
		panelCadastro.add(lblDataCadastro);
		
		JLabel lblLatitude = new JLabel("Latitude");
		lblLatitude.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLatitude.setBounds(10, 138, 62, 14);
		panelCadastro.add(lblLatitude);
		
		txtLatitude = new JTextField();
		txtLatitude.setColumns(10);
		txtLatitude.setBounds(95, 137, 190, 20);
		panelCadastro.add(txtLatitude);
		
		JLabel lblLongitude = new JLabel("Longitude");
		lblLongitude.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLongitude.setBounds(10, 178, 75, 17);
		panelCadastro.add(lblLongitude);
		
		txtLongitude = new JTextField();
		txtLongitude.setColumns(10);
		txtLongitude.setBounds(95, 178, 190, 20);
		panelCadastro.add(txtLongitude);
		
		final JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(144, 230, 100, 30);
		panelCadastro.add(btnCadastrar);
		
		final JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(144, 230, 100, 30);
		panelCadastro.add(btnSalvar);
		panelCadastro.setVisible(false);
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
		
		table = new JTable(){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Latitude", "Longitude", "Documento", "Data de Cadastro", "Endereço"
			}
		));
		scrollPane.setViewportView(table);
		
		
		
		JButton btnNovaPropriedade = new JButton("Nova Propriedade");
		btnNovaPropriedade.setBounds(10, 290, 150, 30);
		panelFiltro.add(btnNovaPropriedade);
		btnNovaPropriedade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//panelFiltro.setVisible(true);
				panelCadastro.setVisible(true);
				btnSalvar.setVisible(false);
				btnCadastrar.setVisible(true);
				
				
				
			}
		});
		btnNovaPropriedade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCadastro.setVisible(true);
				btnCadastrar.setVisible(false);
				btnSalvar.setVisible(true);
				
			}
		});
		btnAlterar.setBounds(222, 290, 100, 30);
		panelFiltro.add(btnAlterar);
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
			}
		});
		btnRemover.setBounds(410, 290, 100, 30);
		panelFiltro.add(btnRemover);
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));

	}
	
	private void limparTela() {
		txtDocumento.setText("");
		txtEndereco.setText("");
		txtLatitude.setText("");
		txtLongitude.setText("");
	}
	
	
}
