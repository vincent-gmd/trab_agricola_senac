package model.dao.base;

import java.util.ArrayList;
import model.dao.base.Colum;


public class Table {
	protected String name;
	protected ArrayList<Colum> colums = new ArrayList<Colum>(); 
	public Table() {
		super();
		
		
		
	}
	public ArrayList<String> getNames(){
		ArrayList<String> a =new ArrayList<String>();
		for(int i=0;i<colums.size();i++) {
			a.add(colums.get(i).getName());
		}
		
		return a;
	}
	public ArrayList<String> getTipes(){
		ArrayList<String> a =new ArrayList<String>();
		for(int i=0;i<colums.size();i++) {
			a.add(colums.get(i).getType());
		}
		
		return a;
	}
	public ArrayList<Colum> getColums(){
		return colums;
		
	}
	public String getName(){
		return name;
	}

}
