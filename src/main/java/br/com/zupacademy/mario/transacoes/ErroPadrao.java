package br.com.zupacademy.mario.transacoes;

public class ErroPadrao {
	private String mensagem;
	private Integer status;
	private String caminho;
	private String erro;

	public ErroPadrao(String mensagem, Integer status, String caminho, String erro) {
		this.mensagem = mensagem;
		this.status = status;
		this.caminho = caminho;
		this.erro = erro;
	}
	

}