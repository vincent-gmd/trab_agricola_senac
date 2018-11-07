package controller;

import java.util.List;

import model.bo.FornecedorBO;
import model.vo.Fornecedor;

public class FornecedorController {
	private FornecedorBO bo = new FornecedorBO();

	public int inserir(Fornecedor entidade) {
		return bo.inserir(entidade);
	}

	public boolean atualizar(Fornecedor entidade, int idEntidade) {
		return bo.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return bo.excluir(idEntidade);
	}

	public Fornecedor pesquisarPorId(int idEntidade) {
		return bo.pesquisarPorId(idEntidade);
	}

	public List<Fornecedor> listarTodos() {
		return bo.listarTodos();
	}
}
