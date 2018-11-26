package model.vo.conector;

import java.time.Instant;

public class Cultivo {
private Integer idcultivo;
private Integer hectares_ocupa;
private Instant dataInicio;
private Instant DataFim;
private Integer idCultura;
private Integer idPropriedade;
public Integer getIdcultivo() {
	return idcultivo;
}
public void setIdcultivo(Integer idcultivo) {
	this.idcultivo = idcultivo;
}
public Integer getHectares_ocupa() {
	return hectares_ocupa;
}
public void setHectares_ocupa(Integer hectares_ocupa) {
	this.hectares_ocupa = hectares_ocupa;
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
