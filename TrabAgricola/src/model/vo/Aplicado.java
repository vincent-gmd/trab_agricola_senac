package model.vo;

import java.sql.Date;

public class Aplicado {
private int id;
private Date data ;
private int idPropriedade;
private int idTratamento;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
}
public int getIdPropriedade() {
	return idPropriedade;
}
public void setIdPropriedade(int idPropriedade) {
	this.idPropriedade = idPropriedade;
}
public int getIdTratamento() {
	return idTratamento;
}
public void setIdTratamento(int idTratamento) {
	this.idTratamento = idTratamento;
}

}
