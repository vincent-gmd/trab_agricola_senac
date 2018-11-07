package model.bo;

import java.util.List;

import model.dao.ProdutoDAO;
import model.vo.conector.Produto;

public class ProdutoBO {
	private ProdutoDAO dao =new ProdutoDAO();
	public int inserir(Produto entidade){
		return dao.inserir(entidade);	
	}
	public boolean atualizar(Produto entidade, int idEntidade) {
		return dao.atualizar(entidade, idEntidade);
	}
	public boolean excluir(int idEntidade) {
		return dao.excluir(idEntidade);
	}
	public Produto pesquisarPorId(int idEntidade){
		return dao.pesquisarPorId(idEntidade);
	}
	public List<Produto> listarTodos() {
		return dao.listarTodos();
	}

}
