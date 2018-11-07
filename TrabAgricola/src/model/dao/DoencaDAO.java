package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.CulturaTable;
import model.dao.tables.DoencaTable;
import model.vo.conector.Cultura;
import model.vo.conector.Doenca;

public class DoencaDAO extends BaseDAO_Tables<Doenca>{
	public DoencaDAO(){
		this.table=new DoencaTable();
	}

    @Override
    public void setValoresAtributosInsert(Doenca entidade, PreparedStatement stmt) throws SQLException  {
    	int i=1;
    	 stmt.setString(i++, entidade.getNome());
         stmt.setString(i++, entidade.getCausador());
         stmt.setString(i++, entidade.getDescricao());
    }

    @Override
    public void setValoresAtributosUpdate(Doenca entidade, PreparedStatement stmt)throws SQLException  {
    	int i=1;
    	stmt.setInt(i++, entidade.getIdDoenca());
        stmt.setString(i++, entidade.getNome());
        stmt.setString(i++, entidade.getCausador());
        stmt.setString(i++, entidade.getDescricao());
    }

    @Override
    public Doenca construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	Doenca p =new Doenca();
        int i=1;
        p.setIdDoenca( resultado.getInt(i++));
        p.setNome( resultado.getString(i++));
        p.setCausador( resultado.getString(i++));
        p.setDescricao( resultado.getString(i++));
        return p;
    }
    
}
