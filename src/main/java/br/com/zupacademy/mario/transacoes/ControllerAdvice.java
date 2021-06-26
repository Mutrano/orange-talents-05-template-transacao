package br.com.zupacademy.mario.transacoes;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ControllerAdvice {

	
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<ErroPadrao> erroDeStatus(ResponseStatusException expn, HttpServletRequest request){
		var mensagem = expn.getReason();
		var status= expn.getStatus().value();
		var caminho = request.getRequestURI();
		var erro =  expn.getStatus().getReasonPhrase();
		
		var err = new ErroPadrao(mensagem, status, caminho, erro);
		
		return ResponseEntity.status(status).body(err);
	}
	
}
