package sistema_folha_pagamento;

import java.util.Calendar;
import java.util.Scanner;

public class Venda {
	private Calendar data;
	private double valor;
	private Scanner input;
	
	public Venda(double valor, String data) {
		this.valor = valor;
		setData(data);
	}
	
	public Calendar getData() {
		return data;
	}
	
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public void setData(String data) {
		input = new Scanner(System.in);
		while(!verificarData(data)) {
    		System.out.println("Data no formato incorreto, digite novamente:");
    		data = input.nextLine();
    	}
    	
    	Calendar dataVenda = Calendar.getInstance();
    	dataVenda.set(Integer.parseInt(data.substring(6)), Integer.parseInt(data.substring(3,5)), Integer.parseInt(data.substring(0, 2)));
    	this.data = dataVenda;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	private boolean verificarData(String dataVenda) {
		if(dataVenda.length() == 10) {
			for(int i=0;i<10;i++) {
				if(i == 2 || i == 5) {
					if(dataVenda.charAt(i) != '/')
						return false;
				}else {
					if(dataVenda.charAt(i) < '0' && dataVenda.charAt(i) > '9')
						return false;
				}
			}
			
			return true;
		}
		return false;
	}
	
}
