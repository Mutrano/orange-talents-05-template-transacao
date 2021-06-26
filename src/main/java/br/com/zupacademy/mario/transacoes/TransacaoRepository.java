package br.com.zupacademy.mario.transacoes;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
	
	@Transactional
	public Transacao save(Transacao transacao);
	
	@Transactional(readOnly = true)
	public List<Transacao> findByCartaoUuid(UUID uuid);
	
	@Transactional(readOnly= true)
	public Page<Transacao> findByCartaoUuid(UUID uuid, Pageable pageable);
}
