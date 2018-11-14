package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.FornecedorTable;
import model.vo.conector.Fornecedor;

public class FornecedorDAO extends BaseDAO_Tables<Fornecedor>{
	public FornecedorDAO(){
		this.table=new FornecedorTable();
	}

    @Override
    public void setValoresAtributosInsert(Fornecedor entidade, PreparedStatement stmt) throws SQLException  {
    	int i=1;
    	stmt.setString(i++, entidade.getNome());
    	stmt.setString(i++, entidade.getDescricao());
    }

    @Override
    public void setValoresAtributosUpdate(Fornecedor entidade, PreparedStatement stmt)throws SQLException  {
    	int i=1;
    	stmt.setInt(i++, entidade.getIdFornecedor());
        stmt.setString(i++, entidade.getNome());
        stmt.setString(i++, entidade.getDescricao());
    }

    @Override
    public Fornecedor construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	Fornecedor p =new Fornecedor();
        p.setIdFornecedor( resultado.getInt(i++));
        p.setNome( resultado.getString(i++));
        p.setDescricao( resultado.getString(i++));
        return p;
    }
    
}