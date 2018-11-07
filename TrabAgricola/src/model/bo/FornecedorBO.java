package model.bo;

import java.util.List;

import model.dao.FornecedorDAO;
import model.vo.conector.Fornecedor;

public class FornecedorBO {

	private FornecedorDAO dao = new FornecedorDAO();

	public int inserir(Fornecedor entidade) {
		return dao.inserir(entidade);
	}

	public boolean atualizar(Fornecedor entidade, int idEntidade) {
		return dao.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return dao.excluir(idEntidade);
	}

	public Fornecedor pesquisarPorId(int idEntidade) {
		return dao.pesquisarPorId(idEntidade);
	}

	public List<Fornecedor> listarTodos() {
		return dao.listarTodos();
	}
}
