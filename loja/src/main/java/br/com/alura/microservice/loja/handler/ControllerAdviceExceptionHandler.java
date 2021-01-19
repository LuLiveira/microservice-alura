package br.com.alura.microservice.loja.handler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import br.com.alura.microservice.loja.handler.utils.Erro;
import br.com.alura.microservice.loja.service.exception.PedidoNaoEncontradoException;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleHttpClientErrorException(HttpClientErrorException e){
		return ResponseEntity.status(NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(PedidoNaoEncontradoException.class)
	public ResponseEntity<Erro> handlePedidoNaoEncontradoException(HttpServletRequest request,PedidoNaoEncontradoException e){
		return ResponseEntity.status(NOT_FOUND).body(new Erro(e.getMessage(), request.getServletPath()));
		
	}
}
