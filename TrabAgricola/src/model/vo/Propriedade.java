package model.vo;

import java.time.Instant;
import java.time.LocalDate;

public class Propriedade {
	private Integer idPropriedade;
	private Double localizacaoX;
	private Double localizacaoY;
	private String documento;
	private Instant data_cadastro;
	private String endereco;
	private Integer idcliente;
	public Double getLat() {
		return localizacaoX;
	}
	public void setLat(Double lat) {
		this.localizacaoX = lat;
	}
	public Double getLon() {
		return localizacaoY;
	}
	public void setLon(Double lon) {
		this.localizacaoY = lon;
	}
	public Integer getIdPropriedade() {
		return idPropriedade;
	}
	public void setIdPropriedade(Integer idPropriedade) {
		this.idPropriedade = idPropriedade;
	}	public Double getLocalizacaoX() {
		return localizacaoX;
	}
	public void setLocalizacaoX(Double localizacaoX) {
		this.localizacaoX = localizacaoX;
	}
	public Double getLocalizacaoY() {
		return localizacaoY;
	}
	public void setLocalizacaoY(Double localizacaoY) {
		this.localizacaoY = localizacaoY;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public Instant getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Instant data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}
	
}
