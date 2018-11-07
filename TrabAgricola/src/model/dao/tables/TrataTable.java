package model.dao.tables;

import model.dao.base.Colum;
import model.dao.base.Table;

public class TrataTable extends Table{
	public TrataTable(){
        name="Trata";
        colums.add(new Colum("int","id"));
        colums.add(new Colum("int","iddoenca"));
        colums.add(new Colum("int","idtratamento"));

    }
}