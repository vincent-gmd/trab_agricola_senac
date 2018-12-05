package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.CultivoDAO;
import model.dao.base.Filtro;
import model.vo.conector.Cultivo;

public class CultivoBO {
	private CultivoDAO dao = new CultivoDAO();

	public int inserir(Cultivo entidade) {
		return dao.inserir(entidade);
	}

	public boolean atualizar(Cultivo entidade, int idEntidade) {
		return dao.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return dao.excluir(idEntidade);
	}

	public Cultivo pesquisarPorId(int idEntidade) {
		return dao.pesquisarPorId(idEntidade);
	}

	public List<Cultivo> listarTodos() {
		return dao.listarTodos();
	}
	public List<Cultivo> listarTodosWhere( ArrayList<Filtro> Filtros) {
		if(Filtros==null) {
			Filtros = new ArrayList<Filtro>();
		}
		try {
			return  dao.listarTodosWhereFiltros(Filtros);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
		
	}

}
