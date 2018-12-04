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

public class TelaTratamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable tblTratamentos;
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
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFiltro = new JLabel("Filtro Inteligente:");
		lblFiltro.setForeground(new Color(255, 255, 255));
		lblFiltro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFiltro.setBounds(10, 11, 101, 17);
		contentPane.add(lblFiltro);

		txtFiltro = new JTextField();
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(121, 11, 190, 20);
		contentPane.add(txtFiltro);

		JLabel lblTratamento = new JLabel("Produtos");
		lblTratamento.setForeground(new Color(255, 255, 255));
		lblTratamento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTratamento.setBounds(10, 50, 61, 14);
		contentPane.add(lblTratamento);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 500, 200);
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
				btnEditar.setEnabled(true);
				btnRemover.setEnabled(true);
			}
		});
		tblTratamentos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Descri\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(tblTratamentos);

		JButton btnNovoTratamento = new JButton("Novo Tratamento");
		btnNovoTratamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manipularMenu(1);
			}
		});
		btnNovoTratamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovoTratamento.setBounds(10, 291, 145, 20);
		contentPane.add(btnNovoTratamento);

		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText((String) tblTratamentos.getValueAt(0, 0));
				txtDescricao.setText((String) tblTratamentos.getValueAt(0, 1));
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(228, 291, 100, 20);
		contentPane.add(btnEditar);

		btnRemover = new JButton("Remover");
		btnRemover.setEnabled(false);
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemover.setBounds(410, 291, 100, 20);
		contentPane.add(btnRemover);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 351, 52, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setColumns(10);
		txtNome.setBounds(65, 349, 190, 20);
		contentPane.add(txtNome);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setForeground(new Color(255, 255, 255));
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescricao.setBounds(10, 376, 67, 17);
		contentPane.add(lblDescricao);

		txtDescricao = new JTextField();
		txtDescricao.setEnabled(false);
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(10, 404, 500, 200);
		contentPane.add(txtDescricao);

		btnSalvar = new JButton("Cadastrar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarCampos();
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(97, 629, 100, 30);
		contentPane.add(btnSalvar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setEnabled(false);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimparTela();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(335, 629, 100, 30);
		contentPane.add(btnLimpar);
	}
	
	private boolean validarCampos() {
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Campo Nome!!");
			return false;
		} else if(txtDescricao.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Preencha o Campo Descrição!");
			return false;
		}else {
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
