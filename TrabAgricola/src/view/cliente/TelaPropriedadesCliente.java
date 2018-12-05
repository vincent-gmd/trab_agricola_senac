package view.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
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
import model.dao.base.Comparador;
import model.dao.base.Filtro;
import model.vo.conector.Propriedade;
import javax.swing.JComboBox;

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
	private JButton btnLimpar;
	private JButton btnLimpar_1;
	private JButton btnCadastrar;
	private JButton btnCadastrar_1;
	private static final int INSERIR = 1;
	private static final int ALTERAR = 2;
	private static final int REMOVER = 3;
	private static final int CULTURAS = 4;

	private Boolean selectEnabled=false;
	private JButton btnConfirmar;
	private JButton btnSalvar;
	

	private TelaClienteControler telaControler;
	private PropriedadeController propriedadeController;

	private String[] colunasTabela = new String[] { "Documento", "Endere\u00E7o", "Hecatres", "Hectares Ocupados", };
	private JButton btnFiltrar;
	private JComboBox<Comparador> comboBoxCompare;
	JComboBox<CampoPropriedade> comboBoxColuna;


	
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

		txtFiltro = new JTextField();
		txtFiltro.setBounds(248, 26, 190, 20);
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
			private static final long serialVersionUID = 8032292260300472361L;

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
				manipularMenu(REMOVER);
			}
		});

		btnRemover.setBounds(410, 290, 100, 30);
		panelFiltro.add(btnRemover);
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 13));

		btnMinhasCulturas = new JButton("Culturas da Propriedade");
		btnMinhasCulturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mostrarTelaCulturas();
			}
		});
		btnMinhasCulturas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMinhasCulturas.setBounds(10, 336, 190, 30);
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

		btnCadastrar_1 = new JButton("Cadastrar");
		btnCadastrar_1.setEnabled(false);
		btnCadastrar_1.setVisible(false);

		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (validarCampos()) {
					cadastrar();

				}
			}
		});
		btnCadastrar_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar_1.setBounds(10, 529, 100, 30);
		panelFiltro.add(btnCadastrar_1);

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

		btnLimpar_1 = new JButton("Limpar");
		btnLimpar_1.setEnabled(false);
		btnLimpar_1.setVisible(false);

		btnLimpar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
			}
		});
		btnLimpar_1.setBounds(231, 530, 96, 30);
		panelFiltro.add(btnLimpar_1);
		
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
		
		comboBoxCompare = new JComboBox<Comparador>();
		comboBoxCompare.setModel(new DefaultComboBoxModel<Comparador>(Comparador.values()));
		comboBoxCompare.setBounds(100, 26, 138, 20);
		panelFiltro.add(comboBoxCompare);
		
		comboBoxColuna = new JComboBox<CampoPropriedade>();
		comboBoxColuna.setModel(new DefaultComboBoxModel<CampoPropriedade>(CampoPropriedade.values()));
		comboBoxColuna.setBounds(10, 26, 80, 20);
		panelFiltro.add(comboBoxColuna);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(validarFiltro()) {
					setFiltroPropriedade();
				}
				atualizarTabela();
				
			}
		});
		btnFiltrar.setBounds(448, 25, 89, 23);
		panelFiltro.add(btnFiltrar);

		atualizarTabela();

	}
	protected void setFiltroPropriedade() {
		if(((CampoPropriedade)comboBoxColuna.getSelectedItem()).col.getType().equalsIgnoreCase("int")) {
			try{
				telaControler.setFiltroPropriedade(((CampoPropriedade)comboBoxColuna.getSelectedItem()).col, (Comparador)comboBoxCompare.getSelectedItem(), (Object)Integer.parseInt(txtFiltro.getText()));
			}catch (java.lang.NumberFormatException e) {
				e.printStackTrace();
				return ;
			}
		}else {
			telaControler.setFiltroPropriedade(((CampoPropriedade)comboBoxColuna.getSelectedItem()).col, (Comparador)comboBoxCompare.getSelectedItem(), (Object)txtFiltro.getText());
		}
	}
	protected boolean validarFiltro() {
		
		if(comboBoxColuna.getSelectedItem()==null) {
			JOptionPane.showMessageDialog(null, "Selecione uma coluna");
			return false;
		}
		if(comboBoxCompare.getSelectedItem()==null) {
			JOptionPane.showMessageDialog(null, "Selecione um comparador");
			return false;
		}
		if(txtFiltro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite um valor a ser filtrado");
			return false;
		}
		if(((CampoPropriedade)comboBoxColuna.getSelectedItem()).col.getType().equalsIgnoreCase("int")) {
			try{
				Integer.parseInt(txtFiltro.getText());
			}catch (java.lang.NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Digite numero inteiro valido");
				return false;
			}
			if(((Comparador)comboBoxCompare.getSelectedItem())==Comparador.LIKE) {
				JOptionPane.showMessageDialog(null, "LIKE so pode ser usado com campos texto");
				return false;
			}
			if(((Comparador)comboBoxCompare.getSelectedItem())==Comparador.LIKE) {
				JOptionPane.showMessageDialog(null, "NOT_LIKE so pode ser usado com campos texto");
				return false;
			}
		}
		
		
		
		
		
		return true;
		
	}
	void mostrarTelaCulturas(){
		if(telaControler.getPropriedadeIndex()==null) {
			JOptionPane.showMessageDialog(null, "Selecione uma propriedade");
			return ;
		}
		TelaPrincipalCliente pai = (TelaPrincipalCliente) SwingUtilities
				.windowForComponent(panelPropriedadesClientes);
		pai.mostrarTelaCulturas();
	}


	protected void excluir() {
		telaControler.excluirPropridedadeSelecionada();
		atualizarTabela();
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
		propriedade.setIdPropriedade( telaControler.getPropridedadeSelecionada().getIdPropriedade());
		propriedadeController.atualizar(propriedade, telaControler.getPropridedadeSelecionada().getIdPropriedade());
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
		}catch (java.lang.NumberFormatException e) {
			e.printStackTrace();
		}
		propriedade.setEndereco(txtEndereco.getText());
		propriedade.setIdcliente(telaControler.getCliente().getIdCliente());
		propriedadeController.inserir(propriedade);
		atualizarTabela();
	}

	private void atualizarTabela() {
		int size=telaControler.atualizarListaPropriedades();

		Object[][] valores = new Object[size][colunasTabela.length];
		Propriedade propriedade;
		table.setModel(new DefaultTableModel(valores, colunasTabela));
		TableModel model = table.getModel();
		int count;
		for (int i = 0; i < size; i++) {
			propriedade = telaControler.getPropriedades().get(i);
			count = 0;

			model.setValueAt(propriedade.getDocumento(), i, count++);
			model.setValueAt(propriedade.getEndereco(), i, count++);
			model.setValueAt(propriedade.getHectares_total(), i, count++);

		}
		if(size>0) {
			btnAlterar.setEnabled(true);
			btnRemover.setEnabled(true);

			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
				public void valueChanged(ListSelectionEvent event) {
					// do some actions here, for example
					// print first column value from selected row
					if(table.getSelectedRow()<0) {
						return;
					}else {
						telaControler.setPropriedadeIndex(table.getSelectedRow());
						if(selectEnabled) {
							
							
							
							txtDocumento.setText(telaControler.getPropridedadeSelecionada().getDocumento());
							txtEndereco.setText(telaControler.getPropridedadeSelecionada().getEndereco());
							txtHecatares.setText(telaControler.getPropridedadeSelecionada().getHectares_total().toString());

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
			try{
				Integer.parseInt(txtHecatares.getText());
			}catch (java.lang.NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Digite numero inteiro valido");
				return false;
			}
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
			btnLimpar_1.setEnabled(true);
			btnLimpar_1.setVisible(true);
			btnCadastrar_1.setEnabled(true);
			btnCadastrar_1.setVisible(true);
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
			btnLimpar_1.setEnabled(false);
			btnLimpar_1.setVisible(false);
			btnCadastrar_1.setVisible(false);
			btnCadastrar_1.setEnabled(false);
			btnConfirmar.setVisible(false);
			btnConfirmar.setEnabled(false);
			btnSalvar.setVisible(true);
			btnSalvar.setEnabled(true);
			if(telaControler.getPropridedadeSelecionada()!=null) {
				txtDocumento.setText(telaControler.getPropridedadeSelecionada().getDocumento());
	    		txtEndereco.setText(telaControler.getPropridedadeSelecionada().getEndereco());
	    		txtHecatares.setText(telaControler.getPropridedadeSelecionada().getHectares_total().toString());
			}

			selectEnabled=true;
			break;
		case REMOVER:
			txtDocumento.setEnabled(true);
			txtEndereco.setEnabled(true);
			txtHecatares.setEnabled(true);
			if(telaControler.getPropridedadeSelecionada()!=null) {
				txtDocumento.setText(telaControler.getPropridedadeSelecionada().getDocumento());
	    		txtEndereco.setText(telaControler.getPropridedadeSelecionada().getEndereco());
	    		txtHecatares.setText(telaControler.getPropridedadeSelecionada().getHectares_total().toString());
			}
			txtDocumento.setEditable(false);
			txtEndereco.setEditable(false);
			txtHecatares.setEditable(false);
			btnLimpar_1.setEnabled(false);
			btnLimpar_1.setVisible(false);
			btnCadastrar_1.setEnabled(false);
			btnCadastrar_1.setVisible(false);
			btnConfirmar.setVisible(true);
			btnConfirmar.setEnabled(true);
			btnSalvar.setVisible(false);
			btnSalvar.setEnabled(false);
		
			selectEnabled=true;

			break;
		case CULTURAS:

			txtDocumento.setEnabled(true);
			txtEndereco.setEnabled(true);
			txtHecatares.setEnabled(true);
			if(telaControler.getPropridedadeSelecionada()!=null) {
				txtDocumento.setText(telaControler.getPropridedadeSelecionada().getDocumento());
	    		txtEndereco.setText(telaControler.getPropridedadeSelecionada().getEndereco());
	    		txtHecatares.setText(telaControler.getPropridedadeSelecionada().getHectares_total().toString());
			}
			txtDocumento.setEditable(false);
			txtEndereco.setEditable(false);
			txtHecatares.setEditable(false);
			btnLimpar_1.setEnabled(false);
			btnLimpar_1.setVisible(false);
			btnCadastrar_1.setEnabled(false);
			btnCadastrar_1.setVisible(false);
			btnConfirmar.setVisible(false);
			btnConfirmar.setEnabled(false);
			btnSalvar.setVisible(false);
			btnSalvar.setEnabled(false);
		
			selectEnabled=true;
			break;

		}
	}
}