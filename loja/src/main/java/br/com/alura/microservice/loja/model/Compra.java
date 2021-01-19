package br.com.alura.microservice.loja.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.alura.microservice.loja.controller.dto.CompraRequest;
import br.com.alura.microservice.loja.model.enums.CompraState;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long pedidoId;
	
	@Column(name = "tempo_preparo")
	@Positive
	private Integer tempoDePreparo;
	
	private String endereco;
	
	private LocalDate dataParaEntrega;
	
	private Long voucher;
	
	@Enumerated(EnumType.STRING)
	private CompraState state = CompraState.RECEBIDO;

	public Compra() {
	}

	public Compra(@NotNull @Positive @NotBlank Long pedidoId, @NotNull @Positive @NotBlank Integer tempoDePreparo, @NotNull @NotBlank String endereco, LocalDate dataParaEntrega, Long voucher) {
		this.pedidoId = pedidoId;
		this.tempoDePreparo = tempoDePreparo;
		this.dataParaEntrega = dataParaEntrega;
		this.voucher = voucher;
		this.endereco = endereco;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public LocalDate getDataParaEntrega() {
		return dataParaEntrega;
	}

	public void setDataParaEntrega(LocalDate dataParaEntrega) {
		this.dataParaEntrega = dataParaEntrega;
	}

	public Long getVoucher() {
		return voucher;
	}

	public void setVoucher(Long voucher) {
		this.voucher = voucher;
	}

	public CompraRequest toModel() {
		return new CompraRequest(this.pedidoId, this.endereco, this.tempoDePreparo, this.dataParaEntrega.toString(), this.voucher, this.state.toString());
	}

	public CompraState getState() {
		return state;
	}

	public void setState(CompraState state) {
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
