package model.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.conector.Afeta;

public abstract class BaseDAO_TablesJoin<T,J,L> extends BaseDAO_Tables<T>{
	protected  Table tableJoin;
	protected  Table tableList;
	private boolean getConector;
	private boolean getLister;
	public Table getTableJoin() {
		return tableJoin;
	}
	public void setTableJoin(Table tableJoin) {
		this.tableJoin = tableJoin;
	}
	public Table getTableList() {
		return tableList;
	}
	public void setTableList(Table tableList) {
		this.tableList = tableList;
	}
	@Override
	protected void setValoresAtributosInsert(T entidade, PreparedStatement stmt) throws SQLException {		
	}
	@Override
	protected void setValoresAtributosUpdate(T entidade, PreparedStatement stmt) throws SQLException {		
	}
	@Override
	protected abstract T construirObjetoDoResultSet(ResultSet resultado) throws SQLException;
	protected abstract J construirObjetoDoResultSetJoin(ResultSet resultado) throws SQLException;
	protected abstract L construirObjetoDoResultSetList(ResultSet resultado) throws SQLException;
	
	protected String getNomeColunaChavePrimaria() {
		return getTable().getName()+"."+getTable().getColums().get(0).getName();
	}



	private String getColunasSelect() {
		String clausulaSet = "";
		Integer count=0;
		String asColum ="colum";
		
		clausulaSet +=getNomeColunaChavePrimaria();
		clausulaSet+=" , ";

		if(getConector==true) {
			for(int i=0;i<getTableJoin().getColums().size();i++) {

				if(getTableJoin().getColums().get(i).getType().equalsIgnoreCase("point")) {
					clausulaSet += getTableJoin().getName()+"."+getTableJoin().getColums().get(i).getName()+" as "+asColum+(count++);
				}else {
					clausulaSet += getTableJoin().getName()+"."+getTableJoin().getColums().get(i).getName()+" as "+asColum+(count++);
				}



				if((i+1)<getTableJoin().getColums().size()) {
					clausulaSet+=" , ";
				}
			}	
		}
		if(getLister==true) {
			for(int i=0;i<getTableList().getColums().size();i++) {

				if(getTableList().getColums().get(i).getType().equalsIgnoreCase("point")) {
					clausulaSet += getTableList().getName()+"."+getTableList().getColums().get(i).getName()+" as "+asColum+(count++);
				}else {
					clausulaSet += getTableList().getName()+"."+getTableList().getColums().get(i).getName()+" as "+asColum+(count++);
				}



				if((i+1)<getTableList().getColums().size()) {
					clausulaSet+=" , ";
				}
			}	
		}
		return clausulaSet;
	}

	private String getJoinString() {
		String clausulaSet = "";
		clausulaSet +=table.getName();
		clausulaSet +=" inner join ";
		clausulaSet +=tableJoin.getName();
		clausulaSet +=" on ";
		clausulaSet +=table.getName()+"."+table.colums.get(0);
		clausulaSet +=" = ";
		clausulaSet +=tableJoin.getName()+"."+table.colums.get(0);
		clausulaSet +=" inner join ";
		clausulaSet +=tableList.getName();
		clausulaSet +=" on ";
		clausulaSet +=tableList.getName()+"."+tableList.colums.get(0);
		clausulaSet +=" = ";
		clausulaSet +=tableJoin.getName()+"."+tableList.colums.get(0);
		
		return clausulaSet;
	}
	
	public JoinAgregator<T,J,L> pesquisarJoinPorId(int idEntidade){
		//SQL: SELECT * FROM NOMETABELA WHERE WHERE ID = idEntidade
		String sql = "SELECT "+ getColunasSelect() +" FROM "+ getJoinString()+" WHERE " + getNomeColunaChavePrimaria() + " = " + idEntidade;

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		JoinAgregator<T,J,L> joinAgregator = new JoinAgregator<T,J,L>();
		T objetoConsultado =  pesquisarPorId( idEntidade);
		ArrayList<J> listaJoin = new ArrayList<J>();
		ArrayList<L> listaList = new ArrayList<L>();


		try{
			resultado = stmt.executeQuery(sql);
			while(resultado.next()){
				i=1;
				i++;
				
				J objetoConsultadoJoin = construirObjetoDoResultSetJoin(resultado);
				listaJoin.add(objetoConsultadoJoin);
				L objetoConsultadoList = construirObjetoDoResultSetList(resultado);
				listaList.add(objetoConsultadoList);

			}
			joinAgregator.setT(objetoConsultado);
			joinAgregator.setJoinList(listaJoin);
			joinAgregator.setListList(listaList);
		} catch (SQLException e){
			System.out.println("Erro ao consultar o registro com id = " + idEntidade + "da entidade " + this.getClass().toString());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return joinAgregator;
	}
	
	public List<T> listarTodos() {
		String sql = "SELECT * FROM " + getNomeTabela();

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		ArrayList<T> listaEntidades = new ArrayList<T>();

		try{
			resultado = stmt.executeQuery(sql);
			while(resultado.next()){
				T objetoConsultado = construirObjetoDoResultSet(resultado);
				listaEntidades.add(objetoConsultado);
			}
		} catch (SQLException e){
			System.out.println("Erro ao consultar todos os objetos da entidade " + this.getClass().toString());
			System.out.println(e.getMessage());
			
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaEntidades;
	}
	
	
	

	

}
 