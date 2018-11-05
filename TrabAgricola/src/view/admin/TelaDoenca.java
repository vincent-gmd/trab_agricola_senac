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
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaDoenca extends JFrame {

	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable tblDoencas;
	private JTextField txtNome;
	private JTextField txtCausador;
	private JTextField txtDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDoenca frame = new TelaDoenca();
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
	public TelaDoenca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
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
		
		JLabel lblDoena = new JLabel("Doen\u00E7a");
		lblDoena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoena.setBounds(10, 39, 61, 20);
		contentPane.add(lblDoena);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 500, 200);
		contentPane.add(scrollPane);
		
		tblDoencas = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		 };
		tblDoencas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tblDoencas.getSelectedRow();
				String celulaNome = (String) tblDoencas.getModel().getValueAt(linha, 0);
				String celulaCausador = (String) tblDoencas.getModel().getValueAt(linha, 1);
				String celulaDescricao = (String) tblDoencas.getModel().getValueAt(linha, 2);
			}
		});
		tblDoencas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Causador", "Descrição"
			}
		));
		scrollPane.setViewportView(tblDoencas);
		
		JButton btnNovaDoenca = new JButton("Nova Doen\u00E7a");
		btnNovaDoenca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovaDoenca.setBounds(10, 281, 130, 30);
		contentPane.add(btnNovaDoenca);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText((String) tblDoencas.getValueAt(0,0));
				txtCausador.setText((String) tblDoencas.getValueAt(0,1));
				txtDescricao.setText((String) tblDoencas.getValueAt(0,2));
				
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(211, 281, 100, 32);
		contentPane.add(btnEditar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemover.setBounds(408, 281, 100, 30);
		contentPane.add(btnRemover);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 322, 61, 14);
		contentPane.add(lblNome);
		
		JLabel lblCausador = new JLabel("Causador:");
		lblCausador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCausador.setBounds(10, 361, 71, 14);
		contentPane.add(lblCausador);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrio.setBounds(10, 396, 84, 20);
		contentPane.add(lblDescrio);
		
		txtNome = new JTextField();
		txtNome.setBounds(77, 322, 190, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCausador = new JTextField();
		txtCausador.setBounds(77, 360, 190, 20);
		contentPane.add(txtCausador);
		txtCausador.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 427, 500, 160);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(91, 598, 100, 30);
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparTela();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(321, 598, 100, 30);
		contentPane.add(btnLimpar);
	}
	
	private void LimparTela() {
		txtNome.setText("");
		txtCausador.setText("");
		txtDescricao.setText("");
		
	}

}
