package sistema_folha_pagamento;

public class colaboradorHorista {
	
	String nome;
	int id_cartao;
	int horasTrabalhadasDia;
	float salario;
	boolean sindical;
	int id;
	String metodoPagamento;
	/*
	 * método que paga o colaborador horista
	 * Entradas: horas trabalhadas no dia e o quanto é pago por hora, respectivamente.
	 * Saída: valor a ser pago.
	 */
	public float pagamendoHorista(int horasTrabalhadasDia, float horaTrabalhada, boolean sindicalizado){ 
		float pagamento = 0;
		
		if(horasTrabalhadasDia > 8){
			float horaExtra = horaTrabalhada - 8;
			float pagamentoHoraExtra = (float) (1.5*horaExtra);
			
			pagamento = horaTrabalhada*8 + pagamentoHoraExtra;
		}else{
			pagamento = horasTrabalhadasDia*horaTrabalhada;
		}
		
		if(sindicalizado){
			float taxaSindical = (float) 0.05*pagamento;
			pagamento = pagamento - taxaSindical;
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
