package model.bo;

import java.util.List;

import model.dao.CulturaDAO;
import model.vo.conector.Cultura;

public class CulturaBO {
	private CulturaDAO dao = new CulturaDAO();

	public int inserir(Cultura entidade) {
		return dao.inserir(entidade);
	}

	public boolean atualizar(Cultura entidade, int idEntidade) {
		return dao.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return dao.excluir(idEntidade);
	}

	public Cultura pesquisarPorId(int idEntidade) {
		return dao.pesquisarPorId(idEntidade);
	}

	public List<Cultura> listarTodos() {
		return dao.listarTodos();
	}
}
