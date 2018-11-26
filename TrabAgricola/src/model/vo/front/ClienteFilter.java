package model.vo.front;

import java.util.List;

import ca.odell.glazedlists.TextFilterator;
import model.vo.conector.Cliente;

public class ClienteFilter implements TextFilterator<Cliente> {

	@Override
	public void getFilterStrings(List<String> baseList, Cliente element) {
		baseList.add(element.getLogin());
		baseList.add(element.getEmail());
		
	}


}
