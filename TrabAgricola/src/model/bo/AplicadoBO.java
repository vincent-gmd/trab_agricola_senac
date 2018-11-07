package model.bo;

import java.util.List;

import model.dao.AplicadoDAO;
import model.vo.conector.Aplicado;

public class AplicadoBO {

	private AplicadoDAO dao = new AplicadoDAO();

	public int inserir(Aplicado entidade) {
		return dao.inserir(entidade);
	}

	public boolean atualizar(Aplicado entidade, int idEntidade) {
		return dao.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return dao.excluir(idEntidade);
	}

	public Aplicado pesquisarPorId(int idEntidade) {
		return dao.pesquisarPorId(idEntidade);
	}

	public List<Aplicado> listarTodos() {
		return dao.listarTodos();
	}
}
