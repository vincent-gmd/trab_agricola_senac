package controller;

import java.util.List;

import model.bo.ProdutoBO;
import model.vo.Produto;

public class ProdutoController {
	private ProdutoBO bo =new ProdutoBO();
	public int inserir(Produto entidade){
		return bo.inserir(entidade);	
	}
	public boolean atualizar(Produto entidade, int idEntidade) {
		return bo.atualizar(entidade, idEntidade);
	}
	public boolean excluir(int idEntidade) {
		return bo.excluir(idEntidade);
	}
	public Produto pesquisarPorId(int idEntidade){
		return bo.pesquisarPorId(idEntidade);
	}
	public List<Produto> listarTodos() {
		return bo.listarTodos();
	}
}
