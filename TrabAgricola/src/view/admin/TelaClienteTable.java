package view.admin;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.FilterList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.TextFilterator;
import ca.odell.glazedlists.matchers.MatcherEditor;
import ca.odell.glazedlists.swing.*;

import model.bo.ClienteBO;
import model.vo.conector.Cliente;
import model.vo.front.ClienteFilter;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaClienteTable extends JFrame {

	private JPanel contentPane;
	private JTextField filtroInteligenteClientes;
	private JTable table;
	protected List<Cliente> clientes;
	private String[] camposTabela;
	MatcherEditor<Cliente> textMatcherEditor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClienteTable frame = new TelaClienteTable();
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
	public TelaClienteTable() {
		model.dao.tables.ClienteTable clienteTable = new model.dao.tables.ClienteTable();
		camposTabela =clienteTable.getNames().toArray(new String[clienteTable.getNames().size()]);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 218, 563, 210);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		filtroInteligenteClientes = new JTextField();
		filtroInteligenteClientes.setBounds(10, 187, 203, 20);
		contentPane.add(filtroInteligenteClientes);
		filtroInteligenteClientes.setColumns(10);
		
		JButton btnBuscarClientes = new JButton("buscar Clientes");
		btnBuscarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientes = new ClienteBO().listarTodos() ;
				atualizarTable();
			}
		});
		btnBuscarClientes.setBounds(10, 11, 111, 23);
		contentPane.add(btnBuscarClientes);
		
		JButton btnFiltrar = new JButton("filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrar();
			}
		});
		btnFiltrar.setBounds(131, 11, 89, 23);
		contentPane.add(btnFiltrar);
		
		
		
		
		
		
		
		
		
		
		textMatcherEditor = new TextComponentMatcherEditor<Cliente>(
				filtroInteligenteClientes, new ClienteFilter());

	}
	protected void filtrar() {
		// TODO Auto-generated method stub
		
	}

	void atualizarTable(){
		
		Object[][] valores = new Object[clientes.size()][camposTabela.length] ;
		List<Cliente> listOfNames = clientes;
		EventList<Cliente> eventList = GlazedLists.eventList(listOfNames);
		EventList<Cliente> threadSafeEventList = GlazedLists.threadSafeList(eventList);
	    FilterList<Cliente> textFilteredcliente = new FilterList<Cliente>(threadSafeEventList, textMatcherEditor);

		table.setModel(new DefaultTableModel(
				valores
				,
				camposTabela
			));
		TableModel model = table.getModel();
		for(int i=0;i<clientes.size();i++) {
			
				model.setValueAt(textFilteredcliente.get(i).getIdCliente(), i, 0);
				model.setValueAt(textFilteredcliente.get(i).getLogin(), i, 1);
				model.setValueAt(textFilteredcliente.get(i).getSenha(), i, 2);
				model.setValueAt(textFilteredcliente.get(i).getNivelAcesso(), i, 3);
				model.setValueAt(textFilteredcliente.get(i).getEmail(), i, 4);
			
			
		}
	}
}
