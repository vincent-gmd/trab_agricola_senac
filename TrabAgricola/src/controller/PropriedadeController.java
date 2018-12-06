package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bo.PropriedadeBO;
import model.dao.base.Colum;
import model.dao.base.Filtro;
import model.dao.base.JoinAgregator;
import model.vo.conector.Cultivo;
import model.vo.conector.Cultura;
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

	public List<Propriedade> listarTodosWhere(ArrayList<Colum> colums, ArrayList<Object> values) {
		return bo.listarTodosWhere(colums, values);
	}
	
	public JoinAgregator<Propriedade,Cultivo,Cultura> pesquisarJoinPorId(int idEntidade) {
		return bo.pesquisarJoinPorId(idEntidade);
	}
	public List<Propriedade> listarPorClientId(Integer clienteId, ArrayList<Filtro> Filtros ) {
		return bo.listarPorClientId(clienteId,Filtros);
	}

	public void gerarRelatorio(String caminhoEscolhido) {
		bo.gerarRelatorio(caminhoEscolhido);
		
	}

}
