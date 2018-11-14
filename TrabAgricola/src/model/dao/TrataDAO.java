package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.TrataTable;
import model.vo.conector.Trata;

public class TrataDAO extends BaseDAO_Tables<Trata>{

	public TrataDAO(){
		this.table=new TrataTable();
	}

    @Override
    public void setValoresAtributosInsert(Trata entidade, PreparedStatement stmt) throws SQLException  {
    	int i=1;
        stmt.setInt(i++, entidade.getIdDoenca());
        stmt.setInt(i++, entidade.getIdTratamento());
    }

    @Override
    public void setValoresAtributosUpdate(Trata entidade, PreparedStatement stmt)throws SQLException  {
    	int i=1;
    	stmt.setInt(i++, entidade.getId());
        stmt.setInt(i++, entidade.getIdDoenca());
        stmt.setInt(i++, entidade.getIdTratamento());


    }

    @Override
    public Trata construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	Trata p =new Trata();
        p.setId( resultado.getInt(i++));
        p.setIdDoenca( resultado.getInt(i++));
        p.setIdTratamento( resultado.getInt(i++));


        return p;
    }

}
