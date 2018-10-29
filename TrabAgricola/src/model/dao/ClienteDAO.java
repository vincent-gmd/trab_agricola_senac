package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.ClienteTable;
import model.vo.Cliente;

public class ClienteDAO extends BaseDAO_Tables<Cliente>{
	public ClienteDAO(){
		this.table=new ClienteTable();
	}

    @Override
    public void setValoresAtributosInsert(Cliente entidade, PreparedStatement stmt) throws SQLException  {
        stmt.setString(2, entidade.getLogin());
        stmt.setString(3, entidade.getSenha());
        stmt.setString(4, entidade.getNivelAcesso());
        stmt.setString(4, entidade.getEmail());
    }

    @Override
    public void setValoresAtributosUpdate(Cliente entidade, PreparedStatement stmt)throws SQLException  {
        stmt.setInt(1, entidade.getIdCliente());
        stmt.setString(2, entidade.getLogin());
        stmt.setString(3, entidade.getSenha());
        stmt.setString(4, entidade.getNivelAcesso());
        stmt.setString(4, entidade.getEmail());


    }

    @Override
    public Cliente construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	Cliente p =new Cliente();
        p.setIdCliente( resultado.getInt(1));
        p.setLogin( resultado.getString(2));
        p.setSenha( resultado.getString(3));
        p.setNivelAcesso( resultado.getString(4));
        p.setEmail( resultado.getString(5));


        return p;
    }
}
