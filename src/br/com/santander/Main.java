package br.com.santander;

public class Main {

	public static void main(String[] args) {
		
		Cliente clienteWilson = new Cliente(
			18,
			"Wilson",
			"Faustino",
			"00.000.00-X",
			"000.000.000-00"
		);
		
		//Conta poupança
		ContaPoupanca poupanca = new ContaPoupanca(clienteWilson);
		System.out.println(poupanca.consultaSaldo());
		
		poupanca.depositarDinheiro(325.55f);

		System.out.println("Saldo: " + poupanca.consultaSaldo());
		
		boolean sacou300 = poupanca.sacarDinheiro(300);
		System.out.println(sacou300 ? "Sacou 300! Saldo:"  + poupanca.consultaSaldo() : "Não deu pra sacar 300! Saldo: " + poupanca.consultaSaldo());
		
		boolean sacou100 = poupanca.sacarDinheiro(100);
		System.out.println(sacou100 ? "Sacou 100! Saldo:"  + poupanca.consultaSaldo() : "Não deu pra sacar 100! Saldo: " + poupanca.consultaSaldo());
		
		//Conta corrente
		ContaCorrente contaCC = new ContaCorrente(clienteWilson, 1000);
		contaCC.depositarDinheiro(200);
		contaCC.depositarCheque(75.68f, "Santander", "19/08/2020");
		
		System.out.println("Saldo: " + contaCC.consultaSaldo());
		
		boolean sacou100CC = contaCC.sacarDinheiro(100);
		System.out.println(sacou100CC ? "Sacou 100! Saldo:"  + contaCC.consultaSaldo() : "Não deu pra sacar 100! Saldo: " + contaCC.consultaSaldo());
		
		boolean sacou200CC = contaCC.sacarDinheiro(200);
		System.out.println(sacou200CC ? "Sacou 200! Saldo:"  + contaCC.consultaSaldo() : "Não deu pra sacar 200! Saldo: " + contaCC.consultaSaldo());
		
		boolean sacou1000CC = contaCC.sacarDinheiro(1000);
		System.out.println(sacou1000CC ? "Sacou 1000! Saldo:"  + contaCC.consultaSaldo() : "Não deu pra sacar 1000! Saldo: " + contaCC.consultaSaldo());
	}

}
