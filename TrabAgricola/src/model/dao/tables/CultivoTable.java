package model.dao.tables;

import model.dao.base.Colum;
import model.dao.base.Table;

public class CultivoTable extends Table {
	public CultivoTable(){
        name="produz";
        colums.add(new Colum("int","idcultivo"));
        colums.add(new Colum("int","hectares_ocupa"));

        colums.add(new Colum("Date","data_inicio"));
        colums.add(new Colum("Date","data_fim"));
        
        colums.add(new Colum("int","idpropriedade"));
        colums.add(new Colum("int","idcultura"));

    }
}
