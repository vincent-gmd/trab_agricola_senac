package model.bo;

import java.util.List;

import model.dao.PropriedadeDAO;
import model.vo.conector.Propriedade;

public class PropriedadeBO {
	private PropriedadeDAO dao = new PropriedadeDAO();

	public int inserir(Propriedade entidade) {
		return dao.inserir(entidade);
	}

	public boolean atualizar(Propriedade entidade, int idEntidade) {
		return dao.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return dao.excluir(idEntidade);
	}

	public Propriedade pesquisarPorId(int idEntidade) {
		return dao.pesquisarPorId(idEntidade);
	}

	public List<Propriedade> listarTodos() {
		return dao.listarTodos();
	}
}
