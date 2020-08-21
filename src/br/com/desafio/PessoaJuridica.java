package br.com.desafio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PessoaJuridica extends Funcionario {
	
	private String cnpj;

	public PessoaJuridica(
			String nome,
			String cnpj,
			Endereco endereco,
			String email,
			SetorEnum setor,
			float salariobase,
			LocalDate dataAdmissao,
			LocalDate dataDemissao
	) throws Exception {
			
		super(nome, endereco, email, setor, salariobase, dataAdmissao, dataDemissao);
		
		if(setor!=SetorEnum.PRODUCAO) {
			throw new Exception("O cargo " + setor.getNameCargo() + " não pode ser Pessoa Jurídica!");
		}
		
		this.cnpj = cnpj;
	}
	
	@Override
	public void imprimeCredenciais(){
		System.out.println("==== Credenciais Pessoa Jurídica ====");
		System.out.println("Nome: " + this.getNome());
		System.out.print("Endereço: ");
		System.out.print("Rua " + this.endereco.getRua());
		System.out.print(" nº" + this.endereco.getNumero());
		System.out.print(", CEP: " + this.endereco.getCep());
		System.out.print(" - " + this.endereco.getPais());
		System.out.println("Setor: " + this.getSetor().getNameCargo());
		System.out.println("Cargo: " + this.getSetor().getNameCargo());
		System.out.println("CPNJ: " + this.cnpj);
		System.out.println("Data de admissão: " + this.getDataAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
		System.out.println("==== FIM ====");
	}
	
}