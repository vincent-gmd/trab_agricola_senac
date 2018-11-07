package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.ClienteTable;
import model.vo.conector.Cliente;

public class ClienteDAO extends BaseDAO_Tables<Cliente>{
	public ClienteDAO(){
		this.table=new ClienteTable();
	}

    @Override
    public void setValoresAtributosInsert(Cliente entidade, PreparedStatement stmt) throws SQLException  {
    	int i=1;
    	stmt.setString(i++, entidade.getLogin());
        stmt.setString(i++, entidade.getSenha());
        stmt.setString(i++, entidade.getNivelAcesso());
        stmt.setString(i++, entidade.getEmail());
    }

    @Override
    public void setValoresAtributosUpdate(Cliente entidade, PreparedStatement stmt)throws SQLException  {
    	int i=1;
    	stmt.setInt(i++, entidade.getIdCliente());
        stmt.setString(i++, entidade.getLogin());
        stmt.setString(i++, entidade.getSenha());
        stmt.setString(i++, entidade.getNivelAcesso());
        stmt.setString(i++, entidade.getEmail());


    }

    @Override
    public Cliente construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	Cliente p =new Cliente();
    	int i=1;
        p.setIdCliente( resultado.getInt(i++));
        p.setLogin( resultado.getString(i++));
        p.setSenha( resultado.getString(i++));
        p.setNivelAcesso( resultado.getString(i++));
        p.setEmail( resultado.getString(i++));


        return p;
    }
}
