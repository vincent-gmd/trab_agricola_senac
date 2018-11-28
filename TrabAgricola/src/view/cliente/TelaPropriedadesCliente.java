package view.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Instant;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controller.PropriedadeController;
import model.vo.conector.Propriedade;

public class TelaPropriedadesCliente extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtFiltro;
	private JTable tblPropriedades;
	private TelaPropriedadesCliente panelPropriedadesClientes;
	private JTextField txtDocumento;
	private JTextField txtEndereco;
	private JTextField txtHectares;
	private JButton btnNovaPropriedade;
	private JButton btnAlterar;
	private JButton btnMinhasCulturas;
	private JButton btnRemover;
	private PropriedadeController propriedadeController;

	/**
	 * Create the panel.
	 */
	public TelaPropriedadesCliente() {

		panelPropriedadesClientes = this;
		setBounds(new Rectangle(0, 0, 1000, 800));
		setBackground(new Color(85, 107, 47));
		setLayout(null);

		final JPanel panelFiltro = new JPanel();
		panelFiltro.setBackground(new Color(85, 107, 47));
		panelFiltro.setBounds(10, 11, 560, 678);
		add(panelFiltro);
		panelFiltro.setLayout(null);
		setVisible(false);

		JLabel lblFiltroInteligente = new JLabel("Filtro Inteligente:");
		lblFiltroInteligente.setBounds(10, 11, 101, 17);
		panelFiltro.add(lblFiltroInteligente);
		lblFiltroInteligente.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtFiltro = new JTextField();
		txtFiltro.setBounds(121, 10, 190, 20);
		panelFiltro.add(txtFiltro);
		txtFiltro.setColumns(10);

		JLabel lblPropriedades = new JLabel("Propriedades");
		lblPropriedades.setBounds(10, 51, 79, 17);
		panelFiltro.add(lblPropriedades);
		lblPropriedades.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 540, 200);
		panelFiltro.add(scrollPane);

		tblPropriedades = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblPropriedades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnAlterar.setEnabled(true);
				btnRemover.setEnabled(true);
			}
		});
		tblPropriedades.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Documento", "Hecatres", "Endere\u00E7o", "Hectares Ocupados" }));
		scrollPane.setViewportView(tblPropriedades);

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
				TelaPrincipalCliente pai = (TelaPrincipalCliente) SwingUtilities
						.windowForComponent(panelPropriedadesClientes);
				pai.mostrarTelaCulturas();
			}
		});
		btnMinhasCulturas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMinhasCulturas.setBounds(10, 336, 134, 30);
		panelFiltro.add(btnMinhasCulturas);

		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDocumento.setBounds(10, 405, 74, 17);
		panelFiltro.add(lblDocumento);

		txtDocumento = new JTextField();
		txtDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(95, 402, 190, 20);
		panelFiltro.add(txtDocumento);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEndereco.setBounds(10, 433, 75, 17);
		panelFiltro.add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(95, 432, 190, 20);
		panelFiltro.add(txtEndereco);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ValidarCampos() == true) {
					propriedadeController = new PropriedadeController();
					Propriedade propriedade = new Propriedade();
					String documento = txtDocumento.getText();
					String endereco = txtEndereco.getText();
					Integer hectares = Integer.parseInt((txtHectares.getText()));
					System.out.println(hectares);
					Instant dataCadastro = Instant.now();
					LocalDate data = LocalDate.now();
					propriedade.setDocumento(documento);
					propriedade.setEndereco(endereco);
					propriedade.setHectares_total(hectares);
					propriedade.setData_cadastro(data);

					if (propriedadeController.validarCadastroPropriedade(documento) == true) {
						JOptionPane.showMessageDialog(null, "Propriedade cadastrada com sucesso!");
						propriedadeController.inserir(propriedade);
						carregarTabela();
					} else {
						JOptionPane.showMessageDialog(null, "Propriedade já cadastrada");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

				}

			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.setBounds(10, 541, 100, 30);
		panelFiltro.add(btnCadastrar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalvar.setBounds(11, 541, 100, 30);
		panelFiltro.add(btnSalvar);

		JLabel lblHectares = new JLabel("Hectares:");
		lblHectares.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHectares.setBounds(10, 461, 62, 17);
		panelFiltro.add(lblHectares);

		txtHectares = new JTextField();
		txtHectares.setColumns(10);
		txtHectares.setBounds(95, 463, 190, 20);
		panelFiltro.add(txtHectares);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
			}
		});
		btnLimpar.setBounds(166, 542, 96, 30);
		panelFiltro.add(btnLimpar);
	}

	private void limparTela() {
		txtDocumento.setText("");
		txtEndereco.setText("");
		txtHectares.setText("");
	}

	private boolean ValidarCampos() {
		if (txtDocumento.getText().isEmpty() || txtEndereco.getText().isEmpty() || txtHectares.getText().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public void carregarTabela() {
		DefaultTableModel modelo = new DefaultTableModel(
				new Object[] { "DOCUMENTO", "HECTARES", "ENDERECO", "DATA DE CADASTRO" }, 0);
		for (int i = 0; i < propriedadeController.listarTodos().size(); i++) {
			Object linha[] = new Object[] { propriedadeController.listarTodos().get(i).getDocumento(),
					propriedadeController.listarTodos().get(i).getHectares_total(),
					propriedadeController.listarTodos().get(i).getEndereco(),
					propriedadeController.listarTodos().get(i).getData_cadastro() };

			modelo.addRow(linha);
		}
		tblPropriedades.setModel(modelo);

	}
}
