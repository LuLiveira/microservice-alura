package br.com.alura.microservice.loja.controller.dto;

import java.util.List;

import br.com.alura.microservice.loja.domain.NovaCompra;

public class NovaCompraRequest {

	private List<ItemCompraRequest> itens;
	private EnderecoRequest endereco;

	public List<ItemCompraRequest> getItens() {
		return itens;
	}

	public void setItens(List<ItemCompraRequest> itens) {
		this.itens = itens;
	}

	public EnderecoRequest getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoRequest endereco) {
		this.endereco = endereco;
	}
	
	public NovaCompra toModel() {
		return new NovaCompra(this.itens, this.endereco);
	}

}
