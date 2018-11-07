package view.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable tblProdutos;
	private JTextField txtNome;
	private JTextField txtDescricao;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 709);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFiltroInteligente = new JLabel("Filtro Inteligente:");
		lblFiltroInteligente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFiltroInteligente.setBounds(10, 11, 101, 17);
		contentPane.add(lblFiltroInteligente);
		
		txtFiltro = new JTextField();
		txtFiltro.setBounds(121, 11, 190, 20);
		contentPane.add(txtFiltro);
		txtFiltro.setColumns(10);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProdutos.setBounds(10, 62, 61, 14);
		contentPane.add(lblProdutos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 87, 500, 200);
		contentPane.add(scrollPane);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(25, 355, 52, 14);
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
			
			}
		});
		btnNovoProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovoProduto.setBounds(22, 298, 130, 30);
		contentPane.add(btnNovoProduto);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText((String) tblProdutos.getValueAt(0,0));
				txtDescricao.setText((String) tblProdutos.getValueAt(0,1));
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(211, 298, 100, 30);
		contentPane.add(btnEditar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemover.setBounds(420, 298, 100, 30);
		contentPane.add(btnRemover);
		
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(23, 385, 67, 17);
		contentPane.add(lblDescricao);
		
		txtNome = new JTextField();
		txtNome.setBounds(73, 354, 190, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(27, 413, 500, 200);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(110, 624, 100, 30);
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparTela();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(348, 624, 100, 30);
		contentPane.add(btnLimpar);
	}
	
	private void LimparTela() {
		txtNome.setText("");
		txtDescricao.setText("");
		
	}
		
}