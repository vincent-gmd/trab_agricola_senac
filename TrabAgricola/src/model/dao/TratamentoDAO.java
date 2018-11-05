package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.TratamentoTable;
import model.vo.Tratamento;

public class TratamentoDAO extends BaseDAO_Tables<Tratamento>{

	public TratamentoDAO(){
		this.table=new TratamentoTable();
	}

    @Override
    public void setValoresAtributosInsert(Tratamento entidade, PreparedStatement stmt) throws SQLException  {
    	int i=1;
        stmt.setString(i++, entidade.getDescricao());
        stmt.setString(i++, entidade.getNome());

    }

    @Override
    public void setValoresAtributosUpdate(Tratamento entidade, PreparedStatement stmt)throws SQLException  {
    	int i=1;
    	stmt.setInt(i++, entidade.getIdTratamento());
        stmt.setString(i++, entidade.getDescricao());
        stmt.setString(i++, entidade.getNome());

    }

    @Override
    public Tratamento construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	Tratamento p =new Tratamento();
    	int i=1;
        p.setIdTratamento( resultado.getInt(i++));
        p.setDescricao( resultado.getString(i++));
        p.setNome( resultado.getString(i++));

        return p;
    }

}
