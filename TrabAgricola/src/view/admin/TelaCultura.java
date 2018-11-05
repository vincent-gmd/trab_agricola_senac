package view.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCultura extends JFrame {

	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable tblCulturas;
	private JTextField txtNome;
	private JTextField txtTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCultura frame = new TelaCultura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCultura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 546);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFiltro = new JLabel("Filtro Inteligente:");
		lblFiltro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFiltro.setBounds(10, 11, 101, 17);
		contentPane.add(lblFiltro);
		
		txtFiltro = new JTextField();
		txtFiltro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(121, 11, 190, 20);
		contentPane.add(txtFiltro);
		
		JLabel lblCultura = new JLabel("Cultura");
		lblCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCultura.setBounds(10, 54, 61, 14);
		contentPane.add(lblCultura);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 500, 200);
		contentPane.add(scrollPane);
		
		tblCulturas = new JTable() {
			public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
		tblCulturas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = tblCulturas.getSelectedRow();
				String celulaNome = (String) tblCulturas.getModel().getValueAt(linha, 0);
				String celulaTipo = (String) tblCulturas.getModel().getValueAt(linha, 1);
			}
		});
		tblCulturas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Tipo"
			}
		));
		scrollPane.setViewportView(tblCulturas);
		
		JButton btnNovaCultura = new JButton("Nova Cultura");
		btnNovaCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovaCultura.setBounds(10, 290, 130, 30);
		contentPane.add(btnNovaCultura);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText((String) tblCulturas.getValueAt(0,0));
				txtTipo.setText((String) tblCulturas.getValueAt(0,1));
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(199, 290, 100, 32);
		contentPane.add(btnEditar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemover.setBounds(408, 290, 100, 30);
		contentPane.add(btnRemover);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(12, 348, 52, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(73, 347, 190, 20);
		contentPane.add(txtNome);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipo.setBounds(10, 378, 67, 17);
		contentPane.add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(73, 378, 190, 20);
		contentPane.add(txtTipo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(60, 449, 100, 30);
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparTela();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(290, 449, 100, 30);
		contentPane.add(btnLimpar);
	}
	private void LimparTela() {
		txtNome.setText("");
		txtTipo.setText("");
		
		
	}
}
