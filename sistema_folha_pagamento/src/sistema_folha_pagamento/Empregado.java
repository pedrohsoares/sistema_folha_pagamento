package sistema_folha_pagamento;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Empregado {
	private int id;
	private Calendar dataEntrada;
	private String nome;
	private String endereco;
	private TipoEmpregado tipo;
	private double salario;
	private double salarioHora;
	private double comissao;
	private boolean sindicalizado;
	private ArrayList<Venda> listVendas;
	private ArrayList<TaxaServico> listTaxaServico;
	private double pagamentoBruto;
	private double pagamentoLiquido;
	
	
	private Scanner input;
	
	public Empregado() {
		this.salario  = 0;
		this.pagamentoBruto = 0;
		this.pagamentoLiquido = 0;
		this.listVendas = new ArrayList<Venda>();
		this.listTaxaServico = new ArrayList<TaxaServico>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Calendar getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public TipoEmpregado getTipo() {
		return tipo;
	}
	public void setTipo(TipoEmpregado tipo) {
		this.tipo = tipo;
	}
	public int setTipo(int tipo) {
		input = new Scanner(System.in);
		while(tipo < 1 || tipo > 3) {
			System.out.println("Entrada invalida, informe novamente");
			tipo = Integer.parseInt(input.nextLine());
		}
		
		switch(tipo) {
			case 1:
				this.tipo = TipoEmpregado.ASSALARIADO;
				break;
			case 2:
				this.tipo = TipoEmpregado.COMISSIONADO;
				break;
			case 3:
				this.tipo = TipoEmpregado.HORISTA;
				break;
		}
		
		return tipo;
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		input = new Scanner(System.in);
		while(salario < 0) {
			System.out.println("Salario deve ser maior que 0. Digite novamente:");
			salario = Double.parseDouble(input.nextLine());
		}
		
		this.salario = salario;
	}
	public boolean isSindicalizado() {
		return sindicalizado;
	}
	public void setSindicalizado(boolean sindicalizado) {
		this.sindicalizado = sindicalizado;
	}
	public void setSindicalizado(int sindicalizado) {
		input = new Scanner(System.in);
		while(sindicalizado < 0 || sindicalizado > 1) {
			System.out.println("Entrada invalida, informe novamente");
			sindicalizado = Integer.parseInt(input.nextLine());
		}
		
		if(sindicalizado == 1)
			this.sindicalizado = true;
		else
			this.sindicalizado = false;
	}

	public double getSalarioHora() {
		return salarioHora;
	}

	public void setSalarioHora(double salarioHora) {
		this.salarioHora = salarioHora;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		input = new Scanner(System.in);
		if(comissao >= 0 && comissao <= 100) {
			this.comissao = comissao;
		}else {
			while(comissao < 0 || comissao > 100) {
				System.out.println("Entrada invalida, informe a comissão novamente:");
				comissao = Double.parseDouble(input.nextLine());
			}
			
			this.comissao = comissao;
			
		}
	}

	public ArrayList<Venda> getListVendas() {
		return listVendas;
	}

	public void setListVendas(ArrayList<Venda> listVendas) {
		this.listVendas = listVendas;
	}
	
	public void adicionarResultadoVenda(Venda venda) {
		this.listVendas.add(venda);
	}

	public ArrayList<TaxaServico> getListTaxaServico() {
		return listTaxaServico;
	}

	public void setListTaxaServico(ArrayList<TaxaServico> listTaxaServico) {
		this.listTaxaServico = listTaxaServico;
	}
	
	public void adicionarTaxaServico(TaxaServico taxaServico) {
		this.listTaxaServico.add(taxaServico);
	}

	public double getPagamentoBruto() {
		return pagamentoBruto;
	}

	public void setPagamentoBruto(double pagamentoBruto) {
		this.pagamentoBruto = pagamentoBruto;
	}

	public double getPagamentoLiquido() {
		return pagamentoLiquido;
	}

	public void setPagamentoLiquido(double pagamentoLiquido) {
		this.pagamentoLiquido = pagamentoLiquido;
	}
	
}
