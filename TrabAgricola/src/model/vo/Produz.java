package model.vo;

import java.sql.Date;

public class Produz {
private int id;
private Date dataInicio;
private Date DataFim;
private int idCultura;
private int idPropriedade;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getDataInicio() {
	return dataInicio;
}
public void setDataInicio(Date dataInicio) {
	this.dataInicio = dataInicio;
}
public Date getDataFim() {
	return DataFim;
}
public void setDataFim(Date dataFim) {
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
