package model.dao.tables;

import model.dao.base.Colum;
import model.dao.base.Table;

public class PropriedadeTable extends Table{
    public PropriedadeTable(){
        name="propriedade";
        colums.add(new Colum("int","idpropriedade"));
        colums.add(new Colum("Point","localisacao"));
        colums.add(new Colum("String","documento"));
        colums.add(new Colum("Date","data_cadastro"));
        colums.add(new Colum("String","endereco"));
        colums.add(new Colum("int","hectares_total"));

        colums.add(new Colum("int","idcliente"));
    }
    
}
