package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.AplicadoTable;
import model.vo.conector.Aplicado;

public class AplicadoDAO extends BaseDAO_Tables<Aplicado>{

	public AplicadoDAO(){
		this.table=new AplicadoTable();
	}

    @Override
    public void setValoresAtributosInsert(Aplicado entidade, PreparedStatement stmt) throws SQLException  {
    	int i=1;
    	stmt.setDate(i++, (Date)Date.from(entidade.getData()));
    	stmt.setInt(i++, entidade.getIdPropriedade());
    	stmt.setInt(i++, entidade.getIdTratamento());
    }

    @Override
    public void setValoresAtributosUpdate(Aplicado entidade, PreparedStatement stmt)throws SQLException  {
    	int i=1;
    	stmt.setInt(i++, entidade.getId());
        stmt.setDate(i++, (Date)Date.from(entidade.getData()));
        stmt.setInt(i++, entidade.getIdPropriedade());
        stmt.setInt(i++, entidade.getIdTratamento());

    }

    @Override
    public Aplicado construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	Aplicado p =new Aplicado();
        p.setId( resultado.getInt(i++));
        p.setData( resultado.getDate(i++).toInstant());
        p.setIdPropriedade( resultado.getInt(i++));
        p.setIdTratamento( resultado.getInt(i++));

        return p;
    }

}
