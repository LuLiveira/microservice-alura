package br.com.alura.microservice.loja.service.exception;

public class PedidoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PedidoNaoEncontradoException(String s) {
		super(s);
	}
}
