package model.dao.join;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.AfetaDAO;
import model.dao.CulturaDAO;
import model.dao.DoencaDAO;
import model.dao.base.BaseDAO_TablesJoin;
import model.vo.conector.Afeta;
import model.vo.conector.Cultura;
import model.vo.conector.Doenca;

public class CulturaAfetaDoencaJoin extends BaseDAO_TablesJoin<Cultura,Afeta,Doenca> {

	@Override
	protected Cultura construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
		return new CulturaDAO().construirObjetoDoResultSet(resultado);
	}

	@Override
	protected Afeta construirObjetoDoResultSetJoin(ResultSet resultado) throws SQLException {
		return new AfetaDAO().construirObjetoDoResultSet(resultado);
	}

	@Override
	protected Doenca construirObjetoDoResultSetList(ResultSet resultado) throws SQLException {
		return new DoencaDAO().construirObjetoDoResultSet(resultado);
	}
}
