package controller;

import java.util.ArrayList;
import java.util.List;

import model.bo.ClienteBO;
import model.dao.base.Colum;
import model.vo.conector.Cliente;

public class ClienteController {

	private ClienteBO bo = new ClienteBO();

	public int inserir(Cliente entidade) {
		int idRetorno = -1;
		ArrayList<Object> values=new ArrayList<Object>();
		ArrayList<Colum> colums=new ArrayList<Colum>();
		colums.add(new Colum("String","email"));
		values.add(entidade.getEmail());	
		List<Cliente> listaClientes = bo.listarTodosWhere(colums, values);
		if (listaClientes.size()==0) {
			return	idRetorno = bo.inserir(entidade);
		}else {
			return idRetorno;
		}
		/**
		 * Em caso de funcionario ser cadastrado com sucesso o metodo retornará o ID
		 * gerado dentro do banco de dados, caso já possua o email o mesmo retornará -1.
		 */
	}

	public boolean atualizar(Cliente entidade, int idEntidade) {
		boolean idRetorno = false;
		ArrayList<Object> values=new ArrayList<Object>();
		ArrayList<Colum> colums=new ArrayList<Colum>();
		colums.add(new Colum("String","email"));
		values.add(entidade.getEmail());
		List<Cliente> listaClientes = bo.listarTodosWhere(colums, values);
		if (listaClientes.size()==0) {
			return	idRetorno = bo.atualizar(entidade, idEntidade);
		}else {
			return idRetorno;
		}
		
		/**
		 * Em caso do funcionario ser atualizado com sucesso o metodo retornará o
		 * verdadeiro, caso já possua o email vinculado a outro cadastro o mesmo
		 * retornará false.
		 */
	}

	public boolean excluir(int idEntidade) {
		return bo.excluir(idEntidade);
	}

	public Cliente pesquisarPorId(int idEntidade) {
		return bo.pesquisarPorId(idEntidade);
	}

	public List<Cliente> listarTodos() {
		return bo.listarTodos();
	}
}
