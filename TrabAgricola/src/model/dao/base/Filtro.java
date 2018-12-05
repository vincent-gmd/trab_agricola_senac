package model.dao.base;

public class Filtro {
	private Comparador comparador;
	private Colum col;
	private Object value;
	private Filtro alt;
	public Filtro(Comparador comparador, Colum col, Object value, Filtro alt) {
		super();
		this.comparador = comparador;
		this.col = col;
		this.value = value;
		this.alt = alt;
	}
	public Filtro(Comparador comparador, Colum col, Object value) {
		super();
		this.comparador = comparador;
		this.col = col;
		this.value = value;
		this.alt = null;
	}
	public Comparador getComparador() {
		return comparador;
	}
	public void setComparador(Comparador comparador) {
		this.comparador = comparador;
	}
	public Colum getCol() {
		return col;
	}
	public void setCol(Colum col) {
		this.col = col;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Filtro getAlt() {
		return alt;
	}
	public void setAlt(Filtro alt) {
		this.alt = alt;
	}
	
	
}
