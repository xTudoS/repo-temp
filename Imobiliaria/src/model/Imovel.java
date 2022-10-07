package model;
import java.util.ArrayList;
import java.util.List;

public class Imovel extends Venda {
	private int id;
	private String endereco;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String tipoimov;
	private Pessoa proprietario;
	private Pessoa corretor;
	private List<Pessoa> proprietarios = new ArrayList<>();
	
	public Imovel(String endereco, int numero, String complemento, String bairro, String cidade, String estado, String tipoimov ,String tipo, String tipopagamento, int valorpagamento) {
		super(tipo, tipopagamento, valorpagamento);
		this.bairro = bairro;    
		this.cidade = cidade;
		this.complemento = complemento;
		this.endereco = endereco;
		this.endereco = endereco;
		this.estado = estado; 
		this.numero = numero; 
		this.tipoimov = tipoimov;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void adicionarProp(Pessoa proprietario) {
		this.proprietario = proprietario;
	}
	public void adicionarCorretor(Pessoa corretor) {
		this.corretor = corretor;
	}
	public Pessoa getProprietario() {
		return proprietario;
	}
	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}
	public List<Pessoa> getProprietarios(){
		return proprietarios;
	}
	public String getEndereco() {
		return endereco;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "Endereco:" + endereco + ", Numero:" + numero +", Cidade:" + cidade + "Tipo de Imovel: " + tipoimov + ", Proprietario:"
				+ proprietario.getNome();
	}
	
	
}
