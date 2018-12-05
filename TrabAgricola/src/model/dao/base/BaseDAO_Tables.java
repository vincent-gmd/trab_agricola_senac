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
	protected String getNomeTabela() {
		return getTable().getName();

	}

	@Override
	protected String getNomeColunaChavePrimaria() {
		return getTable().getColums().get(0).getName();
	}

	@Override
	protected String getNomesColunasInsert() {
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
	protected String getInterrogacoesInsert() {
		String s= "";
		for(int i=1;i<getTable().getColums().size();i++) {
			if(getTable().getColums().get(i).getType().equalsIgnoreCase("point")) {
				s= s+"point (?,?)";
			}else {
				s= s+"?";
			}
			
			if((i+1)<getTable().getColums().size()) {
				s=s+",";
			}
		}
		
		return s;
	}



	@Override
	protected String getValoresClausulaSetUpdate() {
		// TODO Auto-generated method stub
		String clausulaSet = "";
		for(int i=0;i<getTable().getColums().size();i++) {
			if(getTable().getColums().get(i).getType().equalsIgnoreCase("point")) {
				clausulaSet += getTable().getColums().get(i).getName()+" = point (?,?)";
			}else {
				clausulaSet += getTable().getColums().get(i).getName()+" =  ?";
			}
			
			
			
					if((i+1)<getTable().getColums().size()) {
						clausulaSet+=",";
					}
		}	
		return clausulaSet;
	}
	private String getValoresClausulaWhere(ArrayList<Colum> colums) {
		// TODO Auto-generated method stub
                if(!(colums.size()>0)){
                    return "";
                }
		String clausulaSet = " WHERE ";
		for(int i=0;i<colums.size();i++) {
			
			clausulaSet += colums.get(i).getName()+" =  ? ";
					if((i+1)<colums.size()) {
						clausulaSet+=" AND ";
					}
		}	
		return clausulaSet;
	}

	private String getValoresClausulaWhereFlitros(ArrayList<Filtro> Filtros) {
		// TODO Auto-generated method stub
                if(!(Filtros.size()>0)){
                    return "";
                }
		String clausulaSet = " WHERE ";
		for(int i=0;i<Filtros.size();i++) {
			
			clausulaSet += Filtros.get(i).getCol().getName()+Filtros.get(i).getComparador().op +"  ? ";
					if((i+1)<Filtros.size()) {
						clausulaSet+=" AND ";
					}
		}	
		return clausulaSet;
	}

	
	
	public List<T> listarTodosWhere(ArrayList<Colum> colums ,ArrayList<Object> values) throws SQLException{
		String sql = "SELECT * FROM " + getNomeTabela()+getValoresClausulaWhere(colums)+";";
		System.out.println(sql);


		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		ArrayList<T> listaEntidades = new ArrayList<T>();
		
		try{
			this.setValoresAtributosWhere(colums, values, stmt);
			resultado = stmt.executeQuery();
			while(resultado.next()){
				i=1;
				T objetoConsultado = construirObjetoDoResultSet(resultado);
				listaEntidades.add(objetoConsultado);
			}
		} catch (SQLException e){

			e.printStackTrace();

		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaEntidades;
	}
	public List<T> listarTodosWhereFiltros(ArrayList<Filtro> Filtros) throws SQLException{
		String sql = "SELECT * FROM " + getNomeTabela()+getValoresClausulaWhereFlitros(Filtros)+";";
		System.out.println(sql);


		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		ArrayList<T> listaEntidades = new ArrayList<T>();
		
		try{
			this.setValoresAtributosWhereFiltros( Filtros, stmt);
			resultado = stmt.executeQuery();
			while(resultado.next()){
				i=1;
				T objetoConsultado = construirObjetoDoResultSet(resultado);
				listaEntidades.add(objetoConsultado);
			}
		} catch (SQLException e){

			e.printStackTrace();

		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaEntidades;
	}

	private void setValoresAtributosWhere(ArrayList<Colum> columns ,ArrayList<Object> values,PreparedStatement stmt) throws SQLException{
		for(int i =0;i<values.size();i++) {
			
			switch (columns.get(i).getType()) {
			case "String":
			case "string":
				stmt.setString(i+1, values.get(i).toString());
				break;
			case "int":
			case "Int":
			case "Integer":
			case "integer":
				stmt.setInt(i+1,(Integer) values.get(i));
				break;
			
			case "BigDecimal":
				stmt.setBigDecimal(i+1,(BigDecimal) values.get(i));
				break;
				
			case "Boolean":
			case "boolean":
				stmt.setBoolean(i+1,(Boolean) values.get(i));
				break;
				
			case "Date":
				stmt.setDate(i+1,(Date) values.get(i));
				break;
				
			case "Double":
			case "double":
				stmt.setDouble(i+1,(Double) values.get(i));
				break;
				
			case "Float":
			case "float":
				stmt.setFloat(i+1,(Float) values.get(i));
				break;
			
			case "Long":
			case "long":
				stmt.setLong(i+1,(Long) values.get(i));
				break;
			
			case "Null":
			case "null":
				stmt.setNull(i+1,(Integer) values.get(i));
				break;
				
			case "Short":
			case "short":
				stmt.setShort(i+1,(Short) values.get(i));
				break;
				
			case "Time":
				stmt.setTime(i+1,(Time) values.get(i));
				break;
				
			case "Timestamp":
				stmt.setTimestamp(i+1,(Timestamp) values.get(i));
				break;
				
			case "URL":
				stmt.setURL(i+1,(URL) values.get(i));
				break;
			
				
				
			default:
				System.out.println("Erro ao identificar tipo :"+columns.get(i).getType()+" de:"+ columns.get(i).getName()+" valor:"+values.get(i).toString());
				break;
			}
			
		}
				

	}
	private void setValoresAtributosWhereFiltros(ArrayList<Filtro> Filtros,PreparedStatement stmt) throws SQLException{
		for(int i =0;i<Filtros.size();i++) {
			
			switch (Filtros.get(i).getCol().getType()) {
			case "String":
			case "string":
				stmt.setString(i+1, Filtros.get(i).getValue().toString());
				break;
			case "int":
			case "Int":
			case "Integer":
			case "integer":
				stmt.setInt(i+1,(Integer) Filtros.get(i).getValue());
				break;
			
			case "BigDecimal":
				stmt.setBigDecimal(i+1,(BigDecimal) Filtros.get(i).getValue());
				break;
				
			case "Boolean":
			case "boolean":
				stmt.setBoolean(i+1,(Boolean) Filtros.get(i).getValue());
				break;
				
			case "Date":
				stmt.setDate(i+1,(Date) Filtros.get(i).getValue());
				break;
				
			case "Double":
			case "double":
				stmt.setDouble(i+1,(Double) Filtros.get(i).getValue());
				break;
				
			case "Float":
			case "float":
				stmt.setFloat(i+1,(Float) Filtros.get(i).getValue());
				break;
			
			case "Long":
			case "long":
				stmt.setLong(i+1,(Long) Filtros.get(i).getValue());
				break;
			
			case "Null":
			case "null":
				stmt.setNull(i+1,(Integer) Filtros.get(i).getValue());
				break;
				
			case "Short":
			case "short":
				stmt.setShort(i+1,(Short) Filtros.get(i).getValue());
				break;
				
			case "Time":
				stmt.setTime(i+1,(Time) Filtros.get(i).getValue());
				break;
				
			case "Timestamp":
				stmt.setTimestamp(i+1,(Timestamp) Filtros.get(i).getValue());
				break;
				
			case "URL":
				stmt.setURL(i+1,(URL) Filtros.get(i).getValue());
				break;
			
				
				
			default:
				System.out.println("Erro ao identificar tipo :"+Filtros.get(i).getCol().getType()+" de:"+ Filtros.get(i).getCol().getName()+" valor:"+Filtros.get(i).getValue().toString());
				break;
			}
			
		}
				

	}
						

}
