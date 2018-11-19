package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.ClienteDAO;
import model.dao.base.Colum;
import model.vo.conector.Cliente;

public class ClienteBO {

	private ClienteDAO dao = new ClienteDAO();

	public int inserir(Cliente entidade) {
		return dao.inserir(entidade);
	}

	public boolean atualizar(Cliente entidade, int idEntidade) {
		return dao.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return dao.excluir(idEntidade);
	}

	public Cliente pesquisarPorId(int idEntidade) {
		return dao.pesquisarPorId(idEntidade);
	}

	public List<Cliente> listarTodos() {
		return dao.listarTodos();
	}

	public List<Cliente> listarTodosWhere(ArrayList<Colum> colums, ArrayList<Object> values) {
		try {
			return dao.listarTodosWhere(colums, values);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Cliente login(String login, String senha) {

		ArrayList<Colum> colums = new ArrayList<Colum>();
		ArrayList<Object> values = new ArrayList<Object>();
		colums.add(new Colum("String", "login"));
		values.add(login);
		colums.add(new Colum("String", "senha"));
		values.add(senha);
		List<Cliente> listaClientes = listarTodosWhere(colums, values);
		if (listaClientes.isEmpty()) {
			System.out.println("Ta caindo no bo");
			return null;
		} else if (listaClientes.size() > 1) {
			// errror mais de um cliente identico
			System.out.println("TA caindo do bo 2");
			return null;
		} else {

			return listaClientes.get(0);
		}

	}

	public Boolean validarCadastro(String login, String email) {
		Boolean validado = true;

		ArrayList<Colum> colums = new ArrayList<Colum>();
		ArrayList<Object> values = new ArrayList<Object>();
		List<Cliente> listaClientes;
		colums.add(new Colum("String", "login"));
		values.add(login);
		listaClientes = listarTodosWhere(colums, values);
		if (listaClientes.isEmpty()) {
			// ok nao exise cliente com esse login;
		} else {
			// erro exise cliente com esse login;
			return false;
		}
		ArrayList<Colum> colums2 = new ArrayList<Colum>();
		ArrayList<Object> values2 = new ArrayList<Object>();
		colums.add(new Colum("String", "email"));
		values.add(email);
		listaClientes = listarTodosWhere(colums2, values2);
		if (listaClientes.isEmpty()) {
			// ok nao exise cliente com esse email;
		} else {
			// erro exise cliente com esse email;
			return false;
		}

		// nemhum erro athe aqui pode cadastrar
		return true;

	}

}
