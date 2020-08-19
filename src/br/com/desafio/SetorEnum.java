package br.com.desafio;

public enum SetorEnum {
	
	GERENCIA(1), SUPERVISOR(2), PRODUCAO(3);
	
	private int value;
	
	SetorEnum(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getNameSetor() {
		
		String name;
		
		switch(this.value) {
		case 1:
			name = "Ger�ncia";
			break;
		case 2:
			name = "Supervis�o";
			break;
		case 3:
			name = "Produ��o";
			break;
		default:
			name = "Setor desconhecido";
		}
		
		return name;
		
	}
	
	public String getNameCargo() {
		
		String name;
		
		switch(this.value) {
		case 1:
			name = "Gerente";
			break;
		case 2:
			name = "Supervisor";
			break;
		case 3:
			name = "Funcion�rio da produ��o";
			break;
		default:
			name = "Cargo desconhecido";
		}
		
		return name;
		
	}
	
}