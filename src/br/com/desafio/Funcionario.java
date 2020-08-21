package br.com.desafio;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public abstract class Funcionario {
	
	private String nome;
	protected Endereco endereco;
	private String email;
	private SetorEnum setor;
	private LocalDate dataAdmissao;
	private LocalDate dataDemissao;
	private LocalDate dataUltimasFerias;
	private float salario;
	private float bonificacao;
	private boolean estaEmFerias;
	
	public Funcionario(
		String nome,
		Endereco endereco,
		String email,
		SetorEnum setor,
		float salariobase,
		LocalDate dataAdmissao,
		LocalDate dataDemissao
	) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.setor = setor;
		this.salario = salariobase; //N�o considerado bonifica��o no sal�rio base
		this.dataAdmissao = dataAdmissao;
		this.dataDemissao = dataDemissao;
		this.estaEmFerias = false;
		this.bonificacao = 1;
		
		if(this.setor==SetorEnum.GERENCIA) {
			this.bonificacao = 1.12f;
		} else if(this.setor==SetorEnum.SUPERVISOR) {
			this.bonificacao = 1.08f;
		}
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public LocalDate getDataAdmissao() {
		return this.dataAdmissao;
	}
	
	public SetorEnum getSetor() {
		return this.setor;
	}
	
	public abstract void imprimeCredenciais();
	
	public void consultarContraCheque(String tipoDocumento, String NumeroDocumento) {
		System.out.println("==== Contra Cheque ====");
		System.out.println("Nome do funcion�rio: " + nome);
		System.out.println("Cargo: " + setor.getNameCargo());
		System.out.println(tipoDocumento + ": " + NumeroDocumento);
		System.out.println("Sal�rio atual: " + salario);
		System.out.println("==== FIM ====");
	}
	
	public boolean requisitarFerias(){
		
		LocalDate today = LocalDate.now();
		Boolean autorizaFerias = false;
		
		//Avalia se foi contratado h� mais de 11 meses
		long mesesContratados = Period.between(this.dataAdmissao, today).toTotalMonths();
		
		//Avalia se a data das �ltimas f�rias � superior a 4 meses
		long mesesUltimasFerias = 0;
		
		if(this.dataUltimasFerias!=null)
			Period.between(this.dataUltimasFerias, today).toTotalMonths();
		
		System.out.println("==== F�rias ====");
		
		if(this.estaEmFerias) {
			System.out.println("Funcion�rio j� est� de f�rias");
		} else if(mesesContratados >= 11 && (this.dataUltimasFerias==null || mesesUltimasFerias >= 4)) {
			System.out.println("Funcion�rio pode sair de f�rias!");
			System.out.print("Funcion�rio foi contradado h� " + mesesContratados + " meses");
			if(this.dataUltimasFerias!=null)
				System.out.println(" e tirou f�rias h� " + mesesUltimasFerias + " meses!\"");
			else
				System.out.println();
			this.dataUltimasFerias = LocalDate.now();
			autorizaFerias = true;
		} else {
			System.out.println("F�rias negadas!");
			System.out.println("Meses trabalhados: " + mesesContratados);
			System.out.println("meses ultimas f�rias: " + mesesUltimasFerias);
		}
		
		System.out.println("==== FIM ====");
		
		return autorizaFerias;
	}
	
	public boolean demitirFuncionario(Funcionario demissor) {
		
		boolean autorizaDemissao = true;
		
		//Se j� est� demitido
		if(this.dataDemissao!=null) {
			System.out.println("Funcion�rio j� demitido!");
			autorizaDemissao = false;
			
		} else if(this.setor==SetorEnum.GERENCIA){
			System.out.println("Gerentes n�o podem ser demitidos!");
			autorizaDemissao = false;
		
		//Se n�o for do setor de produ��o, n�o pode haver demiss�es no mesmo setor ou se a pr�pria pessoa est� tentando se demitir
		} else if(this.setor!=SetorEnum.PRODUCAO && this.setor == demissor.setor || this.equals(demissor)) {
			System.out.println("Esta demiss�o n�o pode ocorrer!");
			autorizaDemissao = false;
			
		} else {
			System.out.println("O funcion�rio " + this.nome + " foi demitido!");
		}
		
		return autorizaDemissao;
	}
	
	public boolean reajustarSalario(Funcionario superiorRealizaReajuste, float novoValor){
		
		boolean autorizaReajuste = true;
		
		System.out.println("==== Reajuste de sal�rio ====");
		
		if(superiorRealizaReajuste.setor!=SetorEnum.GERENCIA || novoValor <= this.salario) {
			System.out.println("Reajuste n�o autorizado!");
			autorizaReajuste = false;
		} else {
			System.out.println("Reajuste realizado de " + this.salario + " para " + novoValor + "!");
			this.salario = novoValor * this.bonificacao;
		}
		
		return autorizaReajuste;
	}
	
	public boolean trabalhar() {
		
		boolean funcionarioPodeTrabalhar = true;
		
		if(this.estaEmFerias) {
			System.out.println("Funcion�rio n�o pode trabalhar pois est� em f�rias!");
			funcionarioPodeTrabalhar = false;
			
		} else if(this.dataDemissao!=null) {
			System.out.println("Funcion�rio n�o pode trabalhar pois foi demitido!");
			funcionarioPodeTrabalhar = false;
			
		} else {
			System.out.println("Trabalho conclu�do pelo funcion�rio " + this.nome + "!");
		}
		
		return funcionarioPodeTrabalhar;
	}
	
	public boolean solicitarAumento(float novoValor) {
		
		Random rand = new Random();
		
		boolean aceitaAumento = rand.nextBoolean();
		
		if(novoValor <= this.salario) {
			System.out.println("Novo valor tem que ser maior!");
			aceitaAumento = false;
		} else if(aceitaAumento) {
			System.out.println("Reajuste aceito! Aumento de " + this.salario + " para " + novoValor + "!");
			this.salario = novoValor * this.bonificacao;
		} else {
			System.out.println("Reajuste negado!");
		}
			
		return aceitaAumento;
	}
	
	public void tirarFuncionarioDeFerias() {
		estaEmFerias = false;
	}
	
	public boolean pedirDemissao() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		
		boolean autorizaDemissao = true;
		
		if(this.dataDemissao==null) {
			this.dataDemissao = LocalDate.now();
			System.out.println("Funcion�rio foi demitido hoje " + this.dataDemissao.format(dtf) + "!");
		} else {
			System.out.println("Funcion�rio j� tinha sido demitido em " + this.dataDemissao.format(dtf) + "!");
			autorizaDemissao = false;
		}
		
		return autorizaDemissao;
	}
	
}