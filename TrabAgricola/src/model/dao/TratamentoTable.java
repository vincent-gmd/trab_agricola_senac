package model.dao;

import model.dao.base.Colum;
import model.dao.base.Table;

public class TratamentoTable extends Table{
	TratamentoTable(){
        name="tratamento";
        colums.add(new Colum("int","idtratamento"));
        colums.add(new Colum("String","descri"));
        //colums.add(new Colum("String","fotos"));
        colums.add(new Colum("String","nome"));
    }
}
