package model;
import java.util.ArrayList;
import java.util.List;


public class Corretor extends Pessoa {
	private int creci;
	private double salarioFixo;
	private double comissao;
	private int qntdVendas;
	public Corretor(String nome, int idade, String telefone, int creci, double salarioFixo, double comissao, int qntdVendas) {
		super(nome, idade, telefone);
		this.creci = creci;
		this.salarioFixo = salarioFixo;
		this.comissao = comissao;
		this.qntdVendas = qntdVendas;
	}
	public Corretor(String nome, int idade, String telefone, int creci) {
		super(nome, idade, telefone);
		this.creci = creci;
	}
	public void setCreci(int creci) {
		this.creci = creci;
	}
	public int getCreci() {
		return creci;
	}
}
