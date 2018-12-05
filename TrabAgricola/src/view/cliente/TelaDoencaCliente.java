package view.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.PropriedadeController;
import controller.TelaClienteControler;
import model.dao.PropriedadeDAO;
import model.vo.conector.Cultivo;
import model.vo.conector.Cultura;
import model.vo.conector.Propriedade;

public class TelaDoencaCliente extends JPanel {
	private JTextField txtFiltrointeligente;
	private JTable tblDoencas;
	private JTextField filtroInteligenteTratamentos;
	private JPanel panelTratamentos;
	private JPanel panelDoenca;
	private PropriedadeController controller;
	private final JComboBox cboxCulturas;
	private TelaClienteControler telaControler;
	/**
	 * Create the panel.
	 */
	public TelaDoencaCliente(TelaClienteControler telaControlerIn) {

		setBackground(new Color(85, 107, 47));
		setLayout(null);

		panelDoenca = new JPanel();
		panelDoenca.setBounds(0, 0, 496, 424);
		add(panelDoenca);
		panelDoenca.setBackground(new Color(85, 107, 47));
		panelDoenca.setLayout(null);

		JLabel lblFiltroInteligente = new JLabel("Pesquisar:");
		lblFiltroInteligente.setForeground(new Color(255, 255, 255));
		lblFiltroInteligente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFiltroInteligente.setBounds(74, 106, 75, 17);
		panelDoenca.add(lblFiltroInteligente);

		txtFiltrointeligente = new JTextField();
		txtFiltrointeligente.setColumns(10);
		txtFiltrointeligente.setBounds(145, 106, 191, 20);
		panelDoenca.add(txtFiltrointeligente);

		JLabel lblPropriedades = new JLabel("Propriedades:");
		lblPropriedades.setForeground(new Color(255, 255, 255));
		lblPropriedades.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPropriedades.setBounds(10, 11, 96, 17);
		panelDoenca.add(lblPropriedades);

		final JComboBox cboxPropriedades = new JComboBox();
		cboxPropriedades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				for(Propriedade p : controller.listarPorClientId(telaControler.getCliente().getIdCliente(),null)) {
					cboxPropriedades.addItem(p);
				}
				enableCultura();
			}
		});
		cboxPropriedades.setBounds(99, 11, 190, 20);
		panelDoenca.add(cboxPropriedades);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 134, 421, 200);
		panelDoenca.add(scrollPane);

		tblDoencas = new JTable();
		tblDoencas.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Tipo", "Causador", }));
		scrollPane.setViewportView(tblDoencas);

		JLabel lblCulturas = new JLabel("Cultivos:");
		lblCulturas.setForeground(new Color(255, 255, 255));
		lblCulturas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCulturas.setBounds(10, 39, 85, 14);
		panelDoenca.add(lblCulturas);

		 cboxCulturas = new JComboBox();
		cboxCulturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idpropriedade=((Propriedade)cboxPropriedades.getSelectedItem()).getIdPropriedade();
				for(Cultivo c : controller.pesquisarJoinPorId(idpropriedade).getJoinList()) {
					cboxCulturas.addItem(c);
				}
				
			}
		});
		cboxCulturas.setBounds(99, 39, 190, 20);
		panelDoenca.add(cboxCulturas);

		JButton btnBuscarTratamentos = new JButton("Buscar Tratamento");
		btnBuscarTratamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDoenca.setVisible(false);
				panelDoenca.updateUI();
				panelTratamentos.setVisible(true);
				panelTratamentos.updateUI();

			}
		});
		btnBuscarTratamentos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarTratamentos.setBounds(160, 345, 164, 33);
		panelDoenca.add(btnBuscarTratamentos);
		
				panelTratamentos = new JPanel();
				panelTratamentos.setVisible(false);
				panelTratamentos.setBounds(0, 0, 496, 424);
				add(panelTratamentos);
				panelTratamentos.setLayout(null);
				panelTratamentos.setBackground(new Color(85, 107, 47));
				
						JLabel lblPesquisar = new JLabel("Pesquisar:");
						lblPesquisar.setForeground(new Color(255, 255, 255));
						lblPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblPesquisar.setBounds(66, 54, 69, 17);
						panelTratamentos.add(lblPesquisar);
						
								filtroInteligenteTratamentos = new JTextField();
								filtroInteligenteTratamentos.addKeyListener(new KeyAdapter() {
									@Override
									public void keyTyped(KeyEvent arg0) {

									}
								});
								filtroInteligenteTratamentos.setColumns(10);
								filtroInteligenteTratamentos.setBounds(129, 54, 216, 20);
								panelTratamentos.add(filtroInteligenteTratamentos);
								
										JLabel label_1 = new JLabel("Tratamentos");
										label_1.setForeground(new Color(255, 255, 255));
										label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
										label_1.setBounds(198, 11, 114, 17);
										panelTratamentos.add(label_1);
										
												JScrollPane scrollPane_1 = new JScrollPane();
												scrollPane_1.setBounds(25, 82, 436, 200);
												panelTratamentos.add(scrollPane_1);
												
														JButton button = new JButton("Aplicar");
														button.setEnabled(false);
														button.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {

															}
														});
														button.setFont(new Font("Tahoma", Font.PLAIN, 14));
														button.setBounds(25, 293, 114, 40);
														panelTratamentos.add(button);
														
																JButton btnVoltar = new JButton("Voltar");
																btnVoltar.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		panelDoenca.setVisible(true);
																		panelDoenca.updateUI();
																		panelTratamentos.setVisible(false);
																		panelTratamentos.updateUI();
																	}
																});
																btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
																btnVoltar.setBounds(358, 294, 103, 39);
																panelTratamentos.add(btnVoltar);

	}
	void enableCultura(){
		cboxCulturas.setEnabled(true);
	}
}