package sistema_folha_pagamento;

public class Main {
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		Empresa empresa = new Empresa("UFAL");
		boolean flag = true;
		
		while(flag){
			switch(menu.menuPrincipal()) {
				case 0:
					flag = false;
					break;
				case 1:
					menu.adicionarEmpregado(empresa);
					break;
				case 2:
					menu.removerEmpregado(empresa);
					break;
				case 3:
					menu.lancarCartao(empresa);
					break;
				case 4:
					menu.lancarResultadoVenda(empresa);
					break;
				case 5:
					menu.lancarTaxaServico(empresa);
					break;
				case 6:
					menu.alterarEmpregado(empresa);
					break;
				case 7:
					menu.rodarFolhaPagamento(empresa);
					break;
				case 8:
					menu.undo(empresa);
					break;
				case 9:
					menu.redo(empresa);
					break;
				
				default:
					System.out.println("Esta opcao nao existe. Tente novamente!");
					break;
			}
			
		}
		
	}

}
