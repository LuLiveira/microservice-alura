package br.com.alura.microservice.loja.controller.dto;

import java.time.LocalDate;

import br.com.alura.microservice.loja.domain.NovaCompra;

public class InformacaoEntregaDTO {

	private Long pedidoId;
	private LocalDate dataParaEntrega;
	private String enderecoOrigem;
	private String enderecoDestino;

	public InformacaoEntregaDTO(InfoPedidoRequest infoPedidoRequest, NovaCompra novaCompra, InfoFornecedorRequest infoFornecedor) {
		this.pedidoId = infoPedidoRequest.getId();
		this.dataParaEntrega = LocalDate.now().plusDays(infoPedidoRequest.getTempoDePreparo());
		this.enderecoDestino = novaCompra.getEndereco().toString();
		this.enderecoOrigem = infoFornecedor.getEndereco();
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public LocalDate getDataParaEntrega() {
		return dataParaEntrega;
	}

	public void setDataParaEntrega(LocalDate dataParaEntrega) {
		this.dataParaEntrega = dataParaEntrega;
	}

	public String getEnderecoOrigem() {
		return enderecoOrigem;
	}

	public void setEnderecoOrigem(String enderecoOrigem) {
		this.enderecoOrigem = enderecoOrigem;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

}
