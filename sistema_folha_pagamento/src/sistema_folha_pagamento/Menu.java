package sistema_folha_pagamento;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private Scanner input;
	
	public int menuPrincipal() {
		input = new Scanner(System.in);
		int opcao;
		
		System.out.println("O que deseja fazer?");	
		System.out.println("1 - Adicao de um empregado?");	
		System.out.println("2 - Remocao de um empregado?");	
		System.out.println("3 - Lancar um cartao de ponto?");	
		System.out.println("4 - Lancar um resultado de venda?");	
		System.out.println("5 - Lancar uma taxa de servico?");
		System.out.println("6 - Alterar detalhes de um empregado?");
		System.out.println("7 - Rodar folha de empregados do dia?");
		System.out.println("8 - Undo?");
		System.out.println("9 - Redo?");
		System.out.println("0 - Sair");
		opcao = Integer.parseInt(input.nextLine());
		
		return opcao;
	}
	
	public void adicionarEmpregado(Empresa empresa) {
		input = new Scanner(System.in);
		empresa.setListEmpregadoUndo(new ArrayList<Empregado>(empresa.getListEmpregado()));
			
		
		System.out.println("1 - Adicao de um empregado foi escolhido");
		
		Empregado empregado = new Empregado();
		
		System.out.println("Digite o nome do empregado");
		empregado.setNome(input.nextLine());
		
		System.out.println("Digite o endereco do empregado");
		empregado.setEndereco(input.nextLine());
		
		System.out.println("Empregado sindicalizado? (1 - Sim, 0 - Nao)");
		empregado.setSindicalizado(Integer.parseInt(input.nextLine()));

		System.out.println("Digite o tipo do empregado (1 - Assalariado. 2 - Comissionado. 3 - Horista)");
		int type = empregado.setTipo(Integer.parseInt(input.nextLine()));
		
		switch(type) {
			case 1:
				System.out.println("Assalariado escolhido");
				System.out.println("Entre com o salario mensal(dinheiro bruto) do empregado:");
				empregado.setSalario(Double.parseDouble(input.nextLine()));
				break;
			case 2:
				System.out.println("Comissionado escolhido");	
				System.out.println("Entre com a comissao(em percentual) por venda do empregado:");
				empregado.setComissao(Double.parseDouble(input.nextLine()));
				break;
			case 3:
				System.out.println("Horista escolhido");
				System.out.println("Entre com o salario por hora(dinheiro bruto) do empregado:");
				empregado.setSalarioHora(Double.parseDouble(input.nextLine()));
				break;
		}
		
		empresa.adicionarEmpregado(empregado);
	}
	
	public void removerEmpregado(Empresa empresa) {
		input = new Scanner(System.in);
		empresa.setListEmpregadoUndo(new ArrayList<Empregado>(empresa.getListEmpregado()));
		
		System.out.println("2 - Remoção de um empregado foi escolhido");	
		System.out.println("Digite o ID do empregado em que você deseja remover:");
		
		int deleteId = Integer.parseInt(input.nextLine());
		empresa.removerEmpregado(deleteId);
	}
	
	public void lancarCartao(Empresa empresa) {
		input = new Scanner(System.in);
		empresa.setListEmpregadoUndo(new ArrayList<Empregado>(empresa.getListEmpregado()));
		
		System.out.println("3 - Lançar um cartão de ponto foi escolhido");	

		System.out.println("Digite o ID do empregado:");
						
		int idEmpregado = Integer.parseInt(input.nextLine());
		Empregado empregado = empresa.buscarEmpregado(idEmpregado);
		
		if(empregado.getTipo() == TipoEmpregado.HORISTA) {
			System.out.println("Digite as horas trabalhadas pelo empregado hoje:");

			int horasTrabalhadas = Integer.parseInt(input.nextLine());

        	if(horasTrabalhadas > 8){
        		int horaExtra = horasTrabalhadas - 8;
        		empregado.setSalario(empregado.getSalario() + (empregado.getSalarioHora()*8 + (horaExtra*(1.5*empregado.getSalarioHora()))));	
        	}else{
        		empregado.setSalario(empregado.getSalario() + (horasTrabalhadas*empregado.getSalarioHora()));
        	}
		}else {
			System.out.println("Empregado não é horista, portanto não é possível lançar um cartão de ponto.");
		}
	}

	public void lancarResultadoVenda(Empresa empresa) {
		input = new Scanner(System.in);
		empresa.setListEmpregadoUndo(new ArrayList<Empregado>(empresa.getListEmpregado()));
		
		System.out.println("4 - Lancar um resultado de venda foi escolhido");	
		
		System.out.println("Digite o ID do empregado:");
		int idEmpregado = Integer.parseInt(input.nextLine());
		
		Empregado empregado = empresa.buscarEmpregado(idEmpregado);
		
		if(empregado.getTipo() != TipoEmpregado.COMISSIONADO) {
		
        	 System.out.println("Empregado nao e comissionado, portanto nao e possivel lancar um resultado de venda.");

         }else{
        	 
        	System.out.println("Digite o valor da venda :");

			double valorVenda = Integer.parseInt(input.nextLine());
			
        	System.out.println("Digite a data da venda (DD/MM/AAAA) :");
        	String dataVenda = input.nextLine();
        	
        	Venda venda = new Venda(valorVenda,dataVenda);
        	empregado.adicionarResultadoVenda(venda);
         }
		       
	}
	
	public void lancarTaxaServico(Empresa empresa) {
		input = new Scanner(System.in);
		empresa.setListEmpregadoUndo(new ArrayList<Empregado>(empresa.getListEmpregado()));
		
		System.out.println("5 - Lancar uma taxa de servico foi escolhido");	
		
		System.out.println("Digite o ID do empregado:");
		int idEmpregado = Integer.parseInt(input.nextLine());
		
		Empregado empregado = empresa.buscarEmpregado(idEmpregado);
		
		if(empregado.isSindicalizado() == true) {
			System.out.println("Informe o nome do servico:");
			String nome = input.nextLine();
			
			System.out.println("Informe o valor do servico:");
			double valor = Double.parseDouble(input.nextLine());
			
			TaxaServico taxaServico = new TaxaServico(nome, valor);
			empregado.adicionarTaxaServico(taxaServico);
			
			System.out.println("Taxa adicionada com sucesso!");
		}else {
			System.out.println("Somente empregados sindicalizados podem receber taxas de servico");
		}
	}
	
	public void alterarEmpregado(Empresa empresa) {
		input = new Scanner(System.in);
		empresa.setListEmpregadoUndo(new ArrayList<Empregado>(empresa.getListEmpregado()));
		
		System.out.println("6 - Alterar detalhes de um empregado foi escolhido");
		
		System.out.println("Digite o ID do empregado em que você deseja alterar:");
		
		int updateId = Integer.parseInt(input.nextLine());
		Empregado empregado = empresa.buscarEmpregado(updateId);
		
		System.out.println("Escolha o que deseja alterar:");
		System.out.println("1 - Endereço");
		System.out.println("2 - Tipo (1 - Assalariado. 2 - Comissionado. 3 - Horista)");
		System.out.println("3 - Salario (Salario Mensal - Assalariado. Comissao - Comissionado. Salario por Hora - Horista");
		
		int updateNumber = Integer.parseInt(input.nextLine());
		
		while(updateNumber < 1 || updateNumber > 3) {
			System.out.println("Opcao invalida, digite novamente");
			updateNumber = Integer.parseInt(input.nextLine());
		}
		
		switch(updateNumber) {
			case 1:
				System.out.println("Escreva o novo endereço do empregado:");
				String address = input.nextLine();
				empregado.setEndereco(address);
				System.out.println("Endereco alterado com sucesso!");
				break;
			case 2:
				System.out.println("Escolha o novo tipo do empregado (1 - Assalariado. 2 - Comissionado. 3 - Horista):");
				int newType = Integer.parseInt(input.nextLine());
				empregado.setTipo(newType);
				System.out.println("Tipo do empregado alterado com sucesso!");
				break;
			case 3:
				switch(empregado.getTipo()) {
					case ASSALARIADO:
						System.out.println("Digite o novo salario mensal:");
						double salario = Double.parseDouble(input.next());
						empregado.setSalario(salario);
						System.out.println("Salario mensal alterado com sucesso!");
						break;
					case COMISSIONADO:
						System.out.println("Digite a nova comissao por produto:");
						double comissao = Double.parseDouble(input.next());
						empregado.setComissao(comissao);
						System.out.println("Comissao alterada com sucesso!");
						break;
					case HORISTA:
						System.out.println("Digite o novo salario por hora:");
						double salarioHora = Double.parseDouble(input.next());
						empregado.setSalarioHora(salarioHora);
						System.out.println("Salario por hora alterado com sucesso!");
						break;
				}
				break;
		}
	}
	
	public void undo(Empresa empresa) {
		input = new Scanner(System.in);
		System.out.println("Deseja realmente utilizar o undo?");
		System.out.println("\t1. Sim\n\t2. Nao");
		int opcao = Integer.parseInt(input.nextLine());
		
		while(opcao < 1 || opcao > 2) {
			System.out.println("Opcao invalida, digite novamente:");
			opcao = Integer.parseInt(input.nextLine());
		}
		
		if(opcao == 1) {
			empresa.setListEmpregadoRedo(new ArrayList<Empregado>(empresa.getListEmpregado()));
			empresa.setListEmpregado(new ArrayList<Empregado>(empresa.getListEmpregadoUndo()));
			
			System.out.println("Operacao executada com sucesso");
		}else {
			System.out.println("Operacao abortada!");
		}
	}
	
	public void redo(Empresa empresa) {
		input = new Scanner(System.in);
		System.out.println("Deseja realmente utilizar o redo?");
		System.out.println("\t1. Sim\n\t2. Nao");
		int opcao = Integer.parseInt(input.nextLine());
		
		while(opcao < 1 || opcao > 2) {
			System.out.println("Opcao invalida, digite novamente:");
			opcao = Integer.parseInt(input.nextLine());
		}
		
		if(opcao == 1) {
			empresa.setListEmpregado(new ArrayList<Empregado>(empresa.getListEmpregadoRedo()));
			
			System.out.println("Operacao executada com sucesso");
		}else {
			System.out.println("Operacao abortada!");
		}
	}
	
	public void rodarFolhaPagamento(Empresa empresa) {
		input = new Scanner(System.in);
		System.out.println("7 - Rodar folha de empregados do dia\n");
		
		System.out.println("Voce deseja realmente rodar a folha de pagamento? (1 - Sim. 2 - Nao)");
		int opcao = Integer.parseInt(input.nextLine());
		while(opcao < 1 || opcao > 2) {
			System.out.println("Opcao invalida, digite novamente:");
			opcao = Integer.parseInt(input.nextLine());
		}
		
		if(opcao == 1) {
			empresa.folhaPagamento();
		}else {
			System.out.println("Rodar folha de pagamento cancelado.");
		}
	}
}
