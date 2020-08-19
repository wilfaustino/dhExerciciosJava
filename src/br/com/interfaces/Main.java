package br.com.interfaces;

public class Main {

	public static void main(String[] args) {
		
		Pato pato = new Pato();
		Aviao aviao = new Aviao();
		SuperHomem superHomem = new SuperHomem();
		
		VoadorInterface listaDeVoadores[] = { pato, aviao, superHomem };
		
		TorreDeControle torreDeControle = new TorreDeControle(listaDeVoadores);
		
		int numVoos = 1;
		
		do {
			System.out.println("Voo número " + numVoos);
			torreDeControle.voemTodos();
			numVoos++;
		} while(numVoos < 25);
		
	}

}
