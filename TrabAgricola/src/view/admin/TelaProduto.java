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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class TelaProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable tblProdutos;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JButton btnEditar;
	private JButton btnRemover;
	private JButton btnSalvar;
	private JButton btnLimpar;	
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
					TelaProduto frame = new TelaProduto();
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
	public TelaProduto() {
		setTitle("Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 709);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFiltroInteligente = new JLabel("Filtro Inteligente:");
		lblFiltroInteligente.setForeground(new Color(255, 255, 255));
		lblFiltroInteligente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFiltroInteligente.setBounds(10, 11, 101, 17);
		contentPane.add(lblFiltroInteligente);

		txtFiltro = new JTextField();
		txtFiltro.setBounds(121, 11, 190, 20);
		contentPane.add(txtFiltro);
		txtFiltro.setColumns(10);

		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setForeground(new Color(255, 255, 255));
		lblProdutos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProdutos.setBounds(10, 52, 61, 14);
		contentPane.add(lblProdutos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 500, 200);
		contentPane.add(scrollPane);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 344, 52, 14);
		contentPane.add(lblNome);

		tblProdutos = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				int linha = tblProdutos.getSelectedRow();
				String celulaNome = (String) tblProdutos.getModel().getValueAt(linha, 0);
				String celulaDescricao = (String) tblProdutos.getModel().getValueAt(linha, 1);
				btnEditar.setEnabled(true);
				btnRemover.setEnabled(true);
			}
		});
		tblProdutos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Descri\u00E7\u00E3o"
			}
		));
		tblProdutos.setCellSelectionEnabled(false);
		tblProdutos.setRowSelectionAllowed(true);
		scrollPane.setViewportView(tblProdutos);

		JButton btnNovoProduto = new JButton("Novo Produto");
		btnNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manipularMenu(1);
			}
		});
		btnNovoProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovoProduto.setBounds(10, 298, 130, 20);
		contentPane.add(btnNovoProduto);

		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText((String) tblProdutos.getValueAt(0, 0));
				txtDescricao.setText((String) tblProdutos.getValueAt(0, 1));
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(224, 298, 100, 20);
		contentPane.add(btnEditar);

		btnRemover = new JButton("Remover");
		btnRemover.setEnabled(false);
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemover.setBounds(410, 298, 100, 20);
		contentPane.add(btnRemover);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setForeground(new Color(255, 255, 255));
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescricao.setBounds(10, 373, 67, 17);
		contentPane.add(lblDescricao);

		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setBounds(61, 342, 190, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtDescricao = new JTextField();
		txtDescricao.setEnabled(false);
		txtDescricao.setBounds(10, 401, 500, 200);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);

		btnSalvar = new JButton("Cadastrar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarCampos();
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(101, 629, 100, 25);
		contentPane.add(btnSalvar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setEnabled(false);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparTela();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(331, 629, 100, 25);
		contentPane.add(btnLimpar);
	}
	
	private boolean validarCampos() {
		if (txtNome.getText().isEmpty() || txtDescricao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			return false;
		} else {
			JOptionPane.showMessageDialog(null, "Campos preenchidos corretamente! Cadastro concluído com sucesso.");
			return true;
		}
	}

	private void LimparTela() {
		txtNome.setText("");
		txtDescricao.setText("");

	}
	
	public void manipularMenu(int modo) {
		switch (modo) {
		case INSERIR:
			txtNome.setEnabled(true);
			txtDescricao.setEnabled(true);
			btnSalvar.setEnabled(true);
			btnLimpar.setEnabled(true);
			break;
	} 
  }

}
