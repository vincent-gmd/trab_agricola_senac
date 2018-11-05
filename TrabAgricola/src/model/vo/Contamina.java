package model.vo;

import java.time.Instant;

public class Contamina {
	private int id;
	private Instant dataFim;
	private Instant data;
	//private String fotos;
	private int confirmacao;
	private String descricao;
	private int idPropriedade;
	private int idDoenca;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Instant getDataFim() {
		return dataFim;
	}
	public void setDataFim(Instant dataFim) {
		this.dataFim = dataFim;
	}
	public Instant getData() {
		return data;
	}
	public void setData(Instant data) {
		this.data = data;
	}

	public int getConfirmacao() {
		return confirmacao;
	}
	public void setConfirmacao(int confirmacao) {
		this.confirmacao = confirmacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getIdPropriedade() {
		return idPropriedade;
	}
	public void setIdPropriedade(int idPropriedade) {
		this.idPropriedade = idPropriedade;
	}
	public int getIdDoenca() {
		return idDoenca;
	}
	public void setIdDoenca(int idDoenca) {
		this.idDoenca = idDoenca;
	}
	

}
