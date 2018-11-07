package model.dao.tables;

import model.dao.base.Colum;
import model.dao.base.Table;

public class UsaTable extends Table{
	public UsaTable(){
        name="Usa";
        colums.add(new Colum("int","id"));
        colums.add(new Colum("int","idproduto"));
        colums.add(new Colum("int","idtratamento"));

    }
}