package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.AplicadoTable;
import model.vo.Aplicado;

public class AplicadoDAO extends BaseDAO_Tables<Aplicado>{

	public AplicadoDAO(){
		this.table=new AplicadoTable();
	}

    @Override
    public void setValoresAtributosInsert(Aplicado entidade, PreparedStatement stmt) throws SQLException  {
    	stmt.setDate(1, entidade.getData());
    	stmt.setInt(2, entidade.getIdPropriedade());
    	stmt.setInt(3, entidade.getIdTratamento());
    }

    @Override
    public void setValoresAtributosUpdate(Aplicado entidade, PreparedStatement stmt)throws SQLException  {
        stmt.setInt(1, entidade.getId());
        stmt.setDate(2, entidade.getData());
        stmt.setInt(3, entidade.getIdPropriedade());
        stmt.setInt(4, entidade.getIdTratamento());

    }

    @Override
    public Aplicado construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	Aplicado p =new Aplicado();
        p.setId( resultado.getInt(1));
        p.setData( resultado.getDate(2));
        p.setIdPropriedade( resultado.getInt(3));
        p.setIdTratamento( resultado.getInt(4));

        return p;
    }

}
