package br.com.santander;

public abstract class Conta {

	protected float saldo;
	protected Cliente cliente;
	
	Conta(Cliente cliente){
		this.cliente = cliente;
	}
	
	public float consultaSaldo() {
		return (float) Math.floor(this.saldo * 100) / 100f;
	}
	
	public abstract boolean sacarDinheiro(float valor);
	
	public abstract void depositarDinheiro(float valor);
	
}
