package model.dao.base;

public enum Comparador {
	IGUAL(" = "),MAIOR(" > "),MENOR(" < "),MAIOR_IGUAL(" >= "),MENOR_IGUAL(" <= "),
	DIFERENTE(" <> "),
	LIKE(" LIKE "),NOT_LIKE(" NOT LIKE ");
	String op;
	Comparador(String op){
		this.op=op;
	}
}
