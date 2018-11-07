package controller;

import java.util.List;

import model.bo.ContaminaBO;
import model.vo.Contamina;

public class ContaminaController {

	private ContaminaBO bo = new ContaminaBO();

	public int inserir(Contamina entidade) {
		return bo.inserir(entidade);
	}

	public boolean atualizar(Contamina entidade, int idEntidade) {
		return bo.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return bo.excluir(idEntidade);
	}

	public Contamina pesquisarPorId(int idEntidade) {
		return bo.pesquisarPorId(idEntidade);
	}

	public List<Contamina> listarTodos() {
		return bo.listarTodos();
	}
}
