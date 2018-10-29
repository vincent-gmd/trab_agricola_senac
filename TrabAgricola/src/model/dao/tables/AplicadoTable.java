package model.dao.tables;

import java.sql.Date;

import model.dao.base.Colum;
import model.dao.base.Table;

public class AplicadoTable extends Table{
	public AplicadoTable(){

        colums.add(new Colum("int","id"));
        colums.add(new Colum("Date","data"));
        colums.add(new Colum("int","idpropriedade"));
        colums.add(new Colum("int","idtratamento"));
    }

}
