package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.PropriedadeDAO;
import model.dao.base.Colum;
import model.dao.base.JoinAgregator;
import model.dao.join.ProriedadeCultivoCulturaJoin;
import model.vo.conector.Cliente;
import model.vo.conector.Cultivo;
import model.vo.conector.Cultura;
import model.vo.conector.Propriedade;

public class PropriedadeBO {
	private PropriedadeDAO dao = new PropriedadeDAO();
	private ProriedadeCultivoCulturaJoin join = new ProriedadeCultivoCulturaJoin();


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
	public List<Propriedade> listarPorClientId(Integer clienteId ) {
		ArrayList<Colum> colums = new ArrayList<Colum>();
		ArrayList<Object> values = new ArrayList<Object>();
		colums.add(new Colum("int","idcliente"));
		values.add(clienteId);
		try {
			return  dao.listarTodosWhere(colums, values);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
		
	}
	
	public JoinAgregator<Propriedade,Cultivo,Cultura> pesquisarJoinPorId(int idEntidade) {
		return join.pesquisarJoinPorId(idEntidade);
	}
}
