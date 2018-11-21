package view.cliente;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaDoencaCliente extends JPanel {
	private JTextField txtFiltrointeligente;
	private JTable tblDoencas;
	private JTextField filtroInteligenteTratamentos;
	private JPanel panelTratamentos;
	private JPanel panelDoenca;
	 
	/**
	 * Create the panel.
	 */
	public TelaDoencaCliente() {

		setBackground(SystemColor.activeCaption);
		setLayout(null);
				
				panelDoenca = new JPanel();
				panelDoenca.setBounds(0, 0, 550, 580);
				add(panelDoenca);
				panelDoenca.setBackground(SystemColor.activeCaption);
				panelDoenca.setLayout(null);
				
				JLabel lblFiltroInteligente = new JLabel("Filtro Inteligente");
				lblFiltroInteligente.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblFiltroInteligente.setBounds(10, 105, 96, 17);
				panelDoenca.add(lblFiltroInteligente);
				
				txtFiltrointeligente = new JTextField();
				txtFiltrointeligente.setColumns(10);
				txtFiltrointeligente.setBounds(116, 105, 191, 20);
				panelDoenca.add(txtFiltrointeligente);
				
				JLabel lblPropriedades = new JLabel("Propriedades");
				lblPropriedades.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblPropriedades.setBounds(10, 11, 96, 17);
				panelDoenca.add(lblPropriedades);
				
				JComboBox cboxPropriedades = new JComboBox();
				cboxPropriedades.setBounds(116, 11, 190, 20);
				panelDoenca.add(cboxPropriedades);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 193, 500, 200);
				panelDoenca.add(scrollPane);
				
				tblDoencas = new JTable();
				tblDoencas.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Nome", "Tipo", "Causador",
					}
				));
				scrollPane.setViewportView(tblDoencas);
				
				JLabel lblCulturas = new JLabel("Culturas");
				lblCulturas.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblCulturas.setBounds(10, 49, 85, 14);
				panelDoenca.add(lblCulturas);
				
				JComboBox cboxCulturas = new JComboBox();
				cboxCulturas.setBounds(116, 48, 190, 20);
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
						btnBuscarTratamentos.setBounds(158, 423, 164, 33);
						panelDoenca.add(btnBuscarTratamentos);
						
						panelTratamentos = new JPanel();
						panelTratamentos.setVisible(false);
						panelTratamentos.setBounds(0, 0, 550, 580);
						add(panelTratamentos);
						panelTratamentos.setLayout(null);
						panelTratamentos.setBackground(SystemColor.activeCaption);
						
						
						JLabel label = new JLabel("Filtro Inteligente");
						label.setFont(new Font("Tahoma", Font.PLAIN, 14));
						label.setBounds(10, 11, 103, 17);
						panelTratamentos.add(label);
						
						filtroInteligenteTratamentos = new JTextField();
						filtroInteligenteTratamentos.addKeyListener(new KeyAdapter() {
							@Override
							public void keyTyped(KeyEvent arg0) {
								
							}
						});
						filtroInteligenteTratamentos.setColumns(10);
						filtroInteligenteTratamentos.setBounds(123, 11, 190, 20);
						panelTratamentos.add(filtroInteligenteTratamentos);
						
						JLabel label_1 = new JLabel("Tratamentos");
						label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
						label_1.setBounds(10, 54, 78, 17);
						panelTratamentos.add(label_1);
						
						JScrollPane scrollPane_1 = new JScrollPane();
						scrollPane_1.setBounds(10, 82, 500, 200);
						panelTratamentos.add(scrollPane_1);
						
						JButton button = new JButton("Aplicar");
						button.setEnabled(false);
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								
							}
						});
						button.setFont(new Font("Tahoma", Font.PLAIN, 14));
						button.setBounds(10, 293, 114, 40);
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
						btnVoltar.setBounds(407, 293, 103, 39);
						panelTratamentos.add(btnVoltar);

	}
}