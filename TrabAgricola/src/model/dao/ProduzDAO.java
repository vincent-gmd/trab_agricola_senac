package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.ContaminaTable;
import model.dao.tables.ProduzTable;
import model.vo.Contamina;
import model.vo.Produz;

public class ProduzDAO extends BaseDAO_Tables<Produz>{

	public ProduzDAO(){
		this.table=new ProduzTable();
	}

    @Override
    public void setValoresAtributosInsert(Produz entidade, PreparedStatement stmt) throws SQLException  {
    	int i=1;
    	stmt.setDate(i++, (Date)Date.from(entidade.getDataInicio()));
        stmt.setDate(i++, (Date)Date.from(entidade.getDataFim()));
        stmt.setInt(i++, entidade.getIdCultura());
        stmt.setInt(i++, entidade.getIdPropriedade());
    }

    @Override
    public void setValoresAtributosUpdate(Produz entidade, PreparedStatement stmt)throws SQLException  {
    	int i=1;
    	stmt.setInt(i++, entidade.getId());
    	stmt.setDate(i++, (Date)Date.from(entidade.getDataInicio()));
        stmt.setDate(i++, (Date)Date.from(entidade.getDataFim()));
        stmt.setInt(i++, entidade.getIdCultura());
        stmt.setInt(i++, entidade.getIdPropriedade());

    }

    @Override
    public Produz construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	Produz p =new Produz();
    	int i=1;
        p.setId( resultado.getInt(i++));
        p.setDataInicio( resultado.getDate(i++).toInstant());
        p.setDataFim( resultado.getDate(i++).toInstant());
        p.setIdCultura( resultado.getInt(i++));
        p.setIdPropriedade( resultado.getInt(i++));

        return p;
    }

}