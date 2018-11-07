package model.bo;

import java.util.List;

import model.dao.DoencaDAO;
import model.vo.conector.Doenca;

public class DoencaBO {

	private DoencaDAO dao = new DoencaDAO();

	public int inserir(Doenca entidade) {
		return dao.inserir(entidade);
	}

	public boolean atualizar(Doenca entidade, int idEntidade) {
		return dao.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return dao.excluir(idEntidade);
	}

	public Doenca pesquisarPorId(int idEntidade) {
		return dao.pesquisarPorId(idEntidade);
	}

	public List<Doenca> listarTodos() {
		return dao.listarTodos();
	}
}
