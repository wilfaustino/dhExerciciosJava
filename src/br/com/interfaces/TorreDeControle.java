package br.com.interfaces;

public class TorreDeControle {

	private VoadorInterface voadores[];
	
	TorreDeControle(VoadorInterface voadores[]){
		this.voadores = voadores;
	}
	
	public void voemTodos() {

		for(int i=0; i<voadores.length; i++) {
			voadores[i].voar();
		}
		
	}

}
