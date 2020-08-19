package br.com.interfaces;

public class SuperHomem implements VoadorInterface {
	
	private int experiencia = 0;

	@Override
	public void voar() {
		experiencia += 3;
		System.out.println("Estou voando como um campeão!");
	}

}
