package model.vo;

import java.time.Instant;

public class Produz {
private Integer id;
private Instant dataInicio;
private Instant DataFim;
private Integer idCultura;
private Integer idPropriedade;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Instant getDataInicio() {
	return dataInicio;
}
public void setDataInicio(Instant dataInicio) {
	this.dataInicio = dataInicio;
}
public Instant getDataFim() {
	return DataFim;
}
public void setDataFim(Instant dataFim) {
	DataFim = dataFim;
}
public Integer getIdCultura() {
	return idCultura;
}
public void setIdCultura(Integer idCultura) {
	this.idCultura = idCultura;
}
public Integer getIdPropriedade() {
	return idPropriedade;
}
public void setIdPropriedade(Integer idPropriedade) {
	this.idPropriedade = idPropriedade;
} 

}
