package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.ContaminaTable;
import model.vo.conector.Contamina;

public class ContaminaDAO extends BaseDAO_Tables<Contamina>{

	public ContaminaDAO(){
		this.table=new ContaminaTable();
	}

    @Override
    public void setValoresAtributosInsert(Contamina entidade, PreparedStatement stmt) throws SQLException  {
    	int i=1;
        stmt.setDate(i++, (Date)Date.from(entidade.getDataFim()));
        stmt.setDate(i++, (Date)Date.from(entidade.getData_inicio()));
        //stmt.setString(i++, entidade.getFotos());
        stmt.setInt(i++, entidade.getConfirmacao());
        stmt.setString(i++, entidade.getDescricao());
        stmt.setInt(i++, entidade.getIdCultivo());
        stmt.setInt(i++, entidade.getIdDoenca());
    }

    @Override
    public void setValoresAtributosUpdate(Contamina entidade, PreparedStatement stmt)throws SQLException  {
    	int i=1;
    	stmt.setInt(i++, entidade.getId());
        stmt.setDate(i++, (Date)Date.from(entidade.getDataFim()));
        stmt.setDate(i++, (Date)Date.from(entidade.getData_inicio()));
        //stmt.setString(i++, entidade.getFotos());
        stmt.setInt(i++, entidade.getConfirmacao());
        stmt.setString(i++, entidade.getDescricao());
        stmt.setInt(i++, entidade.getIdCultivo());
        stmt.setInt(i++, entidade.getIdDoenca());

    }

    @Override
    public Contamina construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	Contamina p =new Contamina();
        p.setId( resultado.getInt(i++));
        p.setDataFim( resultado.getDate(i++).toInstant());
        p.setData_inicio( resultado.getDate(i++).toInstant());
        p.setConfirmacao( resultado.getInt(i++));
        p.setDescricao( resultado.getString(i++));
        p.setIdCultivo( resultado.getInt(i++));
        p.setIdDoenca( resultado.getInt(i++));

        return p;
    }

}
