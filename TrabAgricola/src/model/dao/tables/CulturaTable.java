package model.dao.tables;

import model.dao.base.Colum;
import model.dao.base.Table;

public class CulturaTable extends Table {
	public CulturaTable(){
        name="cultura";
        colums.add(new Colum("int","idcultura"));
        colums.add(new Colum("String","tipo"));
        colums.add(new Colum("String","nome"));
        //colums.add(new Colum("String","fotos"));
        colums.add(new Colum("String","descri"));
    }
}
