package model.vo.conector;

import java.util.List;

public class Tratamento {
	private Integer idTratamento;
	private String descricao;
	private String nome;
	private List<Produto> listaProdutos;
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	public Integer getIdTratamento() {
		return idTratamento;
	}
	public void setIdTratamento(Integer idTratamento) {
		this.idTratamento = idTratamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
