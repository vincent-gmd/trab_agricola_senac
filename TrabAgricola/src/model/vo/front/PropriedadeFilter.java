package model.vo.front;

import java.util.List;

import ca.odell.glazedlists.TextFilterator;
import model.vo.conector.Propriedade;

public class PropriedadeFilter implements TextFilterator<Propriedade>{

	@Override
	public void getFilterStrings(List<String> baseList, Propriedade element) {
		baseList.add(element.getDocumento());
		baseList.add(element.getEndereco());
		
	}

}
