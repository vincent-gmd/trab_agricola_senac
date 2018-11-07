package controller;

import java.util.List;

import model.bo.DoencaBO;
import model.vo.Doenca;

public class DoencaController {

	private DoencaBO bo = new DoencaBO();

	public int inserir(Doenca entidade) {
		return bo.inserir(entidade);
	}

	public boolean atualizar(Doenca entidade, int idEntidade) {
		return bo.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return bo.excluir(idEntidade);
	}

	public Doenca pesquisarPorId(int idEntidade) {
		return bo.pesquisarPorId(idEntidade);
	}

	public List<Doenca> listarTodos() {
		return bo.listarTodos();
	}
}
