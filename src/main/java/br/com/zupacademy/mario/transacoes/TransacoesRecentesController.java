package br.com.zupacademy.mario.transacoes;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TransacoesRecentesController {

	private TransacaoRepository repository;

	public TransacoesRecentesController(TransacaoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/Transacoes/{uuid}")
	public ResponseEntity<Page<TransacaoMensagem>> transacoesRecentes(@PathVariable UUID uuid,
			@RequestParam(value="page" ,defaultValue = "0") Integer page ){
		var cartaoEncontrado = repository.findByCartaoUuid(uuid);
		if(cartaoEncontrado.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"O cartão informado não foi encontrado");
		}
		var pageRequest = PageRequest.of(page, 10, Direction.DESC,"efetivadaem");
		
		var transactionPage =repository.findByCartaoUuid(uuid,pageRequest);
		
		var transactionMessage= transactionPage.map(
				transacao -> TransacaoMensagem.paraMensagem(transacao));
		
		return ResponseEntity.ok().body(transactionMessage);
	}
	
}
