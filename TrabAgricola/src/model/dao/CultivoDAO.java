package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

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
    	
    	
    	stmt.setInt(i++, entidade.getHectares_ocupa());

    	if(entidade.getDataInicio()!=null) {
    	  //  OffsetDateTime odt = OffsetDateTime.ofInstant(entidade.getDataInicio(), ZoneOffset.UTC );
        	stmt.setObject(i++,LocalDateTime.ofInstant(entidade.getDataInicio(), ZoneOffset.UTC) );
    	}else {
    		i++;
    	}
    	if(entidade.getDataFim()!=null) {
    	  //  OffsetDateTime odt = OffsetDateTime.ofInstant(entidade.get(), ZoneOffset.UTC );
            stmt.setObject(i++, LocalDateTime.ofInstant(entidade.getDataFim(), ZoneOffset.UTC));
    	}else {
    		i++;
    	}
    	
        stmt.setInt(i++, entidade.getIdPropriedade());
        stmt.setInt(i++, entidade.getIdCultura());


    }

    @Override
    public void setValoresAtributosUpdate(Cultivo entidade, PreparedStatement stmt)throws SQLException  {
    	int i=1;
    	
    	
    	
    	stmt.setInt(i++, entidade.getIdcultivo());
    	stmt.setInt(i++, entidade.getHectares_ocupa());

    	if(entidade.getDataInicio()!=null) {
    	  //  OffsetDateTime odt = OffsetDateTime.ofInstant(entidade.getDataInicio(), ZoneOffset.UTC );
        	stmt.setObject(i++,LocalDateTime.ofInstant(entidade.getDataInicio(), ZoneOffset.UTC) );
    	}else {
    		i++;
    	}
    	if(entidade.getDataFim()!=null) {
    	  //  OffsetDateTime odt = OffsetDateTime.ofInstant(entidade.get(), ZoneOffset.UTC );
            stmt.setObject(i++, LocalDateTime.ofInstant(entidade.getDataFim(), ZoneOffset.UTC));
    	}else {
    		i++;
    	}
    	
        stmt.setInt(i++, entidade.getIdPropriedade());
        stmt.setInt(i++, entidade.getIdCultura());


    }

    @Override
    public Cultivo construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
    	Cultivo p =new Cultivo();
        p.setIdcultivo( resultado.getInt(i++));
        p.setHectares_ocupa( resultado.getInt(i++));
        if(resultado.getDate(i)!=null) {
            p.setDataInicio( resultado.getObject(i++,LocalDateTime.class).atZone(ZoneOffset.UTC).toInstant());
        }else {
        	i++;
        }
        if(resultado.getDate(i)!=null) {
            p.setDataFim( resultado.getObject(i++,LocalDateTime.class).atZone(ZoneOffset.UTC).toInstant());
        }else {
        	i++;
        }
        
        p.setIdPropriedade( resultado.getInt(i++));
        p.setIdCultura( resultado.getInt(i++));


        return p;
    }

}