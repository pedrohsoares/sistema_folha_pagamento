package sistema_folha_pagamento;

public class colaboradorComissionado {

	String nome;
	float salario;
	boolean sindical;
	int id;
	int nVendas;
	String metodoPagamento;
	
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
