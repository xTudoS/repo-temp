package model;
import java.util.ArrayList;
import java.util.List;


public class Venda {
	public String tipo;
	public String tipopagamento;
	public int valorpagamento;
	public Venda(String tipo, String tipopagamento, int valorpagamento) {
		this.tipo = tipo;
		this.tipopagamento = tipopagamento;
		this.valorpagamento = valorpagamento;
	}
}
