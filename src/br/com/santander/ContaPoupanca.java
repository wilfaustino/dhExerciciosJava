package br.com.santander;

public class ContaPoupanca extends Conta {
	
	private float taxaDeJuros = 0.0013f;
	
	ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public boolean sacarDinheiro(float valor) {
		if(valor>this.saldo)
			return false;
		
		this.saldo -= Math.abs(valor);
		
		return true;
	}
	
	@Override
	public void depositarDinheiro(float valor) {
		float jurosCalculado = Math.abs(valor) * taxaDeJuros;
		jurosCalculado = (float) Math.floor(jurosCalculado * 100) / 100f;
		this.saldo += Math.abs(valor) + jurosCalculado;
	}
	
}
