package br.com.alura.microservice.loja.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.loja.controller.dto.CompraRequest;
import br.com.alura.microservice.loja.controller.dto.NovaCompraRequest;
import br.com.alura.microservice.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	final static Logger LOGGER = LoggerFactory.getLogger(CompraController.class);
	
	private CompraService compraService;

	public CompraController(CompraService compraService) {
		this.compraService = compraService;
	}
	
	@GetMapping(value = "/{id}")
	public CompraRequest getCompraById(@PathVariable Long id) {
		LOGGER.info("Buscando informacões do pedido " + id);
		return compraService.getCompraById(id);
	}
	
	@PostMapping
	public CompraRequest comprar(@RequestBody NovaCompraRequest request) {
		LOGGER.info("Realizando compra");
		return compraService.realizarCompra(request.toModel());
	}
}
