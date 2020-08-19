package br.com.desafio;

import java.util.Date;

public class Funcionario {
	
	private String nome;
	private Endereco endereco;
	private String email;
	private SetorEnum setor;
	private Date dataAdmissao;
	private Date dataDemissao;
	private Date dataUltimasFerias;
	private float salario;
	private boolean estaEmFerias = false;
	
	public Funcionario(
		String nome,
		Endereco endereco,
		String email,
		SetorEnum setor,
		float salariobase,
		Date dataAdmissao,
		Date dataDemissao
	) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.setor = setor;
		this.salario = salariobase;		
		this.dataAdmissao = dataAdmissao;
		this.dataDemissao = dataDemissao;
	}

	public void imprimeCredenciais() {
		System.out.println("Nome: " + nome);
		System.out.print("Endereço: ");
		System.out.print("Rua " + endereco.getRua());
		System.out.print(" nº" + endereco.getNumero());
		System.out.print(", CEP: " + endereco.getCep());
		System.out.print(" - " + endereco.getPais());
		System.out.println("Setor: " + setor.getNameCargo());
		System.out.println("Cargo: " + setor.getNameCargo());
		System.out.println("Data de admissão: " + dataAdmissao);
	}
	
	public boolean reajustarSalario(float novoValor) {
		if(novoValor <= this.salario) {
			return false;
		}
		
		this.salario = novoValor;
		
		return true;
	}
	
	public void consultarContraCheque() {
		System.out.println("==== Contra Cheque ====");
		System.out.println("Nome do funcionário: " + nome);
		System.out.println("Cargo: " + setor.getNameCargo());
		System.out.println("Salário atual: " + salario);
		System.out.println("==== FIM ====");
	}
	
	public void tirarFuncionarioDeFerias() {
		estaEmFerias = false;
	}
	
	public void pedirDemissao() {
		dataDemissao = new Date();
	}
	
}