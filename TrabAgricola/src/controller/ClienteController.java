package controller;

import java.util.List;

import model.bo.ClienteBO;
import model.vo.conector.Cliente;

public class ClienteController {

	private ClienteBO bo = new ClienteBO();

	public int inserir(Cliente entidade) {
		return bo.inserir(entidade);
	}

	public boolean atualizar(Cliente entidade, int idEntidade) {
		return bo.atualizar(entidade, idEntidade);
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

	/**
	 * Verificar se o login existe e se a senha é valida
	 * 
	 * @param login
	 * @param senha
	 * @return String - Nivel de Acesso ou Null caso
	 */
	public Cliente validarLogin(String login, String senha) {
		Cliente cliente = bo.login(login, senha);
		return cliente;
	}

	public boolean validarCadastro(String login, String email) {
		return bo.validarCadastro(login, email);
	}
}
