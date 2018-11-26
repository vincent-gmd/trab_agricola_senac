package model.dao;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import model.dao.base.BaseDAO_Tables;
import model.dao.tables.CulturaTable;
import model.dao.tables.PropriedadeTable;
import model.dao.util.Coordinate;
import model.dao.util.PointParser;
import model.vo.conector.Cultura;
import model.vo.conector.Propriedade;

public class PropriedadeDAO extends BaseDAO_Tables< Propriedade>{
	public  PropriedadeDAO(){
		this.table=new  PropriedadeTable();
	}

    @Override
    public void setValoresAtributosInsert( Propriedade entidade, PreparedStatement stmt) throws SQLException  {
    	int i=1;
    	;
        stmt.setDouble(i++, entidade.getLocalizacaoX());
        stmt.setDouble(i++, entidade.getLocalizacaoY());
        stmt.setString(i++, entidade.getDocumento());
        stmt.setDate(i++, (Date)Date.from(entidade.getData_cadastro()) );
        stmt.setString(i++, entidade.getEndereco());
    	stmt.setInt(i++, entidade.getHectares_total());

        
    	stmt.setInt(i++, entidade.getIdcliente());
    }

    @Override
    public void setValoresAtributosUpdate( Propriedade entidade, PreparedStatement stmt)throws SQLException  {
    	int i=1;
    	stmt.setInt(i++, entidade.getIdPropriedade());
        stmt.setDouble(i++, entidade.getLocalizacaoX());
        stmt.setDouble(i++, entidade.getLocalizacaoY());
        stmt.setString(i++, entidade.getDocumento());
        stmt.setDate(i++, (Date)Date.from(entidade.getData_cadastro()) );
        stmt.setString(i++, entidade.getEndereco());
    	stmt.setInt(i++, entidade.getHectares_total());

        
    	stmt.setInt(i++, entidade.getIdcliente());


    }

    @Override
    public  Propriedade construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	 Propriedade p =new  Propriedade();
        p.setIdPropriedade( resultado.getInt(i++));
        byte[] b=  resultado.getBytes(i++);
        Coordinate c= PointParser.readCoordinateFromWkbBytes(b);
        p.setLocalizacaoX(c.getX());
        p.setLocalizacaoY(c.getY());
        
        p.setDocumento(resultado.getString(i++));
        p.setData_cadastro(resultado.getDate(i++).toInstant());
        p.setEndereco(resultado.getString(i++));
        p.setHectares_total(resultado.getInt(i++));

        
        p.setIdcliente(resultado.getInt(i++));

        return p;
    }
    
}
