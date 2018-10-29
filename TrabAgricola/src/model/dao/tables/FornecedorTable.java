package model.dao.tables;

import model.dao.base.Colum;
import model.dao.base.Table;

public class FornecedorTable extends Table{
	public FornecedorTable(){
        name="fornecedor";
        colums.add(new Colum("int","idfornecedor"));
        colums.add(new Colum("String","nome"));
        //colums.add(new Colum("String","fotos"));
        colums.add(new Colum("String","descri"));
    }
}
