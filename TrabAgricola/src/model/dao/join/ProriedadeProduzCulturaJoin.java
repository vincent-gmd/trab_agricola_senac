package model.dao.join;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.CulturaDAO;
import model.dao.CultivoDAO;
import model.dao.PropriedadeDAO;
import model.dao.base.BaseDAO_TablesJoin;
import model.vo.conector.Cultura;
import model.vo.conector.Cultivo;
import model.vo.conector.Propriedade;

public class ProriedadeProduzCulturaJoin extends BaseDAO_TablesJoin<Propriedade,Cultivo,Cultura>{

	@Override
	protected Propriedade construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
		return new PropriedadeDAO().construirObjetoDoResultSet(resultado);
	}

	@Override
	protected Cultivo construirObjetoDoResultSetJoin(ResultSet resultado) throws SQLException {
		return new CultivoDAO().construirObjetoDoResultSet(resultado);

	}

	@Override
	protected Cultura construirObjetoDoResultSetList(ResultSet resultado) throws SQLException {
		return new CulturaDAO().construirObjetoDoResultSet(resultado);
	}

}
