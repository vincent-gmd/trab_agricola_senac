package view.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class TelaPrincipalCliente extends JFrame {

	private JPanel contentPane;
	private TelaPropriedadesCliente telaPropriedades;
	private TelaProdutoCliente telaProdutoCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalCliente frame = new TelaPrincipalCliente();
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
	public TelaPrincipalCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 573);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Propriedades");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCadastroDePropriedade = new JMenuItem("Minhas Propriedades");
		mntmCadastroDePropriedade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaPropriedades = new TelaPropriedadesCliente();
				setContentPane(telaPropriedades);
				telaPropriedades.setVisible(true);
				telaPropriedades.updateUI();
			}
		});
		mnNewMenu.add(mntmCadastroDePropriedade);
		
		JMenu mnProdutos = new JMenu("Produtos");
		menuBar.add(mnProdutos);
		
		JMenuItem mntmMeusProdutos = new JMenuItem("Meus Produtos");
		mntmMeusProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaProdutoCliente = new TelaProdutoCliente();
				setContentPane(telaProdutoCliente);
				telaProdutoCliente.setVisible(true);
				telaProdutoCliente.updateUI();
			}
		});
		mnProdutos.add(mntmMeusProdutos);
		
		JMenu mnTratamentos = new JMenu("Tratamentos");
		menuBar.add(mnTratamentos);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnTratamentos.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
