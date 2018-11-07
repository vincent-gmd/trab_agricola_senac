package model.dao.tables;

import model.dao.base.Colum;
import model.dao.base.Table;

public class AfetaTable extends Table{
	public AfetaTable(){
        name="afeta";
        colums.add(new Colum("int","id"));
        colums.add(new Colum("int","idcultura"));
        colums.add(new Colum("int","iddoenca"));

    }
}