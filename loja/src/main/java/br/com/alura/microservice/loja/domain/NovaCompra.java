package br.com.alura.microservice.loja.domain;

import java.util.List;

import br.com.alura.microservice.loja.controller.dto.EnderecoRequest;
import br.com.alura.microservice.loja.controller.dto.ItemCompraRequest;

public class NovaCompra {

	private List<ItemCompraRequest> itens;
	private EnderecoRequest endereco;

	public NovaCompra() {}
	
	public NovaCompra(List<ItemCompraRequest> itens, EnderecoRequest endereco) {
		this.itens = itens;
		this.endereco = endereco;
	}

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

}
