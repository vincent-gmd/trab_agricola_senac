package model.vo.conector;

import java.time.LocalDate;

public class Propriedade {
	private Integer idPropriedade;
	private Double localisacaoX;
	private Double localisacaoY;
	private String documento;
	private LocalDate data_cadastro;
	private String endereco;
	private Integer hectares_total;
	private Integer idcliente;
	public Integer getIdPropriedade() {
		return idPropriedade;
	}
	public void setIdPropriedade(Integer idPropriedade) {
		this.idPropriedade = idPropriedade;
	}
	public Double getLocalisacaoX() {
		return localisacaoX;
	}
	public void setLocalisacaoX(Double localisacaoX) {
		this.localisacaoX = localisacaoX;
	}
	public Double getLocalisacaoY() {
		return localisacaoY;
	}
	public void setLocalisacaoY(Double localisacaoY) {
		this.localisacaoY = localisacaoY;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public LocalDate getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(LocalDate data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getHectares_total() {
		return hectares_total;
	}
	public void setHectares_total(Integer hectares_total) {
		this.hectares_total = hectares_total;
	}
	public Integer getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}


}
