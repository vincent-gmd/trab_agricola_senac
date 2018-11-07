package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.TrataTable;
import model.dao.tables.UsaTable;
import model.vo.conector.Trata;
import model.vo.conector.Usa;

public class UsaDAO extends BaseDAO_Tables<Usa>{

	public UsaDAO(){
		this.table=new UsaTable();
	}

    @Override
    public void setValoresAtributosInsert(Usa entidade, PreparedStatement stmt) throws SQLException  {
    	int i=1;
        stmt.setInt(i++, entidade.getIdProduto());
        stmt.setInt(i++, entidade.getIdTratamento());
    }

    @Override
    public void setValoresAtributosUpdate(Usa entidade, PreparedStatement stmt)throws SQLException  {
    	int i=1;
    	stmt.setInt(i++, entidade.getId());
        stmt.setInt(i++, entidade.getIdProduto());
        stmt.setInt(i++, entidade.getIdTratamento());


    }

    @Override
    public Usa construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	Usa p =new Usa();
    	int i=1;
        p.setId( resultado.getInt(i++));
        p.setIdProduto( resultado.getInt(i++));
        p.setIdTratamento( resultado.getInt(i++));


        return p;
    }

}
