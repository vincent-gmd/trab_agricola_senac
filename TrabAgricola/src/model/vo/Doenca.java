package model.vo;

import java.util.List;

public class Doenca {
	private Integer idDoenca;
	private String nome;
	private String causador;
	private String descricao;
	//private String fotots;
	public Integer getIdDoenca() {
		return idDoenca;
	}
	public void setIdDoenca(Integer idDoenca) {
		this.idDoenca = idDoenca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCausador() {
		return causador;
	}
	public void setCausador(String causador) {
		this.causador = causador;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void getFilterStrings(List baseList) {
		baseList.add(nome);
		baseList.add(descricao);
		baseList.add(causador);

	}
	
	
	
}
