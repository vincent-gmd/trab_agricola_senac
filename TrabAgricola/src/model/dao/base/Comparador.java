package model.dao.base;

public enum Comparador {IGUAL(" == "),MAIOR(" > "),MENOR(" < "),LIKE(" LIKE ");
	String op;
	Comparador(String op){
		this.op=op;
	}
}
