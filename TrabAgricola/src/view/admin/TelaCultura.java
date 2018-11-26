package view.admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
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

public class TelaCultura extends JFrame {

	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable tblCulturas;
	private JTextField txtNome;
	private JTextField txtTipo;
	private JButton btnLimpar;
	private JButton btnEditar;
	private JButton btnRemover;
	private JButton btnSalvar;
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

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaCultura.class.getResource("/icones/icons8-ovelha-2-26.png")));
		setTitle("Cultura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 488, 547);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFiltro = new JLabel("Pesquisar:");
		lblFiltro.setForeground(new Color(255, 255, 255));
		lblFiltro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFiltro.setBounds(20, 51, 75, 17);
		contentPane.add(lblFiltro);

		txtFiltro = new JTextField();
		txtFiltro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(89, 49, 190, 20);
		contentPane.add(txtFiltro);

		JLabel lblCultura = new JLabel("Culturas");
		lblCultura.setForeground(new Color(255, 255, 255));
		lblCultura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCultura.setBounds(204, 11, 75, 14);
		contentPane.add(lblCultura);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setEnabled(false);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparTela();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar.setBounds(236, 401, 100, 30);
		contentPane.add(btnLimpar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.setBounds(111, 401, 100, 30);
		contentPane.add(btnSalvar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 79, 433, 200);
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
				btnEditar.setEnabled(true);
				btnRemover.setEnabled(true);
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

		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText((String) tblCulturas.getValueAt(0, 0));
				txtTipo.setText((String) tblCulturas.getValueAt(0, 1));
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEditar.setBounds(191, 290, 100, 20);
		contentPane.add(btnEditar);

		btnRemover = new JButton("Remover");
		btnRemover.setEnabled(false);
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRemover.setBounds(353, 290, 100, 20);
		contentPane.add(btnRemover);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(20, 332, 52, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(82, 331, 190, 20);
		txtNome.setEnabled(false);
		contentPane.add(txtNome);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(new Color(255, 255, 255));
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipo.setBounds(20, 360, 57, 17);
		contentPane.add(lblTipo);

		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(83, 360, 190, 20);
		txtTipo.setEnabled(false);
		contentPane.add(txtTipo);
		
		JButton btnNovaCultura = new JButton("Nova Cultura");
		btnNovaCultura.setBounds(30, 290, 113, 20);
		contentPane.add(btnNovaCultura);
		btnNovaCultura.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					manipularMenu(1);
				}
				});
		btnNovaCultura.setFont(new Font("Tahoma", Font.PLAIN, 12));
	}

	private void ValidarCampos() {
		if (txtNome.getText().isEmpty() || txtTipo.getText().isEmpty() || txtDescricao.getText().isEmpty()
				|| txtHectaresOcupados.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		} else {
			JOptionPane.showMessageDialog(null, "Campos preenchidos corretamente! Cadastro Concluído com sucesso.");
		}
	}
	
	private void LimparTela() {
		txtNome.setText("");
		txtTipo.setText("");

	}
	
	public void manipularMenu(int modo) {
		switch (modo) {
		case INSERIR:
			txtNome.setEnabled(true);
			txtTipo.setEnabled(true);
			btnSalvar.setEnabled(true);
			btnLimpar.setEnabled(true);
			break;
	} 
  }
	
	
}
