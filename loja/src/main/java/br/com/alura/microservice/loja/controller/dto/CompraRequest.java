package br.com.alura.microservice.loja.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CompraRequest {

	private Long pedidoId;
	private String endereco;
	private Integer tempoDePreparo;
	private String dataParaEntrega;
	private Long voucher;
	private String state;

	public CompraRequest(Long pedidoId, @NotNull @NotBlank String endereco, @Positive Integer tempoDePreparo, String dataParaEntrega, Long voucher, String state) {
		this.pedidoId = pedidoId;
		this.endereco = endereco;
		this.tempoDePreparo = tempoDePreparo;
		this.dataParaEntrega = dataParaEntrega;
		this.voucher = voucher;
		this.setState(state);
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

	public String getDataParaEntrega() {
		return dataParaEntrega;
	}

	public void setDataParaEntrega(String dataParaEntrega) {
		this.dataParaEntrega = dataParaEntrega;
	}

	public Long getVoucher() {
		return voucher;
	}

	public void setVoucher(Long voucher) {
		this.voucher = voucher;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

}
