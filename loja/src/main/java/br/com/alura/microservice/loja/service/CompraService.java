package br.com.alura.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.client.TransportadorClient;
import br.com.alura.microservice.loja.controller.dto.CompraRequest;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorRequest;
import br.com.alura.microservice.loja.controller.dto.InfoPedidoRequest;
import br.com.alura.microservice.loja.controller.dto.InformacaoEntregaDTO;
import br.com.alura.microservice.loja.controller.dto.VoucherDTO;
import br.com.alura.microservice.loja.domain.NovaCompra;
import br.com.alura.microservice.loja.model.Compra;
import br.com.alura.microservice.loja.model.enums.CompraState;
import br.com.alura.microservice.loja.repository.CompraRepository;
import br.com.alura.microservice.loja.service.exception.PedidoNaoEncontradoException;

@Service
public class CompraService {
	final static Logger LOGGER = LoggerFactory.getLogger(CompraService.class);


	private FornecedorClient fornecedorClient;
	private CompraRepository compraRepository;
	private TransportadorClient transportadorClient;

	public CompraService(FornecedorClient fornecedorClient, TransportadorClient transportadorClient, CompraRepository compraRepository) {
		this.fornecedorClient = fornecedorClient;
		this.transportadorClient = transportadorClient;
		this.compraRepository = compraRepository;

	}

	@Transactional
	public CompraRequest realizarCompra(NovaCompra novaCompra) {

		InfoFornecedorRequest infoFornecedor = fornecedorClient.getInfoPorEstado(novaCompra.getEndereco().getEstado());
		
		Compra compra = new Compra();
		compra.setEndereco(novaCompra.getEndereco().toString());
		LOGGER.info("INSERT COMPRA");
		compra = compraRepository.save(compra);
		
		InfoPedidoRequest infoPedidoRequest = fornecedorClient.realizaPedido(novaCompra.getItens());
		LOGGER.info("ALTERANDO DADOS DA COMPRA");
		compra.setState(CompraState.PEDIDO_REALIZADO);
		compra.setPedidoId(infoPedidoRequest.getId());
		compra.setTempoDePreparo(infoPedidoRequest.getTempoDePreparo());

		VoucherDTO voucherDTO = transportadorClient.reservaEntrega(new InformacaoEntregaDTO( infoPedidoRequest, novaCompra, infoFornecedor ));
		LOGGER.info("ALTERANDO DADOS DA COMPRA 2");
		compra.setState(CompraState.RESERVA_ENTREGA_REALIZADA);
		compra.setDataParaEntrega(voucherDTO.getPrevisaoParaEntrega());
		compra.setVoucher(voucherDTO.getNumero());
		
		LOGGER.info("FIM");
		return compra.toModel();
	}

	public CompraRequest getCompraById(Long id) {
		return compraRepository.findById(id).orElseThrow(() -> new PedidoNaoEncontradoException("Pedido não encontrado")).toModel();
	}
}
