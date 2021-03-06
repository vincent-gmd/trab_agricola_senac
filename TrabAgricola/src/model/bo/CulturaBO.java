package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.CulturaDAO;
import model.dao.base.Colum;
import model.dao.base.Comparador;
import model.dao.base.Filtro;
import model.vo.conector.Cultura;
import model.vo.conector.Propriedade;

public class CulturaBO {
	private CulturaDAO dao = new CulturaDAO();

	public int inserir(Cultura entidade) {
		return dao.inserir(entidade);
	}

	public boolean atualizar(Cultura entidade, int idEntidade) {
		return dao.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return dao.excluir(idEntidade);
	}

	public Cultura pesquisarPorId(int idEntidade) {
		return dao.pesquisarPorId(idEntidade);
	}

	public List<Cultura> listarTodos() {
		return dao.listarTodos();
	}
	public List<Cultura> listarTodosWhere( ArrayList<Filtro> Filtros) {
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
