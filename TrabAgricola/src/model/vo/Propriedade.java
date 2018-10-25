package model.vo;

import java.awt.Point;
import java.sql.Date;

public class Propriedade {
	private int idPropriedade;
	private Point localisacao;
	private String documento;
	private Date data_cadastro;
	private String endereco;
	private int idcliente;
	public int getIdPropriedade() {
		return idPropriedade;
	}
	public void setIdPropriedade(int idPropriedade) {
		this.idPropriedade = idPropriedade;
	}
	public Point getLocalisacao() {
		return localisacao;
	}
	public void setLocalisacao(Point localisacao) {
		this.localisacao = localisacao;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public Date getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	
}
