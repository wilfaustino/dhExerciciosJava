package br.com.desafio;

public class Endereco {
	
	private String rua;
	private String numero;
	private String cep;
	private String bairro;
	private String pais;

	public Endereco(String rua, String numero, String cep, String bairro, String pais) {
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.pais = pais;
	}
	
	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getCep() {
		return cep;
	}

	public String getBairro() {
		return bairro;
	}

	public String getPais() {
		return pais;
	}	

}