package controller;

import java.util.ArrayList;
import java.util.List;

import model.bo.CulturaBO;
import model.dao.base.Filtro;
import model.vo.conector.Cultura;

public class CulturaController {

	private CulturaBO bo = new CulturaBO();

	public int inserir(Cultura entidade) {
		return bo.inserir(entidade);
	}

	public boolean atualizar(Cultura entidade, int idEntidade) {
		return bo.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return bo.excluir(idEntidade);
	}

	public Cultura pesquisarPorId(int idEntidade) {
		return bo.pesquisarPorId(idEntidade);
	}

	public List<Cultura> listarTodos() {
		return bo.listarTodos();
	}
	public List<Cultura> listarTodosWhere( ArrayList<Filtro> Filtros) {
		return bo.listarTodosWhere(Filtros);
	}

		
}
