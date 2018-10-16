package view;

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
		
		JMenu mnProduto = new JMenu("produto");
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
