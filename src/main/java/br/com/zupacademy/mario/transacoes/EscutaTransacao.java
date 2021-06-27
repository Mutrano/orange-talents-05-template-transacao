package br.com.zupacademy.mario.transacoes;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EscutaTransacao {

	private TransacaoRepository repository;
	private EntityManager em;

	public EscutaTransacao(TransacaoRepository repository, EntityManager em) {
		this.repository = repository;
		this.em = em;
	}

	private final Logger logger = org.slf4j.LoggerFactory.getLogger(EscutaTransacao.class);

	@Transactional
	@KafkaListener(topics = "${transacao.topico}")
	public void consome(TransacaoMensagem mensagem) {
		var cartaoEncontrado = repository.findByCartaoUuid(mensagem.getCartao().getId());
		var estabelecimentoEncontrado = repository.findByEstabelecimentoNome(mensagem.getEstabelecimento().getNome());
		var transacao = mensagem.paraTransacao();

		if (cartaoEncontrado.isEmpty()) {
			logger.info("cartao nao existia");
			var cartaoSalvo = mensagem.getCartao().paraCartao();
			em.persist(cartaoSalvo);
			transacao.setCartao(cartaoSalvo);

		} else {
			logger.info("cartao ja existia");
			transacao.setCartao(cartaoEncontrado.get(0).getCartao());
		}
		if (estabelecimentoEncontrado.isEmpty()) {
			logger.info("estabelecimento nao existia");
			var estabelecimentoSalvo = mensagem.getEstabelecimento().paraEstabelecimento();
			em.persist(estabelecimentoSalvo);
			transacao.setEstabelecimento(estabelecimentoSalvo);
		} else {
			logger.info("estabelecimento ja existia");
			transacao.setEstabelecimento(estabelecimentoEncontrado.get(0).getEstabelecimento());
		}

		logger.info("salvando essa mensagem: " + mensagem);
		em.persist(transacao);
		logger.info("mensagem foi salva");

	}

}
