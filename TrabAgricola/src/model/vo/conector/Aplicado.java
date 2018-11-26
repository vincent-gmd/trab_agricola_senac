package model.vo.conector;

import java.time.Instant;

public class Aplicado {
private Integer id;
private Instant data_fim ;
private Instant data_inicio ;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Instant getData_fim() {
	return data_fim;
}
public void setData_fim(Instant data_fim) {
	this.data_fim = data_fim;
}
public Instant getData_inicio() {
	return data_inicio;
}
public void setData_inicio(Instant data_inicio) {
	this.data_inicio = data_inicio;
}
public Integer getIdcultivo() {
	return idcultivo;
}
public void setIdcultivo(Integer idcultivo) {
	this.idcultivo = idcultivo;
}
public Integer getIdTratamento() {
	return idTratamento;
}
public void setIdTratamento(Integer idTratamento) {
	this.idTratamento = idTratamento;
}
private Integer idcultivo;
private Integer idTratamento;

}
