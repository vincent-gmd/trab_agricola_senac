package view;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import com.mysql.cj.result.LocalDateValueFactory;

import model.dao.PropriedadeDAO;
import model.vo.conector.Propriedade;

public class PontoTest {
	/*
	for(int i=0;i<getTableSource().getColums().size();i++) {
		
		if(getTableSource().getColums().get(i).getType().equalsIgnoreCase("point")) {
			clausulaSet += getTableSource().getColums().get(i).getName()+"";
		}else {
			clausulaSet += getTableSource().getColums().get(i).getName()+"";
		}
		
		
		
				if((i+1)<getTableSource().getColums().size()) {
					clausulaSet+=",";
				}
	}	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropriedadeDAO pdao =new PropriedadeDAO();
		Propriedade p = new Propriedade();
        p.setLocalizacaoX(10D);
        p.setLocalizacaoY(11D);

        p.setDocumento("documento");
        p.setData_cadastro(Instant.now());
        p.setEndereco("rua tal");
        p.setIdcliente(1);
        //pdao.inserir(p);
        List<Propriedade> l =pdao.listarTodos();
        
        for(int i=0;i<l.size();i++) {
        	System.out.println(l.get(i).getLocalizacaoX());
        	System.out.println(l.get(i).getLocalizacaoY());
        	System.out.println(l.get(i).getDocumento());
        	System.out.println(l.get(i).getData_cadastro());
        	System.out.println(l.get(i).getEndereco());
        	System.out.println(l.get(i).getIdcliente());
        	
        	System.out.println("--------------------------");
        }
	}

}
