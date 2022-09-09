package aplicacao;

import com.db4o.ObjectContainer;

import model.Cliente;
import model.Corretor;
import model.Imovel;
import model.Pessoa;


public class Cadastrar {
	private ObjectContainer manager;
	
	public Cadastrar(){
		manager = Util.conectarDb4oAgendaLocal();
		cadastrar();
		manager.close();
		System.out.println("fim do programa");
	}

	public void cadastrar(){
		System.out.println("Cadastrando...");
		
		Imovel imovel1, imovel2, imovel3;
		Pessoa pessoa1,pessoa2, pessoa3, pessoa4, pessoa5;
		
		pessoa1 = new Pessoa("joao", 18, "99999999");
		pessoa2= new Pessoa("maria", 18, "99999999");
		pessoa3= new Pessoa("paulo", 18, "99999999");
		pessoa4= new Pessoa("antonio", 18, "99999999");
		pessoa5= new Pessoa("pedro", 18, "99999999");

		imovel1 = new Imovel("rua da areia", 69, "", "centro", "Joao Pessoa", "Paraiba", "Comercial", "Aluguel", "A vista", 1000);
		imovel1.adicionarProp(pessoa1);
		imovel1.adicionarCorretor(pessoa2);
		
		imovel2 = new Imovel("Avenida Esperanca", 69, "", "Manaira", "Joao Pessoa", "Paraiba", "Comercial", "Aluguel", "A vista", 1000);
		imovel2.adicionarProp(pessoa1);
		imovel2.adicionarCorretor(pessoa3);
		
		imovel3 = new Imovel("Rua infante dom henrique", 406, "Apt 101", "Tambau", "Joao Pessoa", "Paraiba", "Comercial", "Aluguel", "A vista", 1000);
		imovel3.adicionarProp(pessoa1);
		imovel1.adicionarCorretor(pessoa4);
		
		pessoa1.adicionarImov(imovel1);
		pessoa1.adicionarImov(imovel2);
		pessoa1.adicionarImov(imovel3);
		
		pessoa1.adicionarImov(imovel1);
		
		pessoa2.adicionarImov(imovel2);
		
		pessoa3.adicionarImov(imovel3);
		
		//persistir livro1
		manager.store(imovel1);
		//persistir livro2
		manager.store(imovel2);
		//persistir livro3
		manager.store(imovel3);
		manager.commit();
	}

	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


