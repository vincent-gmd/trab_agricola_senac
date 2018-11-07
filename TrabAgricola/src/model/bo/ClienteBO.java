package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.ClienteDAO;
import model.dao.base.Colum;
import model.vo.Cliente;

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
	public List<Cliente> listarTodosWhere(ArrayList<Colum> colums ,ArrayList<Object> values) {
		try {
			return dao.listarTodosWhere(colums, values);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
