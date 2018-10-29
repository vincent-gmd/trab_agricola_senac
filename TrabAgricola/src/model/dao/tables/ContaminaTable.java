package model.dao.tables;

import model.dao.base.Colum;
import model.dao.base.Table;

public class ContaminaTable extends Table{
	public ContaminaTable(){
        name="contamina";

        colums.add(new Colum("int","id"));
        colums.add(new Colum("Date","data_fim"));
        colums.add(new Colum("Date","date"));
        //colums.add(new Colum("String","fotos"));
        colums.add(new Colum("int","confirma"));
        colums.add(new Colum("String","descri"));
        colums.add(new Colum("int","idpropriedade"));
        colums.add(new Colum("int","iddoenca"));
    }
}
