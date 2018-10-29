package model.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.ProdutoTable;
import model.vo.Produto;


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
    	stmt.setString(1, entidade.getNome());
    	stmt.setString(2, entidade.getDescricao());
    }

    @Override
    public void setValoresAtributosUpdate(Produto entidade, PreparedStatement stmt)throws SQLException  {
        stmt.setInt(1, entidade.getIdProduto());
        stmt.setString(2, entidade.getNome());
        stmt.setString(3, entidade.getDescricao());
    }

    @Override
    public Produto construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
        Produto p =new Produto();
        p.setIdProduto( resultado.getInt(1));
	p.setNome( resultado.getString(2));
        p.setDescricao( resultado.getString(3));
        return p;
    }
    
}
