package sistema_folha_pagamento;

public class TaxaServico {
	private String nome;
	private double valor;
	
	public TaxaServico(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
