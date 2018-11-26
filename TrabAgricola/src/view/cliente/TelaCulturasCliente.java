package view.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCulturasCliente extends JPanel {

	private TelaCulturasCliente panelCulturasClientes;
	private TelaPropriedadesCliente telaPropriedadesClientes;
	private JTextField txtFiltro;
	private JTable tblCulturas;
	private JTextField txtNome;
	private JTextField txtTipo;
	private JTextField txtDescricao;
	private JTextField txtHectaresOcupados;
	private JDateChooser dataPlantio;
	private JDateChooser dataColheita;
	private JButton btnAlterar;
	private JButton btnRemover;
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JButton btnCadastrar;
	private JButton btnVoltar;
	private static final int INSERIR = 1;

	/**
	 * Create the panel.
	 */
	public TelaCulturasCliente() {
		panelCulturasClientes = this;
		setBackground(new Color(85, 107, 47));
		setLayout(null);

		JPanel panelFiltro = new JPanel();
		panelFiltro.setBackground(new Color(85, 107, 47));
		panelFiltro.setBounds(0, 0, 528, 678);
		add(panelFiltro);
		panelFiltro.setLayout(null);

		JLabel lblFiltro = new JLabel("Pesquisar:");
		lblFiltro.setForeground(new Color(255, 255, 255));
		lblFiltro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFiltro.setBounds(10, 50, 76, 17);
		panelFiltro.add(lblFiltro);

		txtFiltro = new JTextField();
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(78, 50, 190, 20);
		panelFiltro.add(txtFiltro);

		JLabel lblCulturas = new JLabel("Culturas");
		lblCulturas.setForeground(new Color(255, 255, 255));
		lblCulturas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCulturas.setBounds(233, 11, 59, 17);
		panelFiltro.add(lblCulturas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 500, 200);
		panelFiltro.add(scrollPane);

		tblCulturas = new JTable();
		tblCulturas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnAlterar.setEnabled(true);
				btnRemover.setEnabled(true);
			}
		});
		tblCulturas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Tipo", "Descri\u00E7\u00E3o", "Hectares utilizados"
			}
		));
		scrollPane.setViewportView(tblCulturas);

		JButton btnNovaCultura = new JButton("Nova Cultura");
		btnNovaCultura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manipularMenu(1);
			}
		});
		btnNovaCultura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNovaCultura.setBounds(10, 289, 114, 30);
		panelFiltro.add(btnNovaCultura);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAlterar.setBounds(208, 289, 101, 30);
		panelFiltro.add(btnAlterar);

		btnRemover = new JButton("Remover");
		btnRemover.setEnabled(false);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRemover.setBounds(409, 289, 101, 30);
		panelFiltro.add(btnRemover);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 346, 46, 14);
		panelFiltro.add(lblNome);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(new Color(255, 255, 255));
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipo.setBounds(10, 371, 46, 22);
		panelFiltro.add(lblTipo);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setForeground(new Color(255, 255, 255));
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescricao.setBounds(10, 405, 76, 22);
		panelFiltro.add(lblDescricao);

		JLabel lblDataInicio = new JLabel("Data de In\u00EDcio:");
		lblDataInicio.setForeground(new Color(255, 255, 255));
		lblDataInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDataInicio.setBounds(10, 438, 100, 22);
		panelFiltro.add(lblDataInicio);

		JLabel lblDataColheita = new JLabel("Data de Colheita:");
		lblDataColheita.setForeground(new Color(255, 255, 255));
		lblDataColheita.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDataColheita.setBounds(10, 471, 100, 22);
		panelFiltro.add(lblDataColheita);

		JLabel lblHectaresOcupados = new JLabel("Hectares Ocupados:");
		lblHectaresOcupados.setForeground(new Color(255, 255, 255));
		lblHectaresOcupados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHectaresOcupados.setBounds(10, 504, 124, 22);
		panelFiltro.add(lblHectaresOcupados);

		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setColumns(10);
		txtNome.setBounds(144, 344, 190, 20);
		panelFiltro.add(txtNome);

		txtTipo = new JTextField();
		txtTipo.setEnabled(false);
		txtTipo.setColumns(10);
		txtTipo.setBounds(144, 373, 190, 20);
		panelFiltro.add(txtTipo);

		txtDescricao = new JTextField();
		txtDescricao.setEnabled(false);
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(144, 407, 190, 20);
		panelFiltro.add(txtDescricao);

		txtHectaresOcupados = new JTextField();
		txtHectaresOcupados.setEnabled(false);
		txtHectaresOcupados.setColumns(10);
		txtHectaresOcupados.setBounds(144, 506, 190, 20);
		panelFiltro.add(txtHectaresOcupados);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalvar.setBounds(10, 583, 101, 30);
		panelFiltro.add(btnSalvar);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(10, 585, 100, 27);
		panelFiltro.add(btnCadastrar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setEnabled(false);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLimpar.setBounds(196, 583, 91, 30);
		panelFiltro.add(btnLimpar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipalCliente pai = (TelaPrincipalCliente) SwingUtilities
						.windowForComponent(panelCulturasClientes);
				pai.mostrarTelaPropriedade();

			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltar.setBounds(362, 583, 101, 30);
		panelFiltro.add(btnVoltar);

		dataPlantio = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		dataPlantio.setEnabled(false);
		dataPlantio.setBounds(144, 440, 190, 20);
		panelFiltro.add(dataPlantio);

		dataColheita = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		dataColheita.setEnabled(false);
		dataColheita.setBounds(144, 471, 190, 20);
		panelFiltro.add(dataColheita);
		

	}

	private void limparTela() {
		txtNome.setText("");
		txtTipo.setText("");
		txtDescricao.setText("");
		txtHectaresOcupados.setText("");
	}
	
	public void manipularMenu(int modo) {
		switch (modo) {
		case INSERIR:
			txtNome.setEnabled(true);
			txtTipo.setEnabled(true);
			txtDescricao.setEnabled(true);
			dataPlantio.setEnabled(true);
			dataColheita.setEnabled(true);
			txtHectaresOcupados.setEnabled(true);
			btnSalvar.setEnabled(true);
			btnLimpar.setEnabled(true);
			break;
	} 
  }
}
