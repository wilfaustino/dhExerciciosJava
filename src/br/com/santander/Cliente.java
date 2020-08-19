package br.com.santander;

public class Cliente {

	private int idCliente;
	private String nome;
	private String sobrenome;
	private String rg;
	private String cpf;
	
	public Cliente(
		int idCliente,
		String nome,
		String sobrenome,
		String rg,
		String cpf
	) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.rg = rg;
		this.cpf = cpf;
	}
	
}
