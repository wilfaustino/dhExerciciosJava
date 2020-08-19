package br.com.santander;

public class ContaCorrente extends Conta {
	
	private float limiteCE;
	
	ContaCorrente(Cliente cliente, float limite) {
		super(cliente);
		this.limiteCE = limite;
	}

	@Override
	public boolean sacarDinheiro(float valor) {
		
		float valorTotal = this.saldo + this.limiteCE;
		
		if(Math.abs(valor)>valorTotal)
			return false;
		
		this.saldo -= Math.abs(valor);
		
		return true;
	}
	
	@Override
	public void depositarDinheiro(float valor) {
		this.saldo += Math.abs(valor); //Depósito do valor
	}
	
	public void depositarCheque(float valor, String banco, String dataPagamento) {
		this.saldo += Math.abs(valor); //Depósito do valor do cheque
	}
}