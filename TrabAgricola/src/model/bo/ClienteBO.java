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
			return null;
		} else if(listaClientes.size()>1){	
			//errror mais de um cliente identico
			return null;
		} else {
			return listaClientes.get(0);
		}

	}

	public Cliente validarCadastro(String login, String email) {

		ArrayList<Colum> colums = new ArrayList<Colum>();
		ArrayList<Object> values = new ArrayList<Object>();
		colums.add(new Colum("String", "login"));
		values.add(login);
		colums.add(new Colum("String", "email"));
		values.add(email);
		List<Cliente> listaClientes = listarTodosWhere(colums, values);
		if (listaClientes.isEmpty()) {
			return null;
		} else {
			return listaClientes.get(0);
		}

	}

}
