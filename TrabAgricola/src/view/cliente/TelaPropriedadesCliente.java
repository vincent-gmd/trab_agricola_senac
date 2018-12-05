package view.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.PropriedadeController;
import controller.TelaClienteControler;
import model.vo.conector.Propriedade;

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
	private JTextField txtHecatares;
	private JButton btnNovaPropriedade;
	private JButton btnAlterar;
	private JButton btnMinhasCulturas;
	private JButton btnRemover;
	private TelaClienteControler telaControler;
	private JButton btnLimpar;
	private JButton btnCadastrar;
	private static final int INSERIR = 1;
	private static final int ALTERAR = 2;
	private static final int REMOVER = 3;
	private Boolean selectEnabled=false;
	private JButton btnConfirmar;
	private JButton btnSalvar;
	private Integer selected=null;
	private List<Propriedade> propriedades;


	private PropriedadeController propriedadeController;

	private String[] colunasTabela = new String[] { "Documento", "Endere\u00E7o", "Hecatres", "Hectares Ocupados", };
	private Propriedade propridedadeSelecionada;

	private void setSelected(Integer i){
		selected=i;
		if(i!=null) {
			propridedadeSelecionada =propriedades.get(i);
		}else {
			propridedadeSelecionada=null;
		}
	}
	/**
	 * Create the panel.
	 */
	public TelaPropriedadesCliente(TelaClienteControler telaControlerIn) {
		telaControler = telaControlerIn;
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
		lblFiltroInteligente.setForeground(new Color(255, 255, 255));
		lblFiltroInteligente.setBounds(10, 11, 101, 17);
		panelFiltro.add(lblFiltroInteligente);
		lblFiltroInteligente.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtFiltro = new JTextField();
		txtFiltro.setBounds(121, 10, 190, 20);
		panelFiltro.add(txtFiltro);
		txtFiltro.setColumns(10);

		JLabel lblPropriedades = new JLabel("Propriedades");
		lblPropriedades.setForeground(new Color(255, 255, 255));
		lblPropriedades.setBounds(10, 51, 79, 17);
		panelFiltro.add(lblPropriedades);
		lblPropriedades.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 540, 200);
		panelFiltro.add(scrollPane);

		table = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

			}
		});

		table.setModel(new DefaultTableModel(new Object[][] {},

				colunasTabela));
		scrollPane.setViewportView(table);

		btnNovaPropriedade = new JButton("Nova Propriedade");
		btnNovaPropriedade.setBounds(10, 290, 146, 30);
		panelFiltro.add(btnNovaPropriedade);
		btnNovaPropriedade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manipularMenu(INSERIR);

			}
		});
		btnNovaPropriedade.setFont(new Font("Tahoma", Font.PLAIN, 13));

		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manipularMenu(ALTERAR);
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
				manipularMenu(REMOVER);

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
		lblDocumento.setForeground(new Color(255, 255, 255));
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDocumento.setBounds(10, 405, 74, 17);
		panelFiltro.add(lblDocumento);

		txtDocumento = new JTextField();
		txtDocumento.setEnabled(false);
		txtDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(95, 402, 190, 20);
		panelFiltro.add(txtDocumento);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setForeground(new Color(255, 255, 255));
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEndereco.setBounds(10, 433, 75, 17);
		panelFiltro.add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setEnabled(false);
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(95, 432, 190, 20);
		panelFiltro.add(txtEndereco);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		btnCadastrar.setVisible(false);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (validarCampos()) {
					cadastrar();

				}
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.setBounds(10, 529, 100, 30);
		panelFiltro.add(btnCadastrar);

		 btnSalvar = new JButton("Salvar \r\nAlteraçao");
		btnSalvar.setVisible(false);
		btnSalvar.setEnabled(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterar();
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalvar.setBounds(10, 529, 174, 31);
		panelFiltro.add(btnSalvar);

		JLabel lblHectares = new JLabel("Hectares:");
		lblHectares.setForeground(new Color(255, 255, 255));
		lblHectares.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHectares.setBounds(10, 464, 62, 17);
		panelFiltro.add(lblHectares);

		txtHecatares = new JTextField();
		txtHecatares.setEnabled(false);
		txtHecatares.setColumns(10);
		txtHecatares.setBounds(95, 463, 190, 20);
		panelFiltro.add(txtHecatares);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setEnabled(false);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
			}
		});
		btnLimpar.setBounds(231, 530, 96, 30);
		panelFiltro.add(btnLimpar);
		
		 btnConfirmar = new JButton("Cofirmar Remover");
		btnConfirmar.setVisible(false);
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnConfirmar.setBounds(323, 399, 138, 30);
		panelFiltro.add(btnConfirmar);

		atualizarTabela();

	}
	/*
	protected void alterar() {
		Propriedade propriedade = new Propriedade();
		propriedadeController = new PropriedadeController();
		LocalDate data = LocalDate.now();
		propriedade.setData_cadastro(data);
		propriedade.setDocumento(txtDocumento.getText());
		try{
			propriedade.setHectares_total(Integer.parseInt(txtHecatares.getText()));
			}catch (Exception e) {
				e.printStackTrace();
			}
		propriedade.setEndereco(txtEndereco.getText());
		propriedade.setIdcliente(telaControler.getCliente().getIdCliente());
		//propriedadeController.atualizar(propriedade)
		atualizarTabela();
	}
*/
	protected void excluir() {

		Propriedade propriedade = new Propriedade();
		propriedadeController = new PropriedadeController();
		propriedadeController.excluir(propridedadeSelecionada.getIdPropriedade());

	}

	protected void alterar() {
		Propriedade propriedade = new Propriedade();
		propriedadeController = new PropriedadeController();
		LocalDate data = LocalDate.now();
		propriedade.setData_cadastro(data);
		propriedade.setDocumento(txtDocumento.getText());
		try{
		propriedade.setHectares_total(Integer.parseInt(txtHecatares.getText()));
		}catch (Exception e) {
			e.printStackTrace();
		}
		propriedade.setEndereco(txtEndereco.getText());
		propriedade.setIdcliente(telaControler.getCliente().getIdCliente());
		propriedade.setIdPropriedade( propriedades.get(selected).getIdPropriedade());
		propriedadeController.atualizar(propriedade, propridedadeSelecionada.getIdPropriedade());
		atualizarTabela();
	}

	protected void cadastrar() {

		Propriedade propriedade = new Propriedade();
		propriedadeController = new PropriedadeController();
		LocalDate data = LocalDate.now();
		propriedade.setData_cadastro(data);
		propriedade.setDocumento(txtDocumento.getText());
		try{
		propriedade.setHectares_total(Integer.parseInt(txtHecatares.getText()));
		}catch (Exception e) {
			e.printStackTrace();
		}
		propriedade.setEndereco(txtEndereco.getText());
		propriedade.setIdcliente(telaControler.getCliente().getIdCliente());
		propriedadeController.inserir(propriedade);
		atualizarTabela();

	}

	private void atualizarTabela() {

		propriedades = new PropriedadeController()
				.listarPorClientId(telaControler.getCliente().getIdCliente());

		Object[][] valores = new Object[propriedades.size()][colunasTabela.length];
		Propriedade propriedade;
		table.setModel(new DefaultTableModel(valores, colunasTabela));
		TableModel model = table.getModel();
		int count;
		for (int i = 0; i < propriedades.size(); i++) {
			propriedade = propriedades.get(i);
			count = 0;

			model.setValueAt(propriedade.getDocumento(), i, count++);
			model.setValueAt(propriedade.getEndereco(), i, count++);
			model.setValueAt(propriedade.getHectares_total(), i, count++);

		}
		if(propriedades.size()>0) {
			btnAlterar.setEnabled(true);
			btnRemover.setEnabled(true);

			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
				public void valueChanged(ListSelectionEvent event) {
					// do some actions here, for example
					// print first column value from selected row
					if(table.getSelectedRow()<0) {
						return;
					}else {
						setSelected(table.getSelectedRow());
						if(selectEnabled) {
							txtDocumento.setText(propridedadeSelecionada.getDocumento());
							txtEndereco.setText(propridedadeSelecionada.getEndereco());
							txtHecatares.setText(propridedadeSelecionada.getHectares_total().toString());

						}else {
							//setSelected(null);
						}
					}
				}
			});
		}



	}



	private void limparTela() {
		txtDocumento.setText("");
		txtEndereco.setText("");
		txtHecatares.setText("");
	}

	private Boolean validarCampos() {
		if (txtDocumento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"O Campo Documento precisa ser preenchido!");
			return false;
		}else if(txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "O Campo Endere�o precisa ser preenchido!");
			return false;
		} else if(txtHecatares.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "O Campo Hectares precisa ser preenchido!");
			return false;
		}else {
			//JOptionPane.showMessageDialog(null,"Campos preenchidos corretamente!");
		}
		return true;
	}

	public void manipularMenu(int modo) {
		switch (modo) {
		case INSERIR:
			txtDocumento.setEnabled(true);
			txtEndereco.setEnabled(true);
			txtHecatares.setEnabled(true);
			btnLimpar.setEnabled(true);
			btnLimpar.setVisible(true);
			btnCadastrar.setEnabled(true);
			btnCadastrar.setVisible(true);
			btnConfirmar.setVisible(false);
			btnConfirmar.setEnabled(false);
			btnSalvar.setVisible(false);
			btnSalvar.setEnabled(false);

			selectEnabled=false;

			limparTela() ;
			break;
		case ALTERAR:
			txtDocumento.setEnabled(true);
			txtEndereco.setEnabled(true);
			txtHecatares.setEnabled(true);
			btnLimpar.setEnabled(false);
			btnLimpar.setVisible(false);
			btnCadastrar.setVisible(false);
			btnCadastrar.setEnabled(false);
			btnConfirmar.setVisible(false);
			btnConfirmar.setEnabled(false);
			btnSalvar.setVisible(true);
			btnSalvar.setEnabled(true);
			if(propridedadeSelecionada!=null) {
				txtDocumento.setText(propridedadeSelecionada.getDocumento());
	    		txtEndereco.setText(propridedadeSelecionada.getEndereco());
	    		txtHecatares.setText(propridedadeSelecionada.getHectares_total().toString());
			}

			selectEnabled=true;
			break;
		case REMOVER:
			txtDocumento.setEnabled(false);
			txtEndereco.setEnabled(false);
			txtHecatares.setEnabled(false);
			btnLimpar.setEnabled(false);
			btnLimpar.setVisible(false);
			btnCadastrar.setEnabled(false);
			btnCadastrar.setVisible(false);
			btnConfirmar.setVisible(true);
			btnConfirmar.setEnabled(true);
			btnSalvar.setVisible(false);
			btnSalvar.setEnabled(false);
			if(propridedadeSelecionada!=null) {
				txtDocumento.setText(propridedadeSelecionada.getDocumento());
	    		txtEndereco.setText(propridedadeSelecionada.getEndereco());
	    		txtHecatares.setText(propridedadeSelecionada.getHectares_total().toString());
			}

			selectEnabled=true;

			break;


		}
	}
	private Boolean validarCamposAlterar() {
		if (txtDocumento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"O Campo Documento precisa ser preenchido!");
			return false;
		}else if(txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "O Campo Endere�o precisa ser preenchido!");
			return false;
		} else if(txtHecatares.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "O Campo Hectares precisa ser preenchido!");
			return false;
		}else {
			//JOptionPane.showMessageDialog(null,"Campos preenchidos corretamente!");
		}
		return true;
	}
}