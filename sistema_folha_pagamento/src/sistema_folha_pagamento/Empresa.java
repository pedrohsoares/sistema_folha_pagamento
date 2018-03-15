package sistema_folha_pagamento;

import java.util.ArrayList;
import java.util.Calendar;

public class Empresa {
	private String nome;
	private ArrayList<Empregado> listEmpregado;
	private ArrayList<Empregado> listEmpregadoUndo;
	private ArrayList<Empregado> listEmpregadoRedo;
	
	public Empresa(String nome) {
		this.nome = nome;
		this.listEmpregado = new ArrayList<Empregado>();
		this.listEmpregadoUndo = new ArrayList<Empregado>();
		this.listEmpregadoRedo = new ArrayList<Empregado>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Empregado> getListEmpregado() {
		return listEmpregado;
	}

	public void setListEmpregado(ArrayList<Empregado> listEmpregado) {
		this.listEmpregado = listEmpregado;
	}

	public ArrayList<Empregado> getListEmpregadoUndo() {
		return listEmpregadoUndo;
	}

	public void setListEmpregadoUndo(ArrayList<Empregado> listEmpregadoUndo) {
		this.listEmpregadoUndo = listEmpregadoUndo;
	}

	public ArrayList<Empregado> getListEmpregadoRedo() {
		return listEmpregadoRedo;
	}

	public void setListEmpregadoRedo(ArrayList<Empregado> listEmpregadoRedo) {
		this.listEmpregadoRedo = listEmpregadoRedo;
	}
	
	public Empregado buscarEmpregado(int idEmpregado) {
		for(Empregado empregado : this.listEmpregado) 
			if(empregado.getId() == idEmpregado)
				return empregado;
		
		return null;
	}
	
	public void adicionarEmpregado(Empregado empregado) {
		empregado.setDataEntrada(Calendar.getInstance());
		if(this.listEmpregado.size() > 0) {
			empregado.setId(this.listEmpregado.get(listEmpregado.size()-1).getId() + 1);
		}else {
			empregado.setId(1);
		}
		
		listEmpregado.add(empregado);
	}
	
	public void removerEmpregado(int idEmpregado) {
		Empregado empregado = buscarEmpregado(idEmpregado);
		
		if(empregado == null) {
			System.out.println("Nao foi possivel encontrar este empregado.");
		}else {
			this.listEmpregado.remove(empregado);
			this.listEmpregadoUndo.add(empregado);
			
			System.out.println("Operacao finalizada com sucesso!");
		}
	}
	
	public void folhaPagamento() {
		Calendar dataAtual = Calendar.getInstance();
		
		if(dataAtual.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
			for(Empregado empregado : this.listEmpregado) {
				if(empregado.getTipo() == TipoEmpregado.HORISTA) {
					empregado.setPagamentoBruto(empregado.getSalario());
					if(empregado.isSindicalizado()) {
						double pagamentoLiquido = empregado.getSalario();
						for(TaxaServico taxa : empregado.getListTaxaServico())
							pagamentoLiquido -= taxa.getValor()/4;
						
						empregado.setPagamentoLiquido(pagamentoLiquido);
					}else {
						
					}
					
					empregado.setSalario(0);
				}
				
				if(empregado.getTipo() == TipoEmpregado.COMISSIONADO) {
					double totalSalario = 0.0;
						
					for(Venda venda : empregado.getListVendas()) 
						totalSalario += (venda.getValor() * empregado.getComissao());
					
					empregado.setPagamentoBruto(totalSalario);
					empregado.setListVendas(new ArrayList<Venda>());
				}
			}
		}
		
		if(dataAtual.get(Calendar.DAY_OF_MONTH) == Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH)) {
			double totalTaxa = 0.0;
			for(Empregado empregado : this.listEmpregado) {
				if(empregado.getTipo() == TipoEmpregado.ASSALARIADO) {
					empregado.setPagamentoBruto(empregado.getSalario());
					if(empregado.isSindicalizado()) {
						for(TaxaServico taxa : empregado.getListTaxaServico()) {
							totalTaxa += taxa.getValor();
						}
						empregado.setPagamentoLiquido(empregado.getSalario() - totalTaxa);
				
					}else {
						empregado.setPagamentoLiquido(empregado.getSalario());
					}
				}
			}
		}
	}
	
}
