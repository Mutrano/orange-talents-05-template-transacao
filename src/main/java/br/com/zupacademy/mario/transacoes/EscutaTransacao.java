package br.com.zupacademy.mario.transacoes;

import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EscutaTransacao {
	
	private TransacaoRepository repository;

	public EscutaTransacao(TransacaoRepository repository) {
		this.repository = repository;
	}
	private final Logger logger = org.slf4j.LoggerFactory.getLogger(EscutaTransacao.class);

	@KafkaListener(topics = "${transacao.topico}")
	public void consome(TransacaoMensagem mensagem) {
		var transacao = mensagem.paraTransacao();
		logger.info("salvando essa mensagem: "+mensagem);
		repository.save(transacao);
		logger.info("mensagem foi salva");
	}
	
	
}
