package model;
import java.util.ArrayList;
import java.util.List;

import modelo.Motor;


public class Corretor extends Pessoa {
	private String creci;
	private double salarioFixo;
	private double comissao;
	private int qntdVendas;
	public Corretor(String nome, int idade, String telefone, String creci, double salarioFixo, double comissao, int qntdVendas) {
		super(nome, idade, telefone);
		this.creci = creci;
		this.salarioFixo = salarioFixo;
		this.comissao = comissao;
		this.qntdVendas = qntdVendas;
	}
	public String getCreci() {
		return creci;
	}
	public void setqntdVendas(int qntdVendas) {
		this.qntdVendas = qntdVendas;
	}
}
