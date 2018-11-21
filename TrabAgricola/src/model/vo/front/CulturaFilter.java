package model.vo.front;

import java.util.List;

import ca.odell.glazedlists.TextFilterator;
import model.vo.conector.Cultura;

public class CulturaFilter implements TextFilterator<Cultura> {

	@Override
	public void getFilterStrings(List<String> baseList, Cultura element) {
		baseList.add(element.getTipo());
		baseList.add(element.getNome());
		baseList.add(element.getDescricao());
		
	}
}
