package model.dao.tables;

import java.sql.Date;

import model.dao.base.Colum;
import model.dao.base.Table;

public class AplicadoTable extends Table{
	public AplicadoTable(){
        name="aplicado";

        colums.add(new Colum("int","id"));
        colums.add(new Colum("Date","data_fim"));
        colums.add(new Colum("Date","data_inicio"));

        colums.add(new Colum("int","idcultivo"));
        colums.add(new Colum("int","idtratamento"));
    }

}
