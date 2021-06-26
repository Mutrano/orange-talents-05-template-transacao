package br.com.zupacademy.mario.transacoes;
/*   "estabelecimento":{
      "nome":"B. A. Ware",
      "cidade":"North Winstonbury",
      "endereco":"18327 Mills Groves, West Marquita, SD 31244"
   },*/
public class EstabelecimentoMensagem {
	private String nome;
	private String cidade;
	private String endereco;
	
	@Deprecated
	public EstabelecimentoMensagem() {
		
	}
	
	public EstabelecimentoMensagem(String nome, String cidade, String endereco) {
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public Estabelecimento paraEstabelecimento() {
		return new Estabelecimento(nome, cidade, endereco);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
