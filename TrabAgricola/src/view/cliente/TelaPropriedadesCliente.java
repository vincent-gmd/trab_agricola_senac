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
	private CadastroPropriedade cadastroPropriedade;

	/**
	 * Create the panel.
	 */
	public TelaPropriedadesCliente() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		final JPanel panelCadastro = new JPanel();
		panelCadastro.setBounds(0, 0, 619, 480);
		add(panelCadastro);
		
		final JPanel panelFiltro = new JPanel();
		panelFiltro.setBackground(SystemColor.activeCaption);
		panelFiltro.setBounds(0, -2, 619, 565);
		add(panelFiltro);
		panelFiltro.setLayout(null);
		
		JLabel lblFiltroInteligente = new JLabel("Filtro Inteligente:");
		lblFiltroInteligente.setBounds(10, 11, 101, 17);
		panelFiltro.add(lblFiltroInteligente);
		lblFiltroInteligente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtFiltro = new JTextField();
		txtFiltro.setBounds(138, 5, 190, 20);
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
		btnNovaPropriedade.setBounds(10, 290, 140, 30);
		panelFiltro.add(btnNovaPropriedade);
		btnNovaPropriedade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFiltro.setVisible(false);
				panelCadastro.setVisible(true);
				
				//cadastroPropriedade.setVisible(true);
				//cadastroPropriedade.updateUI();
			}
		});
		btnNovaPropriedade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(203, 290, 100, 30);
		panelFiltro.add(btnEditar);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemover.setBounds(421, 290, 100, 30);
		panelFiltro.add(btnRemover);
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCadastro.setVisible(false);

	}
}
