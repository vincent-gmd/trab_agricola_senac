package controller;

import java.util.List;

import model.bo.AplicadoBO;
import model.vo.Aplicado;

public class AplicadoController {

	private AplicadoBO bo = new AplicadoBO();

	public int inserir(Aplicado entidade) {
		return bo.inserir(entidade);
	}

	public boolean atualizar(Aplicado entidade, int idEntidade) {
		return bo.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return bo.excluir(idEntidade);
	}

	public Aplicado pesquisarPorId(int idEntidade) {
		return bo.pesquisarPorId(idEntidade);
	}

	public List<Aplicado> listarTodos() {
		return bo.listarTodos();
	}
}
