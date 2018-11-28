package view.cliente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.TelaClienteControler;

public class TelaPrincipalCliente extends JFrame {

	private JPanel contentPane;
	private TelaPropriedadesCliente telaPropriedadesCliente;
	private TelaDoencaCliente telaDoencaCliente;
	private TelaCulturasCliente telaCulturasCliente;
	private TelaClienteControler telaControler;
	public void testarChamadaAoPai() {
		JOptionPane.showMessageDialog(null, "Teste");
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalCliente frame = new TelaPrincipalCliente(null);
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
	public TelaPrincipalCliente( TelaClienteControler telaControlerin) {
		this.telaControler=telaControlerin;
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaPrincipalCliente.class.getResource("/icones/icons8-ovelha-2-26.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 573);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Propriedades");
		mnNewMenu.setIcon(new ImageIcon(TelaPrincipalCliente.class.getResource("/icones/icons8-campo-26.png")));
		menuBar.add(mnNewMenu);

		JMenuItem mntmCadastroDePropriedade = new JMenuItem("Minhas Propriedades");
		mntmCadastroDePropriedade
				.setIcon(new ImageIcon(TelaPrincipalCliente.class.getResource("/icones/icons8-fazenda-24.png")));
		mntmCadastroDePropriedade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarTelaPropriedade();
			}
		});
		mnNewMenu.add(mntmCadastroDePropriedade);

		JMenu mnDoenas = new JMenu("Doen\u00E7as");
		mnDoenas.setIcon(
				new ImageIcon(TelaPrincipalCliente.class.getResource("/icones/icons8-comida-org\u00E2nica-26.png")));
		menuBar.add(mnDoenas);

		JMenuItem mntmBuscar = new JMenuItem("Informar Doen\u00E7a");
		mntmBuscar.setIcon(
				new ImageIcon(TelaPrincipalCliente.class.getResource("/icones/icons8-planta-sob-chuva-24.png")));
		mntmBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaDoencaCliente = new TelaDoencaCliente(telaControler);
				setContentPane(telaDoencaCliente);
				telaDoencaCliente.setVisible(true);
				telaDoencaCliente.updateUI();

			}
		});
		mnDoenas.add(mntmBuscar);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void mostrarTelaCulturas() {
		telaCulturasCliente = new TelaCulturasCliente(telaControler);
		setContentPane(telaCulturasCliente);
		telaCulturasCliente.setVisible(true);
		telaCulturasCliente.updateUI();

	}

	public void mostrarTelaPropriedade() {
		telaPropriedadesCliente = new TelaPropriedadesCliente(telaControler);
		setContentPane(telaPropriedadesCliente);
		telaPropriedadesCliente.setVisible(true);
		telaPropriedadesCliente.updateUI();
	}
}
