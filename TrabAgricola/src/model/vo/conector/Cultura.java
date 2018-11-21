package model.vo.conector;

import java.util.List;

import ca.odell.glazedlists.TextFilterable;

public class Cultura implements TextFilterable{
private Integer idCultura;
private String tipo;
private String nome;
//private String fotots;
private String descricao;
public Integer getIdCultura() {
	return idCultura;
}
public void setIdCultura(Integer idCultura) {
	this.idCultura = idCultura;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
@Override
public void getFilterStrings(List<String> baseList) {
	baseList.add(getTipo());
	baseList.add(getNome());
	baseList.add(getDescricao());
	
}
	
}
