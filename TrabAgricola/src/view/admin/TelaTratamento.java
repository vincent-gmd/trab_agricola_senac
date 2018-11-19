package view.admin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TelaTratamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable tblTratamentos;
	private JTextField txtNome;
	private JTextField txtDescricao;

	public JPanel getContentJPanel() {
		return contentPane;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTratamento frame = new TelaTratamento();
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
	public TelaTratamento() {
		setTitle("Tratamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 709);
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
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(121, 11, 190, 20);
		contentPane.add(txtFiltro);

		JLabel lblTratamento = new JLabel("Produtos");
		lblTratamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTratamento.setBounds(10, 62, 61, 14);
		contentPane.add(lblTratamento);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 500, 200);
		contentPane.add(scrollPane);

		tblTratamentos = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblTratamentos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tblTratamentos.getSelectedRow();
				String celulaNome = (String) tblTratamentos.getModel().getValueAt(linha, 0);
				String celulaDescricao = (String) tblTratamentos.getModel().getValueAt(linha, 1);
			}
		});
		tblTratamentos.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Descrição" }));
		scrollPane.setViewportView(tblTratamentos);

		JButton btnNovoTratamento = new JButton("Novo Tratamento");
		btnNovoTratamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovoTratamento.setBounds(10, 291, 141, 30);
		contentPane.add(btnNovoTratamento);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText((String) tblTratamentos.getValueAt(0, 0));
				txtDescricao.setText((String) tblTratamentos.getValueAt(0, 1));
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(228, 291, 100, 30);
		contentPane.add(btnEditar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemover.setBounds(410, 291, 100, 30);
		contentPane.add(btnRemover);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 346, 52, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(61, 345, 190, 20);
		contentPane.add(txtNome);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(10, 390, 67, 17);
		contentPane.add(lblDescricao);

		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(14, 418, 500, 200);
		contentPane.add(txtDescricao);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(97, 629, 100, 30);
		contentPane.add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimparTela();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(335, 629, 100, 30);
		contentPane.add(btnLimpar);
	}

	private void LimparTela() {
		txtNome.setText("");
		txtDescricao.setText("");

	}
}
