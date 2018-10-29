package model.dao.tables;

import model.dao.base.Colum;
import model.dao.base.Table;

public class TratamentoTable extends Table{
	public TratamentoTable(){
        name="tratamento";
        colums.add(new Colum("int","idtratamento"));
        colums.add(new Colum("String","descri"));
        //colums.add(new Colum("String","fotos"));
        colums.add(new Colum("String","nome"));
    }
}
