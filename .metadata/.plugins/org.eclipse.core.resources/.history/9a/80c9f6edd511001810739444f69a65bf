package sistema_folha_pagamento;

public class colaboradorAssalariado {
	
	String nome;
	float salario;
	boolean sindical;
	int id;
	String metodoPagamento;
	
	public float pagamentoAssalariado(boolean sindicalizado, float salarioBruto){
		
		float pagamento = salarioBruto;
		
		if(sindicalizado){
			float taxa = (float) 0.5*pagamento;
			pagamento = pagamento - taxa;
		}
		
		return pagamento;
	}
	
	public void metodoPagamento(int nMetodo){
		
		if(nMetodo == 0){
			System.out.println("Opção cheque pelos correios escolhida.");
			this.metodoPagamento = "Cheque pelos correios";
		}
		
		if(nMetodo == 1){
			System.out.println("Opção cheque em mãos.");
			this.metodoPagamento = "Cheque em mãos";
		}
		
		if(nMetodo == 2){
			System.out.println("Opção depósito em conta.");
			this.metodoPagamento = "Depósito em conta";
		}
		
		if(nMetodo > 2 || nMetodo < 0){
			System.out.println("Opção Inválida.");

		}
	}
	
}
