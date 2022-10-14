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
		Cliente pessoa1,pessoa2;
		Corretor pessoa3, pessoa4, pessoa5;
		
		pessoa1 = new Cliente("joao", 18, "99999999", "Solteiro", 1800, 1);
		pessoa2= new Cliente("maria", 18, "99999999", "Casada", 5000, 2);
		pessoa3= new Corretor("paulo", 18, "99999999", 123);
		pessoa4= new Corretor("antonio", 18, "99999999",456);
		pessoa5= new Corretor("pedro", 18, "99999999", 798);

		imovel1 = new Imovel("rua da areia", 69, "", "centro", "Joao Pessoa", "Paraiba", "Comercial", "Aluguel", "A vista", 1000, 1);
		imovel1.adicionarProp(pessoa1);
		imovel1.adicionarCorretor(pessoa2);
		
		imovel2 = new Imovel("Avenida Esperanca", 96, "", "Manaira", "Joao Pessoa", "Paraiba", "Comercial", "Aluguel", "A vista", 1000, 2);
		imovel2.adicionarProp(pessoa2);
		imovel2.adicionarCorretor(pessoa3);
		
		imovel3 = new Imovel("Rua infante dom henrique", 406, "Apt 101", "Tambau", "Joao Pessoa", "Paraiba", "Comercial", "Aluguel", "A vista", 1000, 3);
		imovel3.adicionarProp(pessoa1);
		imovel1.adicionarCorretor(pessoa4);
		
		pessoa1.adicionarImov(imovel1);
		pessoa1.adicionarImov(imovel2);
		pessoa1.adicionarImov(imovel3);
				
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


