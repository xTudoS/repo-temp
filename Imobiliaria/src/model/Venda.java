package model;
import java.util.ArrayList;
import java.util.List;


public class Venda {
	public String tipo;
	public String tipopagamento;
	public int valorpagamento;
	private int idVenda;
	private ArrayList<Pessoa> pessoas = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();

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
	public void setPreco(int novoValor) {
		this.valorpagamento = novoValor;
	}
	public int getPreco() {
		return valorpagamento;
	}
	public void adicionar(Pessoa p){
		pessoas.add(p);
	}
	public void remover(Pessoa p){
		pessoas.remove(p);
	}
	public Cliente localizar(String nome){
		for(Cliente p : clientes){
			if(p.getNome().equals(nome))
				return p;
		}
		return null;
	}
	
	public ArrayList<Cliente> getClientes() {
		ArrayList<Cliente> clientes = new ArrayList<>();

		for(Pessoa p : pessoas) {
			if (p instanceof Cliente c)
				clientes.add(c);
		}
		return clientes;
	}
}
