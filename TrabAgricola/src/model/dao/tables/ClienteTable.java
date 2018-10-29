package model.dao.tables;

import model.dao.base.Colum;
import model.dao.base.Table;

public class ClienteTable extends Table{
	public ClienteTable(){
        name="cliente";
        colums.add(new Colum("int","idcliente"));
        colums.add(new Colum("String","login"));
        colums.add(new Colum("String","senha"));
        colums.add(new Colum("String","nivelAcesso"));
        colums.add(new Colum("String","email"));

    }
}
