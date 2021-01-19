package br.com.alura.microservice.fornecedor.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.fornecedor.dto.ItemDoPedidoDTO;
import br.com.alura.microservice.fornecedor.model.Pedido;
import br.com.alura.microservice.fornecedor.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	private final static Logger LOG = LoggerFactory.getLogger(PedidoController.class);

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public Pedido realizaPedido(@RequestBody List<ItemDoPedidoDTO> produtos, @RequestHeader MultiValueMap<String, String> headers) {
		headers.forEach((key, value) -> {
	        LOG.info(String.format(
	          "Header '%s' = %s", key, value.stream().collect(Collectors.joining("|"))));
	    });
		return pedidoService.realizaPedido(produtos);
	}
	
	@GetMapping("/{id}")
	public Pedido getPedidoPorId(@PathVariable Long id) {
		return pedidoService.getPedidoPorId(id);
	}
}
