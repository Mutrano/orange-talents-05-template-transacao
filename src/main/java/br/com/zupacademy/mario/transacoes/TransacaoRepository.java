package br.com.zupacademy.mario.transacoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
	
	@Transactional
	public Transacao save(Transacao transacao);
}
