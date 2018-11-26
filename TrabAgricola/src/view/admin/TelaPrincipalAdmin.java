package view.admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaPrincipalAdmin extends JFrame {

	private TelaCultura telaCultura;
	private JPanel contentPane;
	private TelaDoenca telaDoenca;
	private TelaProduto telaProduto;
	private TelaTratamento telaTratamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalAdmin frame = new TelaPrincipalAdmin();
					frame.setVisible(true);
					frame.setTitle("TrabGricola");
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
	public TelaPrincipalAdmin() {

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaPrincipalAdmin.class.getResource("/icones/icons8-ovelha-2-26.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCulturas = new JMenu("Culturas");
		mnCulturas.setIcon(new ImageIcon(TelaPrincipalAdmin.class.getResource("/icones/icons8-tomate-26.png")));
		menuBar.add(mnCulturas);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar Culturas");
		mntmNewMenuItem.setIcon(new ImageIcon(TelaPrincipalAdmin.class.getResource("/icones/icons8-mais-24.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCultura = new TelaCultura();
				JPanel contentPane = telaCultura.getContentJPanel();
				setContentPane(contentPane);
				contentPane.setVisible(true);
				contentPane.updateUI();
			}
		});
		mnCulturas.add(mntmNewMenuItem);

		JMenu mnDoenas = new JMenu("Doen\u00E7as");
		mnDoenas.setIcon(
				new ImageIcon(TelaPrincipalAdmin.class.getResource("/icones/icons8-comida-org\u00E2nica-26.png")));
		menuBar.add(mnDoenas);

		JMenuItem mntmCadastrarDoenas = new JMenuItem("Cadastrar Doen\u00E7as");
		mntmCadastrarDoenas.setIcon(new ImageIcon(TelaPrincipalAdmin.class.getResource("/icones/icons8-mais-24.png")));
		mntmCadastrarDoenas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaProduto = new TelaProduto();
				JPanel contentPane = telaProduto.getContentJPanel();
				setContentPane(contentPane);
				contentPane.setVisible(true);
				contentPane.updateUI();
			}
		});
		mnDoenas.add(mntmCadastrarDoenas);

		JMenu mnProdutos = new JMenu("Produtos");
		mnProdutos.setIcon(new ImageIcon(TelaPrincipalAdmin.class.getResource("/icones/icons8-trator-26.png")));
		menuBar.add(mnProdutos);

		JMenuItem mntmCadastrarProdutos = new JMenuItem("Cadastrar Produtos");
		mntmCadastrarProdutos
				.setIcon(new ImageIcon(TelaPrincipalAdmin.class.getResource("/icones/icons8-mais-24.png")));
		mntmCadastrarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaDoenca = new TelaDoenca();
				JPanel contentPane = telaDoenca.getContentJPanel();
				setContentPane(contentPane);
				contentPane.setVisible(true);
				contentPane.updateUI();
			}
		});
		mnProdutos.add(mntmCadastrarProdutos);

		JMenu mnTratamentos = new JMenu("Tratamentos");
		mnTratamentos.setIcon(
				new ImageIcon(TelaPrincipalAdmin.class.getResource("/icones/icons8-mangueira-de-\u00E1gua-26.png")));
		menuBar.add(mnTratamentos);

		JMenuItem mntmCadastrarTratamentos = new JMenuItem("Cadastrar Tratamentos");
		mntmCadastrarTratamentos
				.setIcon(new ImageIcon(TelaPrincipalAdmin.class.getResource("/icones/icons8-mais-24.png")));
		mntmCadastrarTratamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaTratamento = new TelaTratamento();
				JPanel contentPane = telaTratamento.getContentJPanel();
				setContentPane(contentPane);
				contentPane.setVisible(true);
				contentPane.updateUI();
			}
		});
		mnTratamentos.add(mntmCadastrarTratamentos);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0, 424, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0, 251, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);
	}

}
