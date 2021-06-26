package br.com.zupacademy.mario.transacoes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal valor;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Estabelecimento estabelecimento;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Cartao cartao;

	private LocalDateTime efetivadaem;
	private UUID uuid;

	public Transacao() {
	}

	public Transacao(BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaem,
			UUID uuid) {
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaem = efetivadaem;
		this.uuid = uuid;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaem() {
		return efetivadaem;
	}

	public UUID getUuid() {
		return uuid;
	}
	
	
	

}
