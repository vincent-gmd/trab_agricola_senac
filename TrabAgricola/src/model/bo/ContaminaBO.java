package model.bo;

import java.util.List;

import model.dao.ContaminaDAO;
import model.vo.conector.Contamina;

public class ContaminaBO {

	private ContaminaDAO dao = new ContaminaDAO();

	public int inserir(Contamina entidade) {
		return dao.inserir(entidade);
	}

	public boolean atualizar(Contamina entidade, int idEntidade) {
		return dao.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return dao.excluir(idEntidade);
	}

	public Contamina pesquisarPorId(int idEntidade) {
		return dao.pesquisarPorId(idEntidade);
	}

	public List<Contamina> listarTodos() {
		return dao.listarTodos();
	}
}
