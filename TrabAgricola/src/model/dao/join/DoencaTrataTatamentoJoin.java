package model.dao.join;



     
import model.dao.TrataDAO;
import model.dao.TratamentoDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.DoencaDAO;
import model.dao.base.BaseDAO_TablesJoin;
import model.vo.conector.Trata;
import model.vo.conector.Tratamento;
import model.vo.conector.Doenca;

public class DoencaTrataTatamentoJoin extends BaseDAO_TablesJoin<Doenca,Trata,Tratamento> {

	@Override
	protected Doenca construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
		return new DoencaDAO().construirObjetoDoResultSet(resultado);
	}

	@Override
	protected Trata construirObjetoDoResultSetJoin(ResultSet resultado) throws SQLException {
		return new TrataDAO().construirObjetoDoResultSet(resultado);
	}

	@Override
	protected Tratamento construirObjetoDoResultSetList(ResultSet resultado) throws SQLException {
		return new TratamentoDAO().construirObjetoDoResultSet(resultado);
	}


}
