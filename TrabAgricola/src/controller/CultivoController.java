package controller;

import java.util.ArrayList;
import java.util.List;

import model.bo.CultivoBO;
import model.dao.base.Filtro;
import model.vo.conector.Cultivo;

public class CultivoController {

	private CultivoBO bo = new CultivoBO();

	public int inserir(Cultivo entidade) {
		return bo.inserir(entidade);
	}

	public boolean atualizar(Cultivo entidade, int idEntidade) {
		return bo.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return bo.excluir(idEntidade);
	}

	public Cultivo pesquisarPorId(int idEntidade) {
		return bo.pesquisarPorId(idEntidade);
	}

	public List<Cultivo> listarTodos() {
		return bo.listarTodos();
	}
	public List<Cultivo> listarTodosWhere( ArrayList<Filtro> Filtros) {
		return bo.listarTodosWhere(Filtros);
	}

		

}
