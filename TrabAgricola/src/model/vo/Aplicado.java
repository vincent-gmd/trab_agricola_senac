package model.vo;

import java.time.Instant;

public class Aplicado {
private Integer id;
private Instant data ;
private Integer idPropriedade;
private Integer idTratamento;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Instant getData() {
	return data;
}
public void setData(Instant data) {
	this.data = data;
}
public Integer getIdPropriedade() {
	return idPropriedade;
}
public void setIdPropriedade(Integer idPropriedade) {
	this.idPropriedade = idPropriedade;
}
public Integer getIdTratamento() {
	return idTratamento;
}
public void setIdTratamento(Integer idTratamento) {
	this.idTratamento = idTratamento;
}

}
