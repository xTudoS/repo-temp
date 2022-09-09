package model;
import java.util.ArrayList;
import java.util.List;


public class Pessoa {
	private String nome;
	private int idade;
	private int id;
	private String telefone;
	private Imovel imov;
	private List<Imovel> imoveis = new ArrayList<>();
	
	public Pessoa(String nome, int idade, String telefone) {
		this.idade = idade;
		this.nome = nome;
		this.telefone = telefone;
	}
	public void adicionarImov(Imovel imov) {
		this.imov = imov;
	}
	public Imovel getImovel() {
		return imov;
	}
	public void setImovel(Imovel imov) {
		this.imov = imov;
	}
	public List<Imovel> getImoveis() {
		return imoveis;
	}
	
}
