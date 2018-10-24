package model.dao;

import model.dao.base.Colum;
import model.dao.base.Table;

public class DoencaTable extends Table{
	DoencaTable(){
        name="doenca";
        colums.add(new Colum("int","idcultura"));
        colums.add(new Colum("String","tipo"));
        colums.add(new Colum("String","nome"));
        //colums.add(new Colum("String","fotos"));
        colums.add(new Colum("String","descri"));
    }

}
