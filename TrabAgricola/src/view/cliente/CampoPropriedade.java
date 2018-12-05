package view.cliente;

import model.dao.base.Colum;

public enum CampoPropriedade {Documento(new Colum("String","documento")), Endere\u00E7o(new Colum("String","endereco")), Hecatres(new Colum("int","hectares_total"));
	Colum col;
	CampoPropriedade(Colum col){
		this.col=col;
	}

}
