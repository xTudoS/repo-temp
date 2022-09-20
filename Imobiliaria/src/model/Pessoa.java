package model;
import java.util.ArrayList;
import java.util.List;


public class Pessoa {
	private String nome;
	private int idade;
	private int id;
	private String telefone;
	private List<Imovel> imoveis = new ArrayList<>();
	
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
	@Override
	public String toString() {
		String dados = "Nome: " + nome + ", telefone: " + telefone + ", imoveis: ";
		for(Imovel i: this.imoveis) {
			dados += i.getEndereco() +" , " + i.getNumero() + " , ";
		}
		return dados;
	}
	
}
