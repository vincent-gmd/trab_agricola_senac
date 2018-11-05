package model.vo;

import java.time.Instant;

public class Aplicado {
private int id;
private Instant data ;
private int idPropriedade;
private int idTratamento;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Instant getData() {
	return data;
}
public void setData(Instant data) {
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
