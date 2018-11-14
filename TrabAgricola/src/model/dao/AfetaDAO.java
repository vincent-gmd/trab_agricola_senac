package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.AfetaTable;
import model.vo.conector.Afeta;

public class AfetaDAO extends BaseDAO_Tables<Afeta>{

	public AfetaDAO(){
		this.table=new AfetaTable();
	}

    @Override
    public void setValoresAtributosInsert(Afeta entidade, PreparedStatement stmt) throws SQLException  {
    	int i=1;
        stmt.setInt(i++, entidade.getIdCultura());
        stmt.setInt(i++, entidade.getIdDoenca());
    }

    @Override
    public void setValoresAtributosUpdate(Afeta entidade, PreparedStatement stmt)throws SQLException  {
    	int i=1;
    	stmt.setInt(i++, entidade.getId());
        stmt.setInt(i++, entidade.getIdCultura());
        stmt.setInt(i++, entidade.getIdDoenca());


    }

    @Override
    public Afeta construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	Afeta p =new Afeta();
        p.setId( resultado.getInt(i++));
        p.setIdCultura( resultado.getInt(i++));
        p.setIdDoenca( resultado.getInt(i++));


        return p;
    }

}