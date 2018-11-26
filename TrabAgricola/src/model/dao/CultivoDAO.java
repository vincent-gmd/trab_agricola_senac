package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.ContaminaTable;
import model.dao.tables.CultivoTable;
import model.vo.conector.Contamina;
import model.vo.conector.Cultivo;

public class CultivoDAO extends BaseDAO_Tables<Cultivo>{

	public CultivoDAO(){
		this.table=new CultivoTable();
	}

    @Override
    public void setValoresAtributosInsert(Cultivo entidade, PreparedStatement stmt) throws SQLException  {
    	int i=1;
    	stmt.setDate(i++, (Date)Date.from(entidade.getDataInicio()));
        stmt.setDate(i++, (Date)Date.from(entidade.getDataFim()));
        stmt.setInt(i++, entidade.getIdCultura());
        stmt.setInt(i++, entidade.getIdPropriedade());
    }

    @Override
    public void setValoresAtributosUpdate(Cultivo entidade, PreparedStatement stmt)throws SQLException  {
    	int i=1;
    	stmt.setInt(i++, entidade.getIdcultivo());
    	stmt.setDate(i++, (Date)Date.from(entidade.getDataInicio()));
        stmt.setDate(i++, (Date)Date.from(entidade.getDataFim()));
        stmt.setInt(i++, entidade.getIdCultura());
        stmt.setInt(i++, entidade.getIdPropriedade());

    }

    @Override
    public Cultivo construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	Cultivo p =new Cultivo();
        p.setIdcultivo( resultado.getInt(i++));
        p.setHectares_ocupa( resultado.getInt(i++));
        p.setDataInicio( resultado.getDate(i++).toInstant());
        p.setDataFim( resultado.getDate(i++).toInstant());
        p.setIdCultura( resultado.getInt(i++));
        p.setIdPropriedade( resultado.getInt(i++));

        return p;
    }

}