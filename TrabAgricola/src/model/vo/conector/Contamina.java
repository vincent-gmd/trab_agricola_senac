package model.vo.conector;

import java.time.Instant;

public class Contamina {
	private Integer id;
	private Instant dataFim;
	private Instant data_inicio;
	//private String fotos;
	private Integer confirmacao;
	private String descricao;
	private Integer idCultivo;
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
	public Instant getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Instant data_inicio) {
		this.data_inicio = data_inicio;
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
	public Integer getIdCultivo() {
		return idCultivo;
	}
	public void setIdCultivo(Integer idCultivo) {
		this.idCultivo = idCultivo;
	}
	public Integer getIdDoenca() {
		return idDoenca;
	}
	public void setIdDoenca(Integer idDoenca) {
		this.idDoenca = idDoenca;
	}
	

}
