package br.com.zupacademy.mario.transacoes;

import java.util.UUID;

/*
 * 
 *    "cartao":{
      "id":"b0012b90-42c8-40e6-903b-64acb3aa649b",
      "email":"luram.archanjo@zup.com.br"
   },
 * */
public class CartaoMensagem {
	private UUID id;
	private String email;

	@Deprecated
	public CartaoMensagem() {
	}
	
	public CartaoMensagem(UUID id, String email) {
		this.id = id;
		this.email = email;
	}

	public Cartao paraCartao() {

		return new Cartao(id, email);
	}
	public  static CartaoMensagem paraMensagem(Cartao cartao) {
		return new CartaoMensagem(cartao.getUuid(), cartao.getEmail());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
