package model.vo.conector;

import java.util.List;

import ca.odell.glazedlists.TextFilterable;

public class Cliente implements TextFilterable{
	private Integer idCliente;
	private String login;
	private String senha;
	private String nivelAcesso;
	private String email;
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNivelAcesso() {
		return nivelAcesso;
	}
	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public void getFilterStrings(List<String> baseList) {
	      baseList.add(getLogin());
	      baseList.add(getEmail());
	 
		
	}
	
}
