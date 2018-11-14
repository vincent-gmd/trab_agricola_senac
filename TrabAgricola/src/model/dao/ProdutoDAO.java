package model.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.ProdutoTable;
import model.vo.conector.Produto;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vin3
 */
public class ProdutoDAO extends BaseDAO_Tables<Produto>{
	public ProdutoDAO(){
		this.table=new ProdutoTable();
	}

    @Override
    public void setValoresAtributosInsert(Produto entidade, PreparedStatement stmt) throws SQLException  {
    	int i=1;
    	stmt.setString(i++, entidade.getNome());
    	stmt.setString(i++, entidade.getDescricao());
    }

    @Override
    public void setValoresAtributosUpdate(Produto entidade, PreparedStatement stmt)throws SQLException  {
    	int i=1;
    	stmt.setInt(i++, entidade.getIdProduto());
        stmt.setString(i++, entidade.getNome());
        stmt.setString(i++, entidade.getDescricao());
    }

    @Override
    public Produto construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
        Produto p =new Produto();
        p.setIdProduto( resultado.getInt(i++));
        p.setNome( resultado.getString(i++));
        p.setDescricao( resultado.getString(i++));
        return p;
    }
    
}
