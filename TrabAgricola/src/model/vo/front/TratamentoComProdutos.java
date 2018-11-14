package model.vo.front;

import java.util.List;

import model.vo.conector.Produto;
import model.vo.conector.Tratamento;

public class TratamentoComProdutos{
	private Tratamento tratamento;
	private List<Produto> produtos;
	public Tratamento getTratamento() {
		return tratamento;
	}
	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
