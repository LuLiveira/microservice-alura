package br.com.alura.microservice.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.alura.microservice.loja.controller.dto.InformacaoEntregaDTO;
import br.com.alura.microservice.loja.controller.dto.VoucherDTO;

@FeignClient(name = "transportador")
public interface TransportadorClient {

	@PostMapping("/entrega")
	public VoucherDTO reservaEntrega(@RequestBody InformacaoEntregaDTO informacaoEntregaDTO);
}
