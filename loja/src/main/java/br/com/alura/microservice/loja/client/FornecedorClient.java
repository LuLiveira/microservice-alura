package br.com.alura.microservice.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.alura.microservice.loja.controller.dto.InfoFornecedorRequest;
import br.com.alura.microservice.loja.controller.dto.InfoPedidoRequest;
import br.com.alura.microservice.loja.controller.dto.ItemCompraRequest;

@FeignClient(name = "fornecedor")
public interface FornecedorClient {

	@GetMapping("/infos/{estado}")
	InfoFornecedorRequest getInfoPorEstado(@PathVariable String estado);

	@PostMapping("/pedidos")
	InfoPedidoRequest realizaPedido(@RequestBody List<ItemCompraRequest> itens);
}
