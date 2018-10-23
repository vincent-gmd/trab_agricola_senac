package model.dao.base;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO_Tables<T> extends BaseDAO<T>{

	protected  Table table;
	public Table getTable(){
		return table;	
	}
	public void setTable(Table table){
		this.table =table;	
	}
	public BaseDAO_Tables(Table table) {
		this.table =table;
	}
	public BaseDAO_Tables() {

	}

	@Override
	public String getNomeTabela() {
		return getTable().getName();

	}

	@Override
	public String getNomeColunaChavePrimaria() {
		return getTable().getColums().get(0).getName();
	}

	@Override
	public String getNomesColunasInsert() {
		String s= "";
		
		for(int i=1;i<getTable().getColums().size();i++) {
			s= s+getTable().getColums().get(i).getName();
			
			if((i+1)!=getTable().getColums().size()) {
				s=s+",";
			}
		}
		
		return s;
	}

	@Override
	public String getInterrogacoesInsert() {
		String s= "";
		for(int i=1;i<getTable().getColums().size();i++) {
			s= s+"?";
			
			if((i+1)<getTable().getColums().size()) {
				s=s+",";
			}
		}
		
		return s;
	}



	@Override
	public String getValoresClausulaSetUpdate() {
		// TODO Auto-generated method stub
		String clausulaSet = "";
		for(int i=0;i<getTable().getColums().size();i++) {
			clausulaSet += getTable().getColums().get(i).getName()+" =  ?";
					if((i+1)<getTable().getColums().size()) {
						clausulaSet+=",";
					}
		}	
		return clausulaSet;
	}
	public String getValoresClausulaWhere(ArrayList<Colum> colums) {
		// TODO Auto-generated method stub
                if(!(colums.size()>0)){
                    return "";
                }
		String clausulaSet = "where ";
		for(int i=0;i<colums.size();i++) {
			
			clausulaSet += colums.get(i).getName()+" =  ? ";
					if((i+1)<colums.size()) {
						clausulaSet+=" and ";
					}
		}	
		return clausulaSet;
	}
	public String getValoresClausulaWhereLike(ArrayList<Colum> colums) {
		// TODO Auto-generated method stub
                if(!(colums.size()>0)){
                    return "";
                }
		String clausulaSet = "where ";
		for(int i=0;i<colums.size();i++) {
			
			clausulaSet += colums.get(i).getName()+" like  ? ";
					if((i+1)<colums.size()) {
						clausulaSet+=" and ";
					}
		}	
		return clausulaSet;
	}
	
	public List<T> listarTodosWhereStringsLike(ArrayList<Colum> colums ,ArrayList<String> values) {
		String sql = "SELECT * FROM " + getNomeTabela()+getValoresClausulaWhereLike(colums)+";";
		

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		ArrayList<T> listaEntidades = new ArrayList<T>();
		
		try{
			this.setValoresAtributosWhereStrings(colums, values, stmt);
			resultado = stmt.executeQuery(sql);
			while(resultado.next()){
				T objetoConsultado = construirObjetoDoResultSet(resultado);
				listaEntidades.add(objetoConsultado);
			}
		} catch (SQLException e){
			System.out.println("Erro ao consultar todos os objetos da entidade " + this.getClass().toString());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaEntidades;
	}
	
	public List<T> listarTodosWhere(ArrayList<Colum> colums ,ArrayList<Object> values) throws SQLException{
		String sql = "SELECT * FROM " + getNomeTabela()+getValoresClausulaWhere(colums)+";";
		

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		ArrayList<T> listaEntidades = new ArrayList<T>();
		
		try{
			this.setValoresAtributosWhere(colums, values, stmt);
			resultado = stmt.executeQuery(sql);
			while(resultado.next()){
				T objetoConsultado = construirObjetoDoResultSet(resultado);
				listaEntidades.add(objetoConsultado);
			}
		} catch (SQLException e){
			System.out.println("Erro ao consultar todos os objetos da entidade " + this.getClass().toString());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaEntidades;
	}
	public void setValoresAtributosWhereStrings(ArrayList<Colum> colums ,ArrayList<String> values,PreparedStatement stmt) throws SQLException{
		for(int i =0;i<values.size();i++) {
			stmt.setString(i, values.get(i).toString());
		}
	}
	public void setValoresAtributosWhere(ArrayList<Colum> colums ,ArrayList<Object> values,PreparedStatement stmt) throws SQLException{
		for(int i =0;i<values.size();i++) {
			switch (colums.get(i).getType()) {
			case "String":
			case "string":
				stmt.setString(i, values.get(i).toString());
				break;
			case "int":
			case "Int":
			case "Integer":
			case "integer":
				stmt.setInt(i,(Integer) values.get(i));
				break;
			
			case "BigDecimal":
				stmt.setBigDecimal(i,(BigDecimal) values.get(i));
				break;
				
			case "Boolean":
			case "boolean":
				stmt.setBoolean(i,(Boolean) values.get(i));
				break;
				
			case "Date":
				stmt.setDate(i,(Date) values.get(i));
				break;
				
			case "Double":
			case "double":
				stmt.setDouble(i,(Double) values.get(i));
				break;
				
			case "Float":
			case "float":
				stmt.setFloat(i,(Float) values.get(i));
				break;
			
			case "Long":
			case "long":
				stmt.setLong(i,(Long) values.get(i));
				break;
			
			case "Null":
			case "null":
				stmt.setNull(i,(Integer) values.get(i));
				break;
				
			case "Short":
			case "short":
				stmt.setShort(i,(Short) values.get(i));
				break;
				
			case "Time":
				stmt.setTime(i,(Time) values.get(i));
				break;
				
			case "Timestamp":
				stmt.setTimestamp(i,(Timestamp) values.get(i));
				break;
				
			case "URL":
				stmt.setURL(i,(URL) values.get(i));
				break;
			
				
				
			default:
				System.out.println("Erro ao identificar tipo :"+colums.get(i).getType()+" de:"+ colums.get(i).getName()+" valor:"+values.get(i).toString());
				break;
			}
			
		}
				

	}
						

}
