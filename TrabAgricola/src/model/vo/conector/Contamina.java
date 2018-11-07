package model.vo.conector;

import java.time.Instant;

public class Contamina {
	private Integer id;
	private Instant dataFim;
	private Instant data;
	//private String fotos;
	private Integer confirmacao;
	private String descricao;
	private Integer idPropriedade;
	private Integer idDoenca;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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

	public Integer getConfirmacao() {
		return confirmacao;
	}
	public void setConfirmacao(Integer confirmacao) {
		this.confirmacao = confirmacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getIdPropriedade() {
		return idPropriedade;
	}
	public void setIdPropriedade(Integer idPropriedade) {
		this.idPropriedade = idPropriedade;
	}
	public Integer getIdDoenca() {
		return idDoenca;
	}
	public void setIdDoenca(Integer idDoenca) {
		this.idDoenca = idDoenca;
	}
	

}
