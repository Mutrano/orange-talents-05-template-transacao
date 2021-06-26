package br.com.zupacademy.mario.transacoes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/*
 *id":"c63fd0e0-eccb-4af3-9d49-39cde0ffdaf1",
   "valor":1.4874248222626738,
   "estabelecimento":{
      "nome":"B. A. Ware",
      "cidade":"North Winstonbury",
      "endereco":"18327 Mills Groves, West Marquita, SD 31244"
   },
   "cartao":{
      "id":"b0012b90-42c8-40e6-903b-64acb3aa649b",
      "email":"luram.archanjo@zup.com.br"
   },
   "efetivadaEm":"2020-08-10T13:16:56"
}
 * */
public class TransacaoMensagem {
	private UUID id;
	private BigDecimal valor;
	private EstabelecimentoMensagem estabelecimento;
	private CartaoMensagem cartao;
	private LocalDateTime efetivadaEm;
	
	@Deprecated
	public TransacaoMensagem() {
	}
	
	public TransacaoMensagem(UUID id, BigDecimal valor, EstabelecimentoMensagem estabelecimento, CartaoMensagem cartao,
			LocalDateTime efetivadaem) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaem;
	}
	
	public Transacao paraTransacao() {
		
		var paraEstabelecimento = estabelecimento.paraEstabelecimento();
		var paraCartao = cartao.paraCartao();
		System.out.println(valor+" "+paraCartao+" "+paraEstabelecimento+" "+efetivadaEm+id);
		return new Transacao( valor, paraEstabelecimento, paraCartao, efetivadaEm, id);
	}

	@Override
	public String toString() {
		return "TransacaoMensagem [id=" + id + ", valor=" + valor + ", estabelecimento=" + estabelecimento + ", cartao="
				+ cartao + ", efetivadaEm=" + efetivadaEm + "]";
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public EstabelecimentoMensagem getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(EstabelecimentoMensagem estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public CartaoMensagem getCartao() {
		return cartao;
	}

	public void setCartao(CartaoMensagem cartao) {
		this.cartao = cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public void setEfetivadaEm(LocalDateTime efetivadaEm) {
		this.efetivadaEm = efetivadaEm;
	}
	
	
}
