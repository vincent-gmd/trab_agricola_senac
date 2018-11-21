package model.vo.front;

import java.util.List;

import ca.odell.glazedlists.TextFilterator;
import model.vo.conector.Doenca;

public class DoencaFilter implements TextFilterator< Doenca> {

	@Override
	public void getFilterStrings(List<String> baseList, Doenca element) {
		baseList.add(element.getNome());
		baseList.add(element.getCausador());
		baseList.add(element.getDescricao());
		
	}

}
