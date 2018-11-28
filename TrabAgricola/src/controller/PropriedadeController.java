package controller;

import java.util.List;

import model.bo.PropriedadeBO;
import model.vo.conector.Propriedade;

public class PropriedadeController {

	private PropriedadeBO bo = new PropriedadeBO();

	public int inserir(Propriedade entidade) {
		return bo.inserir(entidade);
	}

	public boolean atualizar(Propriedade entidade, int idEntidade) {
		return bo.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return bo.excluir(idEntidade);
	}

	public Propriedade pesquisarPorId(int idEntidade) {
		return bo.pesquisarPorId(idEntidade);
	}

	public List<Propriedade> listarTodos() {
		return bo.listarTodos();
	}

	public boolean validarCadastroPropriedade(String documento) {
		return bo.validarCadastroPropriedade(documento);
	}

}
