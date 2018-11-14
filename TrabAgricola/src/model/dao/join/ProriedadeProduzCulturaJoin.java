package model.dao.join;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.CulturaDAO;
import model.dao.ProduzDAO;
import model.dao.PropriedadeDAO;
import model.dao.base.BaseDAO_TablesJoin;
import model.vo.conector.Cultura;
import model.vo.conector.Produz;
import model.vo.conector.Propriedade;

public class ProriedadeProduzCulturaJoin extends BaseDAO_TablesJoin<Propriedade,Produz,Cultura>{

	@Override
	protected Propriedade construirObjetoDoResultSet(ResultSet resultado) throws SQLException {
		return new PropriedadeDAO().construirObjetoDoResultSet(resultado);
	}

	@Override
	protected Produz construirObjetoDoResultSetJoin(ResultSet resultado) throws SQLException {
		return new ProduzDAO().construirObjetoDoResultSet(resultado);

	}

	@Override
	protected Cultura construirObjetoDoResultSetList(ResultSet resultado) throws SQLException {
		return new CulturaDAO().construirObjetoDoResultSet(resultado);
	}

}
