/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import java.util.List;

import ca.odell.glazedlists.TextFilterable;

/**
 *
 * @author vin3
 */
public class Produto implements TextFilterable {
	private Integer idProduto;
	private String nome; 
	private String descricao;


	public void getFilterStrings(List baseList) {
		baseList.add(nome);
		baseList.add(descricao);
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
