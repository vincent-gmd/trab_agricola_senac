package controller;

import java.util.List;

import model.vo.conector.Cliente;
import model.vo.conector.Propriedade;

public class TelaClienteControler {
	private Cliente cliente =null;
	private Integer setSelectedIndexPropriedade=null;
	private List<Propriedade> propriedades=null;
	private Propriedade propridedadeSelecionada=null;
	private PropriedadeController propriedadeController= new PropriedadeController();
	public static final int LISTA_IS_NULL = -1;
	//public static final int LISTA_VAZIA = 0;
	//public static final int LISTA_NAO_VAZIA = 1;
	//public static final int MAX_SECONDS = 25;
 public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setPropriedadeIndex(Integer i){
		setSelectedIndexPropriedade=i;
		if(i!=null && propriedades!=null) {
			if(i>=0 && i<propriedades.size()) {
				setPropridedadeSelecionada(propriedades.get(i));
			}
		}else {
			setPropridedadeSelecionada(null);
		}
	}

	public Propriedade getPropridedadeSelecionada() {
		return propridedadeSelecionada;
	}

	public void setPropridedadeSelecionada(Propriedade propridedadeSelecionada) {
		this.propridedadeSelecionada = propridedadeSelecionada;
	}
	public void excluirPropridedadeSelecionada() {
		propriedadeController.excluir(propridedadeSelecionada.getIdPropriedade());
	}
	public int atualizarListaPropriedades() {
		propriedades=propriedadeController.listarPorClientId(getCliente().getIdCliente());
		if(propriedades==null) {
			return LISTA_IS_NULL;
		}
		return propriedades.size();
	}

	public List<Propriedade> getPropriedades() {
		return propriedades;
	}

	public void setPropriedades(List<Propriedade> propriedades) {
		this.propriedades = propriedades;
	}
	

}
