package br.com.zupacademy.mario.transacoes;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Cartao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private UUID uuid;
	private String email;
	public Cartao() {}
	public Cartao(UUID uuid, String email) {

		this.uuid = uuid;
		this.email = email;
	}
	public UUID getUuid() {
		return uuid;
	}
	public String getEmail() {
		return email;
	}


}
