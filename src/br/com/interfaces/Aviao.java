package br.com.interfaces;

public class Aviao implements VoadorInterface {
	
	private int horasVoo = 0;

	@Override
	public void voar() {
		horasVoo += 13;
		System.out.println("Estou voando como um avião e tenho " + horasVoo + " horas de voo!!");
	}

}
