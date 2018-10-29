/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.tables;

import model.dao.base.Colum;
import model.dao.base.Table;

/**
 *
 * @author vin3
 */
public class ProdutoTable extends Table {
    public ProdutoTable(){
        name="produto";
        colums.add(new Colum("int","idproduto"));
        colums.add(new Colum("String","nome"));
        colums.add(new Colum("String","descri"));
    }
    
    
}
