package model.dao.tables;

import model.dao.base.Colum;
import model.dao.base.Table;

public class TableFornece  extends Table{
	public TableFornece(){
        name="fornece";
        colums.add(new Colum("int","id"));
        colums.add(new Colum("int","preco"));
        colums.add(new Colum("int","idfornecedor"));
        colums.add(new Colum("int","idproduto"));

        //colums.add(new Colum("String","fotos"));
    }
}