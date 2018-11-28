package view.admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TelaDoenca extends JFrame {

	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable tblDoencas;
	private JTextField txtNome;
	private JTextField txtCausador;
	private JTextField txtDescricao;
	private JButton btnLimpar;
	private JButton btnSalvar;
	private JButton btnRemover;
	private JButton btnEditar;
	private static final int INSERIR = 1;

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
		setTitle("Doen\u00E7a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFiltro = new JLabel("Pesquisar:");
		lblFiltro.setForeground(new Color(255, 255, 255));
		lblFiltro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFiltro.setBounds(10, 42, 101, 17);
		contentPane.add(lblFiltro);

		txtFiltro = new JTextField();
		txtFiltro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(77, 40, 190, 20);
		contentPane.add(txtFiltro);

		JLabel lblDoena = new JLabel("Doen\u00E7a");
		lblDoena.setForeground(new Color(255, 255, 255));
		lblDoena.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDoena.setBounds(246, 9, 61, 20);
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
				btnEditar.setEnabled(true);
				btnRemover.setEnabled(true);
			}
		});
		tblDoencas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Causador", "Descri\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(tblDoencas);

		JButton btnNovaDoenca = new JButton("Nova Doen\u00E7a");
		btnNovaDoenca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manipularMenu(1);
			}
		});
		btnNovaDoenca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovaDoenca.setBounds(10, 281, 130, 20);
		contentPane.add(btnNovaDoenca);

		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText((String) tblDoencas.getValueAt(0, 0));
				txtCausador.setText((String) tblDoencas.getValueAt(0, 1));
				txtDescricao.setText((String) tblDoencas.getValueAt(0, 2));

			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(211, 281, 100, 20);
		contentPane.add(btnEditar);

		btnRemover = new JButton("Remover");
		btnRemover.setEnabled(false);
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemover.setBounds(408, 281, 100, 20);
		contentPane.add(btnRemover);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 322, 61, 14);
		contentPane.add(lblNome);

		JLabel lblCausador = new JLabel("Causador:");
		lblCausador.setForeground(new Color(255, 255, 255));
		lblCausador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCausador.setBounds(10, 347, 71, 14);
		contentPane.add(lblCausador);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setForeground(new Color(255, 255, 255));
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescrio.setBounds(10, 383, 84, 20);
		contentPane.add(lblDescrio);

		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setBounds(77, 320, 190, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtCausador = new JTextField();
		txtCausador.setEnabled(false);
		txtCausador.setBounds(77, 345, 190, 20);
		contentPane.add(txtCausador);
		txtCausador.setColumns(10);

		txtDescricao = new JTextField();
		txtDescricao.setEnabled(false);
		txtDescricao.setBounds(10, 414, 500, 160);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarCampos();
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(92, 598, 80, 25);
		contentPane.add(btnSalvar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setEnabled(false);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparTela();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(321, 598, 80, 25);
		contentPane.add(btnLimpar);
	}
	
	private boolean validarCampos() {
		if (txtNome.getText().isEmpty() || txtCausador.getText().isEmpty() || txtDescricao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			return false;
		} else {
			JOptionPane.showMessageDialog(null, "Campos preenchidos corretamente! Cadastro concluído com sucesso.");
			return true;
		}
	}

	private void LimparTela() {
		txtNome.setText("");
		txtCausador.setText("");
		txtDescricao.setText("");

	}
	
	public void manipularMenu(int modo) {
		switch (modo) {
		case INSERIR:
			txtNome.setEnabled(true);
			txtCausador.setEnabled(true);
			txtDescricao.setEnabled(true);
			btnLimpar.setEnabled(true);
			btnSalvar.setEnabled(true);
			break;
	} 
  }

}
