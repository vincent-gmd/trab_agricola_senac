package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.ForneceTable;
import model.vo.conector.Fornece;

public class ForneceDAO extends BaseDAO_Tables<Fornece>{

	public ForneceDAO(){
		this.table=new ForneceTable();
	}

    @Override
    public void setValoresAtributosInsert(Fornece entidade, PreparedStatement stmt) throws SQLException  {
    	int i=1;
        stmt.setInt(i++, entidade.getPreco());
        stmt.setInt(i++, entidade.getIdFornecedor());
        stmt.setInt(i++, entidade.getIdproduto());
    }

    @Override
    public void setValoresAtributosUpdate(Fornece entidade, PreparedStatement stmt)throws SQLException  {
    	int i=1;
    	stmt.setInt(i++, entidade.getId());
        stmt.setInt(i++, entidade.getPreco());
        stmt.setInt(i++, entidade.getIdFornecedor());
        stmt.setInt(i++, entidade.getIdproduto());


    }

    @Override
    public Fornece construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	Fornece p =new Fornece();
    	int i=1;
        p.setId( resultado.getInt(i++));
        p.setPreco( resultado.getInt(i++));
        p.setIdFornecedor( resultado.getInt(i++));
        p.setIdproduto( resultado.getInt(i++));


        return p;
    }

}