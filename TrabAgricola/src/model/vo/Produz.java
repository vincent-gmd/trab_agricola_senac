package model.vo;

import java.time.Instant;

public class Produz {
private int id;
private Instant dataInicio;
private Instant DataFim;
private int idCultura;
private int idPropriedade;
public int getId() {
	return id;
}
public void setId(int id) {
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
public int getIdCultura() {
	return idCultura;
}
public void setIdCultura(int idCultura) {
	this.idCultura = idCultura;
}
public int getIdPropriedade() {
	return idPropriedade;
}
public void setIdPropriedade(int idPropriedade) {
	this.idPropriedade = idPropriedade;
} 

}
