package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.PropriedadeDAO;
import model.dao.base.Colum;
import model.dao.base.Comparador;
import model.dao.base.Filtro;
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
	public List<Propriedade> listarPorClientId(Integer clienteId, ArrayList<Filtro> Filtros) {
		ArrayList<Filtro> Filtros2 = new ArrayList<Filtro>();

		if(Filtros==null) {
			
			Filtros = new ArrayList<Filtro>();
		}
		Colum colum =(new Colum("int","idcliente"));
		Filtros2.add(new Filtro(colum, Comparador.IGUAL, clienteId));
		for(int i=0;i<Filtros.size() ;i++) {
			Filtros2.add(Filtros.get(i));
		}
		
		try {
			return  dao.listarTodosWhereFiltros(Filtros);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
		
	}
	
	public JoinAgregator<Propriedade,Cultivo,Cultura> pesquisarJoinPorId(int idEntidade) {
		return join.pesquisarJoinPorId(idEntidade);
	}

	public void gerarRelatorio(String caminhoEscolhido) {
	 List<Propriedade> propriedades = dao.listarTodos();
	 GeradorPlanilha geradorPlanilha=new GeradorPlanilha();
	 geradorPlanilha.gerarPlanilhaPropriedades(propriedades, caminhoEscolhido);
	}
}
