package model.dao.tables;

import model.dao.base.Colum;
import model.dao.base.Table;

public class ProduzTable extends Table {
	public ProduzTable(){
        name="produz";
        colums.add(new Colum("int","id"));
        colums.add(new Colum("Date","data_inicio"));
        colums.add(new Colum("Date","data_fim"));

        colums.add(new Colum("int","idcultura"));

        colums.add(new Colum("int","idpropriedade"));
    }
}
