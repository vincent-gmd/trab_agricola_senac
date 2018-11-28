package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.PropriedadeDAO;
import model.dao.base.Colum;
import model.vo.conector.Propriedade;

public class PropriedadeBO {
	private PropriedadeDAO dao = new PropriedadeDAO();

	public int inserir(Propriedade entidade) {
		return dao.inserir(entidade);
	}

	public boolean atualizar(Propriedade entidade, int idEntidade) {
		return dao.atualizar(entidade, idEntidade);
	}

	public boolean excluir(int idEntidade) {
		return dao.excluir(idEntidade);
	}

	public Propriedade pesquisarPorId(int idEntidade) {
		return dao.pesquisarPorId(idEntidade);
	}

	public List<Propriedade> listarTodos() {
		return dao.listarTodos();
	}

	public List<Propriedade> listarTodosWhere(ArrayList<Colum> colums, ArrayList<Object> values) {
		try {
			return dao.listarTodosWhere(colums, values);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean validarCadastroPropriedade(String documento) {

		ArrayList<Colum> colums = new ArrayList<Colum>();
		ArrayList<Object> values = new ArrayList<Object>();
		List<Propriedade> listaPropriedades;
		colums.add(new Colum("String", "documento"));
		values.add(documento);
		listaPropriedades = listarTodosWhere(colums, values);
		if (listaPropriedades.isEmpty()) {
			return true;
		} else {
			// erro exise cliente com esse login;
			return false;
		}

	}
}
