package view.admin;

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

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JPanel cadastrarProduto=new CadastrarProduto();;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);
		
		JMenuItem mntmCadastrar = new JMenuItem("cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(cadastrarProduto);
				cadastrarProduto.setVisible(true);
				cadastrarProduto.updateUI();
			}
		});
		mnProduto.add(mntmCadastrar);
		
		JMenuItem mntmAlterar = new JMenuItem("alterar");
		mnProduto.add(mntmAlterar);
		
		JMenuItem mntmRemover = new JMenuItem("remover");
		mnProduto.add(mntmRemover);
		
		JMenuItem mntmBuscar = new JMenuItem("buscar");
		mnProduto.add(mntmBuscar);
		
		JMenuItem mntmListar = new JMenuItem("listar");
		mnProduto.add(mntmListar);
		
		JMenu mnCultura = new JMenu("Cultura");
		menuBar.add(mnCultura);
		
		JMenuItem mntmPesquisar = new JMenuItem("pesquisar");
		mnCultura.add(mntmPesquisar);
		
		JMenu mnTratamento = new JMenu("Tratamento");
		menuBar.add(mnTratamento);
		
		JMenuItem mntmCadastro = new JMenuItem("cadastro");
		mnTratamento.add(mntmCadastro);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
