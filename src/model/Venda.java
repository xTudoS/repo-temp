package model;
import java.util.ArrayList;
import java.util.List;


public class Venda {
	public String tipo;
	public String tipopagamento;
	public int valorpagamento;
	private int idVenda;
	public Venda(String tipo, String tipopagamento, int valorpagamento, int id) {
		this.tipo = tipo;
		this.tipopagamento = tipopagamento;
		this.valorpagamento = valorpagamento;
		this.idVenda = id;
	}
	public void setId(int id) {
		this.idVenda = id;
	}
	public int getId() {
		return idVenda;
	}
}
