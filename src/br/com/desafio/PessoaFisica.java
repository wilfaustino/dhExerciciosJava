package br.com.desafio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PessoaFisica extends Funcionario {
	
	private String cpf;
	private String nit;

	public PessoaFisica(
			String nome,
			String cpf,
			String nit,
			Endereco endereco,
			String email,
			SetorEnum setor,
			float salariobase,
			LocalDate dataAdmissao,
			LocalDate dataDemissao
	) {
		super(nome, endereco, email, setor, salariobase, dataAdmissao, dataDemissao);
		this.cpf = cpf;
		this.nit = nit;
	}
	
	@Override
	public void imprimeCredenciais(){
		System.out.println("==== Credenciais Pessoa Física ====");
		System.out.println("Nome: " + this.getNome());
		System.out.print("Endereço: ");
		System.out.print("Rua " + this.endereco.getRua());
		System.out.print(" nº" + this.endereco.getNumero());
		System.out.print(", CEP: " + this.endereco.getCep());
		System.out.print(" - " + this.endereco.getPais());
		System.out.println("Setor: " + this.getSetor().getNameCargo());
		System.out.println("Cargo: " + this.getSetor().getNameCargo());
		System.out.println("CPF: " + this.cpf);
		System.out.println("NIT: " + this.nit);
		System.out.println("Data de admissão: " + this.getDataAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
		System.out.println("==== FIM ====");
	}
	
}