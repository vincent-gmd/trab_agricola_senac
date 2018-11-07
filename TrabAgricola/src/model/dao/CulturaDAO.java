package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.CulturaTable;
import model.dao.tables.ProdutoTable;
import model.vo.conector.Cultura;
import model.vo.conector.Produto;

public class CulturaDAO extends BaseDAO_Tables<Cultura>{
	public CulturaDAO(){
		this.table=new CulturaTable();
	}

    @Override
    public void setValoresAtributosInsert(Cultura entidade, PreparedStatement stmt) throws SQLException  {
    	int i=1;
        stmt.setString(i++, entidade.getTipo());
    	stmt.setString(i++, entidade.getNome());
    	stmt.setString(i++, entidade.getDescricao());
    }

    @Override
    public void setValoresAtributosUpdate(Cultura entidade, PreparedStatement stmt)throws SQLException  {
    	int i=1;
    	stmt.setInt(i++, entidade.getIdCultura());
        stmt.setString(i++, entidade.getTipo());
        stmt.setString(i++, entidade.getNome());
        stmt.setString(i++, entidade.getDescricao());
    }

    @Override
    public Cultura construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	Cultura p =new Cultura();
        int i=1;
        p.setIdCultura( resultado.getInt(i++));
        p.setTipo( resultado.getString(i++));
        p.setNome( resultado.getString(i++));
        p.setDescricao( resultado.getString(i++));
        return p;
    }
    
}
