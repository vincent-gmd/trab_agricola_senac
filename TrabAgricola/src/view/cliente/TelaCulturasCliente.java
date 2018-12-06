package view.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import com.toedter.calendar.JDateChooser;

import controller.CultivoController;
import controller.CulturaController;
import controller.PropriedadeController;
import controller.TelaClienteControler;
import model.dao.base.Colum;
import model.dao.base.Comparador;
import model.dao.base.Filtro;
import model.vo.conector.Cultivo;
import model.vo.conector.Cultura;
import model.vo.conector.Propriedade;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaCulturasCliente extends JPanel {

	private TelaCulturasCliente panelCulturasClientes;
	private TelaPropriedadesCliente telaPropriedadesClientes;
	private JTable tblCulturas;
	private JTextField txtHectaresOcupados;
	private JDateChooser dataPlantio;
	private JDateChooser dataColheita;
	private JButton btnAlterar;
	private JButton btnRemover;
	private JButton btnSalvar;
	private JButton btnCadastrar;
	private JButton btnVoltar;
	private static final int INSERIR = 1;
	private static final int ALTERAR = 2;
	private static final int REMOVER = 3;

	private  int modo = 1;
	private CulturaController culturaController=new CulturaController();
	private CultivoController cultivoController=new CultivoController();

	private TelaClienteControler telaControler;
	private JComboBox comboBox;
	private List<Cultura> listaCulturas;
	private JTextField textFieldFiltroCultura;
	private String[] colunasTabela=new String[] {
			"Cultura", "data Plantio","data Colheita",  "Hectares utilizados"
		};
	protected boolean selectEnabled=true;
	private JButton btnConfirmar;

	/**
	 * Create the panel.
	 */
	public TelaCulturasCliente(TelaClienteControler telaControlerin) {
		telaControler=telaControlerin;
		panelCulturasClientes = this;
		this.setBackground(new Color(85, 107, 47));
		this.setBounds(0, 0, 538, 688);
		this.setLayout(null);

		JLabel lblCulturas = new JLabel("Cultivos");
		lblCulturas.setForeground(new Color(255, 255, 255));
		lblCulturas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCulturas.setBounds(233, 11, 59, 17);
		this.add(lblCulturas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 500, 200);
		this.add(scrollPane);

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
			},colunasTabela
			
		));
		scrollPane.setViewportView(tblCulturas);

		JButton btnNovoCultivo = new JButton("Novo Cultivo");
		btnNovoCultivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manipularMenu(1);
			}
		});
		btnNovoCultivo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNovoCultivo.setBounds(10, 289, 114, 30);
		this.add(btnNovoCultivo);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manipularMenu(ALTERAR);
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAlterar.setBounds(208, 289, 101, 30);
		this.add(btnAlterar);

		btnRemover = new JButton("Remover");
		btnRemover.setEnabled(false);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manipularMenu(REMOVER);
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRemover.setBounds(409, 289, 101, 30);
		this.add(btnRemover);

		JLabel lblCultura = new JLabel("Cultura:");
		lblCultura.setForeground(new Color(255, 255, 255));
		lblCultura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCultura.setBounds(10, 380, 46, 14);
		this.add(lblCultura);

		JLabel lblDataInicio = new JLabel("Data de In\u00EDcio:");
		lblDataInicio.setForeground(new Color(255, 255, 255));
		lblDataInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDataInicio.setBounds(10, 438, 100, 22);
		this.add(lblDataInicio);

		JLabel lblDataColheita = new JLabel("Data de Colheita:");
		lblDataColheita.setForeground(new Color(255, 255, 255));
		lblDataColheita.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDataColheita.setBounds(10, 471, 100, 22);
		this.add(lblDataColheita);

		JLabel lblHectaresOcupados = new JLabel("Hectares Ocupados:");
		lblHectaresOcupados.setForeground(new Color(255, 255, 255));
		lblHectaresOcupados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHectaresOcupados.setBounds(10, 504, 124, 22);
		this.add(lblHectaresOcupados);

		txtHectaresOcupados = new JTextField();
		txtHectaresOcupados.setEnabled(false);
		txtHectaresOcupados.setColumns(10);
		txtHectaresOcupados.setBounds(144, 506, 190, 20);
		this.add(txtHectaresOcupados);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validarCampos()) {
					cadastrar();
				}
				//Propriedade p = new Propriedade();
				//Cultura c = new Cultura();
				//CulturaController controller = new CulturaController();
				
				//controller.atualizar(entidade, idEntidade)
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalvar.setBounds(10, 583, 101, 30);
		this.add(btnSalvar);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(validarCampos()) {
					if(modo==ALTERAR) {
						alterar();
					}
					if(modo==INSERIR) {
						cadastrar();
					}

				}
				
			}
		});
		btnCadastrar.setBounds(10, 585, 100, 27);
		this.add(btnCadastrar);

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
		this.add(btnVoltar);

		dataPlantio = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		dataPlantio.setEnabled(false);
		dataPlantio.setBounds(144, 440, 190, 20);
		this.add(dataPlantio);

		dataColheita = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		dataColheita.setEnabled(false);
		dataColheita.setBounds(144, 471, 190, 20);
		this.add(dataColheita);
		
		comboBox = new JComboBox<Cultura>();
		comboBox.setBounds(144, 376, 190, 20);
		listaCulturas =culturaController.listarTodos();
		comboBox.setModel(new DefaultComboBoxModel<Cultura>( listaCulturas.toArray(new Cultura[listaCulturas.size()])));

		add(comboBox);
		
		JLabel lblFiltroCultura = new JLabel("Filtro Cultura");
		lblFiltroCultura.setForeground(Color.WHITE);
		lblFiltroCultura.setBounds(10, 355, 100, 14);
		add(lblFiltroCultura);
		
		textFieldFiltroCultura = new JTextField();
		textFieldFiltroCultura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 atualizarCulturas();

			}
		});
		textFieldFiltroCultura.setBounds(144, 352, 190, 20);
		add(textFieldFiltroCultura);
		textFieldFiltroCultura.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar Remoçao");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnConfirmar.setBounds(344, 330, 166, 30);
		add(btnConfirmar);
		

		manipularMenu(modo);
		atualizarTabela() ;
	}
	
	protected void remover() {
		cultivoController.excluir(telaControler.getCultivoSelecionado().getIdcultivo())	;	
		atualizarTabela();
	}

	protected void cadastrar() {
		Cultivo cultivo = new Cultivo();
		
		cultivo.setDataInicio(dataPlantio.getDate().toInstant());
		cultivo.setDataFim(dataColheita.getDate().toInstant());
		try{
			cultivo.setHectares_ocupa(Integer.parseInt(txtHectaresOcupados.getText()));
		}catch (java.lang.NumberFormatException e) {
			e.printStackTrace();
		}
		cultivo.setIdPropriedade(telaControler.getPropridedadeSelecionada().getIdPropriedade());
		cultivo.setIdCultura(((Cultura)comboBox.getSelectedItem()).getIdCultura());
		cultivoController.inserir(cultivo);
		atualizarTabela();
		
	}
	
	protected void alterar() {
		Cultivo cultivo = new Cultivo();
		cultivo.setIdcultivo(telaControler.getCultivoSelecionado().getIdcultivo());
		cultivo.setDataInicio(dataPlantio.getDate().toInstant());
		cultivo.setDataFim(dataColheita.getDate().toInstant());
		try{
			cultivo.setHectares_ocupa(Integer.parseInt(txtHectaresOcupados.getText()));
		}catch (java.lang.NumberFormatException e) {
			e.printStackTrace();
		}
		cultivo.setIdPropriedade(telaControler.getPropridedadeSelecionada().getIdPropriedade());
		cultivo.setIdCultura(((Cultura)comboBox.getSelectedItem()).getIdCultura());
		cultivoController.atualizar(cultivo, cultivo.getIdcultivo());
		atualizarTabela();
		
	}


	private void atualizarTabela() {
		int size=telaControler.atualizarListaCultivos();

		Object[][] valores = new Object[size][colunasTabela.length];
		Cultivo cultivo;
		tblCulturas.setModel(new DefaultTableModel(valores, colunasTabela));
		TableModel model = tblCulturas.getModel();
		int count;
		for (int i = 0; i < size; i++) {
			cultivo = telaControler.getCultivos().get(i);
			count = 0;
			Cultura cultura =culturaController.pesquisarPorId( cultivo.getIdCultura());
			model.setValueAt(cultura.getNome(), i, count++);
			model.setValueAt(LocalDateTime.ofInstant(cultivo.getDataInicio(), ZoneOffset.UTC), i, count++);
			model.setValueAt(LocalDateTime.ofInstant(cultivo.getDataFim(), ZoneOffset.UTC), i, count++);
			model.setValueAt(cultivo.getHectares_ocupa(), i, count++);
		}
		if(size>0) {
			btnAlterar.setEnabled(true);
			btnRemover.setEnabled(true);

			tblCulturas.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
				public void valueChanged(ListSelectionEvent event) {
					// do some actions here, for example
					// print first column value from selected row
					if(tblCulturas.getSelectedRow()<0) {
						return;
					}else {
						telaControler.setCulturaIndex(tblCulturas.getSelectedRow());
						if(selectEnabled) {
							
							
							dataPlantio.setDate(Date.from(telaControler.getCultivoSelecionado().getDataInicio()));
							dataColheita.setDate(Date.from(telaControler.getCultivoSelecionado().getDataFim()));
							Cultura cultura =culturaController.pesquisarPorId( telaControler.getCultivoSelecionado().getIdCultura());
							comboBox.setSelectedItem(cultura);

						}else {
							//setSelected(null);
						}
					}
				}
			});
		}
		
	}

	void atualizarCulturas(){
		if(textFieldFiltroCultura.getText().isEmpty()) {
			listaCulturas =culturaController.listarTodos();
			comboBox.setModel(new DefaultComboBoxModel<Cultura>( listaCulturas.toArray(new Cultura[listaCulturas.size()])));
		}else {
			ArrayList<Filtro> Filtros =new ArrayList<Filtro>();
			String value=textFieldFiltroCultura.getText()+"%";
			System.out.println(value);
			Filtro filtro=new Filtro(new Colum("String","nome"), Comparador.LIKE, value);
			Filtros.add(filtro);
			listaCulturas =culturaController.listarTodosWhere(Filtros);
			comboBox.setModel(new DefaultComboBoxModel<Cultura>( listaCulturas.toArray(new Cultura[listaCulturas.size()])));

		}
	}
	
	private Boolean validarCampos() {
		if (comboBox.getSelectedItem()==null) {
			JOptionPane.showMessageDialog(null,"O Campo cultivo precisa ser selecionado!");
			return false;
		}else if(txtHectaresOcupados.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"O Campo Hecatares Ocupados precisa ser preenchido!");
			return false;
		}else if(dataPlantio.getDate() == null) {
			JOptionPane.showMessageDialog(null,"Selecione uma Data de Plantio!");
			return false;
		}else if(dataColheita.getDate() == null) {
			JOptionPane.showMessageDialog(null,"Selecione uma Data de Colheita!");
			return false;
		}else {
			try{
				Integer.parseInt(txtHectaresOcupados.getText());
			}catch (java.lang.NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"HectaresOcupados precisa ser um inteiro valido!");
			}
		}
		return true;
	}
	
	public void manipularMenu(int modo) {
		this.modo=modo;
		switch (modo) {
		case INSERIR:
			selectEnabled =false;
					dataPlantio.setEnabled(true);
					dataColheita.setEnabled(true);
					txtHectaresOcupados.setEnabled(true);
					btnSalvar.setEnabled(true);
					break;

		case ALTERAR:

			selectEnabled =true;
			dataPlantio.setEnabled(true);
			dataColheita.setEnabled(true);
			txtHectaresOcupados.setEnabled(true);
			btnSalvar.setEnabled(true);
			break;


		case REMOVER:
			selectEnabled =true;

			dataPlantio.setEnabled(true);
			dataColheita.setEnabled(true);
			txtHectaresOcupados.setEnabled(true);
			btnSalvar.setEnabled(true);
			break;

			
	} 
		
  }
}
