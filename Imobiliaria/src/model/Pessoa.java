package model;
import java.util.ArrayList;
import java.util.List;


public class Pessoa {
	private String nome;
	private int idade;
	private int idPessoa;
	private String telefone;
	private List<Imovel> imoveis = new ArrayList<>();
	private ArrayList<Venda> vendas = new ArrayList<>();
	
	public Pessoa(String nome, int idade, String telefone) {
		this.idade = idade;
		this.nome = nome;
		this.telefone = telefone;
	}
	public void adicionarImov(Imovel imov) {
		this.imoveis.add(imov);
	}
	public void removerImov(Imovel imov) {
		this.imoveis.remove(imov);
	}
	
	public List<Imovel> getImoveis() {
		return imoveis;
	}
	public String getNome() {
		return this.nome;
	}
	
	public void adicionar(Venda e){
		vendas.add(e);
	}
	public void remover(Venda e){
		vendas.remove(e);
	}
	public Venda localizar(int id){
		for(Venda e : vendas){
			if(e.getId() == id)
				return e;
		}
		return null;
	}
	
	public ArrayList<Venda> getVendas() {
		return vendas;
	}
	
	@Override
	public String toString() {
		String dados = "Nome: " + nome + ", telefone: " + telefone + ", imoveis: ";
		for(Imovel i: this.imoveis) {
			if (i==null){
				return dados;
			}
			else {
				
				dados += i.getEndereco() +" , " + i.getNumero() + " , ";
			}
		}
		return dados;
	}
	public void setId(int id) {
		this.idPessoa = id;
	}
	public int getId() {
		return idPessoa;
	}
	
	
}
