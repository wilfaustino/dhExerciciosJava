package br.com.desafio;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		PessoaFisica pf1 = new PessoaFisica(
			"Joana",
			"000.000.000-00",
			"123-000",
			new Endereco("Rua Ofélia", "5", "00000-000", "Pinheiros", "Brasil"),
			"email@email.com",
			SetorEnum.PRODUCAO,
			1000,
			LocalDate.of(2019, 11, 8),
			null
		);
		
		PessoaFisica pf2 = new PessoaFisica(
				"João",
				"000.000.000-00",
				"123-000",
				new Endereco("Rua Joaquim Antunes", "50", "00000-000", "Cerqueira César", "Brasil"),
				"email@email.com",
				SetorEnum.GERENCIA,
				2500,
				LocalDate.of(2020, 5, 30),
				null
			);
		
		PessoaJuridica pj1 = null;
		
		try {
			
			pj1 = new PessoaJuridica(
				"Ângela",
				"000.000.000.000/1000-00",
				new Endereco("Rua Pedro Álvares Cabral", "150", "00000-000", "Jardim Paulista", "Brasil"),
				"email@email.com",
				SetorEnum.GERENCIA,
				1000,
				LocalDate.of(2015, 1, 2),
				null
			);
			
		} catch (Exception e) {
			System.out.println("Erro ao instanciar Pessoa Jurídica: " + e.getMessage());
		}
		
		try {
			
			pj1 = new PessoaJuridica(
				"Ângela",
				"000.000.000.000/1000-00",
				new Endereco("Rua Pedro Álvares Cabral", "150", "00000-000", "Jardim Paulista", "Brasil"),
				"email@email.com",
				SetorEnum.SUPERVISOR,
				1000,
				LocalDate.of(2015, 1, 2),
				null
			);
			
		} catch (Exception e) {
			System.out.println("Erro ao instanciar Pessoa Jurídica: " + e.getMessage());
		}
		
		try {
			
			pj1 = new PessoaJuridica(
				"Ângela",
				"000.000.000.000/1000-00",
				new Endereco("Rua Pedro Álvares Cabral", "150", "00000-000", "Jardim Paulista", "Brasil"),
				"email@email.com",
				SetorEnum.PRODUCAO,
				1000,
				LocalDate.of(2015, 1, 2),
				null
			);
			
		} catch (Exception e) {
			System.out.println("Erro ao instanciar Pessoa Jurídica: " + e.getMessage());
		}
		
		
		pf1.imprimeCredenciais();
		pf2.imprimeCredenciais();
		
		pf1.demitirFuncionario(pf2);
		
		pf1.trabalhar();
		
		pj1.solicitarAumento(1500);
		pj1.solicitarAumento(1400);
		
		pj1.requisitarFerias();
		
		pj1.pedirDemissao();
		pj1.pedirDemissao();
		
		pj1.demitirFuncionario(pf1);
		
		pf1.solicitarAumento(1500);
	}

}
